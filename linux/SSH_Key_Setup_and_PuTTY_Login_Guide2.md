# SSH Login Setup Guide (Windows + PuTTY + PuTTYgen + Pageant + RHEL 9.7)

Environment:

* Windows PC
* [PuTTY](https://www.putty.org/?utm_source=chatgpt.com)
* [PuTTYgen](https://www.putty.org/?utm_source=chatgpt.com)
* [Pageant](https://www.putty.org/?utm_source=chatgpt.com)
* RHEL 9.7 Server
* Server IP: `192.168.1.11`

---

# 🖥 WHERE does `ssh-keygen` run?

`ssh-keygen` runs on your **Windows machine**.

You run it in:

* Command Prompt (CMD)
* PowerShell
* Windows Terminal

NOT in:

* PuTTY
* Linux server

---

# 🔹 STEP 1 — Open Command Prompt (CMD)

## Method

1. Press `Windows Key`
2. Type:

```text id="ndq7rj"
cmd
```

3. Press Enter

You will see:

```text id="jlwmfx"
C:\Users\YourName>
```

---

# 🔹 STEP 2 — Check If SSH Is Installed

In CMD run:

```powershell id="fc7wbk"
ssh
```

If installed, you will see SSH help output.

---

# ❌ If SSH Is NOT Installed

You have TWO options:

| Option                 | Recommended |
| ---------------------- | ----------- |
| Install OpenSSH Client | ✅ Best      |
| Use only PuTTYgen      | ✅ Also fine |

---

# 🔹 OPTION A — Install OpenSSH Client

## Windows Settings Method

1. Open Settings
2. Go to:

```text id="t8t9ya"
Apps → Optional Features
```

3. Click:

```text id="h9l9wb"
Add a feature
```

4. Search:

```text id="7fvlc5"
OpenSSH Client
```

5. Click Install

After installation reopen CMD and run:

```powershell id="6higpd"
ssh
```

---

# 🔹 OPTION B — Use PuTTYgen ONLY (No OpenSSH Needed)

If your company laptop blocks OpenSSH installation, you can skip `ssh-keygen` completely.

PuTTYgen can generate keys itself.

---

# 🔹 STEP 3 — Generate SSH Key

# Method A — Using ssh-keygen (Recommended)

In CMD run:

```powershell id="t0gkek"
ssh-keygen -t ed25519 -C "your_company_email"
```

Press Enter.

When asked:

```text id="u7q3dz"
Enter file in which to save the key
```

Press Enter for default location.

Optional:
Set passphrase OR press Enter for none.

Keys will be created here:

```text id="z03g9w"
C:\Users\YourName\.ssh\
```

Files created:

```text id="l5w1gh"
id_ed25519
id_ed25519.pub
```

| File             | Purpose                      |
| ---------------- | ---------------------------- |
| `id_ed25519`     | Private key (SECRET)         |
| `id_ed25519.pub` | Public key (share with team) |

---

# Method B — Generate Keys Using PuTTYgen ONLY

If `ssh-keygen` is unavailable:

1. Open [PuTTYgen](https://www.putty.org/?utm_source=chatgpt.com)
2. Select:

```text id="6r49o4"
ED25519
```

3. Click:

```text id="uvn10l"
Generate
```

4. Move mouse randomly inside window

After generation:

* Save private key as:

```text id="3rx8sv"
mykey.ppk
```

* Copy public key from top text box

Public key starts with:

```text id="6k9y6h"
ssh-ed25519 AAAA...
```

Send entire line to your Linux/server team.

---

# 🔹 STEP 4 — Send Public Key to Team

If using `ssh-keygen`:

Open:

```text id="3r4f7r"
C:\Users\YourName\.ssh\id_ed25519.pub
```

Copy the full content.

Send it to your server/Linux team.

---

# 🔹 What Team Does on RHEL Server

They add your public key into:

```text id="n9m4i9"
/home/username/.ssh/authorized_keys
```

This enables passwordless SSH login.

---

# 🔹 STEP 5 — Convert OpenSSH Key to PuTTY Format (.ppk)

⚠ Needed ONLY if you generated key using `ssh-keygen`.

PuTTY requires `.ppk` format.

## Convert Key

1. Open [PuTTYgen](https://www.putty.org/?utm_source=chatgpt.com)
2. Click:

```text id="gll0p6"
Load
```

3. Browse to:

```text id="0d5owm"
C:\Users\YourName\.ssh\
```

4. Change file type:

```text id="5e7q9i"
All Files (*.*)
```

5. Select:

```text id="5lk1tt"
id_ed25519
```

6. Click:

```text id="a5vslx"
Save private key
```

7. Save as:

```text id="3hjtkm"
mykey.ppk
```

---

# 🔹 STEP 6 — Configure PuTTY

1. Open [PuTTY](https://www.putty.org/?utm_source=chatgpt.com)

2. Enter:

```text id="1y8yz6"
Host Name: 192.168.1.11
```

3. Navigate:

```text id="8mpx0w"
Connection → SSH → Auth
```

4. Browse and select:

```text id="5owgw6"
mykey.ppk
```

5. Go back to:

```text id="a4nyah"
Session
```

6. Optional:
   Save session name.

7. Click:

```text id="w0ryrs"
Open
```

8. Login as:

```text id="g7y9gb"
username
```

---

# 🔹 STEP 7 — Configure Pageant (SSH Key Agent)

## What is Pageant?

[Pageant](https://www.putty.org/?utm_source=chatgpt.com) stores your SSH private key in memory.

Benefits:

* No need to browse `.ppk` every time
* Can auto-login into multiple servers
* Works with PuTTY automatically

---

# 🔹 STEP 8 — Start Pageant

1. Open [Pageant](https://www.putty.org/?utm_source=chatgpt.com)

You’ll see a small computer/hat icon in Windows system tray.

---

# 🔹 STEP 9 — Add SSH Key into Pageant

## Method 1 — Using GUI

1. Right-click Pageant tray icon
2. Click:

```text id="7z96hl"
Add Key
```

3. Select:

```text id="r0icdz"
mykey.ppk
```

4. Enter passphrase (if set)

Done.

---

# 🔹 STEP 10 — Use PuTTY With Pageant

Now PuTTY automatically uses the loaded key.

You no longer need to configure:

```text id="5fhy8r"
Connection → SSH → Auth
```

for every session.

Just:

1. Open PuTTY
2. Enter server IP
3. Click Open

Pageant supplies the key automatically.

---

# 🔹 Optional — Auto Start Pageant With Key

Create shortcut target:

```text id="5m1pjh"
"C:\Program Files\PuTTY\pageant.exe" "C:\Keys\mykey.ppk"
```

Now Pageant auto-loads your key on startup.

---

# 🔹 First Connection Warning

First login may show:

```text id="grqf0u"
The server's host key is not cached
```

Click:

```text id="vm9z6u"
Accept
```

Normal behavior.

---

# 🔐 IMPORTANT SECURITY RULES

## NEVER Share

* `.ppk`
* `id_ed25519`
* Passphrase

## ONLY Share

* `id_ed25519.pub`
* Public key text

---

# 🔎 Understanding the Architecture

| Machine     | Role              |
| ----------- | ----------------- |
| Windows PC  | Holds private key |
| RHEL Server | Holds public key  |

Authentication flow:

1. Windows proves identity using private key
2. RHEL checks matching public key
3. Access granted

---

# 🔁 Alternative — Skip PuTTY Entirely

You can also use:

* PowerShell
* Windows Terminal
* Git Bash

Direct login:

```powershell id="9slr8v"
ssh username@192.168.1.11
```

No PuTTY/PuTTYgen/Pageant required.

---

# 📌 SIMPLE END-TO-END FLOW

## Using ssh-keygen

1. Open CMD
2. Run:

```powershell id="y42n6k"
ssh-keygen -t ed25519
```

3. Send `.pub` file to team
4. Convert key to `.ppk`
5. Add `.ppk` to Pageant
6. Open PuTTY
7. Login

---

# 📌 SIMPLE FLOW (PuTTYgen Only)

1. Open PuTTYgen
2. Generate ED25519 key
3. Save `.ppk`
4. Copy public key
5. Send public key to team
6. Add `.ppk` into Pageant
7. Open PuTTY
8. Login
