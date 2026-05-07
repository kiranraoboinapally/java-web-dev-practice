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
for vm in $(virsh list --name); do
  mac=$(virsh domiflist $vm | awk '/virtio/ {print $5}')
  ip=$(ip neigh | grep -i $mac | awk '{print $1}')
  echo "$vm -> $ip"
done
```

### Commit message


