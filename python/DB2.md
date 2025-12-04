
## **1. Prerequisites**

* IBM DB2 LUW installed on Windows.
* Access to **Windows Administrator** or the user who installed DB2.
* DB2 Command Line Processor (CLP) installed (comes with DB2).
* DBeaver installed for database visualization (optional).

---

## **2. Open DB2 Command Window**

1. Click **Start → IBM DB2 → Command Line Tools → DB2 Command Window**.
2. Run as **DB2ADMIN** if you want this user to own the instance and perform administrative tasks.

   * Windows: **Shift + Right-click → Run as different user → DB2ADMIN**.
   * Or in CMD:

     ```cmd
     runas /user:DB2ADMIN "db2cmd"
     ```
3. Verify environment variables:

```cmd
set DB2INSTANCE
```

Expected output:

```
DB2INSTANCE=DB2ADMIN
```

---

## **3. Check DB2 Instance**

```cmd
db2ilist
```

* Should display `DB2ADMIN`.
* Verify connection to the instance:

```cmd
db2 get instance
```

* Should show `DB2ADMIN`.

---

## **4. Create Database**

```cmd
db2 create database myDB
```

* Optional: specify code page and territory:

```cmd
db2 create database myDB using codeset UTF-8 territory US pagesize 4096
```

* Verify database:

```cmd
db2 list db directory
```

---

## **5. Grant DB2ADMIN Full Database Privileges**

Connect to the database:

```cmd
db2 connect to myDB
```

Grant full database authority:

```cmd
db2 "GRANT DBADM ON DATABASE TO USER DB2ADMIN"
db2 "GRANT SECADM ON DATABASE TO USER DB2ADMIN"
```

* **DBADM** → create/drop schemas, tables, alter objects.
* **SECADM** → manage privileges for other users.

Verify:

```cmd
db2 "SELECT GRANTEE, DBADMAUTH, SECADMAUTH FROM SYSCAT.DBAUTH WHERE GRANTEE='DB2ADMIN'"
```

* Should show `Y` for DBADMAUTH and SECADMAUTH.

---

## **6. Check Current User in DB2**

```cmd
db2 "VALUES (SESSION_USER)"
```

* Should output `DB2ADMIN`.
* If it outputs another user (like `KIRAN`), log in as DB2ADMIN using **Run As**.

---

## **7. Create Schema `COL_BANK`**

* If schema does not exist:

```cmd
db2 "CREATE SCHEMA COL_BANK AUTHORIZATION DB2ADMIN"
```

* If schema exists but is owned by another user:

1. Drop existing schema (if empty):

```cmd
db2 "DROP SCHEMA COL_BANK RESTRICT"
```

> Use `CASCADE` if schema has objects — **be careful, deletes everything inside**.

2. Recreate under DB2ADMIN:

```cmd
db2 "CREATE SCHEMA COL_BANK AUTHORIZATION DB2ADMIN"
```

* Verify schema ownership:

```cmd
db2 "SELECT SCHEMANAME, OWNER FROM SYSCAT.SCHEMATA WHERE SCHEMANAME='COL_BANK'"
```

* Should display `DB2ADMIN` as owner.

---

## **8. Grant DB2ADMIN Privileges on Existing Schema (Optional)**

If you cannot change ownership:

```cmd
db2 "GRANT ALL ON SCHEMA COL_BANK TO USER DB2ADMIN"
```

* Allows DB2ADMIN to create tables, alter columns, rename objects, etc.

---

## **9. Refresh DBeaver**

* In DBeaver, right-click your `myDB` connection → **Refresh**.
* The schema `COL_BANK` should now appear under DB2ADMIN.
* DB2ADMIN can now create tables, alter columns, drop objects, etc.

---

## **10. Create Table Example**

```sql
db2 "CREATE TABLE COL_BANK.ACCOUNTS (
    ACCOUNT_ID INT NOT NULL,
    CUSTOMER_NAME VARCHAR(100),
    BALANCE DECIMAL(15,2),
    PRIMARY KEY (ACCOUNT_ID)
)"
```

* Verify:

```sql
db2 "SELECT TABNAME, TABSCHEMA FROM SYSCAT.TABLES WHERE TABSCHEMA='COL_BANK'"
```

---

## **11. Alter Table Example**

```sql
db2 "ALTER TABLE COL_BANK.ACCOUNTS ADD COLUMN CREATED_DATE DATE"
```

* Rename column:

```sql
db2 "ALTER TABLE COL_BANK.ACCOUNTS RENAME COLUMN CUSTOMER_NAME TO CLIENT_NAME"
```

---

## **12. Notes**

* **DBADM** privileges are database-specific; need to grant separately for other databases.
* **SYSADM** privileges are instance-wide and needed only to create new databases.
* Always run DB2 commands in a **DB2 Command Window** with proper user context.

---


