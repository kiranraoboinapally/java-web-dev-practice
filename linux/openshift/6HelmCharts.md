
---

# **Topic 6: Helm Charts**

---

## **1️⃣ What is Helm?**

* Helm is a **package manager for Kubernetes/OpenShift**.
* Helm lets you **define, install, and upgrade applications** in a cluster using reusable packages called **charts**.
* Think of Helm like **apt/yum for Kubernetes**.

---

## **2️⃣ Helm Chart Structure**

A Helm chart is a **directory with files defining your application**. Key components:

| File / Directory | Purpose                                               |
| ---------------- | ----------------------------------------------------- |
| `Chart.yaml`     | Metadata about the chart (name, version, description) |
| `values.yaml`    | Default configuration values for the chart            |
| `templates/`     | Resource definitions using **Go templates**           |
| `charts/`        | Optional dependencies on other charts                 |

**Memory Tip:**

> Chart = “package”
> templates = “blueprint”
> values.yaml = “default settings you can override”

---

## **3️⃣ Installing a Helm Chart**

When you install a chart, you must decide on **three parameters**:

1. **Namespace** → Where in the cluster to deploy the resources
2. **Values to override** → Custom settings (optional)
3. **Release name** → Unique name for this installation

### **Example Command:**

```bash
helm install mywebapp ./nginx-chart --namespace dev -f custom-values.yaml
```

* `mywebapp` → release name
* `./nginx-chart` → chart directory
* `--namespace dev` → target namespace
* `-f custom-values.yaml` → custom values to override defaults

---

## **4️⃣ Overriding Default Values**

* The default values are in `values.yaml`.
* You can override them by creating your **custom YAML file** and using the `--values` option.

**Example `custom-values.yaml`:**

```yaml
replicaCount: 5
image:
  repository: myprivate/nginx
  tag: 1.23
```

* Now, the chart will deploy **5 replicas** instead of default 3, using your custom image.

**Important:** Do NOT modify the original chart directly. Always override values.

---

## **5️⃣ Go Templates in Helm Charts**

* Helm charts use **Go templates** to dynamically create Kubernetes resources.
* Templates allow **user-provided values** to define parameters like:

  * Number of replicas
  * Container image
  * Resource limits

**Example Template Snippet:**

```yaml
replicas: {{ .Values.replicaCount }}
image: "{{ .Values.image.repository }}:{{ .Values.image.tag }}"
```

* `.Values.replicaCount` → replaced with your YAML value or default from `values.yaml`.
* `.Values.image.repository` → replaced with user-specified image.

**Memory Tip:**

> Template = “fill-in-the-blanks blueprint”

---

## **6️⃣ Summary Table**

| Concept         | Explanation                       |
| --------------- | --------------------------------- |
| Helm            | Kubernetes package manager        |
| Chart           | Package with Kubernetes resources |
| Release         | Deployed instance of a chart      |
| values.yaml     | Default configuration             |
| Override values | Customize deployment via `-f`     |
| Go templates    | Dynamic resource definitions      |

---
