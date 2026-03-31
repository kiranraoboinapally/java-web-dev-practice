
---

# **Topic 8: Advanced OpenShift Route Features**

---

## **1️⃣ Why Advanced Features Matter**

* Stateful or production applications often require **secure traffic** and **controlled deployments**.
* OpenShift Routes provide **advanced traffic management** features not fully available in standard Kubernetes Ingress.

---

## **2️⃣ TLS Features**

### **1. TLS Termination Types**

| Type             | How it Works                                                | Use Case                               |
| ---------------- | ----------------------------------------------------------- | -------------------------------------- |
| Edge Termination | TLS ends at OpenShift Router, traffic to pods is plain HTTP | Simple HTTPS                           |
| Re-encryption    | TLS ends at Router → traffic is re-encrypted to pods        | Secure end-to-end TLS                  |
| Passthrough      | Router passes TLS directly to pods (no termination)         | Pod handles TLS, end-to-end encryption |

**Memory Tip:**

> Edge = decrypt at edge, plain inside
> Re-encrypt = decrypt + encrypt again
> Passthrough = no decrypt, secure all the way

---

### **Example: TLS Re-encryption**

```yaml id="tls-reencrypt"
apiVersion: route.openshift.io/v1
kind: Route
metadata:
  name: secure-route
spec:
  host: secure.example.com
  to:
    kind: Service
    name: backend-service
  tls:
    termination: reencrypt
    key: <router-key>
    certificate: <router-cert>
    destinationCACertificate: <ca-cert-for-backend>
```

* Traffic is **HTTPS → Router → HTTPS → Pods**

---

## **3️⃣ Traffic Splitting / Blue-Green Deployments**

* OpenShift Routes can **split traffic between multiple services**.
* Useful for:

  * Testing new versions
  * Gradual rollout
  * Canary deployments

### **Example: Splitting Traffic**

```yaml id="traffic-split"
apiVersion: route.openshift.io/v1
kind: Route
metadata:
  name: web-split
spec:
  to:
    kind: Service
    name: web-v1
    weight: 80
  alternateBackends:
  - kind: Service
    name: web-v2
    weight: 20
```

* **80% traffic → web-v1**, **20% → web-v2**

---

## **4️⃣ Advantages Over Kubernetes Ingress**

| Feature              | Route (OpenShift)    | Ingress (Kubernetes)                                |
| -------------------- | -------------------- | --------------------------------------------------- |
| TLS Re-encryption    | ✅ Built-in           | ⚠ Requires extra config                             |
| TLS Passthrough      | ✅ Built-in           | ⚠ Extra config or controller required               |
| Traffic Splitting    | ✅ Natively supported | ⚠ Usually requires additional tools (Istio/Traefik) |
| Automatic Management | ✅ Yes                | ⚠ No, must manually configure                       |

---

## **5️⃣ Why OpenShift Routes Are Preferred**

1. **Simplifies external connectivity**
2. **Supports advanced TLS features natively**
3. **Allows smooth deployment strategies** (blue-green, canary)
4. **Fully integrated with OpenShift Router**, no extra setup

---

## **6️⃣ Visual Summary**

```text id="route-traffic"
Client --> OpenShift Router --> Service v1 (80%)
                           --> Service v2 (20%)
TLS Re-encryption / Passthrough supported automatically
```

---

