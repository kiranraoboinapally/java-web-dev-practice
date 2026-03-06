
---

# **Single Node OpenShift (SNO) Installation — Step-by-Step**

---

## **Step 1 — Prepare Ignition Server (`.11`)**

1. Go to your SNO install folder:

```bash
cd ~/sno-install-new
```

2. Generate Ignition configs:

```bash
openshift-install create ignition-configs
```

* This creates `bootstrap-in-place-for-live-iso.ign` and other `.ign` files.
* Make sure your `rhcos-live.iso` is in the same folder.

---

## **Step 2 — Serve the Ignition file**

On `.11`, start an HTTP server to serve the Ignition file:

```bash
sudo python3 -m http.server 8080
```

* Keep this running **until the VM finishes installation**.
* Test from any machine in the network:

```bash
curl -I http://192.168.1.11:8080/bootstrap-in-place-for-live-iso.ign
```

* You should see:

```text
HTTP/1.0 200 OK
```

---

## **Step 3 — Configure DNS (`.20`)**

1. Edit `/etc/dnsmasq.conf` on `.20`:

```text
# Single SNO node mapping
address=/api.kiran-sno-demo.sc.lab/192.168.1.210
address=/api-int.kiran-sno-demo.sc.lab/192.168.1.210
address=/.apps.kiran-sno-demo.sc.lab/192.168.1.210

# Forward everything else
server=8.8.8.8
```

2. Restart `dnsmasq`:

```bash
sudo systemctl restart dnsmasq
```

3. Test DNS resolution:

```bash
nslookup api.kiran-sno-demo.sc.lab
```

* Should return `192.168.1.210`.

---

## **Step 4 — Prepare the SNO VM (`.210`)**

1. Create a **new VM** on your hypervisor:

   * CPU: 4
   * RAM: 16 GB
   * Disk: 50 GB
   * Network: same bridge as `.20`
   * Boot ISO: `rhcos-live.iso`

2. Do **not start installation yet**.

---

## **Step 5 — Boot the VM with GRUB**

1. Start the VM, wait for the GRUB menu.
2. Press **`e`** to edit the boot entry.
3. Append the following line **at the end**:

```text
ip=192.168.1.210::192.168.1.1:24:sno:ens3:none nameserver=192.168.1.20 coreos.inst.install_dev=/dev/vda coreos.inst.ignition_url=http://192.168.1.11:8080/bootstrap-in-place-for-live-iso.ign
```

* `.210` → SNO VM IP
* `.20` → DNS server
* `.11` → Ignition server

4. Press **Ctrl + X** to boot.

---

## **Step 6 — What happens on the VM**

* VM gets IP `.210`.
* Downloads Ignition from `.11`.
* Installs RHCOS and OpenShift SNO automatically.
* Reboots into SNO node.

---

## **Step 7 — Monitor and Manage the Cluster (`.11`)**

1. Export kubeconfig:

```bash
export KUBECONFIG=~/auth/kubeconfig
```

2. Check nodes:

```bash
oc get nodes -w
```

* You should see:

```text
sno-kiran   Ready
```

3. Check all pods:

```bash
oc get pods -A
```

* Watch for `openshift-*` pods becoming `Running`.

---

## ✅ **Step 8 — DNS and Access**

* All OpenShift services are on `.210`.
* Users can access:

```text
api.kiran-sno-demo.sc.lab
*.apps.kiran-sno-demo.sc.lab
```

* Multiple users can run `oc` commands from `.11` or any machine with the kubeconfig.

---

### **Summary of Command Flow**

| Action              | Run Where | Notes                                                     |
| ------------------- | --------- | --------------------------------------------------------- |
| Generate Ignition   | `.11`     | `openshift-install create ignition-configs`               |
| Serve Ignition      | `.11`     | `python3 -m http.server 8080`                             |
| Boot VM             | `.210`    | Boot from `rhcos-live.iso`, GRUB points to `.11` Ignition |
| Install RHCOS + SNO | `.210`    | Fully automated via Ignition                              |
| Manage cluster      | `.11`     | Use `oc` or `kubectl` with kubeconfig                     |
| DNS resolution      | `.20`     | `.apps.*`, `api.*` all point to `.210`                    |

---




         ┌───────────────┐
         │  .11 Server   │  <-- Ignition & install server
         │---------------│
         │ • Prepares Ignition files           (bootstrap-in-place-for-live-iso.ign)
         │ • Hosts Ignition via HTTP          (python3 -m http.server 8080)
         │ • Runs openshift-install / oc     (kubectl, pull-secret, install-config)
         └───────────────┘
                   │
                   │ HTTP (port 8080)
                   ▼
         ┌───────────────┐
         │  .210 VM      │  <-- SNO node (your new VM)
         │---------------│
         │ • Boots RHCOS live ISO
         │ • Downloads Ignition from .11
         │ • Installs OpenShift SNO
         │ • Runs all cluster services:
         │      - API server
         │      - Controller, Scheduler
         │      - Apps via .apps.* DNS
         └───────────────┘
                   │
                   │ Cluster traffic resolved via DNS
                   ▼
         ┌───────────────┐
         │  .20 Server   │  <-- DNS server (dnsmasq)
         │---------------│
         │ • Resolves:
         │     api.kiran-sno-demo.sc.lab → 192.168.1.210
         │     api-int.kiran-sno-demo.sc.lab → 192.168.1.210
         │     *.apps.kiran-sno-demo.sc.lab → 192.168.1.210
         └───────────────┘
		 
		 
		 
		
