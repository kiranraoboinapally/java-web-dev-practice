
---

# **Single Node OpenShift (SNO) Baremetal Installation Documentation**

## **Environment Setup**

* **Host OS:** RHEL 9 (or compatible Linux)
* **OpenShift Version:** 4.20.8
* **Client Tools Installed:**

  * `oc` 4.20.8
  * `openshift-install` 4.20.8
* **Directories & Files:**

  ```
  ~/kiran/
  ~/kiran/sno-install/ -> contains master.ign, auth, manifests
  ~/kiran/rhcos-live.iso -> RHCOS live ISO
  ~/kiran/pull-secret.json
  ~/kiran/openshift-install-linux.tar.gz
  ```
* **Goal:** Deploy a single-node OpenShift (SNO) cluster on a baremetal server named `kiran`.

---

## **Step 1: Prepare Install Config**

1. Generate `install-config.yaml`:

```bash
openshift-install create install-config
```

* SSH key provided: `/home/admin/.ssh/id_rsa.pub`
* Platform: `baremetal`
* Networking: `Unmanaged`
* Control-plane host: `kiran`
* Pull secret: `pull-secret.json`

**Note:**
Initially, an invalid `networkType: OpenShiftSDN` was used. This was corrected to:

```yaml
networking:
  networkType: OVNKubernetes
```

* The valid install-config is stored in `sno-install/install-config.yaml`.

---

## **Step 2: Create OpenShift Manifests**

```bash
openshift-install create manifests
```

* Populates manifests in `sno-install/manifests` and `sno-install/openshift`.
* Worker machine set YAML (`99_openshift-cluster-api_worker-machineset-*.yaml`) is **not needed for SNO**, so it was removed:

```bash
rm -f openshift/99_openshift-cluster-api_worker-machineset-*.yaml
```

---

## **Step 3: Create Ignition Configs**

```bash
openshift-install create ignition-configs
```

* Generates:

  ```
  bootstrap.ign
  master.ign
  worker.ign
  metadata.json
  auth/ (kubeadmin-password, kubeconfig)
  ```
* `master.ign` is the main ignition config for the SNO node.

**Notes:**

* `worker.ign` and `bootstrap.ign` are **not used directly** in SNO baremetal node booting.
* `auth/kubeconfig` will be used after installation.

---

## **Step 4: Prepare the RHCOS ISO**

### **Initial Attempt**

* Attempted to use `coreos-installer` from downloaded `.tar.gz` files.
* All downloads failed — the files were **HTML pages**, not binaries.
* Attempting `tar -xvf` and `chmod` on those files failed.

---

### **Resolved Approach**

#### Option A: Use Podman container

* Define an alias to run the containerized `coreos-installer`:

```bash
alias coreos-installer='podman run --privileged --pull always --rm \
  -v /dev:/dev -v /run/udev:/run/udev -v $PWD:/data \
  -w /data quay.io/coreos/coreos-installer:release'
```

* The container provides a fully working `coreos-installer` without downloading binaries manually.

#### Step: Embed ignition

```bash
cd ~/kiran
coreos-installer iso ignition embed \
  -i sno-install/master.ign \
  rhcos-live.iso \
  -o rhcos-sno-embedded.iso
```

* Produces `rhcos-sno-embedded.iso` ready to boot the SNO node.

---

### **Option B: Download correct binary (alternative)**

1. Go to OpenShift mirror for version 4.20.8:

```
https://mirror.openshift.com/pub/openshift-v4/clients/ocp/4.20.8/
```

2. Download `coreos-installer-linux-4.20.8` (binary, no `.tar.gz`).

3. Make it executable and move to PATH:

```bash
chmod +x coreos-installer-linux-4.20.8
sudo mv coreos-installer-linux-4.20.8 /usr/local/bin/coreos-installer
```

4. Then embed ignition as above.

---

## **Step 5: Boot the SNO Node**

* Copy `rhcos-sno-embedded.iso` to a USB drive or mount via PXE/virtual media.
* Boot the **baremetal node `kiran`**.
* Node will auto-install OpenShift using `master.ign`.

---

## **Step 6: Monitor Installation**

From your installer host:

```bash
cd sno-install
openshift-install wait-for bootstrap-complete --log-level=debug
openshift-install wait-for install-complete --log-level=debug
```

* Only the single node (`kiran`) will be provisioned.
* Logs show control-plane components starting automatically.

---

## **Step 7: Verify Cluster**

After installation completes:

```bash
export KUBECONFIG=auth/kubeconfig
oc get nodes
```

Expected output:

```
NAME    STATUS   ROLES                         AGE
kiran   Ready    control-plane,master,worker  XXm
```

---

## **Step 8: Summary of Key Lessons / Gotchas**

1. **Always verify download files** with `file` command — previous `.tar.gz` were HTML pages.
2. `coreos-installer` container image is a reliable method if local binaries fail.
3. For SNO baremetal:

   * Only `master.ign` is required for the node boot.
   * Worker machine set YAML can be removed.
4. Networking must be `OVNKubernetes`, not `OpenShiftSDN`.
5. The embedded ISO (`rhcos-sno-embedded.iso`) is the only thing needed to boot the node.

---

✅ **At this point:**

* You have a fully prepared `rhcos-sno-embedded.iso`.
* Node `kiran` can be booted to self-provision OpenShift SNO.
* `auth/kubeconfig` is ready for cluster management once installation completes.

---

