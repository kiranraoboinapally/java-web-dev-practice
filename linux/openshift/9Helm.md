
---

# **Topic 9: Helm Charts & Go Templates – Advanced**

---

## **1️⃣ Helm Recap**

* Helm is a **package manager for Kubernetes/OpenShift**.
* Charts define **applications, resources, and default settings**.
* Helm lets you **install, upgrade, and manage applications easily**.

---

## **2️⃣ Go Templates in Helm Charts**

* Helm charts use **Go templates** to make resources **dynamic**.
* Templates replace placeholders with **user-provided values** from `values.yaml` or `--values` files.

### **Key Features**

| Feature         | Description                                               |
| --------------- | --------------------------------------------------------- |
| `.Values`       | Access values from `values.yaml` or overrides             |
| `.Release.Name` | Access the release name during installation               |
| `.Chart`        | Access chart metadata (name, version)                     |
| Conditionals    | `if/else` logic to control resource creation              |
| Loops           | `range` loops for multiple replicas, services, or volumes |

---

## **3️⃣ Example: Dynamic Deployment Template**

```yaml id="helm-deploy"
apiVersion: apps/v1
kind: Deployment
metadata:
  name: {{ .Release.Name }}-nginx
spec:
  replicas: {{ .Values.replicaCount }}
  selector:
    matchLabels:
      app: {{ .Release.Name }}-nginx
  template:
    metadata:
      labels:
        app: {{ .Release.Name }}-nginx
    spec:
      containers:
      - name: nginx
        image: "{{ .Values.image.repository }}:{{ .Values.image.tag }}"
        ports:
        - containerPort: {{ .Values.service.port }}
```

* `{{ .Values.replicaCount }}` → uses **user-specified replicas**
* `{{ .Values.image.repository }}` → dynamic container image
* `{{ .Release.Name }}` → ensures **unique naming per release**

---

## **4️⃣ Overriding Values**

* You can override **default `values.yaml`** using a **custom YAML file**:

```yaml id="helm-override"
replicaCount: 5
image:
  repository: myprivate/nginx
  tag: 1.23
service:
  port: 8080
```

**Command:**

```bash
helm install myapp ./nginx-chart -f custom-values.yaml
```

* This will deploy **5 replicas**, use **your private image**, and expose port **8080**.

---

## **5️⃣ Helm Chart Parameters**

When installing or upgrading a Helm chart, you must decide:

1. **Deployment target namespace** → where resources will be created
2. **Values to override** → customize parameters like replicas, images, storage
3. **Release name** → unique identifier for this deployment instance

**Example:**

```bash
helm install myapp ./nginx-chart --namespace dev -f custom-values.yaml
```

---

## **6️⃣ Advanced Go Template Features**

| Feature           | Example Use                                                                                |                                               |
| ----------------- | ------------------------------------------------------------------------------------------ | --------------------------------------------- |
| Conditional Logic | `{{ if .Values.enableMetrics }} ... {{ end }}` → deploy metrics container only if enabled  |                                               |
| Loops             | `{{ range .Values.servers }} ... {{ end }}` → create multiple server resources dynamically |                                               |
| Functions         | `{{ .Release.Name                                                                          | upper }}` → convert release name to uppercase |

**Memory Tip:**

> Template = “dynamic blueprint”
> Values = “user customization”
> Go templates = “logic + loops + placeholders”

---

## **7️⃣ Connection to StatefulSets and Routes**

* Helm charts can **deploy StatefulSets** with dynamic PVCs:

```yaml id="helm-stateful"
volumeClaimTemplates:
- metadata:
    name: data
  spec:
    accessModes: [ "ReadWriteOnce" ]
    resources:
      requests:
        storage: {{ .Values.storage.size }}
```

* Helm charts can also **create Routes** with dynamic hostnames and TLS options:

```yaml id="helm-route"
spec:
  host: {{ .Values.route.host }}
  tls:
    termination: {{ .Values.route.tls }}
```

* This allows **fully automated, customizable deployments** of complex apps.

---

✅ **Summary of Advanced Helm Concepts**

| Concept                       | Purpose                                               |
| ----------------------------- | ----------------------------------------------------- |
| Go Templates                  | Make resources dynamic based on user values           |
| values.yaml                   | Default configuration for a chart                     |
| Overrides                     | Customize deployments without editing chart           |
| Conditional & Loops           | Dynamically generate resources                        |
| StatefulSet + PVC integration | Each pod gets persistent storage automatically        |
| Routes integration            | Expose services externally with TLS and traffic rules |


---

