
---

## 🚀 Git Essentials & Commands

### 🔧 Git Global Configuration

```bash
git config --global -e
# Opens global config file to edit username/email in vim
# Press `i` to insert, then ESC + Shift+:wq to save & quit

git config --global user.name "your_github_username"
git config --global user.email "your_email@example.com"
```

---

### 📂 Common Git Commands

```bash
pwd               # Show current directory
ls                # List files in directory
git status        # Show working tree status

git add .         # Stage all files
git commit -m "msg"   # Commit with message (-m = message)

git remote add origin <url>  # Add remote repo
git push -u origin main      # Push to main branch
# Or if master is used:
git push origin master
```

---

### ❌ Abort Merge Conflicts

```bash
git merge --abort  # Cancel ongoing merge
```

---

### 🧹 Remove `.class` Files from Repo

```bash
find . -type f -name "*.class" -exec git rm {} \;
# Deletes all `.class` files from repo
```

---

### 🚫 Ignore `.class` Files in Future

```bash
echo "*.class" >> .gitignore        # Add to .gitignore
git rm --cached "*.class"           # Untrack from Git
```

---

### 🔍 See Tracked Files

```bash
git ls-files
```

---

### 🗑️ Remove Files or Folders

```bash
git rm -rf folder1          # Remove folder1
git rm .                    # Remove all tracked files
git rm --cached file2.txt   # Untrack file2.txt only
git restore --staged .      # Unstage all staged files
```

---

### 🌿 Branching in Git

```bash
git branch                  # List branches
git branch branchname       # Create a new branch
git checkout main           # Switch to main
git checkout -b main1       # Create and switch to main1
git merge main1             # Merge main1 into current branch
```

---

### 🧠 Git Branch Behavior Explained

#### Scenario:

| Branch  | Action                          | Result                |
| ------- | ------------------------------- | --------------------- |
| branch1 | Add `file1`, `file2` and commit | Files are tracked     |
| branch2 | Create `file3` (untracked)      | Seen across branches  |
| branch2 | Commit `file3`                  | Now only in `branch2` |
| branch1 | Checkout again                  | `file3` disappears    |

💡 **Untracked files** persist across branches. Once committed, they’re tied to that specific branch.

---

## 📥 Pull Only One Folder from Another Branch

### ✅ Goal: Bring `folder3/` from `branch a` into `branch x` only.

```bash
git checkout x                   # Switch to target branch
git checkout a -- folder3/       # Pull only folder3 from branch a
git add folder3/                 # Stage the pulled folder
git commit -m "Pulled folder3 from branch a"
```

🧠 Only `folder3/` will be pulled; other directories remain untouched.

---

## 📦 Clone a Specific Branch Only

```bash
git clone --branch branchName --single-branch https://github.com/username/repo.git
```

➡️ Clones only `branchName` instead of the entire repo with all branches.

---

## 🧼 Ignore Untracked Files in Git

### 1. Add to `.gitignore`

```bash
/.metadata/
back/tasksTODO.md
back/README.md
```

### 2. Clean Untracked Ignored Files

```bash
git clean -fdX
# -f: force, -d: remove dirs, -X: ignored files only
```

---

## ⚛️ React + JSON Server Setup

### 📁 Create a New React App

```bash
npx create-react-app myapp
cd myapp
npm start
```

---

### 🌐 Install & Run JSON Server

```bash
npm install -g json-server             # Install globally
json-server --watch data.json -p 3030 # Run server on port 3030
```

---

### 📡 Install Axios for API Calls

```bash
npm i axios
```

---

## 🛢️ MySQL Workbench Port Change

### 🔁 Change MySQL Default Port (3306 → 3030)

1. Open Notepad as administrator.
2. Edit this file:

```
C:\ProgramData\MySQL\MySQL Server 8.0\my.ini
```

3. Change port from `3306` to `3030`, save, and restart MySQL service.

---

## 💵 USD Currency Converter API (Open Access)

```
https://open.er-api.com/v6/latest/USD
```

➡️ Use this endpoint to convert from USD to other currencies (no API key required).

---

### ✅ Summary of Git Folder Pull Scenario

| Step | Branch    | Action Taken               | Result                           |
| ---- | --------- | -------------------------- | -------------------------------- |
| 1    | `branch1` | Commit `file1`, `file2`    | Files are now tracked            |
| 2    | `branch2` | Create `file3` (untracked) | Visible in both branches         |
| 3    | `branch2` | Commit `file3`             | Now tracked only in `branch2`    |
| 4    | `branch1` | Switch to `branch1`        | `file3` disappears (not tracked) |

---
