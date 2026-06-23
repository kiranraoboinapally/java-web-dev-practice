WireGuard Setup

```text
Physical Host
↓
RHEL 9.7 VM
↓
WireGuard installed inside this RHEL VM
↓
Multiple internal servers behind it
```

You want to **set up WireGuard manually from scratch** (without relying on your script).

This guide assumes:

* WireGuard server runs inside the **RHEL 9.7 VM**
* VPN subnet = `10.10.0.0/24`
* WireGuard port = `51820`
* Client example = `kiran`

---

# Step 1 — Verify WireGuard Installed

SSH into RHEL VM:

```bash
ssh root@<rhel-vm-ip>
```

Check:

```bash
wg --version
```

Expected:

```text
wireguard-tools x.x.x
```

If not installed:

```bash
dnf install epel-release -y
dnf install wireguard-tools -y
```

Verify:

```bash
wg --version
```

---

# Step 2 — Check Existing WireGuard Config

Check:

```bash
ls -la /etc/wireguard
```

Expected:

```text
wg0.conf
server.key
server.pub
```

If files already exist:

```bash
cat /etc/wireguard/wg0.conf
```

If this is already configured → skip server creation.

---

# Step 3 — Create Server Keys (only if new)

Generate:

```bash
mkdir -p /etc/wireguard
chmod 700 /etc/wireguard

wg genkey | tee /etc/wireguard/server.key \
| wg pubkey > /etc/wireguard/server.pub
```

Verify:

```bash
ls -l /etc/wireguard
```

---

# Step 4 — Create Server Config

Open:

```bash
nano /etc/wireguard/wg0.conf
```

Paste:

```ini
[Interface]

Address = 10.10.0.1/24
ListenPort = 51820
PrivateKey = PASTE_SERVER_PRIVATE_KEY

SaveConfig = true
```

Get server key:

```bash
cat /etc/wireguard/server.key
```

Paste into:

```ini
PrivateKey =
```

Save.

---

# Step 5 — Enable IP Forwarding

Temporary:

```bash
sysctl -w net.ipv4.ip_forward=1
```

Permanent:

```bash
nano /etc/sysctl.conf
```

Add:

```text
net.ipv4.ip_forward=1
```

Apply:

```bash
sysctl -p
```

Verify:

```bash
cat /proc/sys/net/ipv4/ip_forward
```

Expected:

```text
1
```

---

# Step 6 — Open Firewall

Allow WireGuard:

```bash
firewall-cmd --permanent --add-port=51820/udp
```

Enable routing:

```bash
firewall-cmd --permanent --add-masquerade
```

Reload:

```bash
firewall-cmd --reload
```

Verify:

```bash
firewall-cmd --list-all
```

---

# Step 7 — Start WireGuard

Start:

```bash
systemctl enable wg-quick@wg0
systemctl start wg-quick@wg0
```

Verify:

```bash
systemctl status wg-quick@wg0
```

Check:

```bash
wg show
```

Expected:

```text
interface: wg0
```

---

# Step 8 — Create Client

Create folder:

```bash
mkdir -p /root/wg_clients/kiran
cd /root/wg_clients/kiran
```

Generate:

```bash
wg genkey | tee kiran.key | wg pubkey > kiran.pub
```

Verify:

```bash
ls
```

Expected:

```text
kiran.key
kiran.pub
```

---

# Step 9 — Register Client

Open:

```bash
nano /etc/wireguard/wg0.conf
```

Append:

```ini
[Peer]
PublicKey = PASTE_kiran_PUBLIC_KEY
AllowedIPs = 10.10.0.2/32
```

Get:

```bash
cat kiran.pub
```

Paste.

Reload:

```bash
systemctl restart wg-quick@wg0
```

Verify:

```bash
wg show
```

---

# Step 10 — Create Client Config

Create:

```bash
nano kiran.conf
```

Paste:

```ini
[Interface]
Address = 10.10.0.2/24
PrivateKey = PASTE_kiran_PRIVATE_KEY
DNS = 1.1.1.1

[Peer]
PublicKey = PASTE_SERVER_PUBLIC_KEY
Endpoint = YOUR_PUBLIC_IP:51820
AllowedIPs = 10.10.0.0/24
PersistentKeepalive = 25
```

Get:

```bash
cat kiran.key
cat /etc/wireguard/server.pub
```

Paste.

Save.

---

# Step 11 — Move Config to Laptop

Copy:

```bash
scp kiran.conf laptop:/Downloads/
```

or download via WinSCP.

---

# Step 12 — Import Client

Install WireGuard client.

Import:

```text
kiran.conf
```

Connect.

---

# Step 13 — Test

From laptop:

```bash
ping 10.10.0.1
```

On server:

```bash
wg
```

Expected:

```text
latest handshake
transfer:
```

---

# Step 14 — Access Internal Servers

If your internal servers are:

```text
192.168.1.0/24
```

Change client:

```ini
AllowedIPs = 10.10.0.0/24,192.168.1.0/24
```

Reconnect.

Test:

```bash
ping 192.168.1.x
```

---

# Troubleshooting

Check logs:

```bash
journalctl -u wg-quick@wg0 -n 100
```

Check listening:

```bash
ss -ulpn | grep 51820
```

Check interface:

```bash
ip a | grep wg
```

This is the complete manual flow that your `createkey.sh` was automating.
