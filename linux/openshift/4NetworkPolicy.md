
---

# **Topic 4: Kubernetes Network Policies**

---

## **1️⃣ What Are Network Policies?**

* **Network Policies** are Kubernetes resources that **control traffic to and from pods**.
* They define rules for **which pods can communicate with which pods**, on **which ports**.
* Useful for **segmentation, security, and microservice isolation**.

### **Key Concept**

* By default, Kubernetes pods **can talk to any pod** in the cluster.
* Network Policies allow **restricting access** based on:

  * **Pod labels**
  * **Namespaces**
  * **IP blocks**

---

## **2️⃣ Key Fields in a NetworkPolicy**

| Field         | Purpose                                           |
| ------------- | ------------------------------------------------- |
| `podSelector` | Defines **which pods the policy applies to**      |
| `ingress`     | Rules for **incoming traffic**                    |
| `egress`      | Rules for **outgoing traffic**                    |
| `ports`       | Defines **allowed ports and protocols** (TCP/UDP) |

---

## **3️⃣ PodSelector Explained**

* **`podSelector`** is a label-based filter for selecting pods the policy applies to.
* Example: `app: frontend` → only pods labeled `app=frontend` are affected.

```yaml id="podsel"
podSelector:
  matchLabels:
    app: frontend
```

* Applies this network policy **only to pods labeled `frontend`**.

---

## **4️⃣ Ports Field Explained**

* The `ports` field in ingress/egress rules specifies **which port numbers and protocols** are allowed for traffic.

Example:

```yaml id="netpolicy-port"
ports:
- protocol: TCP
  port: 80
```

* Only allows **TCP traffic on port 80** to the selected pods.

---

## **5️⃣ Example Network Policy**

```yaml id="np-example"
apiVersion: networking.k8s.io/v1
kind: NetworkPolicy
metadata:
  name: frontend-policy
spec:
  podSelector:
    matchLabels:
      app: frontend
  ingress:
  - from:
    - podSelector:
        matchLabels:
          app: backend
    ports:
    - protocol: TCP
      port: 80
```

**What this does:**

* Applies to **pods labeled `frontend`**
* Allows incoming traffic **only from pods labeled `backend`**
* Only allows **TCP traffic on port 80**

---

## **6️⃣ How Network Policies Help**

* Restrict traffic **between microservices**
* Implement **zero-trust networking** inside the cluster
* Protect sensitive services from unauthorized access

**Memory tip:**

> podSelector = “which pods”
> ingress/egress + ports = “what traffic”

---

## **7️⃣ Connection to OpenShift / StatefulSets**

* Stateful applications often need **restricted network access** (databases shouldn’t be public).
* Deployments or StatefulSets can use **Network Policies** to control who can talk to them.

Example: PostgreSQL StatefulSet pods might only allow traffic from backend app pods.

---

We’ve now **covered Network Policies**, including:

* What they are
* `podSelector` field
* `ports` field
* Example rules
* Connection to StatefulSets

---
