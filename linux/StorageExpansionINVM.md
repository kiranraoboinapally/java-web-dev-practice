# KVM VM Disk Expansion Documentation (RHEL/KVM/libvirt/qcow2)

---

# Scenario

Current VM disk size:

```text
100G
```

Required new size:

```text
200G
```

Increase amount:

```text
+100G
```

---

# Architecture

Host stores VM disks in:

```text
/home/kvm-images/
```

Example VM disk:

```text
/home/kvm-images/ayd.qcow2
```

VM uses:

* KVM/libvirt
* qcow2
* LVM
* XFS (RHEL default)

---

# PART 1 — HOST SIDE (KVM HOST)

---

# Step 1 — Identify VM Disk

Check VM disk mapping:

```bash
virsh domblklist ayd
```

Example output:

```text
Target   Source
--------------------------------------
vda      /home/kvm-images/ayd.qcow2
sda      -
```

---

# Step 2 — Verify Host Free Space

Check host storage:

```bash
df -h
```

Ensure filesystem containing:

```text
/home/kvm-images
```

has enough free space.

Example:

```text
/dev/mapper/rhel_192-home   2.5T   590G   2.0T   24%   /home
```

---

# Step 3 — Optional Backup (Recommended)

Create backup copy:

```bash
cp /home/kvm-images/ayd.qcow2 /home/kvm-images/ayd-backup.qcow2
```

OR create snapshot:

```bash
virsh snapshot-create-as ayd before-expand
```

---

# Step 4 — Shutdown VM

Safely stop VM:

```bash
virsh shutdown ayd
```

Verify VM is stopped:

```bash
virsh list --all
```

Expected state:

```text
shut off
```

---

# Step 5 — Verify Current Disk Size

Check qcow2 info:

```bash
qemu-img info /home/kvm-images/ayd.qcow2
```

Example:

```text
virtual size: 100 GiB
```

---

# Step 6 — Increase qcow2 Disk Size

Increase by 100G:

```bash
qemu-img resize /home/kvm-images/ayd.qcow2 +100G
```

OR set total size directly:

```bash
qemu-img resize /home/kvm-images/ayd.qcow2 200G
```

---

# Step 7 — Verify Resize

Run again:

```bash
qemu-img info /home/kvm-images/ayd.qcow2
```

Expected:

```text
virtual size: 200 GiB
```

---

# Step 8 — Start VM

Start virtual machine:

```bash
virsh start ayd
```

---

# PART 2 — INSIDE THE VM (GUEST OS)

SSH into VM:

```bash
ssh admin@<vm-ip>
```

---

# Step 1 — Check Disk Layout

View block devices:

```bash
lsblk
```

Example before partition expansion:

```text
vda      200G
├─vda1     1G
└─vda2    99G
  ├─rhel-root
  └─rhel-swap
```

Important:

* Disk (`vda`) is now 200G
* Partition (`vda2`) is still old size

---

# Step 2 — Install growpart Utility

Install package:

```bash
sudo dnf install cloud-utils-growpart -y
```

---

# Step 3 — Extend Partition

Expand partition 2:

```bash
sudo growpart /dev/vda 2
```

Meaning:

* Disk = `/dev/vda`
* Partition number = `2`

---

# Step 4 — Verify Partition Expansion

Check again:

```bash
lsblk
```

Expected:

```text
vda      200G
└─vda2   199G
```

---

# Step 5 — Resize LVM Physical Volume

Update LVM physical volume:

```bash
sudo pvresize /dev/vda2
```

---

# Step 6 — Check Logical Volumes

View LVM layout:

```bash
lvs
```

Example:

```text
LV    VG   Attr       LSize
root  rhel -wi-ao---- 100G
swap  rhel -wi-ao----   8G
```

---

# Step 7 — Extend Root Logical Volume

Extend root LV using all free space:

```bash
sudo lvextend -l +100%FREE /dev/mapper/rhel-root
```

---

# Step 8 — Grow XFS Filesystem

Expand filesystem:

```bash
sudo xfs_growfs /
```

---

# Step 9 — Verify Final Filesystem Size

Check final storage:

```bash
df -h
```

Expected:

```text
Filesystem                 Size  Used Avail Use%
/dev/mapper/rhel-root     200G   XXG   XXXG
```

---

# OPTIONAL — Remove Backup After Verification

If everything works properly:

```bash
rm -f /home/kvm-images/ayd-backup.qcow2
```

---

# Important Notes

## Safe Operations

These are safe:

* `qemu-img resize` (increase only)
* `growpart`
* `pvresize`
* `lvextend`
* `xfs_growfs`

---

# Avoid

Do NOT:

* shrink qcow2 casually
* resize wrong VM disk
* run resize on active VM
* delete active qcow2

---

# Important Concepts

| Layer      | Purpose             |
| ---------- | ------------------- |
| qcow2      | Virtual disk file   |
| Partition  | `/dev/vda2`         |
| PV         | LVM physical volume |
| LV         | Logical volume      |
| Filesystem | XFS mounted on `/`  |

---

# Resize Flow

```text
HOST:
qcow2 resize

GUEST:
Partition resize
→ PV resize
→ LV resize
→ Filesystem grow
```

---

# Useful Verification Commands

## Host

```bash
virsh domblklist ayd

qemu-img info /home/kvm-images/ayd.qcow2

df -h
```

---

## Guest

```bash
lsblk

pvs
vgs
lvs

df -h
```

---


* Filesystem available immediately
* VM continues working normally
