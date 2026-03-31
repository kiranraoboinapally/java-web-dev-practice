
---

# **Topic 3: Persistent Volumes (PV) and Persistent Volume Claims (PVC)**

Kubernetes separates **storage resources** from pods. This allows pods to **request storage** without worrying about the underlying infrastructure.

---

## **1️⃣ Persistent Volumes (PV)**

### **Definition**

* PV is a **piece of storage in the cluster**.
* Can be **block storage** (like a virtual disk) or **file storage** (like NFS).
* Independent of pods: even if a pod dies, the PV remains.

### **Key Properties**

| Property       | Description                                                      |
| -------------- | ---------------------------------------------------------------- |
| Capacity       | Size of the storage, e.g., 10Gi                                  |
| Access Modes   | `ReadWriteOnce`, `ReadOnlyMany`, `ReadWriteMany`                 |
| Reclaim Policy | What happens when PVC is deleted (`Retain`, `Delete`, `Recycle`) |
| Storage Class  | Type of storage (`standard`, `fast-ssd`, etc.)                   |

### **Example PV**

```yaml
apiVersion: v1
kind: PersistentVolume
metadata:
  name: pv-postgres-0
spec:
  capacity:
    storage: 10Gi
  accessModes:
    - ReadWriteOnce
  persistentVolumeReclaimPolicy: Retain
  storageClassName: standard
  hostPath:
    path: /mnt/data/postgres-0
```

* This PV will **survive pod restarts**.
* StatefulSet pods will request this PV using a **PVC**.

---

## **2️⃣ Persistent Volume Claims (PVC)**

### **Definition**

* PVC is a **request for storage by a pod**.
* Specifies size, access mode, and optionally storage class.
* Kubernetes **binds a PVC to a matching PV** automatically.

### **Key Properties**

| Property      | Description                           |
| ------------- | ------------------------------------- |
| Resources     | Size requested, e.g., `storage: 10Gi` |
| Access Modes  | `ReadWriteOnce`, etc.                 |
| Storage Class | Optional; specifies type of PV        |

### **Example PVC**

```yaml
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: pvc-postgres-0
spec:
  accessModes:
    - ReadWriteOnce
  resources:
    requests:
      storage: 10Gi
  storageClassName: standard
```

* The PVC will **bind to PV `pv-postgres-0`** automatically if it matches.

---

## **3️⃣ How PV and PVC Work Together**

1. Admin creates **Persistent Volumes (PV)** in the cluster.
2. Pods request storage by creating **Persistent Volume Claims (PVC)**.
3. Kubernetes **binds PVC to a suitable PV** automatically.
4. StatefulSet uses **VolumeClaimTemplates** to automatically create a **PVC per pod**, giving each pod **unique, non-shared storage**.

### **Visual Example**

```text
StatefulSet Pod -> PVC -> PV
postgres-0    -> pvc-0 -> pv-0
postgres-1    -> pvc-1 -> pv-1
postgres-2    -> pvc-2 -> pv-2
```

* Each pod has **its own disk**, ensuring data persistence.

---

## **4️⃣ Persistent Storage for Block vs File Data**

* **Block Storage** → behaves like a hard disk, can be formatted and mounted by pods.
* **File Storage** → networked file systems (NFS), multiple pods can read/write if allowed.

**Stateful apps** (databases, queues) need **block storage** to maintain data integrity.

---

## **5️⃣ Connection to StatefulSets vs Deployments**

| Feature      | StatefulSet                 | Deployment                               |
| ------------ | --------------------------- | ---------------------------------------- |
| Storage      | Unique PV per pod (via PVC) | Usually ephemeral or shared              |
| Pod identity | Stable, PV attached to pod  | Interchangeable, storage lost on restart |
| Use case     | Databases, message queues   | Stateless apps like web servers          |

---

💡 **Memory Trick**

* PV = **“storage available in the cluster”**
* PVC = **“pod asking for storage”**
* StatefulSet → **each pod gets its own PV** via PVC

---
