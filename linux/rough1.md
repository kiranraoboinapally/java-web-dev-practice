
---

# **Linux User Storage Management – Full Documentation**

This guide will help you:

1. Check current storage usage.
2. Analyze which files/folders are using space.
3. Check available space before transferring new files.
4. Manage transfers safely.
5. Optional: monitor and maintain disk usage.

---

## **1. Check Current Directory Storage**

### **Command:**

```bash
du -sh .
```

**Explanation:**

* `du` → disk usage.
* `-s` → summarize (only show total for current directory).
* `-h` → human-readable (KB, MB, GB).

**Example:**

```bash
[kiran@user ~]$ du -sh .
1.1G    .
```

This shows `/home/kiran` is currently using **1.1 GB**.

---

## **2. Check Space Used by Subdirectories**

### **Command (normal directories only):**

```bash
du -sh ./*
```

### **Command (include hidden directories):**

```bash
du -sh .[!.]* * 2>/dev/null
```

* `.[!.]*` → matches hidden folders like `.cache`, `.config`.
* `2>/dev/null` → suppresses permission denied messages.

### **Command (sorted by size):**

```bash
du -sh .[!.]* * 2>/dev/null | sort -h
```

* `sort -h` → sorts human-readable sizes from smallest to largest.
* Quickly identifies which folders take the most space.

---

## **3. Find Top Largest Files**

Sometimes, individual files take more space than folders.

```bash
du -ah . 2>/dev/null | sort -rh | head -n 10
```

**Explanation:**

* `-a` → include files, not just directories.
* `sort -rh` → sort in reverse (largest first).
* `head -n 10` → show top 10 largest items.

This gives you a **list of files/folders using the most space**, which is very useful for cleanup.

---

## **4. Check Available Disk Space on Filesystem**

Before adding new files, check **how much free space is actually available** on the filesystem.

```bash
df -h /home/kiran
```

**Example Output:**

```
Filesystem             Size  Used  Avail  Use%  Mounted on
/dev/mapper/rhel-home   50G   10G   40G   20%   /home
```

* **Size** → total filesystem size.
* **Used** → total space used.
* **Avail** → free space available.
* **Use%** → percent used.

✅ If `Avail` is more than the size of the files you want to transfer, you can safely copy them.

---

## **5. Check User Quotas (if enabled)**

Some systems enforce **per-user disk quotas**. To check:

```bash
quota -s
```

* `-s` → shows sizes in human-readable format.
* Ensures you don’t exceed limits even if `df` shows free space.

---

## **6. Transfer Files Safely**

### **Copying a single file:**

```bash
cp /path/to/source/file /home/kiran/
```

### **Copying multiple files/folders:**

```bash
rsync -av /path/to/source/ /home/kiran/
```

* `rsync` is recommended for large transfers:

  * Preserves permissions.
  * Handles partial transfers safely.
  * Can resume if interrupted.

---

## **7. Optional: Visual Disk Usage Map**

To quickly see **which folders use the most space**, use `ncdu`:

```bash
sudo yum install ncdu   # RHEL/CentOS
ncdu /home/kiran
```

* `ncdu` provides an interactive view.
* Navigate with arrow keys to see sizes per folder/file.

---

## **8. One-liner: Full Storage Summary**

Here’s a command that shows **home usage, free space, and largest directories** all in one:

```bash
echo "Home directory usage:"; du -sh /home/kiran; echo "Free space:"; df -h /home/kiran | awk 'NR==2{print $4}'; echo "Top 10 largest items:"; du -ah /home/kiran 2>/dev/null | sort -rh | head -n 10
```

**Sample Output:**

```
Home directory usage:
1.1G
Free space:
40G
Top 10 largest items:
300M   /home/kiran/Videos/movie.mkv
200M   /home/kiran/Downloads/archive.zip
...
```

* Gives a quick overview of **current usage, free space, and heavy files**.

---

### ✅ **Summary**

* Use `du -sh .` to check your current usage.
* Use `du -sh .[!.]* *` and `du -ah` to find heavy folders/files.
* Use `df -h /home/kiran` to check available space before adding files.
* Check quotas with `quota -s`.
* Use `cp` or `rsync` for safe file transfers.
* Optional: `ncdu` for interactive space visualization.

---
