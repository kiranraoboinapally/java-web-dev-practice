### Short README content


# KVM VM IP Commands

## List all VMs
```bash
virsh list --all
````

## Get VM MAC address

```bash
virsh domiflist <vmname>
```

## Find VM IP using MAC

```bash
ip neigh | grep <MAC>
```

Example:

```bash
ip neigh | grep 52:54:00:ab:cd:ef
```

## Direct IP lookup

```bash
virsh domifaddr <vmname>
```

## DHCP leases

```bash
virsh net-dhcp-leases default
```

## Show all VM IPs

```bash
#!/bin/bash

VM_LIST=$(virsh list --name)

for VM in $VM_LIST
do
    MAC=$(virsh domiflist "$VM" | awk 'NR>2 {print $5}')

    if [ -n "$MAC" ]; then
        IP=$(ip neigh show | awk -v mac="$MAC" '$0~mac {print $1}')
        echo "$VM : ${IP:-UNKNOWN}"
    fi
done
```

```
or
virsh domifaddr <VMNAME> --source agent
```

## For checking complete CPUs,RAM,Storage,VMs

```
echo "===== CPU ====="; lscpu | grep -E "Model name|CPU\\(s\\)|Thread|Core|Socket"; echo; \
echo "===== RAM ====="; free -h; echo; \
echo "===== DISK ====="; lsblk; echo; \
echo "===== FILESYSTEM ====="; df -h; echo; \
echo "===== VMS ====="; virsh list --all 2>/dev/null
```

nmcli connection show "$(nmcli -t -f NAME connection show --active | head -1)" | grep "ipv4.method"

above command inside vm
If this returns manual then IP is fixed other than that as auto means it will change IP sometimes


