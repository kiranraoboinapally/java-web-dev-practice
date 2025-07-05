

---

### **MySQL Basics:**

1. **Starting MySQL in Command Line (CMD):**
   - **Navigate to MySQL bin directory**:
     ```bash
     cd C:/Program Files/MySQL/bin
     ```
   - **Log into MySQL**:
     ```bash
     mysql -u root -p
     ```
   - **Enter password**: 
     ```bash
     kira
     ```

2. **Viewing Databases**:
   - To see all databases in your system:
     ```sql
     show databases;
     ```

3. **Creating a Database**:
   - To create a new database:
     ```sql
     create database databasename;
     ```
     Example:
     ```sql
     create database college;
     ```

4. **Using a Database**:
   - To start using a specific database:
     ```sql
     use databasename;
     ```
     Example:
     ```sql
     use college;
     ```

5. **Deleting a Database**:
   - To delete a database:
     ```sql
     drop database databasename;
     ```
     Example:
     ```sql
     drop database college;
     ```

6. **Creating a Table**:
   - Syntax to create a table:
     ```sql
     create table tablename
     (
       col_name data_type, ...
     );
     ```
     Example:
     ```sql
     create table student (
       sno int,
       name varchar(45),
       mobile int,
       email varchar(45),
       gender char(1)
     );
     ```

7. **Inserting Data into a Table**:
   - To insert data into a table:
     ```sql
     insert into tablename values(col1value, col2value, ...);
     ```
     Example:
     ```sql
     insert into jobs values(121, 'Software', 'IT', 'Btech');
     ```

8. **Selecting Data from a Table**:
   - To display all columns in a table:
     ```sql
     select * from tablename;
     ```
   - To display specific columns:
     ```sql
     select column1, column2 from tablename;
     ```
     Example:
     ```sql
     select Jid, Jname from jobs;
     ```

9. **Describing a Table**:
   - To explain a table’s structure:
     ```sql
     explain tablename;
     ```
     Example:
     ```sql
     explain jobs;
     ```

---

### **Understanding Data Types:**

#### **1. Numeric Data Types:**

These types are used to store numerical values.

- **INT (Integer)**:
  - **Purpose**: Stores whole numbers (both positive and negative).
  - **Range**: Typically between `-2,147,483,648` and `2,147,483,647`.
  - **Use Case**: Good for storing integers such as **IDs**, **counts**, or **age**.

  **Example**:
  ```sql
  create table employee (
    employee_id int,
    name varchar(100)
  );
  ```

- **DOUBLE**:
  - **Purpose**: Used for **floating-point numbers** (decimals), typically with higher precision than `FLOAT`.
  - **Use Case**: Suitable for storing values like **prices**, **measurements**, or **scientific data**.

  **Example**:
  ```sql
  create table product (
    price double
  );
  ```

  **Note**: If you need exact precision (e.g., in financial calculations), consider using `DECIMAL` instead of `DOUBLE`.

- **BIGINT**:
  - **Purpose**: Stores **large integers** beyond the range of `INT`.
  - **Range**: From `-9,223,372,036,854,775,808` to `9,223,372,036,854,775,807`.
  - **Use Case**: Used for large values like **transaction IDs**, **large counts**, or **global unique identifiers (GUIDs)**.

  **Example**:
  ```sql
  create table transaction (
    transaction_id bigint
  );
  ```

---

#### **2. String Data Types:**

These types are used to store text-based data.

- **CHAR(n)**:
  - **Purpose**: Fixed-length strings. If the string length is smaller than `n`, it is padded with spaces.
  - **Range**: `1 to 65535` (depending on MySQL version and row size).
  - **Use Case**: Ideal for **fixed-length** values like **gender**, **country codes**, or **ZIP codes**.

  **Example**:
  ```sql
  create table users (
    gender char(1)
  );
  ```

  **Range Summary**:
  - `CHAR(n)` always stores exactly `n` characters, padding with spaces if necessary.

- **VARCHAR(n)**:
  - **Purpose**: Variable-length strings. Uses only the required space.
  - **Range**: `1 to 65,535` (depending on row size).
  - **Use Case**: Suitable for fields where length can vary, like **names**, **email addresses**, and **descriptions**.

  **Example**:
  ```sql
  create table person (
    name varchar(100),
    email varchar(100)
  );
  ```

  **Range Summary**:
  - `VARCHAR(n)` can store up to `n` characters, using only the space required.

---

#### **3. Date and Time Data Types:**

These types are used to store date and time values.

- **DATE**:
  - **Purpose**: Stores only the **date** (year, month, day).
  - **Range**: From **`1000-01-01`** to **`9999-12-31`**.
  - **Use Case**: Used for storing dates like **birthdates** or **event dates**.

  **Example**:
  ```sql
  create table event (
    event_date date
  );
  ```

  **Range Summary**:
  - `DATE` stores values from `1000-01-01` to `9999-12-31`.

- **DATETIME**:
  - **Purpose**: Stores both **date and time** (e.g., `YYYY-MM-DD HH:MM:SS`).
  - **Use Case**: Ideal for **timestamps** (e.g., recording when an order is placed or when a user logs in).

  **Example**:
  ```sql
  create table user_activity (
    last_login datetime
  );
  ```

- **TIMESTAMP**:
  - **Purpose**: Stores both **date and time**, with automatic updates when a record is modified.
  - **Use Case**: Useful for tracking when a record is **created** or **updated** (e.g., audit trails, record modifications).

  **Example**:
  ```sql
  create table product (
    created_at timestamp default current_timestamp
  );
  ```

- **TIME**:
  - **Purpose**: Stores only the **time** (e.g., `HH:MM:SS`).
  - **Use Case**: Used for storing durations or specific **times of day**, such as **working hours**.

  **Example**:
  ```sql
  create table working_hours (
    start_time time
  );
  ```


### Summary of Use Cases:

| Data Type   | Usage                                                   | Example Use Case                                      |
|-------------|---------------------------------------------------------|-------------------------------------------------------|
| **DATE**    | Stores only the date (year, month, day)                 | Birthdate, Event Date, Membership Start Date          |
| **DATETIME**| Stores date and time (year, month, day, hours, minutes, seconds) | Order Timestamps, User Logins, Scheduled Events       |
| **TIMESTAMP**| Stores date and time with automatic updates on insert/update | Record Creation/Modification Timestamps, Audit Logs |
| **TIME**    | Stores only the time (hours, minutes, seconds)          | Working Hours, Task Durations, Event Duration         |



### Key Points:
- **DATE** is perfect for when you only need the **date**.
- **DATETIME** is used for **precise timestamps**.
- **TIMESTAMP** is useful for **automatic tracking** of changes to records.
- **TIME** is used for **time-related data** without dates, such as durations or specific times of day.


---

### **Additional Details:**

- **Choosing the Right Data Type**:
  - For **performance**: Use smaller data types when possible. For example, use `INT` instead of `BIGINT` unless you expect very large numbers.
  - For **data integrity**: Choose data types that match the data you're storing (e.g., `DATE` for dates, `VARCHAR` for names, etc.).
  - For **flexibility**: Use `VARCHAR` when you expect variable-length data, but make sure to set a reasonable length limit.

---

### **Virtual Columns (Virtually Generated Columns)**

A **virtual column** is a column in a database table that doesn't physically store data but is **calculated dynamically** when queried. These columns are especially useful for derived values that are based on expressions involving other columns in the table.

**Key Points:**
- They are **not stored** in the table but are computed **on the fly** during a query.
- Virtual columns are **read-only** and can’t be updated directly.
- You cannot apply constraints like `NOT NULL`, `DEFAULT`, `UNIQUE`, or `CHECK` on virtual columns.

**Example:**
Imagine a student table where we want to calculate the total marks from three subjects and the percentage of the total marks.

```sql
CREATE TABLE student (
    roll INT,
    name VARCHAR(45),
    section CHAR,
    mobile BIGINT,
    maxmarks INT,
    s1 INT,
    s2 INT,
    s3 INT,
    total INT AS (s1 + s2 + s3),   -- Virtual column
    percentage DOUBLE AS (total / maxmarks * 100)  -- Virtual column
);
```

- The `total` column is calculated as `s1 + s2 + s3`.
- The `percentage` column is calculated as `(total / maxmarks) * 100`.

These columns do not need to be stored in the database, saving space.

---

### **2. Multiple Insert**

In SQL, you can insert multiple rows of data into a table in one `INSERT` statement. This improves performance compared to inserting each row separately.

**Syntax:**
```sql
INSERT INTO table_name (col1, col2, col3, ...) 
VALUES 
(value1a, value2a, value3a, ...), 
(value1b, value2b, value3b, ...),
...
```

**Example:**
If you want to insert multiple students into the `student` table:

```sql
INSERT INTO student (roll, name, section, mobile, maxmarks, s1, s2, s3) 
VALUES 
(1, 'Arjun', 'A', 9893938, 90, 25, 22, 28),
(2, 'Balu', 'B', 982928, 90, 22, 22, 28);
```

This inserts two records in one go. The **virtual columns** (`total`, `percentage`) will be calculated automatically without needing to specify them in the `INSERT` statement.

---

### **3. Constraints in SQL**

SQL constraints are used to define rules that the data must follow in the database to ensure data integrity and consistency. 

#### **Types of Constraints:**

- **NOT NULL**: Ensures that a column cannot have a `NULL` value.
  ```sql
  CREATE TABLE student (
      roll INT NOT NULL,
      name VARCHAR(45) NOT NULL
  );
  ```

- **CHECK**: Ensures that the values in a column satisfy a specific condition.
  ```sql
  CREATE TABLE student (
      age INT CHECK (age >= 18)
  );
  ```

- **DEFAULT**: Assigns a default value to a column if no value is provided.
  ```sql
  CREATE TABLE student (
      gender VARCHAR(45) DEFAULT 'female'
  );
  ```

- **UNIQUE**: Ensures that all values in a column are distinct.
  ```sql
  CREATE TABLE student (
      email VARCHAR(45) UNIQUE
  );
  ```

- **PRIMARY KEY**: A combination of `NOT NULL` and `UNIQUE`, used to uniquely identify each record in a table.
  ```sql
  CREATE TABLE student (
      roll INT PRIMARY KEY
  );
  ```

- **FOREIGN KEY**: Establishes a link between two tables. The foreign key in one table points to the primary key of another table, enforcing referential integrity.
  ```sql
  CREATE TABLE orders (
      oid INT PRIMARY KEY,
      oname VARCHAR(45)
  );

  CREATE TABLE flipkart (
      order_id INT,
      FOREIGN KEY (order_id) REFERENCES orders(oid)
  );
  ```

---

### **4. NULL Values in SQL**

A **NULL** in SQL indicates the absence of a value or an unknown value. It is **not** the same as an empty string or zero. 

- A column with `NULL` means that the value is either not known or not applicable.
  
**Example:**
```sql
CREATE TABLE student (
    name VARCHAR(45),
    age INT
);
```
- In this table, the `age` column can have a `NULL` value if the age is not provided.

---

### **5. Primary and Foreign Keys**

Primary keys and foreign keys are fundamental in relational databases for maintaining data integrity and defining relationships between tables.

- **Primary Key**: A column (or a combination of columns) that uniquely identifies each record in the table. Every table can have only one primary key.
  
- **Foreign Key**: A column in one table that uniquely identifies a row in another table. It establishes a relationship between the two tables.

#### **Example:**

Consider a simple e-commerce system with three tables: `orders`, `flipkart`, and `customer`.

1. **Orders Table**: Contains order information. `oid` is the primary key.
2. **Flipkart Table**: Contains customer details, including an `order_id` that references `orders(oid)` and a `cid` that references `customer(cid)`.
3. **Customer Table**: Contains customer feedback. `cid` is the primary key.

```sql
CREATE TABLE orders (
    oid INT PRIMARY KEY,
    oname VARCHAR(45),
    oprice INT
);

CREATE TABLE customer (
    cid INT PRIMARY KEY,
    feedback VARCHAR(45)
);

CREATE TABLE flipkart (
    name VARCHAR(45),
    email VARCHAR(45) PRIMARY KEY,
    order_id INT,
    cid INT,
    FOREIGN KEY (order_id) REFERENCES orders(oid),
    FOREIGN KEY (cid) REFERENCES customer(cid)
);
```

In this example:
- The `flipkart` table has foreign keys that link to the `orders` table and the `customer` table, ensuring that the customer and the order exist before an entry is made in the `flipkart` table.
- The `customer` table has feedback linked to the `cid`, which is used as a reference in `flipkart`.
---
### 6. Operators

**Definition:**
An **operator** is a symbol or keyword used to perform operations on data, typically on column values or constants in SQL queries. Operators help in manipulating, comparing, or combining data.

---

#### Types of Operators in MySQL

There are **three main categories** of operators:

---

##### 6.1 Arithmetic Operators

These operators perform mathematical calculations on numeric data.

| Operator | Meaning             | Example          | Result |
| -------- | ------------------- | ---------------- | ------ |
| `+`      | Addition            | `SELECT 5 + 3;`  | `8`    |
| `-`      | Subtraction         | `SELECT 10 - 7;` | `3`    |
| `*`      | Multiplication      | `SELECT 4 * 6;`  | `24`   |
| `/`      | Division            | `SELECT 20 / 4;` | `5`    |
| `%`      | Modulus (Remainder) | `SELECT 10 % 3;` | `1`    |

* These operators are mainly used on numeric columns or numeric literals.
* Example usage in SQL:

  ```sql
  SELECT price, price * 0.10 AS discount FROM products;
  ```

---

##### 6.2 Relational (Comparison) Operators

These operators compare two values and return a boolean result (`TRUE` or `FALSE`).

| Operator     | Meaning                  | Example                                          | Result                           |
| ------------ | ------------------------ | ------------------------------------------------ | -------------------------------- |
| `=`          | Equal to                 | `SELECT * FROM users WHERE age = 25;`            | Rows where age = 25              |
| `!=` or `<>` | Not equal to             | `SELECT * FROM users WHERE id != 10;`            | Rows where id is not 10          |
| `<`          | Less than                | `SELECT * FROM orders WHERE quantity < 5;`       | Rows with quantity less than 5   |
| `>`          | Greater than             | `SELECT * FROM products WHERE price > 100;`      | Rows with price greater than 100 |
| `<=`         | Less than or equal to    | `SELECT * FROM table WHERE col <= 50;`           | Rows where col ≤ 50              |
| `>=`         | Greater than or equal to | `SELECT * FROM employees WHERE salary >= 30000;` | Rows where salary ≥ 30000        |

* Commonly used in `WHERE` clauses for filtering data.

---

##### 6.3 Logical Operators

These operators combine multiple boolean conditions to form complex queries.

| Operator | Meaning                | Description                                               | Example                                   |
| -------- | ---------------------- | --------------------------------------------------------- | ----------------------------------------- |
| `AND`    | Logical AND            | Returns TRUE only if **both** conditions are TRUE         | `WHERE age > 20 AND gender = 'M'`         |
| `OR`     | Logical OR             | Returns TRUE if **any one** condition is TRUE             | `WHERE city = 'Delhi' OR city = 'Mumbai'` |
| `NOT`    | Logical NOT (negation) | Reverses the condition: TRUE becomes FALSE and vice versa | `WHERE NOT status = 'active'`             |

* Used mainly in `WHERE` clauses to combine multiple filters.
* Example:

  ```sql
  SELECT * FROM employees WHERE department = 'Sales' AND salary > 50000;
  ```

---

#### Important Notes on Operators

* **Operators are used with columns** or constants inside SQL queries.
* For example, you can use arithmetic operators in a `SELECT` statement to perform calculations on column values:

  ```sql
  SELECT price, price * 0.9 AS discounted_price FROM products;
  ```
* Relational and logical operators are mostly used in `WHERE` clauses to filter rows based on conditions.
* You can combine multiple logical conditions to refine data selection:

  ```sql
  SELECT * FROM orders WHERE quantity > 10 AND status = 'pending';
  ```

---

#### Examples of Using Operators

1. **Arithmetic Operator**

```sql
SELECT 10 + 5;  -- Returns 15
SELECT salary * 12 AS yearly_salary FROM employees;
```

2. **Relational Operator**

```sql
SELECT * FROM students WHERE age > 18;
SELECT * FROM products WHERE price <= 500;
```

3. **Logical Operators**

```sql
SELECT * FROM customers WHERE city = 'New York' AND active = 1;
SELECT * FROM orders WHERE status = 'shipped' OR status = 'delivered';
SELECT * FROM employees WHERE NOT department = 'HR';
```

---


**7. WHERE Clause **

---

### What is WHERE Clause?

The **WHERE** clause is used in SQL to filter rows from a table based on specified condition(s). It returns only those records that meet the condition(s), helping you work with precise data.

---

### Syntax:

```sql
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```

---

### Key Points:

* Conditions can use operators like `=`, `>`, `<`, `>=`, `<=`, `!=`, combined with logical operators `AND`, `OR`, `NOT`.
* Multiple conditions can be combined.
* Applicable in `SELECT`, `UPDATE`, `DELETE` statements.
* If omitted, all rows are affected or returned.

---

### Examples:

1. Filter rows by one condition:

```sql
SELECT * FROM registration WHERE id = 102;
```

2. Filter rows by multiple conditions with OR:

```sql
SELECT * FROM zomato WHERE id = 102 OR price = 170;
```

3. Use NOT operator to negate a condition:

```sql
SELECT * FROM registration WHERE NOT id = 101;
```

4. Use AND operator for multiple conditions that all must be true:

```sql
SELECT * FROM employees WHERE department = 'Sales' AND salary > 50000;
```

---

### Notes on Logical Operators in WHERE:

* **AND** requires all conditions to be true for a row to be selected.
* **OR** requires at least one condition to be true.
* **NOT** negates a condition.
* Conditions apply only to **columns** in the table.

---

### Usage Examples in Other Statements:

* Delete specific records:

```sql
DELETE FROM registration WHERE id = 102;
```

* Update specific records:

```sql
UPDATE registration SET password = 'newpass' WHERE id = 101;
```

---

### 8. Multiple Insert and Auto-Handled Columns

---

### What is Multiple Insert?

Multiple insert refers to inserting several rows into a table with a single `INSERT` statement, which is more efficient than inserting one row at a time.

---

### Syntax for Multiple Insert:

```sql
INSERT INTO table_name (column1, column2, ...)
VALUES 
    (value1_1, value1_2, ...),
    (value2_1, value2_2, ...),
    ...;
```

---

### Example:

```sql
INSERT INTO registration (name, email, password, mobile, gender)
VALUES
    ('Alice', 'alice@example.com', 'pass1', 1234567890, 'F'),
    ('Bob', 'bob@example.com', 'pass2', 9876543210, 'M');
```

---

### Columns Automatically Handled (Omitted Columns)

When inserting records, some columns don’t require explicit values because they are handled automatically by the database:

1. **Default Columns**
   Columns with a default value defined will automatically get that default if omitted in the insert.

   **Note:**
   If you explicitly insert a value into a default column, **that value is stored**, regardless of the default. The default is only applied when the column is omitted in the `INSERT`.

2. **Virtually Generated Columns**
   Computed/generated columns that derive their values automatically from other columns.

3. **AUTO\_INCREMENT Columns**
   Columns (usually primary keys) that auto-increment their value on each new row insertion.

---

### Example of Table with AUTO\_INCREMENT:

```sql
CREATE TABLE registration 
(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL UNIQUE,
  password VARCHAR(45) NOT NULL, 
  mobile BIGINT NOT NULL UNIQUE, 
  gender CHAR(1) NOT NULL
);
```

In this case, `id` is auto-generated, so you don't provide it explicitly in the `INSERT` statements.

---

### 9. DML (Data Manipulation Language)

---

### What is DML?

DML commands are used to **work with data records** inside database tables. They allow you to **insert**, **update**, and **delete** records.

---

### Main DML Commands:

1. **INSERT**
   Adds new records into a table.

2. **UPDATE**
   Modifies existing records in a table.

3. **DELETE**
   Removes existing records from a table.

---

### INSERT Command

Syntax:

```sql
INSERT INTO table_name (column1, column2, ...)
VALUES (value1, value2, ...);
```

Example:

```sql
INSERT INTO registration (name, email, password, mobile, gender)
VALUES ('John', 'john@example.com', 'pass123', 9876543210, 'M');
```

---

### UPDATE Command

Syntax:

```sql
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
```

* The **WHERE** clause specifies which rows to update.
* If **WHERE** is omitted, **all rows** in the table will be updated.

---

#### UPDATE Examples:

* **Update single column for one record:**

```sql
UPDATE registration SET password='newpass' WHERE id=101;
```

* **Update multiple columns for one record:**

```sql
UPDATE registration SET password='abcd123', mobile=1234567890 WHERE id=102;
```

* **Update multiple records:**

```sql
UPDATE registration SET password='xyz' WHERE id=102 OR id=103;
```

* **Update entire table (no WHERE):**

```sql
UPDATE registration SET password='defaultpass';
```

---

### DELETE Command

Syntax:

```sql
DELETE FROM table_name WHERE condition;
```

* Deletes records matching the **WHERE** condition.
* Without **WHERE**, deletes all rows from the table.

---

#### DELETE Examples:

* Delete one record:

```sql
DELETE FROM registration WHERE id=102;
```

* Delete multiple records:

```sql
DELETE FROM registration WHERE id=101 OR id=103;
```

> **Note:**
> Use **OR** to combine multiple conditions.
> Do **not** use commas — commas are for columns only, not for combining conditions.

---

### Important Notes on DML:

* Always use **WHERE** to avoid unintentional updates or deletes on the entire table.
* Changes with DML commands can be controlled with **transactions** (COMMIT, ROLLBACK).
* DML commands modify the data but **do not change the table structure**.

---

### 10. DELETE vs TRUNCATE vs DROP

---

These three commands are used to remove data or tables in MySQL but behave very differently.

---

### 1. DELETE

* **Type:** DML (Data Manipulation Language)
* **Purpose:** Deletes **rows/records** from a table.
* **Usage:** Can delete specific rows by using a **WHERE** clause.
* **Rollback:** Can be rolled back if inside a transaction before commit.
* **Speed:** Slower than TRUNCATE because it logs individual row deletions.
* **Triggers:** Triggers (DELETE triggers) are fired.
* **Effect on Table Structure:** Table structure **remains intact** after deletion.

---

### DELETE Example:

```sql
DELETE FROM registration WHERE id = 101;
```

---

### 2. TRUNCATE

* **Type:** DDL (Data Definition Language)
* **Purpose:** Deletes **all rows** from a table quickly.
* **Usage:** Removes all data; **cannot use WHERE clause**.
* **Rollback:** Cannot be rolled back in many database engines.
* **Speed:** Faster than DELETE because it deallocates data pages instead of logging each row.
* **Triggers:** Does **not** fire DELETE triggers.
* **Effect on Table Structure:** Table structure remains intact.
* **Resets AUTO\_INCREMENT:** Yes, usually resets any AUTO\_INCREMENT counters to zero.

---

### TRUNCATE Example:

```sql
TRUNCATE TABLE registration;
```

---

### 3. DROP

* **Type:** DDL (Data Definition Language)
* **Purpose:** Deletes the **entire table** including structure and data.
* **Usage:** Removes table completely from the database.
* **Rollback:** Cannot be rolled back.
* **Triggers:** N/A (table no longer exists).
* **Effect on Table Structure:** Table is **permanently removed**.
* **Cannot use WHERE clause.**

---

### DROP Example:

```sql
DROP TABLE registration;
```

---

### Table:

| Feature                | DELETE                | TRUNCATE | DROP                     |
| ---------------------- | --------------------- | -------- | ------------------------ |
| Type                   | DML                   | DDL      | DDL                      |
| Deletes Rows           | Specific rows (WHERE) | All rows | Entire table & structure |
| WHERE Clause           | Yes                   | No       | No                       |
| Rollback               | Yes (before commit)   | No       | No                       |
| Speed                  | Slower                | Faster   | N/A                      |
| Triggers Fired         | Yes                   | No       | N/A                      |
| Table Structure Kept   | Yes                   | Yes      | No                       |
| Resets AUTO\_INCREMENT | No                    | Yes      | N/A                      |

---






