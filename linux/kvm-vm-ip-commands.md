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
  [ -z "$vm" ] && continue

  mac=$(virsh domiflist "$vm" | awk '/virtio/ {print $5}')
  ip=$(ip neigh | awk -v mac="$mac" 'tolower($0) ~ tolower(mac) {print $1}')

  echo "$vm -> ${ip:-No IP found}"
done
```


## For checking complete CPUs,RAM,Storage,VMs

```
echo "===== CPU ====="; lscpu | grep -E "Model name|CPU\\(s\\)|Thread|Core|Socket"; echo; \
echo "===== RAM ====="; free -h; echo; \
echo "===== DISK ====="; lsblk; echo; \
echo "===== FILESYSTEM ====="; df -h; echo; \
echo "===== VMS ====="; virsh list --all 2>/dev/null
```




