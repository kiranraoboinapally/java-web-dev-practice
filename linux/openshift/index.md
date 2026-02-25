
# 📘 OpenShift Complete Learning Documentation

## From Absolute Beginner to Production Cluster Administrator

---

## 🎯 Purpose of This Documentation

This guide is for:

* Complete beginners
* People with zero Linux knowledge
* People who do not know TCP/IP, DNS, or servers
* Developers moving into DevOps
* System administrators new to containers

No unexplained terms. Every concept is explained before it is used.

---

# 📚 Learning Philosophy

> Never use a technical term before explaining it.

Learning Flow:

```
Computer Basics → Linux → Networking → Virtualization → Containers → Docker → Kubernetes → OpenShift → Installation → Production
```

---

# 📂 Documentation Structure

Each numbered section is a folder.

Inside each folder:

* `README.md` → Overview of that section
* Separate `.md` files for each topic
* Practical examples, commands, troubleshooting, summary

---

# 🔰 00 — Computer & Server Fundamentals

📁 Folder: `/00-computer-fundamentals/`

* [00.01 What Is a Computer?](00-computer-fundamentals/00.01-what-is-computer.md)
* [00.02 What Is an Operating System?](00-computer-fundamentals/00.02-what-is-os.md)
* [00.03 What Is a Server?](00-computer-fundamentals/00.03-what-is-server.md)
* [00.04 Client vs Server Model](00-computer-fundamentals/00.04-client-vs-server.md)
* [00.05 What Is a Data Center?](00-computer-fundamentals/00.05-what-is-datacenter.md)
* [00.06 What Is Cloud Computing?](00-computer-fundamentals/00.06-cloud-computing.md)
* [00.07 On-Premise vs Cloud](00-computer-fundamentals/00.07-onprem-vs-cloud.md)
* [00.08 What Is Virtualization?](00-computer-fundamentals/00.08-virtualization.md)
* [00.09 What Is a Hypervisor?](00-computer-fundamentals/00.09-hypervisor.md)
* [00.10 Virtual Machines Explained](00-computer-fundamentals/00.10-virtual-machines.md)

---

# 🐧 01 — Linux Fundamentals (Including RHEL)

📁 Folder: `/01-linux/`

* [01.01 What Is Linux?](01-linux/01.01-what-is-linux.md)
* [01.02 Linux Distributions](01-linux/01.02-linux-distributions.md)
* [01.03 What Is Red Hat?](01-linux/01.03-what-is-redhat.md)
* [01.04 What Is Red Hat Enterprise Linux?](01-linux/01.04-what-is-rhel.md)
* [01.05 Linux File System Structure](01-linux/01.05-filesystem.md)
* [01.06 Terminal & Shell](01-linux/01.06-terminal-shell.md)
* [01.07 Basic Linux Commands](01-linux/01.07-basic-commands.md)
* [01.08 File Permissions Explained](01-linux/01.08-file-permissions.md)
* [01.09 Users & Groups](01-linux/01.09-users-groups.md)
* [01.10 Processes & Services](01-linux/01.10-processes-services.md)
* [01.11 Package Management (yum/dnf)](01-linux/01.11-package-management.md)
* [01.12 SSH Explained](01-linux/01.12-ssh.md)
* [01.13 Environment Variables](01-linux/01.13-env-variables.md)
* [01.14 Logs & Troubleshooting Basics](01-linux/01.14-logs-troubleshooting.md)

---

# 🌐 02 — Networking Fundamentals

📁 Folder: `/02-networking/`

* [02.01 What Is Networking?](02-networking/02.01-what-is-networking.md)
* [02.02 What Is an IP Address?](02-networking/02.02-ip-address.md)
* [02.03 Public vs Private IP](02-networking/02.03-public-private-ip.md)
* [02.04 What Is a Subnet?](02-networking/02.04-subnet.md)
* [02.05 What Is TCP?](02-networking/02.05-tcp.md)
* [02.06 What Is UDP?](02-networking/02.06-udp.md)
* [02.07 What Is TCP/IP?](02-networking/02.07-tcpip.md)
* [02.08 What Is DNS?](02-networking/02.08-dns.md)
* [02.09 What Is a Port?](02-networking/02.09-port.md)
* [02.10 What Is HTTP?](02-networking/02.10-http.md)
* [02.11 What Is HTTPS?](02-networking/02.11-https.md)
* [02.12 What Is a Firewall?](02-networking/02.12-firewall.md)
* [02.13 What Is NAT?](02-networking/02.13-nat.md)
* [02.14 What Is a Load Balancer?](02-networking/02.14-load-balancer.md)
* [02.15 How Servers Communicate](02-networking/02.15-server-communication.md)
* [02.16 Basic Network Troubleshooting Tools](02-networking/02.16-network-tools.md)

---

# 🖥 03 — Infrastructure & Cloud Concepts

📁 Folder: `/03-infrastructure/`

* [03.01 What Is Infrastructure?](03-infrastructure/03.01-infrastructure.md)
* [03.02 Physical vs Virtual Infrastructure](03-infrastructure/03.02-physical-vs-virtual.md)
* [03.03 What Is IaaS?](03-infrastructure/03.03-iaas.md)
* [03.04 What Is PaaS?](03-infrastructure/03.04-paas.md)
* [03.05 What Is SaaS?](03-infrastructure/03.05-saas.md)
* [03.06 Regions & Availability Zones](03-infrastructure/03.06-regions-az.md)
* [03.07 Storage Types](03-infrastructure/03.07-storage-types.md)
* [03.08 Basic Cloud Architecture](03-infrastructure/03.08-cloud-architecture.md)

---

# 📦 04 — Container Fundamentals

📁 Folder: `/04-containers/`

* [04.01 What Is a Container?](04-containers/04.01-what-is-container.md)
* [04.02 Containers vs Virtual Machines](04-containers/04.02-containers-vs-vms.md)
* [04.03 Why Containers Were Created](04-containers/04.03-why-containers.md)
* [04.04 Container Runtime](04-containers/04.04-container-runtime.md)
* [04.05 Image Layers Explained](04-containers/04.05-image-layers.md)
* [04.06 Container Lifecycle](04-containers/04.06-lifecycle.md)
* [04.07 Container Registries](04-containers/04.07-registries.md)

---

# 🐳 05 — Docker

📁 Folder: `/05-docker/`

* [05.01 What Is Docker?](05-docker/05.01-what-is-docker.md)
* [05.02 Docker Architecture](05-docker/05.02-architecture.md)
* [05.03 Images vs Containers](05-docker/05.03-images-vs-containers.md)
* [05.04 Dockerfile Explained](05-docker/05.04-dockerfile.md)
* [05.05 Building Images](05-docker/05.05-building-images.md)
* [05.06 Running Containers](05-docker/05.06-running-containers.md)
* [05.07 Docker Networking](05-docker/05.07-networking.md)
* [05.08 Docker Volumes](05-docker/05.08-volumes.md)
* [05.09 Docker Compose](05-docker/05.09-compose.md)
* [05.10 Best Practices](05-docker/05.10-best-practices.md)

---

# ☸️ 06 — Kubernetes Fundamentals

OpenShift is built on Kubernetes.

📁 Folder: `/06-kubernetes/`

* [06.01 What Is Container Orchestration?](06-kubernetes/06.01-container-orchestration.md)
* [06.02 Kubernetes Architecture](06-kubernetes/06.02-architecture.md)
* [06.03 Master & Worker Nodes](06-kubernetes/06.03-master-worker.md)
* [06.04 Pods Explained](06-kubernetes/06.04-pods.md)
* [06.05 Deployments](06-kubernetes/06.05-deployments.md)
* [06.06 ReplicaSets](06-kubernetes/06.06-replicasets.md)
* [06.07 Services](06-kubernetes/06.07-services.md)
* [06.08 ConfigMaps](06-kubernetes/06.08-configmaps.md)
* [06.09 Secrets](06-kubernetes/06.09-secrets.md)
* [06.10 Namespaces](06-kubernetes/06.10-namespaces.md)
* [06.11 Ingress](06-kubernetes/06.11-ingress.md)
* [06.12 Persistent Volumes](06-kubernetes/06.12-persistent-volumes.md)
* [06.13 Scaling Applications](06-kubernetes/06.13-scaling.md)
* [06.14 Self-Healing](06-kubernetes/06.14-self-healing.md)
* [06.15 kubectl Basics](06-kubernetes/06.15-kubectl.md)

---

# 🔴 07 — OpenShift Core Concepts

Now we introduce OpenShift from Red Hat.

📁 Folder: `/07-openshift-core/`

* [07.01 What Is OpenShift?](07-openshift-core/07.01-what-is-openshift.md)
* [07.02 OpenShift vs Kubernetes](07-openshift-core/07.02-openshift-vs-kubernetes.md)
* [07.03 OpenShift Architecture](07-openshift-core/07.03-architecture.md)
* [07.04 Control Plane Components](07-openshift-core/07.04-control-plane.md)
* [07.05 Projects vs Namespaces](07-openshift-core/07.05-projects-namespaces.md)
* [07.06 Routes](07-openshift-core/07.06-routes.md)
* [07.07 Image Streams](07-openshift-core/07.07-image-streams.md)
* [07.08 BuildConfigs](07-openshift-core/07.08-buildconfigs.md)
* [07.09 Security Context Constraints](07-openshift-core/07.09-scc.md)
* [07.10 Web Console](07-openshift-core/07.10-web-console.md)
* [07.11 oc CLI](07-openshift-core/07.11-oc-cli.md)

---

# 🛠 08 — OpenShift Installation

📁 Folder: `/08-openshift-installation/`

* [08.01 Installation Methods Overview](08-openshift-installation/08.01-installation-overview.md)
* [08.02 Hardware Requirements](08-openshift-installation/08.02-hardware-requirements.md)
* [08.03 DNS Requirements](08-openshift-installation/08.03-dns.md)
* [08.04 Load Balancer Requirements](08-openshift-installation/08.04-load-balancer.md)
* [08.05 Firewall Requirements](08-openshift-installation/08.05-firewall.md)
* [08.06 Preparing Infrastructure](08-openshift-installation/08.06-preparing-infrastructure.md)
* [08.07 Installing Cluster](08-openshift-installation/08.07-install-cluster.md)
* [08.08 Verifying Installation](08-openshift-installation/08.08-verifying.md)
* [08.09 Accessing Console](08-openshift-installation/08.09-console.md)
* [08.10 Deploying First Application](08-openshift-installation/08.10-first-app.md)

---

# ⚙️ 09 — Operating OpenShift

📁 Folder: `/09-operations/`

* [09.01 Managing Projects](09-operations/09.01-managing-projects.md)
* [09.02 Managing Deployments](09-operations/09.02-managing-deployments.md)
* [09.03 Scaling Applications](09-operations/09.03-scaling.md)
* [09.04 Managing Secrets](09-operations/09.04-managing-secrets.md)
* [09.05 Monitoring Pods](09-operations/09.05-monitoring.md)
* [09.06 Debugging Applications](09-operations/09.06-debugging.md)
* [09.07 Viewing Logs](09-operations/09.07-logs.md)
* [09.08 Managing Resource Limits](09-operations/09.08-resource-limits.md)

---

# 🏭 10 — Production & Enterprise Best Practices

📁 Folder: `/10-production/`

* [10.01 High Availability](10-production/10.01-high-availability.md)
* [10.02 Backup & Restore](10-production/10.02-backup-restore.md)
* [10.03 Monitoring & Logging](10-production/10.03-monitoring-logging.md)
* [10.04 Security Hardening](10-production/10.04-security.md)
* [10.05 RBAC Configuration](10-production/10.05-rbac.md)
* [10.06 Resource Planning](10-production/10.06-resource-planning.md)
* [10.07 Disaster Recovery](10-production/10.07-disaster-recovery.md)

---

# 🧠 11 — Advanced Topics

📁 Folder: `/11-advanced/`

* [11.01 Operators](11-advanced/11.01-operators.md)
* [11.02 Helm](11-advanced/11.02-helm.md)
* [11.03 GitOps](11-advanced/11.03-gitops.md)
* [11.04 CI/CD Pipelines](11-advanced/11.04-ci-cd.md)
* [11.05 Multi-Cluster Management](11-advanced/11.05-multi-cluster.md)
* [11.06 Performance Tuning](11-advanced/11.06-performance-tuning.md)
* [11.07 Advanced Troubleshooting](11-advanced/11.07-advanced-troubleshooting.md)

---
