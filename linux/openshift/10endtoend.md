
---

# **Topic 10: End-to-End OpenShift Deployment Example**

We will walk through deploying a **stateful application** (like a database) using all the OpenShift/Kubernetes concepts we covered.

---

## **1️⃣ Scenario**

* Deploy a **PostgreSQL database** as a StatefulSet.
* Each pod needs **persistent storage** (PVCs).
* Only allow **backend app pods** to talk to the database (NetworkPolicy).
* Expose the database externally using **OpenShift Route**.
* Deploy everything via a **Helm chart** to allow customization.

---

## **2️⃣ Step 1: Define Persistent Storage**

* Each StatefulSet pod gets its **own unique Persistent Volume Claim (PVC)**.

**Helm template for StatefulSet PVC:**

```yaml id="stateful-pvc"
volumeClaimTemplates:
- metadata:
    name: data
  spec:
    accessModes: [ "ReadWriteOnce" ]
    resources:
      requests:
        storage: {{ .Values.storage.size }}
```

* `.Values.storage.size` can be overridden in `values.yaml` or a custom file.
* Each pod gets **non-shared storage**.

---

## **3️⃣ Step 2: Define the StatefulSet**

* Using Helm templates:

```yaml id="helm-statefulset"
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: {{ .Release.Name }}-postgres
spec:
  serviceName: "{{ .Release.Name }}-postgres"
  replicas: {{ .Values.replicaCount }}
  selector:
    matchLabels:
      app: {{ .Release.Name }}-postgres
  template:
    metadata:
      labels:
        app: {{ .Release.Name }}-postgres
    spec:
      containers:
      - name: postgres
        image: "{{ .Values.image.repository }}:{{ .Values.image.tag }}"
        ports:
        - containerPort: 5432
        volumeMounts:
        - name: data
          mountPath: /var/lib/postgresql/data
```

* Helm templates make **replicas, image, and storage dynamic**.

---

## **4️⃣ Step 3: Define NetworkPolicy**

* Only allow **backend pods** to access PostgreSQL:

```yaml id="np-postgres"
apiVersion: networking.k8s.io/v1
kind: NetworkPolicy
metadata:
  name: postgres-policy
spec:
  podSelector:
    matchLabels:
      app: {{ .Release.Name }}-postgres
  ingress:
  - from:
    - podSelector:
        matchLabels:
          app: backend
    ports:
    - protocol: TCP
      port: 5432
```

* This ensures **secure pod-to-pod communication**.

---

## **5️⃣ Step 4: Define OpenShift Route**

* Expose PostgreSQL externally (optional, often for admin access):

```yaml id="route-postgres"
apiVersion: route.openshift.io/v1
kind: Route
metadata:
  name: {{ .Release.Name }}-postgres-route
spec:
  host: {{ .Values.route.host }}
  to:
    kind: Service
    name: {{ .Release.Name }}-postgres
  tls:
    termination: reencrypt
```

* Advanced TLS options provide **end-to-end encryption**.

---

## **6️⃣ Step 5: Values.yaml for Customization**

```yaml id="values-postgres"
replicaCount: 3
storage:
  size: 10Gi
image:
  repository: postgres
  tag: "15"
route:
  host: db.example.com
```

* Users can **override this YAML** when installing the Helm chart.

---

## **7️⃣ Step 6: Deploy with Helm**

```bash id="helm-deploy-final"
helm install mydb ./postgres-chart --namespace dev -f custom-values.yaml
```

* This deploys **StatefulSet pods with unique PVCs**, applies **NetworkPolicy**, and creates a **Route**.

---

## **8️⃣ How All Components Work Together**

| Component       | Role                                                      |
| --------------- | --------------------------------------------------------- |
| StatefulSet     | Manages database pods with **stable identities**          |
| PVCs            | Provide **persistent, non-shared storage** per pod        |
| NetworkPolicy   | Restricts traffic to only allowed pods                    |
| Helm Chart      | Automates deployment and allows **customization**         |
| OpenShift Route | Exposes service externally with **TLS and traffic rules** |

**Memory Tip:**

> Helm = automation, StatefulSet = stability, PVC = persistence, NetworkPolicy = security, Route = external access

---

Do you want me to create that diagram next?
