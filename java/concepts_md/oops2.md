**Topic 1: Classes and Objects**.

### **Classes and Objects**

#### **Class**:
- A **class** is a blueprint or template for creating objects. It defines the **properties** (fields or variables) and **methods** (functions or behaviors) that the objects created from the class will have.
- A class doesn’t hold any data itself, but objects created from it hold the data for the properties and can use the methods.

**Example**:  
```java
class Car {
    // Properties (instance variables)
    String color;
    int speed;

    // Method (behavior)
    void drive() {
        System.out.println("The car is driving.");
    }
}
```

In the example above:
- `Car` is a class.
- `color` and `speed` are properties.
- `drive()` is a method.

#### **Object**:
- An **object** is an instance of a class. When you create an object, it gets its own copy of the properties defined in the class.
- You can also call the methods of the class using the object.

**Example**:  
```java
public class Main {
    public static void main(String[] args) {
        // Creating an object of the class Car
        Car myCar = new Car();
        
        // Assigning values to the object properties
        myCar.color = "Red";
        myCar.speed = 100;
        
        // Calling the object method
        myCar.drive();
    }
}
```

Here:
- `myCar` is an **object** of class `Car`.
- It has the properties `color` and `speed` that hold data for that specific object.
- You can call `myCar.drive()` to use the method defined in the `Car` class.

#### **Key Points**:
- **Class**: A blueprint/template.
- **Object**: An instance of the class, with specific values for properties and able to call methods.
- Each object is independent and can have different values for properties.

---




Let's dive into **Topic 2: Local Variables vs Instance Variables** in detail.

### **2. Local Variables vs Instance Variables**

In object-oriented programming (OOP), variables can be classified into **local variables** and **instance variables**. They differ in terms of their scope, lifetime, and where they are declared. Here's a detailed breakdown:

---

### **1. Local Variables**

#### **Definition**:
- **Local variables** are declared **inside** a method, constructor, or block of code.
- They are only accessible within the block or method in which they are declared.
- They **do not** have default values. You must explicitly initialize them before using them.

#### **Characteristics**:
- **Scope**: The scope is limited to the method or block in which they are declared.
- **Lifetime**: They are created when the method is invoked and destroyed when the method finishes execution.
- **Initialization**: Local variables must be explicitly initialized before use, as they don’t have default values.
- **Memory**: Memory for local variables is allocated when the method is called and released when the method finishes.

#### **Example**:
```java
class Example {
    void myMethod() {
        int x = 10; // Local variable
        System.out.println(x);
    }
}
```
In this example:
- `x` is a **local variable** because it's declared inside the `myMethod()` method.
- You can only access `x` within `myMethod()`.

---

### **2. Instance Variables**

#### **Definition**:
- **Instance variables** are declared **inside a class**, but **outside any method, constructor, or block**.
- They are associated with **objects** of the class, meaning each object of the class has its own copy of these variables.
- They are **initialized automatically** with default values if not explicitly initialized.

#### **Characteristics**:
- **Scope**: Instance variables can be accessed by any method, constructor, or block within the class.
- **Lifetime**: They exist as long as the object that owns them exists. Once the object is destroyed (garbage collected), the instance variables are also destroyed.
- **Initialization**: Instance variables are automatically initialized to default values when an object is created if no explicit initialization is done (e.g., 0 for `int`, `null` for objects).
- **Memory**: Memory for instance variables is allocated when an object is created and released when the object is garbage collected.

#### **Example**:
```java
class Car {
    String color;  // Instance variable
    int speed;     // Instance variable
    
    void display() {
        System.out.println("Color: " + color);
        System.out.println("Speed: " + speed);
    }
}
```

In this example:
- `color` and `speed` are **instance variables** because they are declared within the class, outside any method.
- Every object of class `Car` will have its own values for `color` and `speed`.

---

### **Key Differences between Local Variables and Instance Variables**:

| Feature                     | Local Variables                         | Instance Variables                       |
|-----------------------------|-----------------------------------------|-----------------------------------------|
| **Declaration**              | Inside a method, constructor, or block | Inside a class, outside methods         |
| **Scope**                    | Limited to the method/block where declared | Available to all methods of the class   |
| **Lifetime**                 | Created when the method is called and destroyed when the method finishes | Exist as long as the object exists      |
| **Initialization**           | Must be initialized explicitly before use | Initialized to default values (0, null) if not initialized |
| **Default Value**            | No default value                       | Has default values (e.g., `0`, `null`)   |
| **Access Modifiers**         | Cannot have access modifiers (public, private) | Can have access modifiers (public, private, etc.) |
| **Memory Allocation**        | Memory allocated when method is called, released when method finishes | Memory allocated when object is created, released when object is destroyed |

---

### **Example Showing Both Local and Instance Variables**:

```java
class Person {
    String name;  // Instance variable
    int age;      // Instance variable

    // Constructor to initialize instance variables
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        String info = "Name: " + name + ", Age: " + age;  // Local variable
        System.out.println(info);  // Printing the local variable
    }

    void changeAge(int newAge) {
        // Local variable 'newAge' is used to update instance variable 'age'
        this.age = newAge; // 'age' is an instance variable, 'newAge' is a local variable
    }
}

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 25);  // Creating an object
        person1.display();  // Accessing instance variables through the object
        
        person1.changeAge(30); // Modifying the instance variable 'age'
        person1.display();
    }
}
```

In this example:
- **Instance variables**: `name` and `age` are instance variables because they belong to the `Person` class, and each `Person` object will have its own copy of them.
- **Local variable**: `info` is a local variable inside the `display()` method. It is created and used only within that method.

---

### **Summary**:
- **Local variables** are temporary, limited in scope, and only exist within a method. They must be initialized explicitly.
- **Instance variables** are associated with objects, exist as long as the object exists, and are initialized with default values if not explicitly initialized.

---

