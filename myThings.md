
# 🖥️ Windows 11 Clean Installation Using USB (UEFI)

**For ASUS VivoBook (Example: X1502ZA)**
**Scenario: Forgot PIN / BitLocker Key / Failed Previous Installation**

---

## ⚠️ IMPORTANT NOTICE

* This process **ERASES ALL DATA** on the internal drive
* If BitLocker recovery key is lost, **data cannot be recovered**
* Follow steps carefully to **avoid cleaning the USB by mistake**

---

## 📦 WHAT YOU NEED

### Hardware

* USB Flash Drive (8 GB or larger, empty)
* Target laptop (ASUS VivoBook)
* Another working laptop/PC

### Software (OFFICIAL ONLY)

* Windows 11 ISO (Microsoft)
* Rufus (USB bootloader tool)

---

## 🔗 OFFICIAL DOWNLOAD LINKS

### 1️⃣ Windows 11 ISO (Microsoft Official)

👉 [https://www.microsoft.com/software-download/windows11](https://www.microsoft.com/software-download/windows11)

Steps on website:

1. Select **Windows 11 Disk Image (ISO)**
2. Choose language
3. Download **64-bit ISO**

---

### 2️⃣ Rufus (Official Website)

👉 [https://rufus.ie/](https://rufus.ie/)

Download:

* **Rufus Portable (.exe)**

---

## 💾 STEP 1 — CREATE WINDOWS 11 BOOTABLE USB (BEST SETTINGS)

1. Insert USB into working PC
2. Open **Rufus**
3. Configure Rufus exactly like this:

```
Device           → USB Flash Drive
Boot Selection   → Disk or ISO Image
Select           → Windows 11 ISO
Partition Scheme → GPT
Target System    → UEFI (non-CSM)
File System      → NTFS
Cluster Size     → Default
```

4. Click **START**
5. When prompted:

   * Choose **Standard Windows Installation**
   * Allow removal of:

     * TPM check
     * Secure Boot check
     * RAM check (recommended)
6. Wait until finished
7. Safely eject USB

---

## 🔧 STEP 2 — ASUS BIOS / UEFI CONFIGURATION

1. Plug USB into ASUS laptop
2. Power ON
3. Press **ESC** repeatedly
4. Choose **Enter BIOS / Setup**

### Set These Options:

```
Boot Mode     → UEFI
CSM           → Disabled
Secure Boot   → Disabled (temporary)
Fast Boot     → Disabled
```

5. Save & Exit

---

## 🚀 STEP 3 — BOOT FROM USB (CRITICAL STEP)

1. Power OFF
2. USB must be plugged in
3. Power ON
4. Press **ESC** repeatedly
5. Boot Menu appears

### SELECT ONLY THIS OPTION:

```
UEFI: USB Partition 1
```

❌ DO NOT select USB Partition 2
❌ DO NOT select Legacy / non-UEFI USB

---

## 🧹 STEP 4 — CLEAN FAILED PREVIOUS INSTALLATION (MANDATORY IF INSTALL FAILED BEFORE)

### ⚠️ WHEN THIS STEP IS REQUIRED

You **MUST do this step** if:

* Previous Windows installation failed
* Laptop stuck in boot loop
* BitLocker recovery key missing
* Windows setup shows partition errors
* Windows cannot install on disk

✅ If previous install was **not perfect**, this step is **REQUIRED**

---

### ⚠️ VERY IMPORTANT WARNING

* `clean` deletes **internal SSD completely**
* **NEVER clean the USB**
* Always verify disk **by size**

---

### HOW TO CLEAN SAFELY

#### 1️⃣ Open Command Prompt

At Windows Setup screen:

```
Shift + F10
```

---

#### 2️⃣ Start DiskPart

```
diskpart
```

---

#### 3️⃣ List Disks

```
list disk
```

Example:

```
Disk 0    476 GB  ← Internal SSD (SELECT THIS)
Disk 1    16 GB   ← USB (DO NOT TOUCH)
```

---

#### 4️⃣ Select Internal Disk ONLY

```
select disk 0
```

Confirm:

```
detail disk
```

✔ Must show internal SSD
❌ If it shows USB → STOP

---

#### 5️⃣ Clean Disk (REQUIRED)

```
clean
```

✔ Removes:

* Broken Windows installation
* BitLocker lock
* Corrupted partitions

---

#### 6️⃣ Exit

```
exit
```

Close Command Prompt.

---

## 🪟 STEP 5 — INSTALL WINDOWS 11

1. Click **Install Now**
2. Skip product key (if asked)
3. Choose Windows edition
4. Accept license
5. Select **Custom: Install Windows only**
6. Choose **Unallocated Space**
7. Click **Next**

Windows will automatically create:

* EFI System Partition
* MSR Partition
* Primary partition

---

## 🔁 STEP 6 — FIRST RESTART

* Laptop restarts automatically
* **REMOVE USB** when restart starts
* Let system boot normally

---

## 🖱️ STEP 7 — DRIVER ISSUES (NORMAL)

After first boot:

* ❌ Wi-Fi not working
* ❌ Bluetooth missing
* ❌ Touchpad not working

✔ This is normal

---

## 🌐 STEP 8 — INSTALL DRIVERS (BEST METHOD)

### 1️⃣ Install Wi-Fi Driver Manually

* Download Wi-Fi driver from ASUS support site
* Copy to USB
* Install on laptop
* Restart

### 2️⃣ Use Windows Update

```
Settings → Windows Update → Check for updates
```

✔ Installs remaining drivers automatically

---

## 🔐 STEP 9 — SECURE YOUR SYSTEM

After everything works:

* Enable **Secure Boot** (optional)
* Save **BitLocker recovery key**
* Create strong PIN
* Create recovery USB

---

## ✅ FINAL SAFETY RULES (MEMORIZE)

✔ Always use **UEFI + GPT**
✔ Always boot **USB Partition 1**
✔ Clean disk ONLY if previous install failed
✔ Identify disk by SIZE
✔ Never clean USB
✔ Remove USB after installation starts

---

## 📌 QUICK DISKPART CHEAT

```
list disk
Big size  = Internal SSD (CLEAN THIS)
Small size = USB (NEVER CLEAN)
```

---

## 🏁 DONE

✔ Clean Windows 11 installation
✔ No BitLocker lock
✔ No boot errors
✔ System stable & secure
