
## A) On KVM host (RHEL manager)

### 1. Check VM state

```bash
virsh domstate <VM_NAME>
```

Expected:

```text
running
```

---

### 2. Check VM NIC mapping

```bash
virsh domiflist <VM_NAME>
```

Expected:

```text
vnet44   bridge   br0   virtio   <MAC_ADDRESS>
```

---

### 3. Check vnet44 exists

```bash
ip link show vnet44
```

---

### 4. Check vnet44 attached to bridge

```bash
bridge link show dev vnet44
```

Expected:

```text
master br0 state forwarding
```

---

### 5. Check bridge members

```bash
bridge link | grep br0
```

You should see:

```text
eno1
vnet44
other vnet interfaces
```

---

### 6. Check VLAN

```bash
bridge vlan show dev vnet44
```

Expected:

```text
vnet44  1 PVID Egress Untagged
```

---

### 7. Check MAC learning

```bash
bridge fdb show br br0 | grep <MAC_ADDRESS>
```

Expected:

```text
<MAC_ADDRESS> dev vnet44
```

---

### 8. Check IP from QEMU guest agent

```bash
virsh domifaddr <VM_NAME> --source agent
```

Expected:

```text
enp1s0  <MAC_ADDRESS>  ipv4  192.168.1.4/24
```

---

### 9. Ping VM from KVM host

```bash
ping -c 4 192.168.1.4
```

---

### 10. Check SSH port from KVM host

```bash
nc -vz 192.168.1.4 22
```

Expected:

```text
Connected to 192.168.1.4:22
```

---

### 11. Check SSH authentication

```bash
ssh -v admin@192.168.1.4
```

---

## B) From Windows PC (where PuTTY is running)

### 12. Ping VM

Open CMD:

```cmd
ping 192.168.1.4
```

---

### 13. Test SSH port

Open PowerShell:

```powershell
Test-NetConnection 192.168.1.4 -Port 22
```

Expected:

```text
TcpTestSucceeded : True
```

---

### 14. Test SSH without PuTTY

PowerShell:

```powershell
ssh admin@192.168.1.4
```

---

## C) If SSH reaches but login fails

On VM console:

```bash
virsh console <VM_NAME>
```

Inside VM:

```bash
systemctl status sshd
```

```bash
ss -tlnp | grep :22
```

```bash
sshd -T | grep -E "passwordauthentication|permitrootlogin|pubkeyauthentication"
```

---


