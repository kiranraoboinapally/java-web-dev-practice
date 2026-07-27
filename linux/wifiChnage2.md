# KVM/libvirt Network Migration Backup Documentation

## 1. Overview

This folder contains the complete backup of the RHEL 9.7 KVM/libvirt host network configuration before replacing the ISP router.

The purpose of this backup is to ensure that:

* KVM host networking can be restored
* Linux bridge configuration can be verified
* VM network connectivity can be recovered
* VM MAC addresses are preserved
* VM definitions can be restored if required

This backup is created for ISP router replacement or network migration activities.

---

# 2. Environment Information

Platform:

```
Operating System:
RHEL 9.7

Virtualization:
KVM / libvirt

Network Bridge:
br0

Physical Network Interface:
eno1
```

Example network used in this documentation:

```
Network:
192.168.50.0/24

Router Gateway:
192.168.50.1

KVM Host:
192.168.50.10
```

Example layout:

```
                 ISP Router
              192.168.50.1
                    |
                    |
                  eno1
                    |
                    |
                  br0
                    |
          ---------------------
          |        |          |
        VM1      VM2        VM3
```

---

# 3. Backup Folder Structure

Location:

```
/root/network-migration-backup/
```

Complete structure:

```
network-migration-backup/
│
├── README.txt
│   └── Documentation for this backup
│
├── host-ip-addr.txt
│   └── KVM host IP address and interface information
│
├── host-ip-route.txt
│   └── Routing table and default gateway information
│
├── br0-config.txt
│   └── Linux bridge br0 configuration
│
├── br0-port-config.txt
│   └── Physical NIC connection to bridge
│
├── bridge-link-backup.txt
│   └── Current bridge attachment status
│
├── all-vm-list.txt
│   └── Complete VM inventory
│
├── all-vm-network.txt
│   └── VM network interface and MAC address mapping
│
└── vm-xml/
    │
    ├── DNS.xml
    ├── UniERP.xml
    ├── ticketmgmt.xml
    ├── iws.xml
    ├── wxd.xml
    └── other-vm.xml

        └── Complete libvirt VM definitions
```

---

# 4. File Details and Usage

---

# 4.1 host-ip-addr.txt

## Purpose

Contains the current network interface and IP address information of the KVM host.

Example:

```
Bridge:
br0

IP Address:
192.168.50.10/24

Physical Interface:
eno1
```

## Used for

Checking host network configuration after router replacement.

Example issue:

```
Cannot connect to KVM host
```

Check:

* Current host IP
* Bridge IP
* Network interface status

---

# 4.2 host-ip-route.txt

## Purpose

Contains the routing information of the KVM host.

Example:

```
default via 192.168.50.1
```

Meaning:

```
KVM Host
   |
   |
Gateway
192.168.50.1
   |
   |
Internet
```

## Used for

Troubleshooting:

* No internet access
* Wrong gateway
* Routing problems

---

# 4.3 br0-config.txt

## Purpose

Contains Linux bridge configuration details.

Example:

```
Bridge:
br0

Host IP:
192.168.50.10

Gateway:
192.168.50.1

DNS:
192.168.50.1
```

Network flow:

```
Virtual Machine
       |
       |
      br0
       |
       |
      eno1
       |
       |
    Router
```

## Used for

Bridge recovery or verification.

Example problem:

```
VMs are running but no network access
```

Check:

* Bridge IP
* Gateway
* DNS
* Bridge status

---

# 4.4 br0-port-config.txt

## Purpose

Contains bridge port information.

Example:

```
Bridge:
br0

Port:
eno1
```

Meaning:

```
Physical Network Cable
          |
         eno1
          |
         br0
          |
         VMs
```

## Used for

Checking whether the physical network interface is attached correctly.

---

# 4.5 bridge-link-backup.txt

## Purpose

Contains the current bridge link status.

Example:

```
eno1   master br0

vnet3  master br0
vnet5  master br0
vnet13 master br0
```

Explanation:

```
eno1:
Physical network interface

vnetX:
Virtual network interfaces created by libvirt
```

Example:

```
UniERP VM
    |
  vnet5
    |
   br0
    |
  eno1
    |
 Router
```

## Used for

Checking whether VM interfaces are connected to the bridge.

---

# 4.6 all-vm-list.txt

## Purpose

Contains the complete list of virtual machines.

Example:

```
DNS
UniERP
ticketmgmt
iws
wxd
```

May contain:

* VM name
* Running state
* Shutdown state

## Used for

Checking whether all expected VMs exist after migration.

---

# 4.7 all-vm-network.txt

## Purpose

Contains VM network adapter information.

Example:

```
===== UniERP =====

Interface:
vnet5

Type:
bridge

Source:
br0

Model:
virtio

MAC:
52:54:00:11:22:33
```

Explanation:

```
VM:
UniERP

Network Adapter:
vnet5

Connected Bridge:
br0

MAC Address:
52:54:00:11:22:33
```

## Important

This file preserves VM network identity.

The MAC address should not be changed.

---

# 4.8 vm-xml Directory

## Purpose

Contains complete libvirt XML definitions of every VM.

Example:

```
vm-xml/

DNS.xml
UniERP.xml
ticketmgmt.xml
```

Each XML contains:

* VM name
* CPU allocation
* Memory allocation
* Disk information
* Network adapter
* MAC address
* Bridge configuration

Example:

```xml
<interface type='bridge'>
    <mac address='52:54:00:11:22:33'/>
    <source bridge='br0'/>
    <model type='virtio'/>
</interface>
```

Meaning:

```
VM Network:

Bridge:
br0

MAC:
52:54:00:11:22:33
```

---

# 5. Network Migration Scenario

## Before Router Replacement

Example:

```
Old ISP Router
      |
      |
    eno1
      |
      |
     br0
      |
      |
   KVM Host
      |
      |
    VMs
```

---

## After Router Replacement

Example:

```
New ISP Router
      |
      |
    eno1
      |
      |
     br0
      |
      |
   KVM Host
      |
      |
    VMs
```

---

# 6. Migration Rules

During router replacement:

## Do NOT change:

```
- VM names
- VM MAC addresses
- VM XML files
- VM disk files
- Bridge name br0
```

These identify the VM network configuration.

---

## Possible changes:

```
- Router IP address
- Gateway
- DNS server
- KVM host IP
- Static VM IP addresses
```

Only modify these if the new router uses a different subnet.

---

# 7. Troubleshooting Guide

---

## Problem: KVM host has no network

Check:

```
host-ip-addr.txt
host-ip-route.txt
br0-config.txt
```

Verify:

```
Host IP:
192.168.50.10

Gateway:
192.168.50.1
```

---

## Problem: VM starts but no network

Check:

```
all-vm-network.txt
```

Verify:

```
VM
 |
br0
 |
eno1
 |
Router
```

Check:

* Bridge name
* MAC address
* Virtual interface

---

## Problem: VM definition is missing

Check:

```
vm-xml/
```

Restore example:

```
virsh define UniERP.xml
```

---

# 8. Recovery Information

The most important recovery files are:

Priority 1:

```
vm-xml/
```

Complete VM definitions.

Priority 2:

```
all-vm-network.txt
```

VM network mapping and MAC addresses.

Priority 3:

```
br0-config.txt
```

Host bridge configuration.

Priority 4:

```
host-ip-route.txt
```

Gateway and routing information.

---

# 9. Backup Verification

Verify backup contents:

```
ls -la /root/network-migration-backup
```

Verify VM XML files:

```
ls -la /root/network-migration-backup/vm-xml
```

Expected:

```
DNS.xml
UniERP.xml
ticketmgmt.xml
iws.xml
wxd.xml
```

---

# 10. Backup Created For

Purpose:

```
ISP Router Replacement
Network Migration
KVM/libvirt Recovery
```

System:

```
RHEL 9.7 KVM Host
```

Bridge:

```
br0
```

Physical Interface:

```
eno1
```

Backup Location:

```
/root/network-migration-backup/
```

End of Documentation.
