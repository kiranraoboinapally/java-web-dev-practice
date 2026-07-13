
Physical Server
================================================

                 72 Threads Total

        NUMA Node 0              NUMA Node 1
       ---------------          ---------------
       36 Threads               36 Threads
       CPU Socket 0             CPU Socket 1

       RAM                      RAM
       Local Memory             Local Memory


              RHEL Host OS
                    |
              KVM/QEMU
                    |
              libvirt
                    |
             Virtual Machines
---

# Complete Manual KVM Setup Workflow

## Phase 1: Physical Server Preparation

You start with:

```
Bare Metal Server
-----------------------
CPU: 2 sockets
CPU threads: 72
RAM: 660GB
Disk: 3.3TB
```

Nothing is installed yet.

---

# Step 1: BIOS Configuration

Boot server → enter BIOS.

Configure:

### CPU Virtualization

Enable:

```
Intel VT-x              Enabled
Intel VT-d              Enabled
```

### NUMA

Enable:

```
NUMA = Enabled
```

Your topology becomes:

```
NUMA Node 0              NUMA Node 1
------------             ------------
36 threads               36 threads
330GB RAM                330GB RAM
```

Save and reboot.

---

# Step 2: Install RHEL Host

Boot using:

```
RHEL 9 ISO
```

Install RHEL on the physical server.

Example disk layout:

```
Disk 3.3TB

+----------------+
| EFI 600MB      |
+----------------+
| /boot 1GB      |
+----------------+
| LVM            |
|                |
| root 100GB     |
| swap 64GB      |
| VM storage     |
+----------------+
```

After installation:

Login:

```bash
root
```

Verify:

```bash
cat /etc/redhat-release
```

---

# Step 3: Update Host

```bash
dnf update -y
```

Reboot:

```bash
reboot
```

---

# Step 4: Verify Hardware

CPU:

```bash
lscpu
```

Expected:

```
CPU(s): 72
Socket(s): 2
NUMA node(s): 2
Virtualization: VT-x
```

NUMA:

```bash
numactl --hardware
```

Expected:

```
node 0 cpus: 0-35
node 1 cpus: 36-71
```

---

# Step 5: Install KVM/QEMU

Install virtualization packages:

```bash
dnf install -y \
qemu-kvm \
libvirt \
virt-install \
virt-manager \
qemu-img \
cloud-init \
qemu-guest-agent
```

Enable libvirt:

```bash
systemctl enable --now libvirtd
```

Check:

```bash
systemctl status libvirtd
```

---

# Step 6: Prepare Storage

You need a place for VM disks.

You have two common designs.

---

## Option A: QCOW2 Storage (your script uses this)

Create:

```bash
mkdir /home/kvm-images
```

Structure:

```
/home/kvm-images

|
+-- template.qcow2
|
+-- vm01.qcow2
|
+-- vm02.qcow2
```

---

## Option B: LVM VM Storage

Example:

```
VG: vg_vmstorage

|
+-- vm01-disk
+-- vm02-disk
```

Used often for performance.

---

# Step 7: Configure Network

Find NIC:

```bash
ip link
```

Example:

```
ens1
```

Create bridge:

```
Physical NIC
     |
     |
    br0
     |
 ----------------
 |       |       |
VM01   VM02    VM03
```

Commands:

```bash
nmcli con add type bridge ifname br0
```

Attach NIC:

```bash
nmcli con add type ethernet \
ifname ens1 \
master br0
```

Configure IP on bridge:

```bash
nmcli con mod br0 \
ipv4.method manual \
ipv4.addresses 192.168.10.20/24 \
ipv4.gateway 192.168.10.1
```

Activate:

```bash
nmcli con up br0
```

Check:

```bash
ip addr
```

---

# Step 8: Create Your First VM Manually

You need an OS ISO:

Example:

```
rhel-9.7-x86_64.iso
```

Create VM:

```bash
virt-install \
--name testvm01 \
--memory 8192 \
--vcpus 4 \
--disk path=/home/kvm-images/testvm01.qcow2,size=50 \
--cdrom /iso/rhel-9.7.iso \
--network bridge=br0 \
--os-variant rhel9 \
--graphics spice
```

Now:

```
Physical Server

RHEL Host
 |
 KVM
 |
 VM01
   |
   RHEL 9
```

---

# Step 9: Install OS Inside VM

The VM boots from ISO.

Install:

```
Hostname:
app01

IP:
192.168.10.50

User:
admin
```

After installation:

Shutdown VM.

---

# Step 10: Convert VM Into Template

A template is a clean master image.

Inside VM:

Install:

```bash
dnf install -y cloud-init qemu-guest-agent
```

Enable:

```bash
systemctl enable qemu-guest-agent
```

Clean:

```bash
cloud-init clean
```

Shutdown:

```bash
shutdown now
```

On host:

Find disk:

```bash
virsh domblklist testvm01
```

Copy:

```bash
cp /home/kvm-images/testvm01.qcow2 \
/home/kvm-images/rhel97-template.qcow2
```

Now:

```
rhel97-template.qcow2
```

is your golden image.

---

# Step 11: Create New VM From Template Manually

Clone:

```bash
qemu-img create \
-f qcow2 \
-b rhel97-template.qcow2 \
-F qcow2 \
app01.qcow2
```

Create VM:

```bash
virt-install \
--name app01 \
--memory 16384 \
--vcpus 8 \
--disk path=/home/kvm-images/app01.qcow2 \
--network bridge=br0 \
--os-variant rhel9 \
--import
```

Now:

```
Template
   |
   |
 Clone
   |
   |
 VM01
```

---

# Step 12: Manage VMs

List:

```bash
virsh list --all
```

Start:

```bash
virsh start app01
```

Shutdown:

```bash
virsh shutdown app01
```

Console:

```bash
virsh console app01
```

Delete:

```bash
virsh destroy app01
virsh undefine app01
```

---

# Step 13: Add Automation Later

Your Python script automates these manual steps:

Manual:

```
Create disk
      |
      |
Write cloud-init
      |
      |
virt-install
      |
      |
Wait for IP
```

Your script:

```
create_disk_from_template()
          |
write_cloud_init_files()
          |
virt-install()
          |
get_vm_ip()
```

So the script is not replacing the KVM setup; it automates VM provisioning after the KVM host is ready.

---

## The complete mental model

```
Hardware
   |
   ↓
BIOS (VT-x, NUMA)
   |
   ↓
RHEL Host OS
   |
   ↓
KVM/QEMU/libvirt
   |
   ↓
Storage + Network
   |
   ↓
Template Image
   |
   ↓
VM Creation
   |
   ↓
Automation
```

