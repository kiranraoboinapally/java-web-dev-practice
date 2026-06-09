
---

## Overview
This guide provides step-by-step instructions for setting up an Oracle Linux 8 virtual machine using KVM (Kernel-based Virtual Machine) on a Linux host system.

---

## Prerequisites
- KVM/QEMU installed and enabled
- Root or sudo access
- Sufficient disk space (minimum 50GB for the VM disk)
- Oracle Linux R8 U8 ISO file
- libvirt service running

---

## Step 1: Find Existing QCOW2 Images

Check for any existing QCOW2 disk images on your system:

```bash
find / -type f -name "*.qcow2" 2>/dev/null
```

---

## Step 2: List Existing ISO Files

Switch to root user and check for available ISO files:

```bash
sudo su -
find /var/lib/libvirt/images -type f -name "*.iso"
exit
```

---

## Step 3: Upload Oracle Linux ISO (If Not Exists)

If the Oracle Linux ISO file doesn't exist, upload it to the downloads directory:

```bash
# Download location
/home/kiran/downloads/OracleLinux-R8-U8-x86_64-dvd.iso
```

---

## Step 4: Move ISO to libvirt Images Directory

Move the ISO file to the libvirt images directory:

```bash
sudo mv /home/kiran/downloads/OracleLinux-R8-U8-x86_64-dvd.iso /var/lib/libvirt/images/
```

---

## Step 5: Set ISO File Ownership

Change the ownership of the ISO file to the QEMU user:

```bash
sudo chown qemu:qemu /var/lib/libvirt/images/OracleLinux-R8-U8-x86_64-dvd.iso
```

---

## Step 6: Set ISO File Permissions

Set appropriate read permissions:

```bash
sudo chmod 644 /var/lib/libvirt/images/OracleLinux-R8-U8-x86_64-dvd.iso
```

**Verify** the file permissions:

```bash
ls -lh /var/lib/libvirt/images/OracleLinux-R8-U8-x86_64-dvd.iso
```

**Expected Output:**
```
-rw-r--r--. 1 qemu qemu 8.6G [DATE] OracleLinux-R8-U8-x86_64-dvd.iso
```

---

## Step 7: Create QCOW2 Disk Image

Create a 50GB QCOW2 disk image for the virtual machine:

```bash
sudo qemu-img create -f qcow2 /home/kvm-images/oraclelinux8.qcow2 50G
```

---

## Step 8: Set Disk Image Ownership and Permissions

### 8a. Change Ownership

```bash
sudo chown qemu:qemu /home/kvm-images/oraclelinux8.qcow2
```

### 8b. Set Permissions

```bash
sudo chmod 644 /home/kvm-images/oraclelinux8.qcow2
```

**Verify** the disk image permissions:

```bash
ls -lh /home/kvm-images/oraclelinux8.qcow2
```

**Expected Output:**
```
-rw-r--r--. 1 qemu qemu 196K [DATE] oraclelinux8.qcow2
```

---

## Step 9: Create Virtual Machine with virt-install

Execute the `virt-install` command to create and start the virtual machine:

```bash
sudo virt-install \
  --name oraclelinux8 \
  --ram 8192 \
  --vcpus 2 \
  --disk path=/home/kvm-images/oraclelinux8.qcow2,format=qcow2 \
  --cdrom /var/lib/libvirt/images/OracleLinux-R8-U8-x86_64-dvd.iso \
  --os-variant ol8.0 \
  --network bridge=br0 \
  --graphics vnc,listen=127.0.0.1 \
  --noautoconsole
```

### Parameter Explanation:
- `--name`: VM name
- `--ram`: Memory allocation (8GB)
- `--vcpus`: Number of vCPUs (2)
- `--disk`: QCOW2 disk image path and format
- `--cdrom`: Path to Oracle Linux ISO
- `--os-variant`: OS variant for optimization
- `--network`: Network bridge configuration
- `--graphics`: VNC graphics support
- `--noautoconsole`: Don't open an interactive console

---

## Step 10: Monitor Installation via Cockpit

1. **Login to Cockpit** (typically at `https://localhost:9090`)
2. Navigate to the Virtual Machines section
3. Select the `oraclelinux8` VM to monitor installation progress
4. Once installation completes, the VM will reboot

---

## Step 11: Network Configuration Troubleshooting

### Issue: IP Address Not Being Assigned

If the virtual machine is not receiving an IP address from DHCP:

#### 11a. Check Network Device Status

```bash
nmcli device status
```

Or:

```bash
nmcli connection show
```

**Expected Output:**
```
NAME      TYPE      DEVICE
enp1s0    ethernet  enp1s0
```

If showing as **disconnected**, proceed to step 11b.

#### 11b. List Available Network Connections

```bash
nmcli connection show
```

Note the connection name (e.g., `enp1s0`, `System eth0`, etc.)

#### 11c. Verify Bridge Network Autoconnect

Check if the bridge network connection has autoconnect enabled:

```bash
nmcli connection show br0-net | grep autoconnect
```

**Expected Output:**
```
connection.autoconnect:                  yes
```

---

## Troubleshooting Tips

### Network Not Connected
- Ensure the bridge `br0` is properly configured on the host
- Verify the connection name with `nmcli connection show`
- Manually activate the connection:
  ```bash
  sudo nmcli connection up enp1s0
  ```

### VM Won't Start
- Check KVM/QEMU service status: `sudo systemctl status libvirtd`
- Verify file permissions are correct
- Ensure ISO and disk paths are accessible

### VNC Connection Issues
- Find VNC port: `sudo virsh dumpxml oraclelinux8 | grep vnc`
- Connect via VNC client to `localhost:[PORT]`

---

## Useful Commands

```bash
# List all VMs
sudo virsh list --all

# Get VM information
sudo virsh dominfo oraclelinux8

# Check VM network details
sudo virsh domifaddr oraclelinux8

# View VM console
sudo virsh console oraclelinux8

# Start/Stop VM
sudo virsh start oraclelinux8
sudo virsh shutdown oraclelinux8

# Edit VM configuration
sudo virsh edit oraclelinux8
```

---

## Notes

- Ensure sufficient disk space in `/home/kvm-images/` and `/var/lib/libvirt/images/`
- The bridge `br0` must be configured on the host for VM network connectivity
- Use Cockpit for a user-friendly interface to manage VMs
- Always use sudo for commands affecting libvirt/KVM

---

sudo sshd -T | grep pubkeyauthentication
pubkeyauthentication yes
sudo sshd -T | grep -i passwordauthentication
passwordauthentication no

check these for setting as login with pageant for this without password
