
---

# **Topic 7: OpenShift Routes vs Kubernetes Ingress**

---

## **1️⃣ Kubernetes Ingress**

### **Definition**

* **Ingress** is a Kubernetes resource that **manages external access** to services in a cluster.
* It defines rules for **HTTP/HTTPS traffic** to reach **specific services**.
* Works with an **Ingress Controller** (like NGINX, HAProxy) that enforces the rules.

### **Key Features**

| Feature    | Explanation                                         |
| ---------- | --------------------------------------------------- |
| Access     | External HTTP/HTTPS traffic                         |
| Routing    | Based on hostnames, paths                           |
| TLS        | Supports TLS termination and optional re-encryption |
| Controller | Requires an Ingress Controller installed separately |

**Example Ingress:**

```yaml id="ingress-example"
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: web-ingress
spec:
  rules:
  - host: www.example.com
    http:
      paths:
      - path: /
        pathType: Prefix
        backend:
          service:
            name: web-service
            port:
              number: 80
```

---

## **2️⃣ OpenShift Routes**

### **Definition**

* **Route** is an OpenShift-specific resource to **expose services externally**.
* Built on top of the OpenShift Router (HAProxy) and integrates tightly with OpenShift.
* Simplifies management compared to standard Kubernetes Ingress.

### **Key Features**

| Feature              | Explanation                                                      |
| -------------------- | ---------------------------------------------------------------- |
| TLS Re-encryption    | Can terminate TLS at router, then re-encrypt to pod              |
| TLS Passthrough      | End-to-end encryption without decrypting at router               |
| Blue-Green / Canary  | Split traffic for advanced deployments                           |
| Automatic Management | RHOCP automatically creates managed routes if Ingress is defined |

**Example Route:**

```yaml id="route-example"
apiVersion: route.openshift.io/v1
kind: Route
metadata:
  name: web-route
spec:
  host: www.example.com
  to:
    kind: Service
    name: web-service
  tls:
    termination: edge
```

---

## **3️⃣ Key Differences**

| Feature                | Kubernetes Ingress                   | OpenShift Route                         |
| ---------------------- | ------------------------------------ | --------------------------------------- |
| Controller             | Requires separate Ingress Controller | Built-in OpenShift Router               |
| TLS Re-encryption      | Optional via advanced config         | Fully supported                         |
| Advanced Traffic Split | Needs extra setup                    | Supported natively (blue-green, canary) |
| Integration            | Standard Kubernetes                  | OpenShift-native, automatically managed |

**Memory Tip:**

> Ingress = Kubernetes standard, requires setup
> Route = OpenShift special, “plug & play”

---

## **4️⃣ Why Routes Are Preferred in OpenShift**

* OpenShift automates routing with the **built-in router**.
* Supports **advanced TLS features** out of the box.
* Allows **split traffic for deployments** (blue-green, canary).
* Provides **easier management** compared to setting up Ingress controllers manually.

---

## **5️⃣ Visual Summary**

```text id="route-vs-ingress"
Kubernetes:
[Ingress] --> [Ingress Controller] --> [Service] --> [Pods]

OpenShift:
[Route] --> [OpenShift Router] --> [Service] --> [Pods]
```


---
