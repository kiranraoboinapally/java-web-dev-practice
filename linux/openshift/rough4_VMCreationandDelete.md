
---

# 1. What Technologies Are Used

Your setup uses:

* **KVM** – Linux kernel virtualization
* **libvirt** – manages virtual machines
* **virt-install** – creates VMs from CLI
* **virsh** – manage VMs
* **qcow2** – VM disk format

Architecture:

```
Hardware
   │
Linux Kernel
   │
KVM
   │
libvirt
   │
virt-install / virsh
   │
Virtual Machines
```

---

# 2. Install Required Packages

Install virtualization packages.

### On RHEL / Rocky / Alma / Fedora

```bash
sudo dnf install qemu-kvm libvirt virt-install virt-manager virt-viewer -y
```

Packages explained:

| Package      | Purpose               |
| ------------ | --------------------- |
| qemu-kvm     | virtualization engine |
| libvirt      | VM management service |
| virt-install | CLI VM creator        |
| virt-manager | GUI manager           |
| virt-viewer  | console viewer        |

---

# 3. Start Virtualization Services

Start **libvirt service**.

```bash
sudo systemctl enable --now libvirtd
```

Check status:

```bash
systemctl status libvirtd
```

Expected:

```
active (running)
```

---

# 4. Verify Virtualization Support

Check CPU virtualization support.

```bash
egrep -c '(vmx|svm)' /proc/cpuinfo
```

If result:

```
0
```

Then virtualization **not enabled in BIOS**.

Enable:

* Intel VT-x
* AMD-V

---

# 5. Check Default Storage Pool

List storage pools.

```bash
virsh pool-list --all
```

Expected:

```
Name      State    Autostart
--------------------------------
default   active   yes
```

Default storage location:

```
/var/lib/libvirt/images/
```

---

# 6. Create Virtual Disk (Volume)

Create a **120 GB qcow2 disk**.

```bash
virsh vol-create-as default kiran.qcow2 120G --format qcow2
```

Explanation:

| Parameter     | Meaning           |
| ------------- | ----------------- |
| vol-create-as | create new volume |
| default       | storage pool      |
| kiran.qcow2   | disk name         |
| 120G          | disk size         |
| qcow2         | disk format       |

---

## Verify Disk

```bash
virsh vol-list default
```

Output:

```
Name          Path
-----------------------------------------
kiran.qcow2   /var/lib/libvirt/images/kiran.qcow2
```

---

# 7. Create Virtual Machine

Run:

```bash
virt-install \
--name kiran \
--memory 32768 \
--vcpus 16 \
--disk vol=default/kiran.qcow2,bus=virtio \
--cdrom /home/kiran/rhcos-live.iso \
--network bridge=br0,model=virtio \
--os-variant rhel9.0 \
--graphics vnc,listen=0.0.0.0 \
--boot cdrom,hd \
--noautoconsole
```

---

# 8. Explanation of Each Parameter

| Parameter               | Meaning                      |
| ----------------------- | ---------------------------- |
| --name                  | VM name                      |
| --memory 32768          | RAM (32 GB)                  |
| --vcpus 16              | number of CPU cores          |
| --disk                  | attach storage               |
| vol=default/kiran.qcow2 | disk volume                  |
| bus=virtio              | high-performance disk driver |
| --cdrom                 | installation ISO             |
| --network bridge=br0    | bridged networking           |
| --os-variant rhel9.0    | OS optimization              |
| --graphics vnc          | remote console               |
| --boot cdrom,hd         | boot order                   |
| --noautoconsole         | don't open console           |

---

# 9. Check VM Status

List VMs.

```bash
virsh list --all
```

Example:

```
Id   Name    State
-------------------------
1    kiran   running
```

---

# 10. Connect to VM Console

Get VNC port:

```bash
virsh vncdisplay kiran
```

Output:

```
:1
```

Meaning:

```
VNC Port = 5901
```

Connect using **TigerVNC**

```
server-ip:5901
```

---

# 11. Stop the Virtual Machine

Graceful shutdown:

```bash
virsh shutdown kiran
```

Force stop:

```bash
virsh destroy kiran
```

---

# 12. Start VM

```bash
virsh start kiran
```

---

# 13. Auto Start VM

Start VM automatically on host reboot.

```bash
virsh autostart kiran
```

---

# 14. Delete the VM

### Stop VM

```bash
virsh destroy kiran
```

### Remove VM configuration

```bash
virsh undefine kiran
```

### Delete disk

```bash
virsh vol-delete kiran.qcow2 --pool default
```

---

# 15. Common Errors and Fixes

---

## Error 1

```
virt-viewer not installed
```

Fix:

```bash
sudo dnf install virt-viewer
```

---

## Error 2

```
storage volume already exists
```

Fix:

```bash
virsh vol-delete kiran.qcow2 --pool default
```

Then recreate.

---

## Error 3

```
network bridge br0 not found
```

Check bridges:

```bash
ip a
```

Create bridge if needed.

---

## Error 4

```
KVM acceleration not available
```

Check:

```bash
lsmod | grep kvm
```

Enable virtualization in BIOS.

---

## Error 5

VM not starting.

Check logs:

```
/var/log/libvirt/qemu/
```

---

# 16. Useful virsh Commands

| Command           | Purpose     |
| ----------------- | ----------- |
| virsh list        | running VMs |
| virsh list --all  | all VMs     |
| virsh start vm    | start VM    |
| virsh shutdown vm | shutdown VM |
| virsh destroy vm  | force stop  |
| virsh undefine vm | delete VM   |
| virsh dominfo vm  | VM info     |

---

# 17. Where Files Are Stored

| File       | Location                |
| ---------- | ----------------------- |
| VM disk    | /var/lib/libvirt/images |
| VM configs | /etc/libvirt/qemu       |
| ISO file   | your chosen path        |

---

# 18. Best Practices

✔ Use **virtio drivers**
✔ Use **qcow2 disks**
✔ Allocate enough RAM
✔ Use bridge networking
✔ Enable CPU host-passthrough

Example improvement:

```
--cpu host-passthrough
```

---

# 19. VM Lifecycle

```
Create disk
     ↓
Create VM
     ↓
Start VM
     ↓
Connect console
     ↓
Install OS
     ↓
Use VM
```

---
