

## Current setup:

* RHEL 9.7 KVM/libvirt host
* Bridge networking (`br0`)
* Host static IP: `192.168.50.10`
* Router gateway: `192.168.50.1`
* VMs connected through `br0`
* Some VMs may be static IP, some may be DHCP

Goal: **Replace Airtel router with Tata Play Fiber without breaking VMs/services.**

---

# PHASE 1 — Before changing router (backup everything)

Do this while the Airtel network is still working.

---

## Step 1: Create a backup folder

On the KVM host:

```bash
mkdir -p /root/network-migration-backup
cd /root/network-migration-backup
```

---

# Step 2: Backup host network configuration

### Save IP information

```bash
ip addr > host-ip-addr.txt
```

```bash
ip route > host-ip-route.txt
```

### Save bridge configuration

```bash
nmcli connection show br0 > br0-config.txt
```

```bash
nmcli connection show br0-port > br0-port-config.txt
```

Current expected configuration:

```
br0 IP      : 192.168.50.10
Gateway     : 192.168.50.1
DNS         : 192.168.50.1
Subnet      : /24
```

---

# Step 3: Backup all VM list

Include running and shutdown VMs:

```bash
virsh list --all > all-vm-list.txt
```

---

# Step 4: Backup every VM network interface

This is important.

```bash
for vm in $(virsh list --all --name); do
    echo "===== $vm ====="
    virsh domiflist "$vm"
done > all-vm-network.txt
```

This saves:

* VM name
* Bridge
* MAC address

---

# Step 5: Backup VM XML configuration

Highly recommended.

```bash
mkdir vm-xml

for vm in $(virsh list --all --name); do
    virsh dumpxml "$vm" > vm-xml/"$vm".xml
done
```

Now you have a complete VM definition backup.

---

# Step 6: Save current VM IP mapping

Save the current VM IP details:

```bash
nano vm-current-ip.txt
```

Example:

```
wxd             192.168.50.45
datacapwindow   192.168.50.35
UniERP          192.168.50.60
ayd             192.168.50.52
ticketmgmt      192.168.50.80
DNS             192.168.50.5
iws             192.168.50.25
```

---

# Step 7: Identify important services

Make a list:

| VM         | Purpose         |
| ---------- | --------------- |
| DNS        | DNS service     |
| UniERP     | ERP application |
| ticketmgmt | Ticket system   |
| iws        | Application     |
| wxd        | Application     |

This helps testing later.

---

# PHASE 2 — Check VM IP type (static or DHCP)

You do not need to check shutdown VMs now.

Check important running VMs first.

Example:

```bash
virsh console UniERP
```

Inside VM:

```bash
nmcli -f ipv4.method,ipv4.addresses,ipv4.gateway connection show
```

Record:

| VM     | IP            | Type   |
| ------ | ------------- | ------ |
| UniERP | 192.168.50.60 | Static |
| DNS    | 192.168.50.5  | Static |
| Test   | 192.168.50.x  | DHCP   |

Exit console:

```
Ctrl + ]
```

---

# PHASE 3 — Replace Airtel router with Tata Play Fiber

## Step 1

Disconnect Airtel router.

Connect:

```
Tata Play Fiber Router
        |
        |
      eno1
        |
       br0
        |
       Host
        |
       VMs
```

---

## Step 2

DO NOT change host IP immediately.

First check the new router LAN address.

Possible Tata Play router IP:

```
192.168.50.1
```

or

```
192.168.29.1
```

---

# PHASE 4 — Decision point

## Case A: Tata router is 192.168.50.1

This is the best case.

Your current configuration:

```
Router:
192.168.50.1

Host:
192.168.50.10

VMs:
192.168.50.x
```

can remain.

Do not change:

* br0
* host IP
* VM IPs
* MAC addresses

Test:

Host:

```bash
ping 192.168.50.1
```

Internet:

```bash
ping google.com
```

VMs:

```bash
ping 192.168.50.60
ping 192.168.50.5
```

---

# Case B: Tata router is 192.168.29.1

Then change host bridge.

Example:

Old:

```
Host:
192.168.50.10

Gateway:
192.168.50.1
```

New:

```
Host:
192.168.29.10

Gateway:
192.168.29.1
```

Commands:

```bash
nmcli connection modify br0 ipv4.addresses 192.168.29.10/24
```

```bash
nmcli connection modify br0 ipv4.gateway 192.168.29.1
```

```bash
nmcli connection modify br0 ipv4.dns 192.168.29.1
```

Restart:

```bash
nmcli connection down br0
nmcli connection up br0
```

Then update static VMs.

---

# PHASE 5 — Start and test VMs

Start VMs:

```bash
virsh start VM_NAME
```

Check:

```bash
virsh list
```

Check VM IPs:

```bash
ip neigh
```

---

# PHASE 6 — Test services

Test in order:

## 1. Network

Host:

```bash
ping google.com
```

VM:

```bash
ping 192.168.50.10
```

---

## 2. DNS

If DNS VM:

```bash
nslookup your-domain
```

---

## 3. Applications

Check:

* ERP login
* Ticket system
* Web applications
* Database connectivity

---

# PHASE 7 — After everything works

Save final state:

```bash
ip addr > final-ip.txt
```

```bash
ip route > final-route.txt
```

```bash
virsh list --all > final-vm-list.txt
```

---

# Important rules during migration

Do NOT change:

❌ VM MAC addresses
❌ VM names
❌ libvirt XML
❌ VM disk files

Only change:

✅ Gateway
✅ Host IP (if subnet changes)
✅ VM static IPs (if subnet changes)
✅ DNS settings

---

## Final example network after migration

```
Router:
192.168.50.1

KVM Host:
192.168.50.10

DNS VM:
192.168.50.5

UniERP:
192.168.50.60

ticketmgmt:
192.168.50.80

wxd:
192.168.50.45

iws:
192.168.50.25
```

The most important step after Tata Play installation:

**Check Tata Play Fiber router LAN IP before making any changes.**

If it matches `192.168.50.1`, the migration should require almost no network changes.

This keeps your original operational document style but replaces the old addresses with a realistic office/home-lab style subnet.
