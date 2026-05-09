should start with project1 from toddo.md

this is chatgpt generated but should do offlcially by practice!
so setup for this

Perfect. We'll build a **small but real enterprise-style Kubernetes platform** on your 8 GB RHEL setup.

This will teach you:

* Kubernetes
* networking
* ingress
* monitoring
* CI/CD basics
* secrets
* troubleshooting

WITHOUT needing huge hardware.

---

# FINAL LAB ARCHITECTURE

```text id="mckjzq"
RHEL HOST
│
├── k3s-master   (3 GB RAM)
└── k3s-worker   (3 GB RAM)

Inside Kubernetes:
- Traefik Ingress
- Grafana
- Prometheus
- Gitea
- Demo Banking App
```

This is small, realistic, and industry-relevant.

---

# PHASE 1 — Prepare RHEL Host

# STEP 1 — Install KVM

On RHEL:

```bash id="lkjlwm"
sudo dnf groupinstall "Virtualization Host" -y
sudo systemctl enable --now libvirtd
```

Verify:

```bash id="pjlwm8"
virsh list --all
```

---

# STEP 2 — Install Cockpit

This gives GUI VM management.

```bash id="o5z0yy"
sudo dnf install cockpit cockpit-machines -y
sudo systemctl enable --now cockpit.socket
```

Access:

```text id="8k5ztc"
https://YOUR-IP:9090
```

Login with your RHEL credentials.

---

# STEP 3 — Create Virtual Network

Inside Cockpit:

* Go → Virtual Machines
* Create network

Create:

| Setting | Value            |
| ------- | ---------------- |
| Name    | k8s-net          |
| Subnet  | 192.168.100.0/24 |

---

# PHASE 2 — Create VMs

# VM 1 — k3s-master

| Setting | Value          |
| ------- | -------------- |
| vCPU    | 2              |
| RAM     | 3072 MB        |
| Disk    | 30 GB          |
| IP      | 192.168.100.10 |

Install:

* Rocky Linux 9
  OR
* Ubuntu Server 24.04

---

# VM 2 — k3s-worker

| Setting | Value          |
| ------- | -------------- |
| vCPU    | 2              |
| RAM     | 3072 MB        |
| Disk    | 30 GB          |
| IP      | 192.168.100.11 |

---

# PHASE 3 — Configure Both VMs

On BOTH VMs:

---

# STEP 1 — Set Hostnames

## Master

```bash id="md34by"
sudo hostnamectl set-hostname k3s-master
```

---

## Worker

```bash id="fg5fr7"
sudo hostnamectl set-hostname k3s-worker
```

---

# STEP 2 — Configure /etc/hosts

On BOTH VMs:

```bash id="h8fowh"
sudo nano /etc/hosts
```

Add:

```text id="5mv88d"
192.168.100.10 k3s-master
192.168.100.11 k3s-worker
```

---

# STEP 3 — Disable Swap

Kubernetes requirement.

```bash id="i7b9f7"
sudo swapoff -a
```

Disable permanently:

```bash id="kz6tq4"
sudo nano /etc/fstab
```

Comment swap line.

---

# PHASE 4 — Install k3s Cluster

# STEP 1 — Install Master

On k3s-master:

```bash id="e7bd32"
curl -sfL https://get.k3s.io | sh -
```

Check:

```bash id="u6iv6x"
sudo kubectl get nodes
```

---

# STEP 2 — Get Cluster Token

```bash id="d6d5wj"
sudo cat /var/lib/rancher/k3s/server/node-token
```

Copy token.

---

# STEP 3 — Install Worker

On k3s-worker:

```bash id="3z09pq"
curl -sfL https://get.k3s.io | K3S_URL=https://192.168.100.10:6443 K3S_TOKEN=YOUR_TOKEN sh -
```

---

# STEP 4 — Verify Cluster

On master:

```bash id="sowrc7"
sudo kubectl get nodes
```

You should see:

```text id="rktjlwm"
k3s-master
k3s-worker
```

---

# PHASE 5 — Install Kubernetes Dashboard

On master:

```bash id="13x6iq"
sudo kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.7.0/aio/deploy/recommended.yaml
```

---

# PHASE 6 — Install Metrics Server

Needed for autoscaling.

```bash id="r15h7r"
sudo kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
```

Verify:

```bash id="nsl04n"
kubectl top nodes
```

---

# PHASE 7 — Deploy Demo Banking App

Create deployment:

```bash id="ap2ijv"
nano bank-app.yaml
```

Paste:

```yaml id="l9t1oc"
apiVersion: apps/v1
kind: Deployment
metadata:
  name: bank-app
spec:
  replicas: 2
  selector:
    matchLabels:
      app: bank-app
  template:
    metadata:
      labels:
        app: bank-app
    spec:
      containers:
      - name: bank-app
        image: nginx
        ports:
        - containerPort: 80
```

Apply:

```bash id="40m8gr"
kubectl apply -f bank-app.yaml
```

---

# Expose Service

```bash id="jlwm76"
kubectl expose deployment bank-app --type=ClusterIP --port=80
```

---

# PHASE 8 — Ingress

k3s already includes Traefik.

Create ingress:

```bash id="e0ibbs"
nano bank-ingress.yaml
```

Paste:

```yaml id="w5mdfw"
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: bank-ingress
spec:
  rules:
  - host: bank.local
    http:
      paths:
      - path: /
        pathType: Prefix
        backend:
          service:
            name: bank-app
            port:
              number: 80
```

Apply:

```bash id="4hzb4v"
kubectl apply -f bank-ingress.yaml
```

---

# Add Local DNS

On your PC:

## Windows

Edit:

```text id="p8hz5r"
C:\Windows\System32\drivers\etc\hosts
```

Add:

```text id="wmc6r4"
192.168.100.10 bank.local
```

---

# PHASE 9 — Install Monitoring

# Install Helm

```bash id="r8t0yz"
curl https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3 | bash
```

---

# Add Repo

```bash id="6id7bb"
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update
```

---

# Install Grafana + Prometheus

```bash id="p3oyzr"
helm install monitoring prometheus-community/kube-prometheus-stack
```

---

# Verify

```bash id="5rht7x"
kubectl get pods
```

---

# PHASE 10 — Real Practice Tasks

Now your REAL learning starts.

---

# TASK 1 — Scale App

```bash id="gq0ws7"
kubectl scale deployment bank-app --replicas=5
```

---

# TASK 2 — Simulate Failure

Delete pod:

```bash id="q25o7h"
kubectl delete pod POD_NAME
```

Observe self-healing.

---

# TASK 3 — Worker Failure

Shutdown worker VM.

Observe:

* rescheduling
* node status

---

# TASK 4 — Rolling Update

Update nginx image version.

Watch:

* zero downtime deployment

---

# TASK 5 — Resource Limits

Add:

* CPU limits
* memory limits

Observe scheduling behavior.

---

# TASK 6 — Namespace Isolation

Create:

```bash id="wqlf06"
kubectl create namespace dev
kubectl create namespace prod
```

---

# TASK 7 — RBAC

Create restricted user.

Allow:

* namespace-only access

---

# TASK 8 — HPA Autoscaling

Configure Horizontal Pod Autoscaler.

---

# TASK 9 — Monitoring Dashboards

Build Grafana dashboards:

* node CPU
* pod memory
* restart count

---

# TASK 10 — Logs

Use:

```bash id="2w11dx"
kubectl logs
kubectl describe pod
kubectl get events
```

Learn troubleshooting.

---

# MOST IMPORTANT

Do NOT rush to:

* Istio
* OpenShift
* huge enterprise stacks

Master:

* Kubernetes basics
* networking
* deployments
* ingress
* troubleshooting
* monitoring

THAT is what companies value first.
