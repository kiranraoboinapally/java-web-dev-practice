Allow Multiple RDP Sessions for the Same User Account
 
Goal
 
Allow the same Windows user account (for example, aayush) to have multiple simultaneous RDP sessions instead of disconnecting the existing session.
 

 
Step 1: Open Local Group Policy Editor
 
Press:
 
Win + R

 
Type:
 
gpedit.msc

 
Click **OK**.
 

 
Step 2: Navigate to RDP Session Policy
 
Go to:
 
Computer Configuration
 └─ Administrative Templates
     └─ Windows Components
         └─ Remote Desktop Services
             └─ Remote Desktop Session Host
                 └─ Connections

 

 
Step 3: Open the Policy
 
Find:
 
Restrict Remote Desktop Services users to a single Remote Desktop Services session

 
Double-click it.
 

 
Step 4: Change the Setting
 
Current value:
 
Not Configured

 
Change to:
 
Disabled

 
Click:
 
Apply
OK

 

 
Step 5: Test Before Running gpupdate
 
Do NOT run:
 
powershell
gpupdate /force

 
yet.
 
First test.
 
Machine 1
 
Connect via RDP using:
 
aayush

 
Keep the session open.
 
Machine 2
 
Connect again via RDP using:
 
aayush

 

 
Step 6: Check Result
 
Run:
 
powershell
quser

 
If you see something similar to:
 
USERNAME     SESSIONNAME
aayush       rdp-tcp#1
aayush       rdp-tcp#2

 
then multiple sessions for the same user are working.
 
No further action required.
 

 
Step 7: If Still Disconnecting
 
Run:
 
powershell
gpupdate /force

 
Wait for completion.
 
Retest using two RDP sessions with the same user.
 

 
Step 8: If Still Disconnecting After gpupdate
 
Reboot the server:
 
powershell
Restart-Computer

 
or
 
Start Menu
→ Power
→ Restart

 
Retest after reboot.
 

 
Additional Check
 
In the same Group Policy folder, review:
 
Limit number of connections

 
Ensure it is not restricting the number of RDP sessions.
 

 
Final Recommendation
 
Is allowing multiple sessions for the same account a good idea?
 
For Testing/Lab Environment
 
Yes, it can be useful.
 
Examples:
 
You
+
Friend
+
Same account

 
Testing software.
 
Testing RDP behavior.
 
Temporary troubleshooting.
 

 
For Production Use
 
Not recommended.
 
Instead create separate users:
 
aayush
deep
kiran

 
and add them to:
 
Remote Desktop Users

 
Benefits:
 
✅ Separate desktops
 
✅ Separate Downloads/Documents folders
 
✅ Separate browser history
 
✅ Better auditing (know who did what)
 
✅ Better security
 
✅ Easier troubleshooting
 
✅ Easier password management
 

 
Problems with Sharing One Account
 
aayush

 
used by multiple people:
 
❌ Cannot identify who made changes
 
❌ Password sharing required
 
❌ File ownership confusion
 
❌ Security risk
 
❌ Session conflicts
 
❌ Harder troubleshooting
 

 
Recommended Enterprise Setup
 
Windows Server
│
├── aayush
├── deep
├── kiran
└── administrator

 
Each user:
 
Own RDP Login
Own Desktop
Own Files
Own Session

 
This is the standard approach used in most enterprise Windows Server environments.
 

 
My Recommendation for Your VM
 
Keep:
 
aayush
deep

 
as separate users.
 
Use multiple sessions for the same account only for testing or temporary requirements.
 
For regular use, separate user accounts are cleaner, safer, and easier to manage.
