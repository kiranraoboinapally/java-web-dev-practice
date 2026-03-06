
---

## **1️⃣ Minimum / Practical Lab Requirements for `.210`**

| Resource | Minimum | Suggested for smooth practical use | Notes                                  |
| -------- | ------- | ---------------------------------- | -------------------------------------- |
| CPU      | 2 cores | 2 cores                            | Enough for OpenShift + small workloads |
| RAM      | 8 GB    | 12–16 GB                           | 12 GB is usually enough for a few pods |
| Disk     | 40 GB   | 50 GB                              | Store RHCOS, pods, container images    |
| Network  | 1 NIC   | Bridged / same network as `.20`    | Static IP recommended for DNS mapping  |

> Since your lab is **single node**, 2 cores + 12 GB RAM + 50 GB disk will let you:
>
> * Run OpenShift SNO
> * Deploy a few sample apps (Pods, Deployments, Services)
> * Practice `oc` commands, projects, and namespaces

---

## **2️⃣ Example allocation for `.210` VM**

```text
CPU: 2 cores
RAM: 12 GB
Disk: 50 GB
Network: Bridged, static IP 192.168.1.210
```

* This leaves `.11` free for serving Ignition files and kubeconfig.
* DNS `.20` points all `.apps.*` and `api.*` to `.210`.

---

## **3️⃣ Notes / Tips**

1. **CPU**: 2 cores is fine for basic labs, more cores are only needed if you deploy many apps.
2. **RAM**: <12 GB will cause pods to crash or be evicted. 12–16 GB is practical for a single-node lab.
3. **Disk**: OpenShift images + container storage can grow fast, 50 GB is enough for experiments.
4. **Network**: Keep a static IP for `.210`, so DNS entries always resolve correctly.

---

### ✅ Recommendation

* For a **basic lab / learning setup**:

  * **CPU: 2 cores**
  * **RAM: 12–16 GB**
  * **Disk: 50 GB**
  * **Static IP** → update `.20` DNS

> This setup allows multiple users to experiment using different projects/namespaces without breaking the single-node cluster.

---
