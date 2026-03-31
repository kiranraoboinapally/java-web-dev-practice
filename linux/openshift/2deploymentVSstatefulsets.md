
---

# **Topic 2: Deployments vs StatefulSets in Kubernetes / OpenShift**

This is a **core concept**, so we’ll go very slowly and cover **everything in detail**.

---

## **1️⃣ Deployments**

### **Definition:**

* A **Deployment** is a Kubernetes resource used to manage **stateless applications**.
* Ensures that **a certain number of identical pods are running** at all times.
* Pods managed by a Deployment are **interchangeable** (no unique identity).

### **Characteristics:**

| Feature          | Deployment                            |
| ---------------- | ------------------------------------- |
| Stateful?        | No, stateless                         |
| Pod identity     | Interchangeable, randomly named       |
| Storage          | Usually ephemeral or shared           |
| Restart behavior | Pods can die and be replaced anywhere |
| Scaling          | All pods are equal, unordered         |
| Use cases        | Web servers, API servers, proxies     |

### **Example Use Case:**

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: web-server
spec:
  replicas: 3
  selector:
    matchLabels:
      app: web
  template:
    metadata:
      labels:
        app: web
    spec:
      containers:
      - name: nginx
        image: nginx:1.23
```

* Deploys **3 replicas** of an NGINX container.
* Pods are **stateless**; if one dies, a new pod is created automatically.

---

## **2️⃣ StatefulSets**

### **Definition:**

* A **StatefulSet** is a Kubernetes resource for **stateful applications**, where **pod identity and persistent storage matter**.
* Ensures:

  1. **Stable network identity** → pods keep their names (`app-0`, `app-1`)
  2. **Stable storage** → each pod has its own Persistent Volume (PV)
  3. **Ordered scaling and termination** → important for databases and clusters

### **Characteristics:**

| Feature          | StatefulSet                                      |
| ---------------- | ------------------------------------------------ |
| Stateful?        | Yes                                              |
| Pod identity     | Stable, unique (e.g., `db-0`)                    |
| Storage          | Each pod has a **unique PV**                     |
| Restart behavior | Pod restarts retain identity and storage         |
| Scaling          | Pods start/stop in order                         |
| Use cases        | Databases, Kafka, message queues, clustered apps |

### **Example Use Case:**

```yaml
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: postgres
spec:
  serviceName: "postgres"
  replicas: 3
  selector:
    matchLabels:
      app: postgres
  template:
    metadata:
      labels:
        app: postgres
    spec:
      containers:
      - name: postgres
        image: postgres:15
        volumeMounts:
        - name: pgdata
          mountPath: /var/lib/postgresql/data
  volumeClaimTemplates:
  - metadata:
      name: pgdata
    spec:
      accessModes: ["ReadWriteOnce"]
      resources:
        requests:
          storage: 10Gi
```

* Creates **3 pods**: `postgres-0`, `postgres-1`, `postgres-2`
* Each pod gets a **unique 10Gi PV**
* Pod names and storage are **stable**, even if pods are rescheduled

---

## **3️⃣ Key Differences**

| Feature       | Deployment         | StatefulSet       |
| ------------- | ------------------ | ----------------- |
| Pod identity  | Interchangeable    | Stable, unique    |
| Storage       | Ephemeral / shared | Unique PV per pod |
| Scaling order | Unordered          | Ordered           |
| Use case      | Stateless apps     | Stateful apps     |

**Memory Trick:**

> Deployment = “replaceable pods”
> StatefulSet = “stable pods, stable storage”

---

## **4️⃣ How StatefulSets Manage Non-shared Storage**

* StatefulSet uses **VolumeClaimTemplates**:

  * Each pod automatically requests its **own PVC**
  * PVC is bound to a **unique PV**
  * Ensures **non-shared, persistent storage**
* Deployment pods **can use PVCs**, but usually storage is **shared or ephemeral**

---

## **5️⃣ Questions You Asked Related to This Topic**

1. **StatefulSet pods vs Deployment pods** → StatefulSet pods have **unique persistent volumes**.
2. **Use cases for StatefulSets** → Databases, distributed queues, clustered apps.
3. **How StatefulSets use storage** → VolumeClaimTemplate creates **unique PV per pod**.

---

💡 **Memory Visualization**

```
Deployment (stateless):
web-a   web-b   web-c
 ephemeral / shared storage

StatefulSet (stateful):
db-0 -> PV-0
db-1 -> PV-1
db-2 -> PV-2
```

---

