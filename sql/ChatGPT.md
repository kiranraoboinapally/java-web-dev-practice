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
  - **Use Case**: Ideal for **fixed-length** values like **gender**, **country codes**, or **ZIP codes**.

  **Example**:
  ```sql
  create table users (
    gender char(1)
  );
  ```

  **When to Avoid**: If the length of the text varies, use `VARCHAR` instead of `CHAR`.

- **VARCHAR(n)**:
  - **Purpose**: Variable-length strings. Uses only the required space.
  - **Use Case**: Suitable for fields where length can vary, like **names**, **email addresses**, and **descriptions**.

  **Example**:
  ```sql
  create table person (
    name varchar(100),
    email varchar(100)
  );
  ```

  **Note**: Always specify a length (`n`) to optimize storage and performance.

---

#### **3. Date and Time Data Types:**

These types are used to store date and time values.

- **DATE**:
  - **Purpose**: Stores only the **date** (year, month, day).
  - **Use Case**: Used for storing dates like **birthdates** or **event dates**.

  **Example**:
  ```sql
  create table event (
    event_date date
  );
  ```

  **Note**: Use `CURDATE()` to automatically insert the current date.

- **DATETIME**:
  - **Purpose**: Stores both **date and time** (e.g., `YYYY-MM-DD HH:MM:SS`).
  - **Use Case**: Ideal for **timestamps** (e.g., recording when an order is placed or when a user logs in).

  **Example**:
  ```sql
  create table user_activity (
    last_login datetime
  );
  ```

  **Note**: If time zones are important, consider `TIMESTAMP` instead of `DATETIME`.

- **TIMESTAMP**:
  - **Purpose**: Stores both **date and time**, but also allows **automatic updates** when a record is modified.
  - **Use Case**: Useful for tracking when a record is **created** or **updated** (e.g., audit trails, record modifications).

  **Example**:
  ```sql
  create table product (
    created_at timestamp default current_timestamp
  );
  ```

  **Important**: `TIMESTAMP` is **time zone-aware** and automatically adjusts to UTC.

- **TIME**:
  - **Purpose**: Stores only the **time** (e.g., `HH:MM:SS`).
  - **Use Case**: Used for storing durations or specific **times of day**, such as **working hours**.

  **Example**:
  ```sql
  create table working_hours (
    start_time time
  );
  ```

---

### **Additional Details:**

- **Choosing the Right Data Type**:
  - For **performance**: Use smaller data types when possible. For example, use `INT` instead of `BIGINT` unless you expect very large numbers.
  - For **data integrity**: Choose data types that match the data you're storing (e.g., `DATE` for dates, `VARCHAR` for names, etc.).
  - For **flexibility**: Use `VARCHAR` when you expect variable-length data, but make sure to set a reasonable length limit.

---
