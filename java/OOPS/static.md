

---

### **Static Variables:**

1. **Definition**: A static variable belongs to the **class** itself, not to individual instances of the class. It is shared among all instances of the class.
2. **Memory Location**: Static variables are stored in the **method area** (part of the JVM memory), not in the heap, where instance variables are stored.
3. **Initialization**: Static variables are initialized only once when the class is loaded into memory. They retain their value as long as the class is loaded.
4. **Access**: You can access a static variable using the class name directly, or via an object, but it is generally accessed via the class name to emphasize its static nature.

### **Static Methods:**

1. **Definition**: A static method belongs to the **class** and can be called without creating an instance of the class.
2. **Access**: Static methods can access only static variables and other static methods directly. They cannot access instance variables or methods unless through an object reference.
3. **No Overriding**: Static methods cannot be overridden (since they belong to the class). They can only be **hidden** in a subclass by defining a method with the same signature.

### **Key Points:**

- **Static variables** store values that are shared across all instances of a class.
- If a static variable is modified, its value is updated for all objects of that class because it's common to all of them.
- **Static methods** can be invoked directly using the class name.
- Static methods **cannot access instance variables** directly.

---

### **Complete Example with Explanation:**

```java
class MyClass {
    // Static variable, shared by all instances of the class
    static int x = 10;

    // Static method, can be called without an object
    public static void display() {
        System.out.println("Static method called");
        System.out.println("Static variable x: " + x);
    }

    // Instance method, can access both static and instance variables
    public void instanceMethod() {
        System.out.println("Instance method called");
        System.out.println("Static variable x: " + x);
    }

    public static void main(String[] args) {
        // Accessing static variable directly through class name
        System.out.println("Static variable x before modification: " + MyClass.x); // Output: 10

        // Modifying the static variable
        MyClass.x = 20;

        // Calling the static method
        MyClass.display();  // Output: Static method called \n Static variable x: 20

        // Creating an object of MyClass
        MyClass obj1 = new MyClass();
        obj1.instanceMethod();  // Output: Instance method called \n Static variable x: 20

        // Creating another object of MyClass
        MyClass obj2 = new MyClass();
        obj2.instanceMethod();  // Output: Instance method called \n Static variable x: 20

        // The static variable 'x' is shared across all instances of MyClass
        System.out.println("Static variable x accessed via obj1: " + obj1.x); // Output: 20
        System.out.println("Static variable x accessed via obj2: " + obj2.x); // Output: 20
    }
}
```

### **Explanation:**

1. **Static Variable `x`:**
   - `static int x = 10;` initializes the static variable `x` to `10` when the class is loaded.
   - When we change `x` to `20` using `MyClass.x = 20;`, the updated value is shared by all instances of `MyClass`.
   - Even when you create objects like `obj1` and `obj2`, they both share the same static variable `x`, so they all reflect the same value (`20`).

2. **Static Method `display()`:**
   - The static method can be called without creating an instance of the class using `MyClass.display();`.
   - The static method accesses the static variable `x` and prints its value.

3. **Instance Method `instanceMethod()`:**
   - The instance method accesses the static variable `x` and prints its value. Static variables can be accessed by instance methods since they belong to the class.

4. **Object Creation and Access:**
   - The static variable `x` is shared across all objects, so both `obj1` and `obj2` print the updated value `20` for `x`.

### **Output of the Program:**
```
Static variable x before modification: 10
Static method called
Static variable x: 20
Instance method called
Static variable x: 20
Instance method called
Static variable x: 20
Static variable x accessed via obj1: 20
Static variable x accessed via obj2: 20
```

---

### **Summary:**

- **Static variables** hold the same value across all instances of the class and are shared by them.
- **Static methods** can be accessed using the class name without creating an instance, and they can only interact with static variables and methods.
- **Instance methods** can access both static and instance variables, and they can be called through objects.
- **Memory Management**: Static variables are allocated once in the **method area** and persist as long as the class is loaded into memory, while instance variables are allocated for each object on the heap.
