Its need to see and understand 
how it means login works if there are multiple users

---

## **1️⃣ Logging in via `oc` (command-line)**

1. **Each user needs a kubeconfig file** generated during installation (on `.11`):

```text id="kq0r8u"
~/auth/kubeconfig
```

2. **Export it** on your local shell (or `.11`):

```bash id="p70cvk"
export KUBECONFIG=~/auth/kubeconfig
```

3. **Log in to the cluster using `oc`** (optional, if you want to switch users or check login):

```bash id="u0efmq"
oc login -u kubeadmin -p <password> https://api.kiran-sno-demo.sc.lab:6443
```

* `<password>` = `kubeadmin-password` created during installation (stored in `auth/kubeadmin-password`).
* After login, you can run commands:

```bash id="f1n2ma"
oc get nodes
oc get pods -A
oc get projects
```

> All commands connect to the **SNO VM `.210` API**, even if run from `.11` or another machine with network access.

---

## **2️⃣ Web Console Login (optional)**

* OpenShift also provides a web console:

```text id="w25ejs"
https://console-openshift-console.apps.kiran-sno-demo.sc.lab
```

* Use the same credentials: `kubeadmin / <password>`
* Multiple users can log in through the browser to see pods, nodes, applications, and the cluster dashboard.

---

## **3️⃣ How multiple users share access**

* Only **one SNO VM** exists (`.210`).
* DNS (`.20`) maps hostnames to `.210`, so all users reach the same cluster.
* Each user can either:

  1. Copy `kubeconfig` from `.11` to their workstation and run `oc`.
  2. Use the web console (`console-openshift-console.apps.kiran-sno-demo.sc.lab`).

> No one needs to log in **directly on `.210` VM** unless doing debugging or maintenance.

---

### ✅ Summary

* **CLI** → `oc login -u kubeadmin -p <password> https://api.kiran-sno-demo.sc.lab:6443`
* **Web** → `https://console-openshift-console.apps.kiran-sno-demo.sc.lab`
* **DNS + static IP** ensures everyone reaches the same SNO node.
* `.11` = Ignition & kubeconfig host, `.210` = SNO VM, `.20` = DNS.

---

