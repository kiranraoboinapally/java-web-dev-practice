Here's a complete step-by-step process to create a user named aayush and allow RDP login.

Step 1: Open PowerShell as Administrator
Click Start → Search:
PowerShell

Right-click → Run as Administrator

Step 2: Create the Password Variable
Run:
$password = ConvertTo-SecureString "Performance@123." -AsPlainText -Force

You won't see any output. That's normal.

Step 3: Create the User
Run:
New-LocalUser `
-Name "aayush" `
-FullName "Aayush" `
-Password $password `
-Description "RDP User"

Expected output:
Name   Enabled
----   -------
aayush True
```

Step 4: Verify User Exists
Run:
```Get-LocalUser

You should see:
Administrator
deep
aayush
```

Step 5: Add User to Remote Desktop Users
Run:
```Add-LocalGroupMember `
-Group "Remote Desktop Users" `
-Member "aayush"

Verify:
Get-LocalGroupMember "Remote Desktop Users"

Expected:
Administrator
deep
aayush

or at least:
aayush

listed in the group.

Step 6: (Optional but Recommended) Make User Administrator
Run:
Add-LocalGroupMember `
-Group "Administrators" `
-Member "aayush"

Verify:
Get-LocalGroupMember "Administrators"

Expected:
Administrator
deep
aayush
```

Step 7: Verify Account is Enabled
Run:
```Get-LocalUser aayush

Expected:
Enabled : True
```

Step 8: Verify Remote Desktop is Enabled
Run:
```(Get-ItemProperty `
'HKLM:\System\CurrentControlSet\Control\Terminal Server').fDenyTSConnections

Expected:
0

If you get:
1

enable RDP:
Set-ItemProperty `
'HKLM:\System\CurrentControlSet\Control\Terminal Server' `
-Name fDenyTSConnections `
-Value 0
```

Step 9: Enable RDP Firewall Rules
Run:
```Enable-NetFirewallRule -DisplayGroup "Remote Desktop"
```

Step 10: Login Using RDP
From another machine:
```mstsc

Computer:
192.168.1.20

Username:
aayush

Password:
Performance@123.

If login still fails after these steps, run:
Get-LocalGroupMember "Remote Desktop Users"
Get-LocalGroupMember "Administrators"

and paste the output. That will show exactly what's missing.

