

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



---

## 1. Operators in MySQL

**Definition:** Operators are symbols that specify the operation to be performed on data or columns.

### Types of Operators:

* **Arithmetic Operators:** `+`, `-`, `/`, `%`, `*`
  Example: `SELECT 1 + 2;`
* **Relational Operators:** `>`, `<`, `>=`, `<=`, `=`, `!=`
  Example: `SELECT 17 > 10;`
* **Logical Operators:** `AND`, `OR`, `NOT`
  Used to combine multiple conditions in `WHERE` clause.

### Important Notes:

* Operators are used with columns in `SELECT` and `WHERE`.
* Example:

  ```sql
  SELECT * FROM zomato WHERE id = 102 OR price = 170;
  SELECT * FROM registration WHERE NOT id = 101;
  ```

---

## 2. WHERE Clause

* Filters rows based on conditions.
* Syntax:

  ```sql
  SELECT * FROM table_name WHERE condition;
  ```
* Logical operators used here:

  * `AND`: Both conditions must be true (filters rows individually).
  * `OR`: Either condition can be true (affects multiple rows).

---

## 3. Multiple Insert Omissions

When doing multiple inserts, omit:

* Default values
* Virtually generated columns
* `AUTO_INCREMENT` columns

---

## 4. Creating a Table Example

```sql
CREATE TABLE registration (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL UNIQUE,
  password VARCHAR(45) NOT NULL,
  mobile BIGINT NOT NULL UNIQUE,
  gender CHAR(1) NOT NULL
);
```

---

## 5. Data Manipulation Language (DML)

Operations that work with **records**:

| Command  | Description               |
| -------- | ------------------------- |
| `INSERT` | Adds new records          |
| `UPDATE` | Modifies existing records |
| `DELETE` | Removes records           |

### Examples:

* **DELETE:**

  ```sql
  DELETE FROM registration WHERE id = 102;
  ```

  To delete multiple rows, use `OR` (never comma).

* **UPDATE:**

  * Update one column:

    ```sql
    UPDATE registration SET password = 'password' WHERE id = 101;
    ```

  * Update multiple columns:

    ```sql
    UPDATE registration SET password = 'abcd123', mobile = 9845 WHERE id = 102;
    ```

  * Update multiple records:

    ```sql
    UPDATE registration SET password = 'xyz' WHERE id = 102 OR id = 103;
    ```

  * Update entire table (no `WHERE`):

    ```sql
    UPDATE registration SET password = 'pqr';
    ```

---

## 6. Data Definition Language (DDL)

DDL commands affect **tables and columns**:

### Table operations:

* `CREATE TABLE`
* `DROP TABLE`
* `TRUNCATE TABLE`
* `RENAME TABLE`

### Column operations via `ALTER TABLE`:

* Add column:

  ```sql
  ALTER TABLE student ADD COLUMN gender VARCHAR(45) NOT NULL;
  ```
* Modify column:

  ```sql
  ALTER TABLE student MODIFY COLUMN mobile BIGINT NOT NULL;
  ```
* Drop column:

  ```sql
  ALTER TABLE student DROP COLUMN gender;
  ```
* Rename column:

  ```sql
  ALTER TABLE student RENAME COLUMN gender TO sgender;
  ```
* Add/drop constraints and indexes:

  ```sql
  ALTER TABLE student ADD UNIQUE(email);
  ALTER TABLE student DROP INDEX mobile;
  ALTER TABLE student DROP PRIMARY KEY;
  ALTER TABLE student ADD PRIMARY KEY(roll);
  ```

### Rename table example:

```sql
RENAME TABLE old_table TO new_table;
```

---

## 7. Difference Between DELETE, TRUNCATE, DROP

| Feature        | DELETE            | TRUNCATE                              | DROP                      |
| -------------- | ----------------- | ------------------------------------- | ------------------------- |
| Type           | DML               | DDL                                   | DDL                       |
| Effect         | Deletes rows      | Deletes all rows but keeps table      | Deletes table & structure |
| WHERE clause   | Allowed           | Not allowed                           | Not allowed               |
| Rollback       | Can rollback      | Cannot rollback                       | Cannot rollback           |
| Speed          | Slower            | Faster                                | Drops table instantly     |
| Logging        | Logs deleted rows | Removes pages, logs page deallocation | N/A                       |
| Triggers fired | Yes               | No                                    | No                        |

---

## 8. Transaction Control Language (TCL)

Used to control transactions:

| Command     | Description                             |
| ----------- | --------------------------------------- |
| `COMMIT`    | Save all changes permanently            |
| `ROLLBACK`  | Undo changes since last commit          |
| `SAVEPOINT` | Set a point to rollback partial changes |

### Autocommit mode:

* `SET autocommit=0;` disables auto commit (manual commit required).
* `SET autocommit=1;` enables auto commit (default behavior).

---

## 9. Logical Operators in Detail

* **BETWEEN**: Checks if value is in range (inclusive).

  ```sql
  SELECT * FROM students WHERE age BETWEEN 6 AND 18;
  ```
* **IN**: Checks if value is in a list.

  ```sql
  SELECT * FROM students WHERE age IN (5, 6);
  ```
* **LIKE**: Pattern matching with wildcards `%` (zero or more chars) and `_` (exactly one char).

  ```sql
  SELECT * FROM students WHERE firstname LIKE 'Jo%'; -- names starting with 'Jo'  
  SELECT * FROM students WHERE firstname LIKE 'Jo_'; -- names with 'Jo' + one char
  ```
* **AND**: Both conditions must be true.
* **OR**: Either condition can be true.
* **NOT**: Negates condition.
* **IS NULL**: Checks for NULL values.

---

## 10. SQL Functions

### 10.1 String Functions

| Function      | Description                     |
| ------------- | ------------------------------- |
| `UPPER()`     | Converts string to uppercase    |
| `LOWER()`     | Converts string to lowercase    |
| `LENGTH()`    | Returns length of string        |
| `INSTR()`     | Returns position of substring   |
| `TRIM()`      | Removes leading/trailing spaces |
| `SUBSTRING()` | Extracts substring              |
| `CONCAT()`    | Concatenates strings            |
| `REVERSE()`   | Reverses a string               |

### 10.2 Numeric Functions

(Examples not provided, but include `ROUND()`, `CEIL()`, `FLOOR()`, etc.)

### 10.3 Date Functions

| Function         | Description                   |
| ---------------- | ----------------------------- |
| `CURRENT_DATE()` | Returns current date          |
| `CURRENT_TIME()` | Returns current time          |
| `NOW()`          | Returns current date and time |
| `SYSDATE()`      | Returns system date and time  |
| `MONTH(date)`    | Extracts month from date      |
| `YEAR(date)`     | Extracts year from date       |
| `DAY(date)`      | Extracts day from date        |

### 10.4 Aggregate Functions

| Function  | Description                        |
| --------- | ---------------------------------- |
| `AVG()`   | Returns average value              |
| `SUM()`   | Returns sum of values              |
| `MIN()`   | Returns minimum value              |
| `MAX()`   | Returns maximum value              |
| `COUNT()` | Counts rows (does not count NULLs) |
| `LIMIT`   | Limits the number of rows returned |

---

## 11. COUNT Function Details

* Counts total number of rows, **excluding NULL values**.
* Counts duplicates as separate rows.
* Useful for counting rows matching a condition.

Example:

```sql
SELECT COUNT(*) FROM students;       -- Counts all rows including duplicates and NULLs
SELECT COUNT(column_name) FROM table; -- Counts only non-NULL values in that column
SELECT COUNT(DISTINCT column_name) FROM table; -- Counts distinct non-NULL values
```

---

