1.Identifiers?.2.Data types (Table type,bit/bytes,range) why char data type range starts from 0?.
Which data type is longest in b/w double and long why?. differecnes b/w ascii and unicode?.
3.Type Casting and its types.What is truncation?what cannot be typecasted?(boolean?)
4.Logical Or 5.Logical And 6.can file name and class name can be different?
7.if-else syntax 8.nested if-else syntnax 9.JDK? 10.JRE? 11.JVM? 12.What is JIT?
13.Bitwise XOR ? 14.Syntax for while?15.assignment operators.16.Pre Increment and post Incremenet?. 17.Java Features?18.For syntax?19.Extraction model ?. 20.break vs continue?.21.Scanner Class& how to give as int num1=s.nextInt(); for all datatypes like this?. 22.Default pkg in java? 23.Class?. 24.Object?.25.Recursion 26.Do-while loop sytnax ?.27.for vs while vs do-while 28.Switch?.29.array?.30.difference b/w array and arrays?.31.BinarySearch?32.Bubble Sort?.33.Command line arguments? 34.Selection Sort?.35.2D-Arrays?.36.Strings


### **Rules for Java Identifiers:**

1. **Cannot start with a digit:**
   - Valid: `num1`, `_num`
   - Invalid: `1num`

2. **Only `_` (underscore) and `$` (dollar sign) are allowed as special characters.**
   - Valid: `num_1`, `num$`
   - Invalid: `num@`, `num#`

3. **Cannot use Java keywords as identifiers:**
   - Invalid: `int`, `class`, `public`

4. **Case-sensitive:**
   - `num` and `Num` are different.

5. **No spaces allowed:**
   - Valid: `numOne`, `total_amount`
   - Invalid: `num one`

---

### **Java Comment Types:**

1. **Single-line comment:**
   - `// This is a single-line comment`

2. **Multi-line comment:**
   - `/* This is a multi-line comment */`

---

### **Examples of Valid Identifiers:**
- `num1`, `sumTotal`, `_amount`, `value$`, `MAX_VAL`

### **Examples of Invalid Identifiers:**
- `1value`, `total@amount`, `class`

Certainly! Here's the updated explanation:

### **1. Variable Declaration:**
   - Declaring a variable means specifying its type and giving it a name.
   - **Important:** A variable can only be declared **once** in a given scope.
   - Syntax:  
     ```java
     datatype variableName;
     ```
   - Example:
     ```java
     int num1;  // Declaring an integer variable named 'num1'
     ```

### **2. Variable Initialization:**
   - Initializing a variable means giving it a value.
   - **Important:** You can initialize a variable **multiple times**, as long as it has already been declared.
   - Syntax:  
     ```java
     variableName = value;
     ```
   - Example:
     ```java
     num1 = 30;  // Initializing 'num1' with the value 30
     ```

### **Combining Declaration and Initialization:**
   - You can declare and initialize a variable in one step:
     ```java
     int num1 = 30;  // Declaring 'num1' and initializing it with 30
     ```

### **Reinitializing the Variable:**
   - A variable can be assigned a new value multiple times.
   - Example:
     ```java
     num1 = 40;  // Reinitializing 'num1' with a new value 40
     ```

### **Summary:**
   - **Declaration** can only be done **once**.
   - **Initialization** can be done **multiple times** after declaration.



---

### **Java Primitive Data Types - Complete Notes**

**Primitive Data Types** in Java are the most basic data types that are built into the language. They are **not objects** and represent raw values directly in memory. Java provides **8 primitive data types**.

---

### **Why Do We Have Primitive Data Types?**

1. **Performance Efficiency**:
   - Primitive types are **more memory-efficient** and **faster** to process than objects. They represent raw values directly, with no overhead.
   - Operations on primitive types like addition, subtraction, and comparison are faster.

2. **Memory Management**:
   - They are stored directly in memory (not the heap) and have a fixed and known size, making them memory-efficient.
   - For example, an `int` is always 4 bytes in memory, and a `char` is always 2 bytes.

3. **Simplification**:
   - Primitive types are simpler to use compared to objects. You don’t need to create additional classes or objects for basic data storage.
   
4. **Compatibility**:
   - Primitive types ensure compatibility with low-level system functions or libraries that require these basic types.
   - They provide consistent behavior across different platforms and software.

---

### **The 8 Primitive Data Types in Java**:

| **Data Type** | **Size** | **Range** | **Use Case** | **Example** |
|---------------|----------|-----------|--------------|-------------|
| **byte**      | 1 byte (8 bits) | -128 to 127 | Ideal for saving memory in large arrays or raw binary data | `byte b = 100;` |
| **short**     | 2 bytes (16 bits) | -32,768 to 32,767 | Can be used when memory savings are important, and value isn't too large | `short s = 10000;` |
| **int**       | 4 bytes (32 bits) | -2,147,483,648 to 2,147,483,647 | Most commonly used integer type for general-purpose numeric operations | `int i = 100000;` |
| **long**      | 8 bytes (64 bits) | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 | Used when `int` isn't large enough (e.g., large numbers, file sizes) | `long l = 100000000000L;` |
| **float**     | 4 bytes (32 bits) | 1.4E-45 to 3.4E38 | Used for single-precision floating-point numbers, typically for less precision | `float f = 10.5f;` |
| **double**    | 8 bytes (64 bits) | 4.9E-324 to 1.8E308 | Used for double-precision floating-point numbers, when higher precision is needed | `double d = 100.123456;` |
| **char**      | 2 bytes (16 bits) | 0 to 65,535 (Unicode) | Represents a single 16-bit Unicode character (e.g., letters, digits) | `char c = 'A';` |
| **boolean**   | Not precisely defined but typically 1 bit | `true` or `false` | Used for logical values (conditions or flags) | `boolean isActive = true;` |

---

### **Explanation of Primitive Types**:

1. **byte**:
   - **Size**: 1 byte (8 bits)
   - **Range**: -128 to 127
   - **Use case**: Ideal for saving memory in large arrays or when working with raw binary data, such as reading from files or network streams.

2. **short**:
   - **Size**: 2 bytes (16 bits)
   - **Range**: -32,768 to 32,767
   - **Use case**: Can be used when you need a smaller range than `int` but still want to work with integer values.

3. **int**:
   - **Size**: 4 bytes (32 bits)
   - **Range**: -2,147,483,648 to 2,147,483,647
   - **Use case**: This is the most commonly used integer type in Java, suitable for general-purpose integer arithmetic and counters.

4. **long**:
   - **Size**: 8 bytes (64 bits)
   - **Range**: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
   - **Use case**: Used when you need a larger integer range than `int`. It is helpful for dealing with large numbers, such as file sizes or time measurements in milliseconds.

5. **float**:
   - **Size**: 4 bytes (32 bits)
   - **Range**: 1.4E-45 to 3.4E38
   - **Use case**: Represents **single-precision floating-point numbers**, used when you need fractional numbers but with lower precision.

6. **double**:
   - **Size**: 8 bytes (64 bits)
   - **Range**: 4.9E-324 to 1.8E308
   - **Use case**: Represents **double-precision floating-point numbers**, used when you need higher precision for fractional numbers, such as scientific calculations.

7. **char**:
   - **Size**: 2 bytes (16 bits)
   - **Range**: 0 to 65,535 (Unicode code points)
   - **Use case**: Used for representing **single characters**. For example, it can store letters, digits, or symbols. It uses Unicode to represent characters, so it can handle characters from different languages.

8. **boolean**:
   - **Size**: Not precisely defined in Java (typically 1 bit)
   - **Range**: `true` or `false`
   - **Use case**: Used to represent binary logical values such as `true` or `false`, commonly used in conditional statements.

---

### **How Range is Determined for Integral Types (int, byte, short, long)?**

- The **range** of a data type is determined by its size in memory and whether it's signed or unsigned. 
- **Signed types** use one bit for the sign (positive/negative), and the remaining bits are used to represent the number.
  - Example: For an `int` (32 bits), 1 bit is used for the sign, and 31 bits represent the number, giving the range of `-2,147,483,648 to 2,147,483,647`.

### **Examples**:

1. **int num1 = 16**:
   - Internally, the number **16** is represented as **00000000 00000000 00000000 00010000** in binary (32 bits).

2. **byte b = 127**:
   - Internally, the number **127** is represented as **01111111** in binary (8 bits), which is the maximum value for a byte.
   - If you tried to store **128** in a `byte`, it would overflow because the range is from **-128 to 127**.

---

### **Why is `char` Different?**

- The **char** data type in Java is a **16-bit Unicode** character, meaning it can store characters from different languages, symbols, and emojis. 
- Internally, the value for a `char` is represented using **Unicode code points**, and **65** represents **'A'** because it’s the Unicode code point for the letter **'A'**.

### **Why Unicode?**
- The **Unicode Consortium** standardized the code points for characters, assigning **65** as the code point for **'A'**. This allows for consistent representation of characters across different platforms and languages.

---

### **Boolean - Internally**:

- Although Java uses the `boolean` type to represent **true/false** values, it’s often stored as a **1 bit** (with `true` as 1 and `false` as 0).
- When we print a boolean, Java returns the values as `true` or `false`, but internally it’s represented as either **1 or 0** in binary form.

---

### **How Do Data Types Work Internally in Java?**

1. **Primitive Types**:
   - Primitive types like `int`, `char`, `boolean`, etc., are stored directly in memory.
   - For example, `int` values are stored in **4 bytes** and `char` values in **2 bytes**.

2. **Object Types**:
   - Objects are stored in the **heap**, and the reference to an object (memory address) is stored in a **variable**. So, the variable points to the object, but the object itself resides elsewhere.

---

### **Example Code Snippets**:

```java
public class PrimitiveDataTypes {
    public static void main(String[] args) {
        // Example of byte
        byte b = 100;
        System.out.println("Byte value: " + b);

        // Example of short
        short s = 10000;
        System.out.println("Short value: " + s);

        // Example of int
        int i = 100000;
        System.out.println("Int value: " + i);

        // Example of long
        long l = 100000000000L;
        System.out.println("Long value: " + l);

        // Example of float
        float f = 10.5f;
        System.out.println("Float value: " + f);

        // Example of double
        double d = 100.123456;
        System.out.println("Double value: " + d);

        // Example of char
        char c = 'A';
        System.out.println("Char value: " + c);

        // Example of boolean
        boolean isActive = true;
        System.out.println("Boolean value: " + isActive);
    }
}
```

### **Output**:
```
Byte value: 100
Short value: 10000
Int value: 100000
Long value: 100000000000
Float value: 10.5
Double value: 100.123456
Char value: A
Boolean value: true
```

---

### **Conclusion**:
Primitive data types in Java are fundamental to writing **efficient** and **optimized** code. They allow for **fast processing** of basic data and **efficient memory usage**, which is crucial for performance-sensitive applications. Understanding the size, range, and use cases of each type is essential for writing robust and efficient Java programs.

---
