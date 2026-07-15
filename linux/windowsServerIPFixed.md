# Windows Server Networking Guide (DHCP, Static IP, Gateway & DNS)

## 1. What is an IP Address?

An **IP Address** is the unique address assigned to a device on a network. It allows other devices to communicate with it.

Example:

```text
192.168.1.50
```

Just like a house has a postal address, every computer or server on a network needs an IP address.

---

# 2. DHCP (Automatic IP)

DHCP (**Dynamic Host Configuration Protocol**) automatically assigns network settings to a computer.

When Windows is configured as:

```text
Obtain an IP address automatically
```

or

```powershell
Dhcp : Enabled
```

The server contacts a DHCP server (usually your router or Windows DHCP Server) and receives:

* IP Address
* Subnet Mask
* Default Gateway
* DNS Server

Example:

```text
IP Address      : 192.168.1.125
Subnet Mask     : 255.255.255.0
Default Gateway : 192.168.1.1
DNS             : 192.168.1.1
```

### Advantages

* Easy to configure
* Centralized management
* No manual configuration required

### Disadvantages

* IP address may change
* Not suitable for servers that clients need to reach consistently

---

# 3. Static IP (Manual IP)

A Static IP is manually configured.

Windows setting:

```text
Use the following IP address
```

or

```powershell
Dhcp : Disabled
```

Example:

```text
IP Address      : 192.168.1.50
Subnet Mask     : 255.255.255.0
Default Gateway : 192.168.1.1
```

### Advantages

* IP never changes (unless you change it)
* Ideal for servers
* Easier to manage services like RDP, SSH, web servers, databases, DNS, etc.

### Disadvantages

* Must be configured manually
* Incorrect settings can cause network problems

---

# 4. IP Address Explained

Example:

```text
192.168.1.50
```

Here:

```
192.168.1     → Network
50            → Host (your server)
```

Every device on the same network must have a unique host number.

Example:

| Device         | IP           |
| -------------- | ------------ |
| Router         | 192.168.1.1  |
| Laptop         | 192.168.1.20 |
| Windows Server | 192.168.1.50 |
| Linux Server   | 192.168.1.60 |

No two devices should use the same IP address.

---

# 5. Subnet Mask

Example:

```text
255.255.255.0
```

The subnet mask tells the computer which part of the IP identifies the network and which part identifies the host.

Example:

```
IP          : 192.168.1.50
Subnet Mask : 255.255.255.0

Network : 192.168.1
Host    : 50
```

Common subnet masks:

| Subnet Mask   | CIDR | Hosts      |
| ------------- | ---- | ---------- |
| 255.255.255.0 | /24  | 254        |
| 255.255.0.0   | /16  | 65,534     |
| 255.0.0.0     | /8   | 16 million |

Most home and office networks use:

```text
255.255.255.0
```

---

# 6. Default Gateway

Example:

```text
Default Gateway : 192.168.1.1
```

The gateway is the device that connects your local network to other networks (typically your router).

### Example

```
Windows Server
      │
      ▼
192.168.1.1 (Gateway / Router)
      │
      ▼
Internet
```

If the server wants to reach:

```
google.com
```

it sends the request to the gateway.

Without a gateway:

* Local devices can communicate.
* Internet access generally will not work.

---

# 7. DNS (Domain Name System)

DNS converts domain names into IP addresses.

Example:

```
google.com
        │
        ▼
142.250.xxx.xxx
```

Without DNS:

You would have to remember IP addresses instead of names.

---

# 8. Preferred DNS Server

This is the first DNS server Windows queries.

Example:

```text
Preferred DNS : 8.8.8.8
```

Windows asks:

```
What is google.com?
```

The DNS server responds:

```
142.250.xxx.xxx
```

---

# 9. Alternate DNS Server

Example:

```text
Alternate DNS : 1.1.1.1
```

Windows uses the alternate DNS only if the preferred DNS is unavailable.

Flow:

```
Computer
     │
     ▼
Preferred DNS (8.8.8.8)
     │
     ├── Working
     │      │
     │      ▼
     │   DNS Response
     │
     └── Not Working
            │
            ▼
Alternate DNS (1.1.1.1)
```

---

# 10. Common Public DNS Servers

| DNS     | Provider                 |
| ------- | ------------------------ |
| 8.8.8.8 | Google Public DNS        |
| 8.8.4.4 | Google Secondary DNS     |
| 1.1.1.1 | Cloudflare DNS           |
| 1.0.0.1 | Cloudflare Secondary DNS |
| 9.9.9.9 | Quad9 DNS                |

---

# 11. What is 127.0.0.1?

```
127.0.0.1
```

This is called the **loopback** or **localhost** address.

It always refers to the local computer.

Example:

```
Windows Server
      │
      ▼
127.0.0.1
      │
      ▼
Windows Server
```

It never leaves the computer.

---

# 12. Why is Preferred DNS set to 127.0.0.1?

If your Windows Server has:

```text
Preferred DNS : 127.0.0.1
Alternate DNS : (blank)
```

it usually means the server is running the **DNS Server** role (often together with **Active Directory Domain Services**).

Flow:

```
Client
    │
    ▼
Windows DNS Server (127.0.0.1)
    │
    ▼
Forwarders / Internet DNS
```

This is normal for a Domain Controller or a dedicated DNS server.

---

# 13. Example Configurations

## Home PC (DHCP)

```text
IP Address      : Automatically Assigned
Subnet Mask     : Automatically Assigned
Default Gateway : Automatically Assigned
DNS             : Automatically Assigned
```

---

## Windows Server (Static IP)

```text
IP Address      : 192.168.1.50
Subnet Mask     : 255.255.255.0
Default Gateway : 192.168.1.1
Preferred DNS   : 127.0.0.1
Alternate DNS   : (blank)
```

---

## Static IP with Public DNS

```text
IP Address      : 192.168.1.50
Subnet Mask     : 255.255.255.0
Default Gateway : 192.168.1.1
Preferred DNS   : 8.8.8.8
Alternate DNS   : 1.1.1.1
```

This is suitable for standalone systems that are **not** running their own DNS service.

---

# 14. How to Check Your Current Configuration

### Command Prompt

```cmd
ipconfig /all
```

Shows:

* IP Address
* DHCP status
* Subnet Mask
* Gateway
* DNS Servers
* MAC Address

---

### PowerShell

Check DHCP:

```powershell
Get-NetIPInterface | Select InterfaceAlias, AddressFamily, Dhcp
```

Check IP configuration:

```powershell
Get-NetIPConfiguration
```

---

# 15. Which Configuration Should You Use?

| Scenario           | Recommendation                     |
| ------------------ | ---------------------------------- |
| Laptop/Desktop     | DHCP                               |
| Home PC            | DHCP                               |
| Test VM            | DHCP or Static (depending on need) |
| Web Server         | Static IP                          |
| Database Server    | Static IP                          |
| Domain Controller  | Static IP                          |
| DNS Server         | Static IP                          |
| File Server        | Static IP                          |
| Application Server | Static IP                          |

---

# 16. Summary

* **IP Address** identifies a device on the network.
* **DHCP** automatically assigns network settings; the IP can change.
* **Static IP** is manually configured and remains fixed until changed.
* **Subnet Mask** defines the network and host portions of the IP address.
* **Default Gateway** is the router used to reach other networks and the Internet.
* **DNS** translates domain names into IP addresses.
* **Preferred DNS** is queried first; **Alternate DNS** is used only if the preferred server is unavailable.
* **127.0.0.1** refers to the local machine and is commonly used as the preferred DNS on Windows Servers running the DNS Server role.
* Static IP configuration and DNS configuration are independent. A server can have a static IP while using either its own DNS service (`127.0.0.1`) or external DNS servers, depending on its role.
