
### Types of Exceptions

1. **Checked Exceptions**:
   - These are exceptions that are checked at compile-time. The compiler forces you to handle these exceptions using `try-catch` or `throws`.
   - Example: `IOException`, `SQLException`, `FileNotFoundException`.

2. **Unchecked Exceptions**:
   - These are exceptions that are not checked at compile-time, and the compiler does not force you to handle them.
   - Example: `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException`, `IllegalArgumentException`.

3. **Errors**:
   - Errors are not typically caught by the program. These are severe conditions that usually cannot be handled, such as running out of memory or a stack overflow.
   - Example: `OutOfMemoryError`, `StackOverflowError`.

### Key Classes for Exceptions

- **`Throwable`**: The superclass of all errors and exceptions in Java. It has two main subclasses:
  - **`Error`**: Represents serious issues that applications should not catch.
  - **`Exception`**: Represents exceptional conditions that programs may want to catch.
  
- **`Exception`** has two main subclasses:
  - **`IOException`** (Checked)
  - **`RuntimeException`** (Unchecked)

### Handling Exceptions

In Java, exceptions are handled using a `try-catch` block, where you try to execute some code, and if an exception occurs, it is caught in the `catch` block.

#### Basic Syntax:

```java
try {
    // Code that might throw an exception
} catch (ExceptionType e) {
    // Code to handle the exception
}
```

#### Example:

```java
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;  // This will cause an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}
```

### Multiple Catch Blocks

You can catch multiple exceptions by having multiple `catch` blocks.

```java
try {
    // Code that may throw exceptions
} catch (IOException e) {
    // Handle IOException
} catch (SQLException e) {
    // Handle SQLException
} catch (Exception e) {
    // Catch any other exceptions
}
```

### `finally` Block

The `finally` block is optional but is always executed after the `try` and `catch` blocks, whether an exception was thrown or not. It is typically used to release resources, like closing files or database connections.

```java
try {
    // Code that might throw an exception
} catch (Exception e) {
    // Handle exception
} finally {
    // Code that will run regardless of exception
    System.out.println("This will always run.");
}
```

### Throwing Exceptions

You can explicitly throw exceptions in your code using the `throw` keyword:

```java
public void checkAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Age must be 18 or older.");
    }
}
```

### Declaring Exceptions (`throws`)

If a method is capable of throwing a checked exception, it must declare that in its signature using the `throws` keyword:

```java
public void readFile(String fileName) throws IOException {
    // Code that may throw an IOException
}
```

### Custom Exceptions

You can create your own exceptions by extending the `Exception` class or `RuntimeException` class (for unchecked exceptions).

```java
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class Test {
    public static void main(String[] args) {
        try {
            throw new MyException("This is a custom exception");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

---

### Summary

- **Checked exceptions** need to be either caught or declared using `throws`.
- **Unchecked exceptions** do not need to be declared or caught explicitly.
- **`try-catch`** blocks are used to handle exceptions, and **`finally`** is for cleanup.
- You can **throw** exceptions explicitly using the `throw` keyword.
- Custom exceptions can be created by extending `Exception` or `RuntimeException`.
