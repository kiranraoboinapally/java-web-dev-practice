
---

# 📘 RHEL 9 Nested KVM Lab Setup (HOST: 192.168.1.14)

---

# 🧭 0. LAB GOAL (what you are building)

You are building a mini private cloud:

```
192.168.1.14 (KVM HOST)
│
├── Management Layer
│     ├── Cockpit Web UI
│     ├── libvirt / KVM engine
│     └── virsh CLI tools
│
├── Storage Layer
│     ├── qcow2 VM disks
│     └── ISO images
│
├── Network Layer
│     ├── NAT (default)
│     └── Bridge (optional br0)
│
└── Compute Layer
      ├── VM1 (testvm)
      ├── VM2 (app server)
      └── VM3 (db server)
```

---

# 🖥️ 1. BASE SYSTEM CHECK (192.168.1.14)

## CPU virtualization

```bash id="c1"
egrep -c '(vmx|svm)' /proc/cpuinfo
```

✔ Must be > 0

---

## RAM

```bash id="c2"
free -h
```

✔ Minimum: 4GB
✔ Recommended: 8GB+

---

## Disk

```
df -h
```

✔ Minimum: 20GB free

---

# ⚙️ 2. INSTALL CORE VIRTUALIZATION STACK(Check before Install***)

## 2.1 Install KVM base system

```
sudo dnf install -y @virtualization
```

---

## 2.2 Enable hypervisor

```
sudo systemctl enable --now libvirtd
```

---

## 2.3 Install CLI tools

libvirt-client

```
sudo dnf install -y libvirt-client
```

---

## 2.4 Install VM creation tool

```bash id="c7"
sudo dnf install -y virt-install
```

---

# 🌐 3. NETWORK ARCHITECTURE

## 3.1 Default NAT network

```text id="n1"
VM → 192.168.122.x
     ↓
   HOST (192.168.1.14)
     ↓
   INTERNET
```

✔ Safe
✔ Easy
❌ Not visible in LAN

---

## 3.2 Bridge network (production style)

```text id="n2"
VM → 192.168.1.x (real LAN IP)
```

✔ Real server behavior
✔ Used in DevOps environments

---

# 🖥️ 4. STORAGE LAYER (QCOW2)

## Location:

```text id="s1"
/var/lib/libvirt/images/
```

## Example VM disk:

```text id="s2"
testvm.qcow2
```

---

## How qcow2 works:

```text id="s3"
Base image (optional template)
        ↓
VM disk file (qcow2)
        ↓
Only changes stored (copy-on-write)
```

✔ Saves disk space
✔ Fast VM cloning

---

# 🌍 5. INSTALL WEB MANAGEMENT (COCKPIT)

## Install

```bash id="c8"
sudo dnf install -y cockpit cockpit-machines
```

---

## Enable service

```bash id="c9"
sudo systemctl enable --now cockpit.socket
```

---

## Firewall setup

```bash id="c10"
sudo systemctl start firewalld
sudo firewall-cmd --permanent --add-service=cockpit
sudo firewall-cmd --reload
```

---

## Access UI

```text id="c11"
https://192.168.1.14:9090
```

Login:

* Linux user of `.14`
* Linux password of `.14`

---

## Cockpit provides:

Cockpit

✔ VM list
✔ Start/stop
✔ Console access
✔ CPU/RAM monitoring

---

# 💿 6. CREATE FIRST VM

## Command:

```bash id="vm1"
sudo virt-install \
--name testvm \
--memory 2048 \
--vcpus 2 \
--disk size=10 \
--os-variant rhel9-unknown \
--network network=default \
--graphics none \
--console pty,target_type=serial \
--location 'http://mirror.stream.centos.org/9-stream/BaseOS/x86_64/os/'
```

---

## VM lifecycle:

```text id="vmflow"
virt-install
   ↓
libvirt defines VM
   ↓
qcow2 disk created
   ↓
QEMU process starts
   ↓
OS installation begins
   ↓
VM ready
```

---

# 🧠 7. VM MANAGEMENT LAYER

## List VMs

```bash id="m1"
virsh list --all
```

---

## Start VM

```bash id="m2"
virsh start testvm
```

---

## Shutdown VM

```bash id="m3"
virsh shutdown testvm
```

---

## VM IP

```bash id="m4"
virsh domifaddr testvm
```

---

# 🔐 8. SECURITY LAYER

## Firewall check

```bash id="sec1"
systemctl status firewalld
```

---

## Cockpit port

```text id="sec2"
9090/tcp
```

---

## SSH access

VMs and host use:

* key-based authentication (recommended)
* password (optional fallback)

---

# 🧪 9. FINAL LAB STRUCTURE

```text id="final"
192.168.1.14 (KVM HOST)
│
├── Cockpit (:9090)
├── libvirt / KVM engine
├── libvirt-client tools
│
├── Storage
│     ├── /var/lib/libvirt/images/
│     └── qcow2 disks
│
├── Network
│     ├── NAT (default)
│     └── Bridge (optional br0)
│
└── VMs
      ├── testvm (2GB RAM)
      ├── appvm
      └── dbvm
```

---

# 🚀 10. WHAT YOU NOW HAVE

✔ Full virtualization host
✔ VM creation system
✔ Web UI management
✔ CLI control system
✔ Storage system (qcow2)
✔ Networking understanding

---

# 💡 11. REAL-WORLD UPGRADE PATH

If you continue, next steps are:

### 🔥 Level 2

* Bridge networking (real LAN IP VMs)
* Static IP configuration
* SSH automation

### 🔥 Level 3

* Multi-VM architecture (web + DB + load balancer)
* Cloud-init automation
* Python VM provisioning (your script)

### 🔥 Level 4

* Multi-host KVM cluster
* Shared storage
* OpenStack-style lab

---


