Below is a complete documentation guide for this process: **expanding a RHEL VM disk from 40GB to 100GB using LVM + XFS without deleting data**.

# RHEL VM Disk Expansion Guide (LVM + XFS)

## Objective

Increase the available root filesystem space on a RHEL VM.

### Original situation

The VM had:

* Virtual disk: **100GB**
* Partition used by OS: **39GB**
* Root filesystem: **35GB**
* Disk usage: **95% full**

Problem:

* Elasticsearch was failing because the root filesystem was almost full.
* The VM disk already had unused space available.
* No application files needed to be deleted.

---

# 1. Check current disk layout

First identify the disk and partitions.

Command:

```bash
lsblk
```

Initial output:

```text
NAME          SIZE TYPE MOUNTPOINT
vda           100G disk
├─vda1          1G part /boot
└─vda2         39G part
  ├─rhel-root 35.1G lvm  /
  └─rhel-swap 3.9G lvm  [SWAP]
```

Observation:

* Disk `/dev/vda` = 100GB
* Partition `/dev/vda2` = only 39GB
* Remaining disk space was unused

---

# 2. Verify filesystem type

Check filesystem:

```bash
df -T /
```

Example output:

```text
Filesystem            Type
/dev/mapper/rhel-root xfs
```

Important:

* RHEL commonly uses **XFS**
* XFS expansion uses `xfs_growfs`

---

# 3. Verify LVM configuration

Check physical volume:

```bash
pvs
```

Example:

```text
PV         VG   PSize   PFree
/dev/vda2  rhel <39G      0
```

Check volume group:

```bash
vgs
```

Example:

```text
VG   VSize   VFree
rhel <39G      0
```

Check logical volumes:

```bash
lvs
```

Example:

```text
LV    VG    Size
root  rhel 35.1G
swap  rhel 3.9G
```

Conclusion:

* LVM was only aware of 39GB.
* The extra disk space was not assigned.

---

# 4. Install growpart utility

`growpart` expands an existing partition into available disk space.

Install:

```bash
dnf install cloud-utils-growpart -y
```

Verify:

```bash
which growpart
```

Expected:

```text
/usr/bin/growpart
```

---

# 5. Expand the partition

Before:

```text
/dev/vda2 = 39G
```

Command:

```bash
growpart /dev/vda 2
```

Meaning:

* `/dev/vda` = disk
* `2` = partition number

Verify:

```bash
lsblk
```

After:

```text
vda          100G
├─vda1         1G
└─vda2        99G
```

At this point:

* Partition is expanded
* LVM still sees old size

---

# 6. Resize the LVM Physical Volume

Tell LVM that the partition is larger.

Command:

```bash
pvresize /dev/vda2
```

Expected:

```text
Physical volume "/dev/vda2" changed
```

Verify:

```bash
pvs
```

Example:

```text
PV          VG    PSize   PFree
/dev/vda2   rhel  99G     ~60G
```

Now LVM knows about the additional space.

---

# 7. Extend the root Logical Volume

Use all available free space for root.

Command:

```bash
lvextend -l +100%FREE /dev/rhel/root
```

Explanation:

* `lvextend` increases logical volume size
* `+100%FREE` uses all unused VG space
* `/dev/rhel/root` is the root logical volume

Verify:

```bash
lvs
```

Expected:

```text
LV    VG    Size
root  rhel  ~95G
swap  rhel   3.9G
```

---

# 8. Expand the XFS filesystem

The logical volume is larger, but the filesystem still needs expansion.

For XFS:

```bash
xfs_growfs /
```

Expected:

```text
data blocks changed
```

No reboot is required.

---

# 9. Verify final storage

Command:

```bash
df -h /
```

Before:

```text
Filesystem              Size Used Avail Use%
/dev/mapper/rhel-root    35G  33G  2G   95%
```

After:

```text
Filesystem              Size Used Avail Use%
/dev/mapper/rhel-root    95G  33G  62G  35%
```
---

# Safety Notes

## What this process changes

Affected:

✅ This VM only
✅ `/dev/vda` virtual disk inside the VM
✅ RHEL LVM layout
✅ Root filesystem size

Not affected:

❌ Physical host server
❌ Other VMs
❌ Docker volumes
❌ ERP application files
❌ Databases
❌ `/home/admin/files`

---

# Recommended Before Production Change

Before running storage changes:

1. Take a VM snapshot if available.
2. Confirm backups exist.
3. Record current state:

```bash
lsblk
pvs
vgs
lvs
df -h
```

---

# Final State

Expected final architecture:

```text
Virtual Disk
/dev/vda 100G
│
├── /dev/vda1
│      └── /boot 1G
│
└── /dev/vda2 99G
       │
       └── LVM VG: rhel
              │
              ├── root LV ~95G
              │       └── XFS /
              │
              └── swap LV ~4G
```

Result:

* Disk pressure removed
* Elasticsearch can start normally
* No application data deleted
* VM remains online throughout the expansion process

This is the standard RHEL production approach for extending an existing LVM/XFS root filesystem.
