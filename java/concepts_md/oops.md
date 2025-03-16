Topics:
 1.classes and objects 2.local variables vs instance varibles 3.polymorphism(compile time,run time) 4a..constructor over loading 4b.method overlaoding 5.this keyword 6 .method vs constructor 7.inheritance(single,multilevvel,heiarachical,hybrid,multiple)  8.method signature 9.run time polymorphism(method over riding) 10.this vs super 11.upcasting 12.final keyword 13.method hiding 14.covariant return types 15.final vs static 16.access modifers(private,default,protected,public) 17.Abstarction 18.multiple inheritance using interface 19.abtstarct calss vs interface 20.functional interface 21.lambda experssions 22.encapsulation 23.is a vs has a vs user a relationship

---

### **Index of Topics**

1. **Classes and Objects**
   - Introduction to Classes and Objects
   - How to Define a Class
   - Creating and Using Objects
   - Constructor in Classes

2. **Local Variables vs Instance Variables**
   - Definition of Local Variables
   - Definition of Instance Variables
   - Differences between Local and Instance Variables
   - Use Cases for Each

3. **Polymorphism**
   - Compile-Time Polymorphism (Method Overloading)
   - Run-Time Polymorphism (Method Overriding)
   - Differences between Compile-Time and Run-Time Polymorphism

4. **Constructor Overloading**
   - Concept of Constructor Overloading
   - How Constructor Overloading Works
   - Example of Constructor Overloading

5. **Method Overloading**
   - Definition of Method Overloading
   - How to Overload Methods
   - Examples of Method Overloading

6. **This Keyword**
   - What is `this` Keyword?
   - Use of `this` in Constructor
   - Use of `this` in Methods
   - Example of `this` Keyword

7. **Method vs Constructor**
   - What is a Method?
   - What is a Constructor?
   - Key Differences between Methods and Constructors

8. **Inheritance**
   - Single Inheritance
   - Multilevel Inheritance
   - Hierarchical Inheritance
   - Hybrid Inheritance
   - Multiple Inheritance (Using Interfaces)

9. **Method Signature**
   - Definition of Method Signature
   - Components of a Method Signature
   - Importance of Method Signature in Java

10. **Run-Time Polymorphism (Method Overriding)**
    - What is Method Overriding?
    - How Method Overriding Works
    - Example of Method Overriding
    - Benefits of Run-Time Polymorphism

11. **This vs Super**
    - `this` Keyword
    - `super` Keyword
    - Differences between `this` and `super`
    - Examples of Using `this` and `super`

12. **Upcasting**
    - What is Upcasting?
    - When to Use Upcasting
    - Example of Upcasting
    - Benefits of Upcasting

13. **Final Keyword**
    - The `final` Keyword for Variables, Methods, and Classes
    - Final Variables
    - Final Methods
    - Final Classes

14. **Method Hiding vs Method Overriding**
    - Method Hiding
    - Method Overriding
    - Key Differences between Method Hiding and Overriding
    - Examples

15. **Covariant Return Types**
    - What is Covariant Return Type?
    - How Covariant Return Type Works
    - Example of Covariant Return Type

16. **Method Hiding**
    - What is Method Hiding?
    - Key Differences between Method Overloading and Hiding
    - Example of Method Hiding

17. **Final vs Static**
    - What is the `final` Keyword?
    - What is the `static` Keyword?
    - Key Differences between Final and Static
    - Use Cases for Final and Static

18. **Access Modifiers (Private, Default, Protected, Public)**
    - Private Modifier
    - Default Modifier
    - Protected Modifier
    - Public Modifier
    - Key Differences between Modifiers

19. **Abstraction**
    - What is Abstraction?
    - Abstract Classes
    - Interfaces
    - Differences between Abstract Classes and Interfaces
    - Examples of Abstraction

20. **Multiple Inheritance using Interface**
    - What is Multiple Inheritance?
    - How Interfaces Enable Multiple Inheritance
    - Example of Multiple Inheritance using Interfaces

21. **Abstract Class vs Interface**
    - Key Differences between Abstract Classes and Interfaces
    - Use Cases for Abstract Classes and Interfaces
    - Example of Abstract Class and Interface

22. **Functional Interface**
    - What is a Functional Interface?
    - Characteristics of a Functional Interface
    - Examples of Functional Interfaces

23. **Lambda Expressions**
    - What are Lambda Expressions?
    - Syntax of Lambda Expressions
    - Benefits of Lambda Expressions
    - Examples of Lambda Expressions

24. **Encapsulation**
    - What is Encapsulation?
    - Benefits of Encapsulation
    - Setter and Getter Methods
    - Access Modifiers and Encapsulation
    - Example of Encapsulation

25. **Is-a vs Has-a vs Uses-a Relationship**
    - Is-a Relationship (Inheritance)
    - Has-a Relationship (Composition)
    - Uses-a Relationship (Dependency)
    - Comparison between Is-a, Has-a, and Uses-a
    - When to Use Each Relationship

---

**Topic 1: Classes and Objects**.

### **Classes and Objects**

#### **Class**:
- A **class** is a blueprint or template for creating objects. 
- A class can contain data members(variables),methods(functions or behaviors),constructors and blocks.
- When we create a class memory will not be allocated until we create an object for class.(proved it class1.java inside java/OOPS)
- Object class is parent class for all the classes in java.
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
- An **object** is an instance/copy of a class. When you create an object, it gets its own copy of the properties defined in the class.
- You can also call the methods of the class using the object.
- We can create an object using new keyword.
- When we can create an object then only memory will be allocated in heap memory

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




**Topic 2: Local Variables vs Instance Variables** in detail.

### **2. Local Variables vs Instance Variables**

In object-oriented programming (OOP), variables can be classified into **local variables** and **instance variables**. They differ in terms of their scope, lifetime, and where they are declared. Here's a detailed breakdown:

---

### **1. Local Variables**

#### **Definition**:
- **Local variables** are declared **inside** a method, constructor, or block of code.
- They are only accessible within the block or method in which they are declared.
- They **do not** have default values. You must explicitly initialize them before using them.
- Local variables are implemented at stack level internally.
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

**Topic 3: Polymorphism (Compile-time and Run-time)**.

### **3. Polymorphism (Compile-time and Run-time)**

#### **Definition**:
Polymorphism is a fundamental concept in Object-Oriented Programming (OOP) where an object can take on multiple forms. The two main types of polymorphism are **Compile-time Polymorphism** (also known as **Method Overloading**) and **Run-time Polymorphism** (also known as **Method Overriding**).

---

### **1. Compile-time Polymorphism (Method Overloading)**

#### **Definition**:
- **Compile-time polymorphism** occurs when you have multiple methods with the **same name** but with **different parameters** (either in number, type, or both).
- The **method to be called** is determined at **compile-time**, based on the method signature.
  
#### **Characteristics**:
- **Same Method Name**: Methods must have the same name but differ in the number or type of parameters.
- **Decided at Compile-time**: The compiler decides which method to call based on the method signature (number/type of arguments).
- **Overloading** happens within the same class.

#### **Example**:
```java
class Calculator {
    // Method to add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two doubles
    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        System.out.println(calc.add(2, 3)); // Calls add(int, int)
        System.out.println(calc.add(2, 3, 4)); // Calls add(int, int, int)
        System.out.println(calc.add(2.5, 3.5)); // Calls add(double, double)
    }
}
```

In this example:
- The method `add()` is **overloaded**: it can take either two integers, three integers, or two doubles.
- The **compiler** decides which `add()` method to call based on the argument types.

#### **Key Point**:  
Compile-time polymorphism (method overloading) is **resolved at compile time** by the compiler.

---

### **2. Run-time Polymorphism (Method Overriding)**

#### **Definition**:
- **Run-time polymorphism** occurs when a subclass provides a specific implementation of a method that is already defined in its superclass.
- The **method to be called** is determined at **run-time**, based on the actual object type (not the reference type).

#### **Characteristics**:
- **Same Method Name and Signature**: The method in the subclass must have the same signature as the method in the superclass.
- **Decided at Run-time**: The method to call is determined at run-time based on the **actual object type** (i.e., the object that the reference variable is pointing to).
- **Overriding** happens in a subclass to modify the behavior of a method inherited from a superclass.

#### **Example**:
```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {
    // Method overriding
    @Override
    void sound() {
        System.out.println("Dog barks.");
    }
}

class Cat extends Animal {
    // Method overriding
    @Override
    void sound() {
        System.out.println("Cat meows.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();  // Reference type is Animal, object type is Dog
        Animal myCat = new Cat();  // Reference type is Animal, object type is Cat
        
        myAnimal.sound();  // Outputs: Animal makes a sound.
        myDog.sound();     // Outputs: Dog barks.
        myCat.sound();     // Outputs: Cat meows.
    }
}
```

In this example:
- The **sound()** method is defined in the `Animal` class and overridden in the `Dog` and `Cat` subclasses.
- **Run-time polymorphism** occurs when the program decides which `sound()` method to call based on the **actual object type** (not the reference type).
  - Even though the reference variable is of type `Animal`, the method that gets called depends on the **actual object type** (whether it's a `Dog` or `Cat`).

#### **Key Point**:  
Run-time polymorphism (method overriding) is **resolved at runtime** by the Java Virtual Machine (JVM), based on the actual object type.

---

### **Summary of Compile-time vs Run-time Polymorphism**:

| Feature                        | Compile-time Polymorphism (Method Overloading)  | Run-time Polymorphism (Method Overriding) |
|---------------------------------|-------------------------------------------------|-------------------------------------------|
| **Method Name**                 | Same method name but different parameters       | Same method name and same parameters      |
| **Method Resolution**           | Resolved at **compile-time**                    | Resolved at **runtime**                   |
| **Type of Polymorphism**        | Method Overloading                              | Method Overriding                        |
| **Purpose**                     | To perform different actions based on parameters | To provide specific behavior for subclasses |
| **Example**                     | Same method name with different parameters      | Same method signature in superclass and subclass |

---

### **Key Takeaways**:
- **Compile-time polymorphism** (method overloading) happens when the method signature differs, and the compiler decides which method to call based on the arguments.
- **Run-time polymorphism** (method overriding) happens when a subclass provides a specific implementation for a method already defined in the parent class, and the JVM decides which method to call based on the actual object type at runtime.

---

**Topic 4: Constructor Overloading and Method Overloading**.

### **4a. Constructor Overloading**

#### **Definition**:
- **Constructor overloading** is a concept where a class can have more than one constructor, each with a **different parameter list**. This allows objects to be initialized in different ways.

#### **Characteristics**:
- **Multiple Constructors**: A class can have more than one constructor, but each constructor must have a **different parameter signature** (i.e., the number or type of parameters must vary).
- **Used for Different Initializations**: It provides flexibility to initialize an object with different sets of values at the time of object creation.
- **Decided at Compile-time**: The correct constructor to call is determined by the number and type of arguments passed when creating an object.

#### **Example**:
```java
class Car {
    String color;
    int speed;

    // Default constructor
    Car() {
        this.color = "Unknown";
        this.speed = 0;
        System.out.println("Default constructor called");
    }

    // Constructor with one parameter
    Car(String color) {
        this.color = color;
        this.speed = 0;
        System.out.println("Constructor with color called");
    }

    // Constructor with two parameters
    Car(String color, int speed) {
        this.color = color;
        this.speed = speed;
        System.out.println("Constructor with color and speed called");
    }

    void display() {
        System.out.println("Car color: " + color + ", Speed: " + speed);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();  // Calls default constructor
        car1.display();

        Car car2 = new Car("Red");  // Calls constructor with one parameter
        car2.display();

        Car car3 = new Car("Blue", 100);  // Calls constructor with two parameters
        car3.display();
    }
}
```

In this example:
- There are **three constructors** in the `Car` class, each with a different set of parameters. The **appropriate constructor** is selected based on the arguments passed when creating the object.
- This demonstrates **constructor overloading**.

#### **Key Points**:
- Constructor overloading is similar to **method overloading**, but it’s used for **object initialization** rather than for methods.
- Constructors are not inherited, so overloading happens within the class itself.

---

### **4b. Method Overloading**

#### **Definition**:
- **Method overloading** occurs when a class has multiple methods with the **same name** but **different parameter lists** (either in number, type, or both).
- Method overloading is resolved at **compile time**.

#### **Characteristics**:
- **Same Method Name**: Multiple methods can have the same name but must differ in their **parameter types, number, or both**.
- **Decided at Compile-time**: The compiler selects the method to call based on the **number and type of arguments** passed.
- **No Return Type Requirement**: Overloading is based on method signatures (name and parameter list), not the return type. The return type alone cannot differentiate overloaded methods.

#### **Example**:
```java
class Printer {
    // Method to print an integer
    void print(int x) {
        System.out.println("Printing integer: " + x);
    }

    // Method to print a string
    void print(String s) {
        System.out.println("Printing string: " + s);
    }

    // Overloaded method to print two integers
    void print(int x, int y) {
        System.out.println("Printing two integers: " + x + " and " + y);
    }
}

public class Main {
    public static void main(String[] args) {
        Printer p = new Printer();
        p.print(100);  // Calls print(int)
        p.print("Hello");  // Calls print(String)
        p.print(10, 20);  // Calls print(int, int)
    }
}
```

In this example:
- The `Printer` class has multiple methods named `print`, but each one has a **different parameter list**.
- The **appropriate method** is called based on the type and number of arguments passed at compile time.

#### **Key Points**:
- Method overloading is resolved **at compile time** by the **compiler**, based on the method signature (name, number, and type of parameters).
- Overloading is helpful when you want to use the same method name for similar operations that differ in the number or type of arguments.

---

### **Summary of Constructor Overloading vs Method Overloading**

| Feature                  | Constructor Overloading                                   | Method Overloading                                          |
|--------------------------|------------------------------------------------------------|-------------------------------------------------------------|
| **Definition**            | Multiple constructors with different parameter lists.      | Multiple methods with the same name but different parameters.|
| **Purpose**               | To initialize objects in different ways.                   | To perform similar operations on different types or numbers of inputs.|
| **Called**                | Invoked during object creation (when a new object is created). | Invoked on objects of a class after the object is created.   |
| **Return Type**           | Constructors do not have a return type.                    | Methods can have a return type (e.g., `void`, `int`, `String`, etc.).|
| **Usage**                 | Used for initializing class fields with different sets of arguments. | Used to perform an action with different sets of parameters. |
| **Inheritance**           | Constructors are **not** inherited.                       | Methods can be inherited and overridden.                   |
| **Examples**              | Different constructors for creating objects with different initial values. | Different methods for performing the same action on different data types or numbers of arguments. |

---

### **Conclusion**
- **Constructor Overloading** allows creating objects in multiple ways with different initialization values.
- **Method Overloading** allows calling a method with different types or numbers of parameters, enabling more flexible behavior.

Both are powerful concepts that help you write cleaner, more readable, and reusable code. However, it’s important to use them appropriately based on whether you are initializing an object (constructor overloading) or performing an operation on various inputs (method overloading).

---

### **Key Differences**:
- **Constructor Overloading** is about initializing objects in different ways with varying parameters.
- **Method Overloading** is about providing different versions of a method with the same name but different parameters, all within the same class.

---
### Topic 5: The `this` Keyword

#### 5.1. **Definition:**

The `this` keyword in Java refers to the current object. It is used within an instance method or constructor to refer to the object that the method or constructor is operating on.

---

#### 5.2. **Characteristics:**

1. **Refers to the Current Object**:
   - The `this` keyword is a reference to the current instance of the class. It is used to access the class's fields, methods, and constructors within an instance method or constructor.
   
2. **Used to Avoid Ambiguity**:
   - When the parameter name is the same as the instance variable name, `this` helps differentiate between the local variable (parameter) and the instance variable.
   
3. **Constructor Call**:
   - The `this()` syntax can be used to invoke another constructor in the same class. This is known as **constructor chaining**.

---

#### 5.3. **Examples:**

1. **Accessing Instance Variables:**

```java
class Car {
    String color;

    // Constructor
    Car(String color) {
        this.color = color;  // 'this.color' refers to the instance variable, 'color' refers to the parameter
    }

    void display() {
        System.out.println("Car color: " + this.color);
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Red");
        myCar.display();
    }
}
```

**Explanation**:
- In this example, `this.color` refers to the instance variable of the `Car` class, while `color` is the parameter of the constructor. Using `this` resolves any ambiguity when both the parameter and instance variable have the same name.

---

2. **Invoking Another Constructor:**

```java
class Car {
    String color;
    int speed;

    // Constructor with one parameter
    Car(String color) {
        this(color, 0);  // Calling another constructor using 'this'
    }

    // Constructor with two parameters
    Car(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

    void display() {
        System.out.println("Car color: " + color + ", Speed: " + speed);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Blue");
        car.display();
    }
}
```

**Explanation**:
- The constructor `Car(String color)` calls the `Car(String color, int speed)` constructor using `this(color, 0)` to provide default values. This demonstrates **constructor chaining**.

---

#### 5.4. **Key Points:**

- **`this` for Instance Variables**: Use `this` when you need to distinguish between instance variables and method/constructor parameters with the same name.
- **`this` for Calling Constructors**: Use `this()` to invoke another constructor in the same class for **constructor chaining**.

---

#### 5.5. **Summary of `this` Keyword Usage:**

1. **Refers to the Current Object**:
   - Inside methods or constructors, `this` refers to the current object instance.
   
2. **Avoids Ambiguity**:
   - When instance variables and parameters have the same name, `this` is used to refer to instance variables, clarifying which is being accessed.

3. **Constructor Chaining**:
   - `this()` can be used to call another constructor in the same class, reducing code duplication and improving maintainability.

---

### **Where `this` Can Be Used:**

1. **Inside Instance Methods**:
   - `this` can be used to refer to the current object within instance methods.
   ```java
   class Car {
       String color;
       void display() {
           System.out.println(this.color);  // Refers to the current object's color
       }
   }
   ```

2. **Inside Constructors**:
   - `this` can be used in constructors to refer to the current object or to call another constructor within the same class.
   ```java
   class Car {
       String color;
       Car(String color) {
           this.color = color;  // Refers to the current object's color
       }
   }
   ```

3. **To Avoid Ambiguity**:
   - When an instance variable and a parameter have the same name, `this` is used to refer to the instance variable.
   ```java
   class Car {
       String color;
       Car(String color) {
           this.color = color;  // Resolves ambiguity between the instance variable and the parameter
       }
   }
   ```

4. **Constructor Chaining**:
   - `this()` is used to call another constructor from the same class.
   ```java
   class Car {
       String color;
       int speed;
       Car(String color) {
           this(color, 0);  // Calls another constructor
       }
       Car(String color, int speed) {
           this.color = color;
           this.speed = speed;
       }
   }
   ```

---

### **Where `this` Cannot Be Used:**

1. **Inside Static Methods**:
   - `this` cannot be used in static methods, as static methods do not belong to a particular instance of the class.
   ```java
   class Car {
       static void staticMethod() {
           // this.color = "Red";  // ERROR: Cannot use 'this' in a static context
       }
   }
   ```

2. **Inside Static Blocks**:
   - `this` cannot be used in static blocks because static blocks are executed without an instance of the class.
   ```java
   class Car {
       static {
           // this.color = "Red";  // ERROR: Cannot use 'this' in static block
       }
   }
   ```

3. **In Lambda Expressions**:
   - `this` can only refer to the instance of the enclosing class in lambda expressions. Conflicts can arise if there's ambiguity between local variables and instance variables.
   ```java
   class Car {
       String color;
       void display() {
           Runnable r = () -> {
               System.out.println(this.color);  // Refers to the enclosing class's 'color'
           };
           r.run();
       }
   }
   ```

4. **In Local Inner Classes**:
   - In local inner classes (classes defined inside methods), `this` refers to the inner class instance, not the outer class. To refer to the outer class, you must use `OuterClassName.this`.
   ```java
   class Outer {
       String message = "Outer class message";
       void createInnerClass() {
           class Inner {
               void show() {
                   System.out.println(this.message);  // Refers to inner class, not outer class
               }
           }
           Inner inner = new Inner();
           inner.show();
       }
   }
   ```

---

### **Summary:**

- **Where `this` can be used**: In instance methods, constructors, for avoiding ambiguity between instance variables and parameters, and for constructor chaining.
- **Where `this` cannot be used**: In static methods, static blocks, lambda expressions, and local inner classes.

The `this` keyword helps maintain clarity in your code and allows you to access or modify instance variables, call other constructors, and avoid naming conflicts. However, it should be used appropriately based on the context to avoid errors.

---



**Topic 6: Method vs Constructor**.


### **6. Method vs Constructor**

Both **methods** and **constructors** are fundamental components of a class in Java, but they serve different purposes and have distinct characteristics. Let's break them down:

#### **1. Constructor**

A **constructor** is a special type of method used to initialize an object when it is created.

#### **Characteristics of Constructors**:
- **Initialization**: The primary role of a constructor is to **initialize** an object (i.e., set the initial state of an object).
- **Name**: A constructor must have the **same name** as the class.
- **No Return Type**: Constructors do not have a return type, not even `void`.
- **Automatically Called**: Constructors are automatically invoked when an object of the class is created.
- **Overloading**: Constructors can be overloaded, meaning you can have multiple constructors with different parameters in the same class.

#### **Example**:
```java
class Car {
    String color;
    int speed;

    // Constructor to initialize the object
    Car(String color, int speed) {
        this.color = color;
        this.speed = speed;
        System.out.println("Constructor called!");
    }

    void display() {
        System.out.println("Car color: " + color + ", Speed: " + speed);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an object, which calls the constructor
        Car myCar = new Car("Red", 100); 
        myCar.display(); // Outputs: Car color: Red, Speed: 100
    }
}
```

In this example:
- `Car()` is the **constructor** of the `Car` class. It initializes the `color` and `speed` instance variables when a new `Car` object is created.

---

#### **2. Method**

A **method** is a block of code that performs a specific task. It can be called on objects (or the class itself, for static methods).

#### **Characteristics of Methods**:
- **Functionality**: The purpose of a method is to perform a specific **action** or **functionality**.
- **Name**: A method can have any name, as long as it doesn't conflict with reserved keywords or other method names in the class.
- **Return Type**: Methods can return a value (e.g., `int`, `String`, `void`), depending on their return type. If a method does not return a value, it uses `void` as the return type.
- **Can be Called Multiple Times**: A method can be invoked multiple times on the same object or on different objects.
- **Overloading**: Methods can be overloaded (having the same name with different parameter types or counts).

#### **Example**:
```java
class Calculator {
    // Method to add two numbers
    int add(int a, int b) {
        return a + b;
    }

    // Method to multiply two numbers
    int multiply(int a, int b) {
        return a * b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        // Calling methods
        System.out.println(calc.add(5, 10)); // Outputs: 15
        System.out.println(calc.multiply(2, 3)); // Outputs: 6
    }
}
```

In this example:
- `add()` and `multiply()` are **methods** that perform actions on the provided arguments (i.e., adding and multiplying the numbers).
- Methods can be called multiple times with different arguments.

---

### **Key Differences between Methods and Constructors**:

| Feature                    | Constructor                                  | Method                               |
|----------------------------|----------------------------------------------|--------------------------------------|
| **Purpose**                 | To initialize the object when it is created  | To perform specific actions or return values |
| **Name**                    | Must have the same name as the class         | Can have any valid name             |
| **Return Type**             | No return type (not even `void`)             | Can have a return type (e.g., `int`, `String`, `void`) |
| **Invoked**                 | Automatically called when an object is created | Called explicitly by the user code or other methods |
| **Overloading**             | Can be overloaded (with different parameters) | Can be overloaded (with different parameters) |
| **Invocation**              | Automatically called during object creation  | Explicitly called on the object     |

#### **Summary**:
- **Constructors** are special methods used for object initialization, automatically invoked when an object is created. They do not return any value.
- **Methods** perform operations or actions on the object and can return values. They are explicitly invoked by the user.

---

**Topic 7: Inheritance**.

### **7. Inheritance (Single, Multilevel, Hierarchical, Hybrid, Multiple)**

#### **Definition**:
- **Inheritance** is a mechanism in object-oriented programming (OOP) where one class (subclass or derived class) inherits the properties and behaviors (methods) of another class (superclass or base class).
- This allows for **code reuse** and **extension** of existing code.

---

#### **Types of Inheritance**:

1. **Single Inheritance**:
   - **Single inheritance** occurs when a class inherits from only **one** superclass.
   - This is the most common form of inheritance.

   **Example**:
   ```java
   class Animal {
       void eat() {
           System.out.println("Eating...");
       }
   }

   class Dog extends Animal {
       void bark() {
           System.out.println("Barking...");
       }
   }

   public class Main {
       public static void main(String[] args) {
           Dog d = new Dog();
           d.eat();  // Inherited method from Animal
           d.bark(); // Method of Dog
       }
   }
   ```

   In this example:
   - `Dog` is a subclass that inherits from the `Animal` superclass. It inherits the `eat()` method.

---

2. **Multilevel Inheritance**:
   - **Multilevel inheritance** occurs when a class is derived from another class, which is also derived from another class.
   - This creates a chain of inheritance.

   **Example**:
   ```java
   class Animal {
       void eat() {
           System.out.println("Eating...");
       }
   }

   class Mammal extends Animal {
       void walk() {
           System.out.println("Walking...");
       }
   }

   class Dog extends Mammal {
       void bark() {
           System.out.println("Barking...");
       }
   }

   public class Main {
       public static void main(String[] args) {
           Dog d = new Dog();
           d.eat();  // Inherited from Animal
           d.walk(); // Inherited from Mammal
           d.bark(); // Defined in Dog
       }
   }
   ```

   In this example:
   - `Dog` inherits from `Mammal`, and `Mammal` inherits from `Animal`. This is multilevel inheritance.

---

3. **Hierarchical Inheritance**:
   - **Hierarchical inheritance** occurs when multiple subclasses inherit from a single superclass.
   - In this type, one parent class serves as the base for multiple child classes.

   **Example**:
   ```java
   class Animal {
       void eat() {
           System.out.println("Eating...");
       }
   }

   class Dog extends Animal {
       void bark() {
           System.out.println("Barking...");
       }
   }

   class Cat extends Animal {
       void meow() {
           System.out.println("Meowing...");
       }
   }

   public class Main {
       public static void main(String[] args) {
           Dog d = new Dog();
           d.eat();
           d.bark();

           Cat c = new Cat();
           c.eat();
           c.meow();
       }
   }
   ```

   In this example:
   - Both `Dog` and `Cat` inherit from `Animal`, demonstrating **hierarchical inheritance**.

---

4. **Hybrid Inheritance**:
   - **Hybrid inheritance** is a combination of two or more types of inheritance (e.g., single, multilevel, and hierarchical).
   - However, Java does not support **multiple inheritance** (a class inheriting from more than one class) due to potential ambiguity.

   **Example** (using interfaces for hybrid behavior):
   ```java
   interface Animal {
       void eat();
   }

   class Mammal implements Animal {
       public void eat() {
           System.out.println("Mammal eating...");
       }
   }

   class Dog extends Mammal {
       void bark() {
           System.out.println("Barking...");
       }
   }

   public class Main {
       public static void main(String[] args) {
           Dog d = new Dog();
           d.eat();  // Inherited from Mammal
           d.bark(); // Defined in Dog
       }
   }
   ```

   In this example:
   - `Dog` inherits from `Mammal`, and `Mammal` implements the `Animal` interface. This is **hybrid inheritance** (using interfaces).

---

5. **Multiple Inheritance** (Not supported directly in Java):
   - **Multiple inheritance** occurs when a class inherits from more than one class. Java does not support multiple inheritance with classes to avoid ambiguity and complexity.
   - **Interfaces** can be used to achieve multiple inheritance in Java.

   **Example** (Using interfaces):
   ```java
   interface Animal {
       void eat();
   }

   interface Mammal {
       void giveBirth();
   }

   class Dog implements Animal, Mammal {
       public void eat() {
           System.out.println("Dog eating...");
       }

       public void giveBirth() {
           System.out.println("Dog giving birth...");
       }
   }

   public class Main {
       public static void main(String[] args) {
           Dog d = new Dog();
           d.eat();
           d.giveBirth();
       }
   }
   ```

   In this example:
   - `Dog` implements both `Animal` and `Mammal` interfaces, achieving **multiple inheritance** through interfaces.

---

### **Summary of Inheritance Types**:

| Type                  | Description                                                  | Example                         |
|-----------------------|--------------------------------------------------------------|---------------------------------|
| **Single Inheritance** | A class inherits from one class only.                       | `Dog` inherits from `Animal`    |
| **Multilevel Inheritance** | A class inherits from another class, which is itself a subclass. | `Dog` → `Mammal` → `Animal`    |
| **Hierarchical Inheritance** | Multiple classes inherit from a single class.             | `Dog` and `Cat` inherit from `Animal` |
| **Hybrid Inheritance** | Combination of two or more inheritance types.               | Interfaces and classes combined (via `Mammal` and `Animal`) |
| **Multiple Inheritance** | A class inherits from multiple classes (not allowed directly in Java). | Achieved using interfaces in Java. |


### **Benefits of Inheritance**

- **Code Reusability**: Subclasses can reuse code from the superclass.
- **Extensibility**: New subclasses can be created easily by extending existing classes.
- **Maintainability**: Changes in the superclass automatically reflect in subclasses, reducing redundancy.

---

### **Limitations of Inheritance**

- **Complexity**: Deep or multiple levels of inheritance can lead to a complex and hard-to-manage system.
- **Tight Coupling**: Subclasses may become tightly coupled to the behavior of the superclass, causing issues if the superclass changes.
- **Java's Multiple Inheritance Limitation**: Java does not allow multiple inheritance directly through classes but can achieve it using interfaces.

---

### **8. Method Signature**

#### **Definition**:
A **method signature** in Java consists of the **method's name** and the **parameter list**. The method signature uniquely identifies a method within a class, and it's essential for method overloading and method invocation.

#### **What the Method Signature Includes**:
- **Method Name**: The name of the method.
- **Parameter List**: The types and number of parameters the method accepts. The **parameter names** are not part of the method signature, but the **types** and **order** of parameters are.
- **Return Type** is **not** part of the method signature. The return type is important for method invocation but does not factor into the method signature.

#### **Example**:
```java
class Calculator {
    // Method 1: Adds two integers
    int add(int a, int b) {
        return a + b;
    }

    // Method 2: Adds two floating-point numbers
    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 3));          // Calls the add(int, int) method
        System.out.println(calc.add(5.5, 3.3));      // Calls the add(double, double) method
    }
}
```

In this example:
- There are **two `add` methods** with the same name but different **parameter lists** (one takes `int` parameters, the other takes `double` parameters).
- **Method signature** in this case is defined by the **name** (`add`) and the **parameter types** (`int, int` or `double, double`).
- **Return type** (`int`, `double`) is **not** part of the method signature, even though it is essential for method invocation.

#### **Key Points About Method Signature**:
- **Unique Identification**: The method signature uniquely identifies a method within a class. It is used during method overloading to distinguish between methods.
- **Does Not Include Return Type**: Only the method name and the parameter list (type and order) make up the method signature.
- **Used in Overloading**: In method overloading, methods can have the same name but must have different method signatures (i.e., different parameter types or numbers).

#### **Incorrect Overloading (Based on Method Signature)**:
If you try to overload a method by changing only its return type, it will not be valid because the return type is **not part of the method signature**. It is considered a **compile-time error**.

```java
class Calculator {
    // Invalid overload: Different return types, but same method signature
    int add(int a, int b) {
        return a + b;
    }

    // This is not considered overloading as the method signature is the same
    double add(int a, int b) {
        return a + b;
    }
}
```

In the above example:
- Even though the return types are different (`int` vs. `double`), both methods have the same **method signature** (`add(int, int)`), which causes a **compilation error**.

---

### **Summary of Method Signature**:

| Feature                        | Description                                          |
|---------------------------------|------------------------------------------------------|
| **Consists of**                 | Method **name** and **parameter list** (type and order) |
| **Excludes**                    | **Return type** (not part of the method signature) |
| **Importance in Overloading**   | Used to differentiate between methods with the same name |
| **Does not Include**            | **Parameter names** (only the type and order of parameters matter) |

---

**Topic 9: Run-Time Polymorphism (Method Overriding)**.

### **9. Run-Time Polymorphism (Method Overriding)**

#### **Definition**:
- **Run-time polymorphism** is a concept in object-oriented programming where a method call is resolved **at runtime** based on the actual object type, rather than the reference type.
- This is achieved through **method overriding**, where a subclass provides a specific implementation of a method already defined in its superclass.

#### **How It Works**:
- A subclass **overrides** a method that is already defined in its superclass with a new implementation.
- At **runtime**, the Java Virtual Machine (JVM) uses the actual object's type (not the reference type) to determine which version of the method to invoke.

#### **Method Overriding**:
- **Method overriding** occurs when a subclass provides a **new implementation** for a method that is already declared in the superclass.
- The method in the subclass must have the same **method signature** (name, return type, and parameter list) as the one in the superclass.
- **Dynamic method dispatch**: The JVM determines which method to call at runtime, based on the actual object type.

#### **Example**:
```java
class Animal {
    // Method in superclass
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Overriding the method in subclass
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    // Overriding the method in subclass
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        // Reference of type Animal, but objects of Dog and Cat
        Animal animal1 = new Dog();  // Dog object
        Animal animal2 = new Cat();  // Cat object

        animal1.sound();  // Outputs: Dog barks (Method of Dog class)
        animal2.sound();  // Outputs: Cat meows (Method of Cat class)
    }
}
```

In this example:
- The `sound()` method is **overridden** in both the `Dog` and `Cat` classes.
- The references `animal1` and `animal2` are of type `Animal`, but at **runtime**, the JVM calls the **appropriate method** based on the actual object type (`Dog` or `Cat`).

#### **Key Points About Run-Time Polymorphism**:
1. **Method Signature**: The method signature (name and parameters) must be the same in both the superclass and subclass for overriding.
2. **Dynamic Dispatch**: The method to be invoked is determined **at runtime**, not at compile time.
3. **Overriding vs. Overloading**: **Overriding** is used for runtime polymorphism (same method signature in subclass and superclass), while **overloading** occurs at compile time with different method signatures.

#### **Benefits of Run-Time Polymorphism**:
- **Flexibility and Reusability**: Run-time polymorphism allows methods to behave differently based on the object type, enabling more flexible and reusable code.
- **Extensibility**: New subclasses can override methods and provide their own behavior, making it easier to extend functionality without changing existing code.

#### **Method Overriding vs. Method Overloading**:
| Feature                | Method Overriding                           | Method Overloading                       |
|------------------------|---------------------------------------------|------------------------------------------|
| **Occurs at**          | **Runtime** (decided based on actual object) | **Compile-time** (decided based on method signature) |
| **Purpose**            | To provide a specific implementation in subclass | To define multiple methods with the same name but different parameters |
| **Method Signature**   | Same method signature in subclass and superclass | Same method name, but different parameter list |
| **Return Type**        | Must be the same or covariant (subtype)     | Can have different return types          |

---

### **Summary**:
- **Run-time polymorphism** is achieved through **method overriding**, allowing the JVM to call the correct method based on the actual object's type at runtime.
- **Method overriding** involves defining a method in a subclass with the same signature as the one in the superclass, and the JVM decides which method to call at runtime.
- **Method overloading** is related but occurs at **compile time** and involves defining multiple methods with the same name but different parameters.

---

**Topic 10: `this` vs `super`**. 

### **10. `this` vs `super`**

#### **1. `this` Keyword**

The `this` keyword refers to the **current instance** of the class. It is commonly used to differentiate between instance variables and local variables with the same name, or to invoke other constructors of the same class.

##### **Key Uses of `this`:**

- **Referring to instance variables**:
  When a method or constructor parameter has the same name as an instance variable, `this` is used to refer to the instance variable.

  **Example:**
  ```java
  class Car {
      String model;

      // Constructor with a parameter
      Car(String model) {
          this.model = model; // 'this.model' refers to the instance variable, 'model' refers to the parameter
      }

      void display() {
          System.out.println("Car model: " + this.model); // 'this.model' explicitly refers to the instance variable
      }
  }

  public class Main {
      public static void main(String[] args) {
          Car car1 = new Car("Tesla");
          car1.display(); // Output: Car model: Tesla
      }
  }
  ```

  In this example:
  - `this.model` refers to the **instance variable**, while `model` refers to the **parameter** in the constructor.
  
- **Invoking current class methods**:
  You can use `this` to explicitly call a method of the current class, although it’s optional and not always necessary unless there's a naming conflict or you want to emphasize that it's the current class method.

  **Example:**
  ```java
  class Car {
      void drive() {
          System.out.println("Driving car");
      }

      void start() {
          this.drive(); // Invoking the current class method using 'this'
      }
  }

  public class Main {
      public static void main(String[] args) {
          Car car1 = new Car();
          car1.start();  // Output: Driving car
      }
  }
  ```

- **Calling another constructor (Constructor chaining)**:
  The `this()` constructor call is used to invoke another constructor in the same class. This is known as **constructor chaining**.

  **Example:**
  ```java
  class Car {
      String model;
      int year;

      // Constructor 1
      Car(String model) {
          this.model = model;
      }

      // Constructor 2
      Car(String model, int year) {
          this(model); // Calling Constructor 1
          this.year = year;
      }

      void display() {
          System.out.println("Car model: " + model + ", Year: " + year);
      }
  }

  public class Main {
      public static void main(String[] args) {
          Car car1 = new Car("Tesla", 2021);
          car1.display(); // Output: Car model: Tesla, Year: 2021
      }
  }
  ```

In this example:
- `this(model)` in the second constructor invokes the first constructor with just the `model` parameter, demonstrating **constructor chaining**.

#### **2. `super` Keyword**

The `super` keyword refers to the **superclass** (parent class) of the current object. It is used to call superclass methods, access superclass constructors, and reference superclass instance variables.

##### **Key Uses of `super`:**

- **Accessing superclass methods**:
  `super` is used to call a method from the parent class, especially when the subclass overrides it and you still want to use the parent class's version.

  **Example:**
  ```java
  class Animal {
      void sound() {
          System.out.println("Animal makes a sound");
      }
  }

  class Dog extends Animal {
      @Override
      void sound() {
          super.sound(); // Calling the superclass (Animal) method
          System.out.println("Dog barks");
      }
  }

  public class Main {
      public static void main(String[] args) {
          Dog dog1 = new Dog();
          dog1.sound();  // Output: Animal makes a sound
                         //         Dog barks
      }
  }
  ```

In this example:
- The `super.sound()` call invokes the `sound()` method from the `Animal` class, even though `sound()` is overridden in the `Dog` class.

- **Calling a superclass constructor**:
  The `super()` keyword is used to call the **constructor** of the parent class. It must be the first statement in the subclass constructor.

  **Example:**
  ```java
  class Animal {
      Animal(String name) {
          System.out.println("Animal's name is: " + name);
      }
  }

  class Dog extends Animal {
      Dog(String name) {
          super(name); // Calling the superclass constructor with the 'name' parameter
          System.out.println("Dog's name is: " + name);
      }
  }

  public class Main {
      public static void main(String[] args) {
          Dog dog1 = new Dog("Buddy");
          // Output:
          // Animal's name is: Buddy
          // Dog's name is: Buddy
      }
  }
  ```

In this example:
- `super(name)` calls the `Animal` class's constructor, passing the `name` parameter. This is a way to initialize the parent class's instance variables using the subclass's constructor.

- **Accessing superclass instance variables**:
  `super` can also be used to refer to **instance variables** of the superclass if they are hidden by the subclass.

  **Example:**
  ```java
  class Animal {
      String name = "Animal";
  }

  class Dog extends Animal {
      String name = "Dog";

      void display() {
          System.out.println("Dog name: " + name);           // Accessing subclass variable
          System.out.println("Animal name: " + super.name);   // Accessing superclass variable
      }
  }

  public class Main {
      public static void main(String[] args) {
          Dog dog1 = new Dog();
          dog1.display();
          // Output:
          // Dog name: Dog
          // Animal name: Animal
      }
  }
  ```

In this example:
- `super.name` refers to the `name` instance variable from the `Animal` class (superclass), while `name` by itself refers to the `name` variable in the `Dog` class (subclass).

---

### **Key Differences Between `this` and `super`**:

| Feature                       | `this`                                           | `super`                                      |
|-------------------------------|-------------------------------------------------|----------------------------------------------|
| **Reference**                  | Refers to the **current instance** of the class | Refers to the **superclass (parent) object** |
| **Usage in Constructor**       | Used to call **another constructor** of the current class (constructor chaining) | Used to call the **constructor** of the superclass |
| **Usage in Method**            | Refers to the **current class method or instance variable** | Refers to the **parent class method or instance variable** |
| **Accessing Variables**        | Used to refer to **instance variables** of the current class | Used to refer to **instance variables** of the parent class |
| **Accessing Methods**          | Used to invoke methods from the current class   | Used to invoke methods from the superclass   |

---

### **Summary**:
- **`this`** is used to refer to the **current instance** of the class. It is commonly used to differentiate between instance variables and parameters, call other methods in the class, and invoke constructors within the same class.
- **`super`** is used to refer to the **superclass** (parent class). It is used to call methods, constructors, or access instance variables of the superclass.

---


### **Topic 11: Upcasting**

Upcasting is a concept in object-oriented programming (OOP) where a subclass object is treated as an object of its superclass. This is a form of **reference type casting** and is **implicitly** handled by Java.

In **upcasting**, a reference variable of a subclass type is assigned to a reference variable of its superclass type. Since the subclass object is also an instance of its superclass, this casting is safe and is automatically done by Java, without needing an explicit cast.

---

### **Key Points About Upcasting:**
- **Subclass to Superclass**: Upcasting happens when an object of a subclass is assigned to a variable of its superclass type.
- **Implicit Casting**: Java handles upcasting **implicitly**, meaning you do not need to write any special casting code for it.
- **Access Limitations**: While upcasting is allowed, it limits access to only the members (methods and variables) that are defined in the superclass. You cannot directly access subclass-specific methods or variables through a superclass reference.

#### **Why Upcasting is Useful**:
- **Polymorphism**: Upcasting is commonly used in the context of polymorphism. It allows you to work with objects of different subclasses in a uniform way through a reference of the superclass type.
- **Generic Programming**: It helps in writing code that works with different subclasses, ensuring flexibility and extensibility.

#### **Example of Upcasting:**
Let's look at an example where we perform upcasting in Java.

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void fetch() {
        System.out.println("Dog is fetching the ball");
    }
}

public class Main {
    public static void main(String[] args) {
        // Upcasting: Dog object is assigned to an Animal reference
        Animal myAnimal = new Dog(); // Upcasting happens here automatically

        myAnimal.sound();  // Outputs: Dog barks (Method overriding)

        // The following line would cause a compile-time error:
        // myAnimal.fetch();  // Error: fetch() is not available in Animal class
    }
}
```

In this example:
- The `Dog` object is assigned to an `Animal` reference: `Animal myAnimal = new Dog();` This is **upcasting**.
- `myAnimal` can call the `sound()` method because `sound()` is defined in the `Animal` class, and the `Dog` class overrides it.
- The `fetch()` method, which is specific to the `Dog` class, **cannot be accessed** through the `Animal` reference, because the reference is of type `Animal`, and `fetch()` is not part of the `Animal` class.

#### **Key Observations:**
1. **Upcasting is Implicit**: You don't need to explicitly cast the `Dog` object to an `Animal` type, as Java automatically handles it.
2. **Access to Superclass Members**: Through upcasting, you can only access the members (methods/fields) defined in the superclass or overridden in the subclass.
3. **Polymorphism**: Even though the reference variable is of type `Animal`, the actual method that gets called (like `sound()`) will be based on the object type (in this case, `Dog`). This is due to **method overriding** and **runtime polymorphism**.

---

### **Upcasting and Polymorphism**:

Upcasting is crucial for implementing polymorphism, especially when working with collections or when you want to treat different types of objects in a uniform way. For example, you can store objects of different subclass types in a single list or array of superclass type.

#### **Example of Upcasting with Polymorphism:**

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];  // Array of Animal references

        animals[0] = new Dog();  // Upcasting Dog to Animal
        animals[1] = new Cat();  // Upcasting Cat to Animal

        for (Animal animal : animals) {
            animal.sound();  // Outputs: Dog barks, Cat meows (polymorphic behavior)
        }
    }
}
```

In this example:
- We created an array of `Animal` references, but we stored `Dog` and `Cat` objects in the array. This is possible because of **upcasting**.
- When we call `sound()` on each element of the array, Java uses **polymorphism** to call the overridden methods of `Dog` and `Cat` respectively, even though the reference type is `Animal`.

---

### **Summary of Upcasting**:
| Feature                     | Upcasting                                          |
|-----------------------------|---------------------------------------------------|
| **What is it?**              | Assigning a subclass object to a superclass reference variable. |
| **Casting Type**             | Implicit (automatic). No need for explicit casting. |
| **Access to Members**        | Limited to superclass members or overridden methods in subclass. |
| **Purpose**                  | Used to enable polymorphism, treat objects of different subclasses uniformly. |
| **When is it Useful?**       | When you want to work with objects in a generalized way, especially in collections or methods that operate on superclass types. |

---

### **Summary**:
- **Upcasting** is a process where an object of a subclass is treated as an object of its superclass. This is done automatically by Java.
- It is useful for achieving **polymorphism**, allowing you to refer to objects of different subclasses using a superclass reference and call methods based on the actual object type.
- You can only access the superclass's fields and methods directly after upcasting. If the subclass has extra methods (like `fetch()` in the `Dog` class), they cannot be accessed through the superclass reference.

---



### **Topic 12: `final` Keyword**

The `final` keyword in Java is used to define constants, prevent method overriding, and prevent inheritance. It can be applied to **variables**, **methods**, and **classes**.

Let's break down the different uses of the `final` keyword:

---

### **1. `final` with Variables**

When the `final` keyword is used with a **variable**, it makes that variable a **constant**. Once a variable is declared as `final`, its value cannot be changed after initialization. This applies to both **instance variables** and **local variables**.

#### **Usage of `final` with Variables:**

- **Final Instance Variable**: Once assigned a value in the constructor, the value cannot be changed.
- **Final Local Variable**: Once initialized, the value cannot be modified in the method.
- **Final Class Variable**: Can only be initialized once, either at the point of declaration or in a constructor.

#### **Example:**

```java
class Car {
    final String model;  // Final instance variable

    // Constructor that initializes the final variable
    Car(String model) {
        this.model = model;  // Can be assigned once, no further modification allowed
    }

    void display() {
        System.out.println("Car model: " + model);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Tesla");
        car1.display();  // Output: Car model: Tesla

        // The following line will cause a compile-time error:
        // car1.model = "BMW";  // Cannot assign a value to a final variable
    }
}
```

In this example:
- The `model` variable is marked as `final`, so once it is initialized in the constructor, it cannot be modified.

---

### **2. `final` with Methods**

When a method is declared as `final`, it **cannot be overridden** by any subclass. This is useful when you want to ensure that a method's behavior remains unchanged in subclasses.

#### **Usage of `final` with Methods:**
- **Prevent Method Overriding**: You can use `final` to prevent subclass methods from modifying the behavior of a parent class method.

#### **Example:**

```java
class Animal {
    final void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // The following will cause a compile-time error:
    // void sound() {
    //     System.out.println("Dog barks");
    // }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound();  // Output: Animal makes a sound
    }
}
```

In this example:
- The `sound()` method is marked as `final` in the `Animal` class. This means the `Dog` class **cannot override** it, ensuring that the `sound()` method's behavior remains fixed.

---

### **3. `final` with Classes**

When a class is declared as `final`, it cannot be **inherited**. This is useful when you want to prevent a class from being subclassed.

#### **Usage of `final` with Classes:**
- **Prevent Inheritance**: A `final` class cannot have any subclasses. This can be used to avoid potential modification of critical classes.

#### **Example:**

```java
final class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {  // This will cause a compile-time error
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound();  // Output: Animal makes a sound
    }
}
```

In this example:
- The `Animal` class is marked as `final`, so it **cannot be extended** by the `Dog` class. Trying to do so results in a **compile-time error**.

---

### **4. `final` with Parameters**

When a **method parameter** is declared as `final`, it means that the parameter's value cannot be changed within the method. This helps to prevent accidental changes to the values passed into the method.

#### **Usage of `final` with Parameters:**

- **Prevent Modification**: When a method parameter is marked `final`, its value cannot be modified in the body of the method.

#### **Example:**

```java
class Calculator {
    void add(final int a, final int b) {
        // a = 5;  // Compile-time error: cannot assign a value to final variable 'a'
        System.out.println("Sum: " + (a + b));
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(10, 20);  // Output: Sum: 30
    }
}
```

In this example:
- The parameters `a` and `b` are marked as `final`. Any attempt to change their values inside the `add` method would cause a **compile-time error**.

---

### **5. `final` with References (Reference Variables)**

When a reference variable is declared as `final`, it means that the reference (the memory address) cannot be reassigned to point to another object. However, the object it points to can still be modified if it is mutable.

#### **Usage of `final` with Reference Variables:**
- **Prevent Reassignment**: The reference variable can still modify the fields of the object it points to, but the reference cannot point to another object after being assigned initially.

#### **Example:**

```java
class Car {
    String model;
    
    Car(String model) {
        this.model = model;
    }

    void changeModel(String newModel) {
        this.model = newModel;
    }
}

public class Main {
    public static void main(String[] args) {
        final Car car = new Car("Tesla");
        car.changeModel("BMW");  // Allowed: Object's state can be changed

        // The following line will cause a compile-time error:
        // car = new Car("Audi");  // Cannot reassign the final reference
    }
}
```

In this example:
- The reference `car` is `final`, meaning it cannot be reassigned to point to a different `Car` object after it is initialized.
- However, the object itself (`car`) can still have its state modified, like changing its `model` field.

---

### **Summary of `final` Keyword Usage:**

| **Context**         | **Usage**                                                                 |
|---------------------|---------------------------------------------------------------------------|
| **Final Variables**  | Used to create constants. The value of the variable cannot be changed after initialization. |
| **Final Methods**    | Used to prevent method overriding in subclasses.                          |
| **Final Classes**    | Used to prevent a class from being inherited.                             |
| **Final Parameters** | Used to prevent method parameters from being changed inside the method.  |
| **Final References** | Prevents the reference from being reassigned to point to another object, but the object's state can still be modified. |

---

### **When to Use `final`:**
- Use `final` when you want to ensure that the value of a variable remains constant throughout the program.
- Use `final` for methods or classes when you want to guarantee that they cannot be overridden or extended.
- Use `final` on parameters to ensure that they are not modified inside the method, which can help maintain code integrity.

---


### **13. Method Hiding**

#### **Definition:**
**Method Hiding** occurs when a **static method** in a subclass has the same method signature (name and parameters) as a static method in its superclass. The subclass method **hides** the superclass method, but does not **override** it. The method resolution happens **at compile-time** based on the reference type, not the actual object type.

#### **Key Characteristics of Method Hiding:**

1. **Only Applies to Static Methods:**
   - Method hiding can only occur with **static methods** (methods that belong to the class, not an instance). Instance methods cannot be hidden in the same way.
   - Static methods are bound to the class, not the object, which is why method hiding applies only to static methods.

2. **Resolution at Compile-Time:**
   - In method hiding, the method that is executed is determined **at compile-time**, based on the **reference type** (not the actual object).
   - If the reference type is of the superclass, the superclass version of the method is called, even if the actual object is of the subclass type.

3. **Does Not Support Polymorphism:**
   - Unlike **method overriding** (which supports runtime polymorphism), method hiding does not support polymorphism. The method call is determined statically at compile-time based on the reference type.
  
4. **No Method Overriding Involved:**
   - In method hiding, the subclass does not override the method in the superclass. Instead, the subclass **hides** the method, which means both methods exist, but the method from the subclass doesn't truly replace the superclass's method.

5. **Binding to Reference Type, Not Object Type:**
   - The static method is resolved using the reference type. For example, if the reference type is the superclass, the superclass’s method will be called, regardless of the actual object.

---

#### **Example of Method Hiding:**

```java
class Animal {
    static void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Hiding the static method of Animal class
    static void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound();  // Output: Animal makes a sound

        Dog dog = new Dog();
        dog.sound();  // Output: Dog barks

        // Using references of the parent class to refer to subclass objects
        Animal myAnimal = new Dog();
        myAnimal.sound();  // Output: Animal makes a sound (resolved at compile-time based on reference type)
    }
}
```

#### **Explanation of the Example:**
- In the example above, the `sound()` method in the `Dog` class **hides** the `sound()` method in the `Animal` class.
- When the method is called using the reference type `Animal` (even if it points to a `Dog` object), the method from `Animal` is called because the resolution is **based on the reference type**, not the actual object.
- The **output** for `myAnimal.sound()` will be `Animal makes a sound` because `myAnimal` is of type `Animal`, even though it refers to a `Dog` object.

---

#### **Method Hiding vs Method Overriding:**

| **Feature**                    | **Method Hiding**                                              | **Method Overriding**                                        |
|---------------------------------|---------------------------------------------------------------|-------------------------------------------------------------|
| **Applies To**                  | **Static methods** (methods that belong to the class)         | **Instance methods** (methods that belong to objects)        |
| **Resolution Time**             | Resolved **at compile-time** based on the reference type      | Resolved **at runtime** based on the actual object type      |
| **Polymorphism**                | Does **not** support polymorphism (no dynamic dispatch)       | Supports polymorphism (dynamic method dispatch)             |
| **Behavior**                    | The subclass method **hides** the superclass method           | The subclass method **overrides** the superclass method      |
| **Inheritance**                 | Can hide a method in the superclass but doesn’t affect subclass behavior | Can override a method in the superclass to change subclass behavior |
| **Method Signature**            | Same method signature, but does not invoke polymorphism      | Same method signature, allows polymorphic behavior at runtime |
| **Binding Type**                | Determined at **compile-time** based on the reference type    | Determined at **runtime** based on the actual object type    |
| **Example**                     | Static method in subclass hiding static method in superclass  | Instance method in subclass overriding instance method in superclass |
| **Common Use**                  | Used when you want to hide the static method in a subclass    | Used when you want to change the behavior of a superclass method in the subclass |

---

#### **Why Method Hiding Is Rarely Used:**
1. **No Runtime Polymorphism:**
   - Since method hiding does not allow dynamic method dispatch (runtime polymorphism), it is less flexible than method overriding.
  
2. **Method Hiding Can Be Confusing:**
   - The fact that the method resolution depends on the **reference type** (not the object type) can be confusing and make code harder to maintain.
  
3. **Limited Use Case:**
   - Method hiding is only useful when you need to hide a **static method** in the subclass but still want to keep the superclass method intact for other cases. However, this scenario is quite rare in practice.

---

### **Summary of Method Hiding:**

- **Method Hiding** is a feature that applies to **static methods** where the subclass method hides the static method of the superclass.
- The method to be executed is resolved at **compile-time**, based on the **reference type**, not the actual object.
- **Method Hiding** does **not support polymorphism**. It is quite different from **Method Overriding**, which happens with instance methods and allows for runtime polymorphism.
  
**Key Takeaway:** While method hiding can be useful in certain situations, it is less common and less flexible compared to method overriding, which supports polymorphism.

---




Let's move on to the next topic:

### **14. Covariant Return Types**

#### **Definition:**
**Covariant return types** allow a subclass method to return an object that is a **subtype** of the return type of the overridden method in the superclass. This concept is used when a subclass overrides a method from its superclass, and the return type in the subclass can be a more specific type than the return type in the superclass.

In other words, covariant return types allow a subclass to return a **more specific** type (a subclass of the original return type) instead of the original return type defined in the superclass method.

#### **Key Characteristics of Covariant Return Types:**

1. **Return Type Substitution:**
   - The return type of the subclass method can be a **subtype** of the return type of the superclass method.
   
2. **Works Only with Overriding:**
   - Covariant return types apply **only to method overriding**. It does not work with method hiding because method hiding is related to static methods, and the return type of a static method cannot be changed in this way.

3. **Enhances Polymorphism:**
   - Covariant return types allow you to maintain polymorphism while refining the return type to be more specific in the subclass.

4. **Java 5 and Above:**
   - Covariant return types were introduced in Java 5 to improve flexibility in method overriding.

#### **How Covariant Return Types Work:**

- If a method in a superclass has a return type of class `A`, then the overridden method in the subclass can return an object of a class that is a subclass of `A` (for example, class `B`).
  
#### **Example of Covariant Return Types:**

```java
class Animal {
    Animal makeSound() {
        System.out.println("Animal makes a sound");
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    Dog makeSound() {
        System.out.println("Dog barks");
        return new Dog();  // Covariant return type (subclass of Animal)
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();  // Output: Animal makes a sound

        Dog dog = new Dog();
        dog.makeSound();  // Output: Dog barks

        Animal myAnimal = new Dog();
        myAnimal.makeSound();  // Output: Dog barks (Covariant return type is maintained)
    }
}
```

#### **Explanation of the Example:**

1. In the `Animal` class, the method `makeSound()` returns an instance of `Animal`.
2. In the `Dog` class, which extends `Animal`, the method `makeSound()` is overridden to return an instance of `Dog`, which is a subclass of `Animal`.
3. The return type of the `makeSound()` method in the `Dog` class is more specific (i.e., `Dog`), which is allowed by covariant return types.
4. When the `myAnimal.makeSound()` method is called, even though the reference is of type `Animal`, the `makeSound()` method from `Dog` is called because of **runtime polymorphism**.

#### **Rules for Covariant Return Types:**

1. The return type of the overridden method must be a subclass (or subtype) of the return type in the superclass method.
2. The overriding method must have the same signature (name and parameters) as the superclass method.
3. Covariant return types work only with **instance methods** (not static methods), because static methods do not participate in polymorphism.

#### **Why Covariant Return Types Are Useful:**

1. **Increased Flexibility**: They allow subclasses to provide more specific return types, improving flexibility while maintaining method overriding.
2. **Polymorphism**: Covariant return types enhance polymorphism because they allow subclasses to be more specific in terms of the returned object while keeping the general method behavior consistent across the class hierarchy.
3. **Maintain Type Safety**: With covariant return types, you maintain type safety because the subclass return type is a subtype of the superclass return type, meaning you can still rely on the behavior expected from the superclass.

---

### **Summary of Covariant Return Types:**

| **Feature**                     | **Covariant Return Types**                               |
|----------------------------------|----------------------------------------------------------|
| **Applies to**                   | **Instance methods** (method overriding)                 |
| **Return Type**                  | The return type can be a **subclass** (covariant) of the superclass return type |
| **Java Version**                 | Introduced in **Java 5**                                  |
| **Overriding**                   | Allows more specific return types when overriding methods |
| **Polymorphism**                 | Supports polymorphism by allowing refined return types   |
| **Example**                      | Subclass overriding method with a more specific return type |
| **Use Case**                     | Helps when a subclass method needs to return a more specific type than the superclass method |

---

### **Conclusion:**
- **Covariant return types** allow subclasses to refine the return type of a method when overriding it. The return type in the subclass can be more specific (a subclass) than the one in the superclass.
- This feature increases the flexibility of object-oriented designs, maintains polymorphism, and allows you to return more specific objects without violating type safety.

---




**Topic 15: `final` vs `static`**:

### **15. `final` vs `static`**

The `final` and `static` keywords in Java are both used in different contexts, and they have distinct meanings and use cases. Let’s explore each one, compare them, and discuss their differences.

---

#### **15.1. The `final` Keyword**

The `final` keyword in Java is used to declare constants, prevent method overriding, and prevent inheritance. It can be applied to **variables**, **methods**, and **classes**.

1. **Final Variables:**
   - A **final variable** can only be assigned once. After its initial assignment, its value cannot be changed (it becomes a constant).
   - A **final variable** can be initialized either at the time of declaration or in the constructor (for instance variables).

   ```java
   class Car {
       final int maxSpeed = 200;  // constant value for max speed

       void setMaxSpeed(int speed) {
           // maxSpeed = speed;  // Error: Cannot assign a value to final variable
       }
   }
   ```

2. **Final Methods:**
   - A **final method** cannot be overridden by subclasses. This is useful when you want to ensure the method behavior remains the same for all subclasses.

   ```java
   class Animal {
       final void makeSound() {
           System.out.println("Animal makes a sound");
       }
   }

   class Dog extends Animal {
       // This would give a compile-time error:
       // void makeSound() {
       //     System.out.println("Dog barks");
       // }
   }
   ```

3. **Final Classes:**
   - A **final class** cannot be subclassed. This is useful when you want to create a class that should not be extended by any other class.

   ```java
   final class Vehicle {
       // Class code here
   }

   // This will give a compile-time error:
   // class Car extends Vehicle { }
   ```

---

#### **15.2. The `static` Keyword**

The `static` keyword in Java is used to indicate that a member (variable, method, or block) belongs to the **class**, rather than to instances of the class (objects). This means that a `static` member can be accessed without creating an instance of the class.

1. **Static Variables:**
   - A **static variable** is shared among all instances of the class. All objects of the class have access to the same static variable, and it can be accessed using the class name.

   ```java
   class Counter {
       static int count = 0;  // Shared by all instances of the class

       Counter() {
           count++;  // Increment the shared count variable
       }
   }

   public class Main {
       public static void main(String[] args) {
           Counter c1 = new Counter();
           Counter c2 = new Counter();
           System.out.println(Counter.count);  // Output: 2
       }
   }
   ```

2. **Static Methods:**
   - A **static method** belongs to the class and can be invoked without creating an instance of the class. It can only access **static variables** and **static methods** of the class.

   ```java
   class MathUtil {
       static int add(int a, int b) {
           return a + b;
       }
   }

   public class Main {
       public static void main(String[] args) {
           System.out.println(MathUtil.add(5, 3));  // Output: 8
       }
   }
   ```

3. **Static Blocks:**
   - A **static block** is used for static initializations. It runs only once when the class is loaded into memory. It's useful for one-time initialization that should happen before any object is created.

   ```java
   class MyClass {
       static {
           System.out.println("Static block is executed");
       }
   }

   public class Main {
       public static void main(String[] args) {
           new MyClass();  // Output: Static block is executed
       }
   }
   ```

---

#### **15.3. Differences Between `final` and `static`**

| **Feature**                | **`final`**                                                       | **`static`**                                                     |
|----------------------------|-------------------------------------------------------------------|------------------------------------------------------------------|
| **Basic Concept**           | Used to define constants, prevent method overriding, and prevent inheritance. | Used to define class-level members that can be accessed without creating an object. |
| **Applies to**              | Variables, Methods, Classes                                       | Variables, Methods, Blocks                                        |
| **Variables**               | Once assigned, the value of a `final` variable cannot be changed. | A `static` variable is shared across all instances of the class. |
| **Methods**                 | A `final` method cannot be overridden by subclasses.              | A `static` method belongs to the class and can be invoked without an instance of the class. |
| **Classes**                 | A `final` class cannot be subclassed.                             | A `static` class is used for inner classes, and the class itself is associated with the outer class. |
| **Use Case**                | To define constants, prevent modification of methods/variables, or prevent inheritance. | To define class-level data or functionality, typically for data shared across instances. |
| **Memory Allocation**       | Final variables are allocated once and their value cannot change. | Static variables are allocated once when the class is loaded and shared among all instances. |

---

#### **15.4. Combining `final` and `static`**

Sometimes, `final` and `static` are used together to define constants. In Java, constants are typically defined using `final static`:

```java
class MathConstants {
    public static final double PI = 3.14159;  // Constant value for Pi
}

public class Main {
    public static void main(String[] args) {
        System.out.println(MathConstants.PI);  // Output: 3.14159
    }
}
```

In this example:
- The `PI` variable is **static**, meaning it belongs to the class itself.
- The `PI` variable is **final**, meaning its value cannot be changed after initialization.

---

#### **15.5. When to Use `final` vs `static`**

- Use **`final`** when:
  - You want to prevent modification (for variables) or prevent inheritance/overriding (for methods/classes).
  - You want to define constants that should not change.

- Use **`static`** when:
  - You want a method or variable that is common to all instances of a class.
  - You want to call a method or access a variable without creating an object of the class.

---

### **Summary:**

| **Keyword**       | **Purpose**                                               | **Common Use Cases**                                        |
|-------------------|-----------------------------------------------------------|------------------------------------------------------------|
| **`final`**       | Prevents modification (variables), inheritance (classes), or method overriding. | Defining constants, ensuring immutability, and preventing subclassing. |
| **`static`**      | Makes a method or variable belong to the class, not instances. | Class-level variables or methods, and one-time initialization blocks. |

Both `final` and `static` are essential for ensuring certain behaviors in Java, such as immutability and class-level functionality. They serve different purposes but are often used together to ensure that data is constant and belongs to the class rather than instances.



---




### **16. Access Modifiers in Java**

Access modifiers in Java are keywords used to define the visibility and accessibility of classes, methods, variables, and constructors. They determine which other classes, methods, or variables can access a particular member of a class. Java provides **four types of access modifiers**:

1. **`private`**
2. **`default`** (no modifier)
3. **`protected`**
4. **`public`**

Each of these modifiers affects the level of access control granted to other classes. Let’s go through each one in detail.

---

#### **1. `private` Access Modifier**

- **Visibility**: A member with the `private` access modifier is accessible **only within the same class**. It is the **most restrictive** access level.
- **Use Case**: This is used when you want to hide the internal details of a class and prevent other classes from directly accessing its fields or methods.
- **Access Level**: **Only within the class** itself.

##### **Example of `private` modifier:**

```java
class Car {
    private String engineType;  // Private field

    private void startEngine() {  // Private method
        System.out.println("Engine started");
    }

    public void showDetails() {
        System.out.println("Engine Type: " + engineType); // Accessing private field within the class
        startEngine(); // Accessing private method within the class
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        // car.engineType = "V8";  // Error: Cannot access private field
        // car.startEngine();      // Error: Cannot access private method
        car.showDetails();        // Output: Engine Type: null (because engineType is not initialized)
    }
}
```

---

#### **2. `default` Access Modifier**

- **Visibility**: If no access modifier is specified (i.e., **default**), the member is accessible **only within the same package**. This is also referred to as **package-private** access.
- **Use Case**: This is useful when you want to allow access to members only within the same package but restrict access from outside the package.
- **Access Level**: **Within the same package** (not visible to classes outside the package).

##### **Example of `default` access modifier:**

```java
class Car {
    String model;  // Default (package-private) access modifier

    void startEngine() {  // Default method
        System.out.println("Engine started");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.model = "Tesla";  // Accessing the default field within the same package
        car.startEngine();    // Accessing the default method within the same package
    }
}
```

- **Note**: If you don't explicitly mention any access modifier, it is considered **default**.

---

#### **3. `protected` Access Modifier**

- **Visibility**: A member with the `protected` access modifier is accessible within the same package **and** by subclasses (even if they are in different packages).
- **Use Case**: This is typically used when you want to allow access to members from subclasses, either in the same package or in different packages, but still keep them hidden from other unrelated classes.
- **Access Level**: **Within the same package** and **by subclasses** (even if they are in different packages).

##### **Example of `protected` access modifier:**

```java
class Animal {
    protected String species;  // Protected field

    protected void makeSound() {  // Protected method
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void displaySpecies() {
        System.out.println("Species: " + species);  // Accessing protected field in subclass
        makeSound();  // Accessing protected method in subclass
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.displaySpecies();  // Output: Species: null, Animal makes a sound
    }
}
```

- The **`species`** field and **`makeSound()`** method are accessible in the **`Dog`** subclass because they are `protected`. If another class outside the package tries to access them directly, it would not be allowed.

---

#### **4. `public` Access Modifier**

- **Visibility**: A member with the `public` access modifier is accessible from **any class** and **any package**. This is the **least restrictive** access level.
- **Use Case**: This is used when you want a member to be accessible from anywhere, such as when you're building APIs or exposing functionality for public use.
- **Access Level**: **Accessible from anywhere**, both within the same package and outside of the package.

##### **Example of `public` access modifier:**

```java
public class Car {
    public String model;  // Public field

    public void startEngine() {  // Public method
        System.out.println("Engine started");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.model = "Toyota";  // Accessing public field
        car.startEngine();     // Accessing public method
    }
}
```

- The `model` field and `startEngine()` method are **public**, meaning they can be accessed from anywhere.

---

### **Comparison of Access Modifiers**

| **Access Modifier** | **Visibility**                                                         | **Use Case**                                      |
|---------------------|-------------------------------------------------------------------------|--------------------------------------------------|
| **`private`**        | Accessible only within the **same class**.                              | To hide implementation details, prevent outside access. |
| **`default`**        | Accessible within the **same package** (package-private).               | For classes that should be used only within the package. |
| **`protected`**      | Accessible within the **same package** and by **subclasses** (even in different packages). | For allowing access to subclasses, but limiting outside access. |
| **`public`**         | Accessible from **any class** in **any package**.                       | For members that should be globally accessible. |

---

### **Key Points to Remember:**

- **`private`** is the most restrictive and hides members from all other classes, including subclasses.
- **`default`** (no modifier) restricts access to the same package.
- **`protected`** allows access within the same package and by subclasses, even if they are in different packages.
- **`public`** is the least restrictive and allows access from anywhere.

---

### **Summary of Access Modifiers:**

| **Access Modifier** | **Description**                                                                 | **Access Level**                                      |
|---------------------|---------------------------------------------------------------------------------|------------------------------------------------------|
| **`private`**        | Restricts access to the same class only.                                         | Class only.                                           |
| **`default`**        | Restricts access to the same package only (no modifier).                        | Same package.                                         |
| **`protected`**      | Allows access within the same package and by subclasses (even in different packages). | Same package and subclasses.                         |
| **`public`**         | Allows access from anywhere (any class, any package).                           | Anywhere.                                             |

---


### **17. Abstraction in Java**

Abstraction is one of the core principles of Object-Oriented Programming (OOP). It allows you to **hide the implementation details** of a class and show only the necessary features or functionalities. In Java, **abstraction** is achieved through **abstract classes** and **interfaces**.

Abstraction helps reduce complexity and allows the programmer to focus on the **essential features** of an object, ignoring the irrelevant details.

---

### **17.1. Types of Abstraction**

There are **two ways** to achieve abstraction in Java:

1. **Abstract Classes** (Using the `abstract` keyword)
2. **Interfaces**

---

#### **17.2. Abstract Class**

An **abstract class** is a class that cannot be instantiated on its own. It can contain both **abstract methods** (methods without implementation) and **concrete methods** (methods with implementation).

- **Abstract Methods**: These are methods declared in an abstract class but without a body. Subclasses must provide an implementation for these methods.
- **Concrete Methods**: These are regular methods with a body that can be inherited and used as-is by subclasses.

##### **Key Characteristics of Abstract Classes**:
- You cannot create an object of an abstract class.
- An abstract class can have both abstract and concrete methods.
- A class that extends an abstract class must provide implementations for all abstract methods unless it is also abstract.

##### **Syntax of Abstract Class:**

```java
abstract class Animal {
    abstract void makeSound();  // Abstract method

    void sleep() {  // Concrete method
        System.out.println("This animal sleeps");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class Main {
    public static void main(String[] args) {
        // Animal animal = new Animal();  // Error: Cannot instantiate abstract class
        Dog dog = new Dog();
        dog.makeSound();  // Output: Bark
        dog.sleep();      // Output: This animal sleeps
    }
}
```

#### **Advantages of Abstract Classes**:
1. **Code Reusability**: You can provide common method implementations that can be reused by subclasses.
2. **Partial Implementation**: You can provide partial implementation of methods, which subclasses can override.
3. **Inheritance**: Abstract classes can be extended by subclasses, making them a foundation for common behavior.

---

#### **17.3. Interface**

An **interface** is a reference type in Java, similar to a class, that can contain only **abstract methods** (before Java 8) and **default methods** (since Java 8), along with **constant variables**. An interface provides a contract for the classes that implement it, ensuring they provide implementations for the methods defined in the interface.

- **Methods in an Interface**: By default, all methods in an interface are **abstract** (until Java 8). From Java 8 onwards, interfaces can also contain **default methods** (methods with a body).
- **Variables in an Interface**: All variables in an interface are **public, static, and final** by default (constants).

##### **Key Characteristics of Interfaces**:
- An interface cannot have constructors.
- A class can implement multiple interfaces (Java supports **multiple inheritance** through interfaces).
- A class that implements an interface must provide an implementation for all the methods of the interface.

##### **Syntax of Interface:**

```java
interface Animal {
    void makeSound();  // Abstract method (no body)

    default void sleep() {  // Default method with implementation
        System.out.println("This animal sleeps");
    }
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();  // Output: Bark
        dog.sleep();      // Output: This animal sleeps
    }
}
```

#### **Advantages of Interfaces**:
1. **Multiple Inheritance**: Java allows a class to implement multiple interfaces, providing a form of multiple inheritance.
2. **Loose Coupling**: Interfaces allow classes to communicate with each other without knowing the implementation details.
3. **Flexibility**: Interfaces allow classes to follow a contract for method signatures, providing flexibility and extensibility.

---

### **17.4. Abstract Class vs Interface**

While both **abstract classes** and **interfaces** provide a way to achieve abstraction, they differ in several important ways.

| **Feature**                 | **Abstract Class**                                      | **Interface**                                               |
|-----------------------------|---------------------------------------------------------|-------------------------------------------------------------|
| **Methods**                 | Can have both abstract and concrete methods            | Can only have abstract methods (before Java 8), and default methods (since Java 8) |
| **Multiple Inheritance**    | A class can inherit from only **one abstract class**    | A class can implement **multiple interfaces**                |
| **Fields**                  | Can have instance fields and constructors              | Can have only **static final** variables (constants)         |
| **Access Modifiers**        | Can have any access modifier (private, protected, etc.) | Methods in an interface are **public** by default            |
| **Use Case**                | Used when you need to provide common implementation and state | Used when you want to provide a contract for classes to follow without enforcing a common implementation |

---

### **17.5. Benefits of Abstraction**

1. **Hides Complexity**: Abstraction hides the complex implementation details and exposes only the necessary functionality.
2. **Improves Code Readability**: By focusing only on essential aspects, abstraction simplifies the interface and makes the code more readable.
3. **Loose Coupling**: It reduces the dependency between different parts of the system, making it easier to change or replace parts without affecting others.
4. **Code Reusability**: Common functionality can be implemented in abstract classes or interfaces, promoting reuse in subclasses.

---

### **17.6. When to Use Abstraction**

- **Use Abstract Classes** when you want to share code among several closely related classes and allow some methods to have a default implementation.
- **Use Interfaces** when you want to define a contract for what a class can do, without enforcing any particular way of doing it, and especially when you need to support multiple inheritance.

---

### **Summary of Abstraction:**

| **Concept**               | **Abstract Class**                                | **Interface**                                        |
|---------------------------|---------------------------------------------------|------------------------------------------------------|
| **Purpose**                | To provide partial implementation and allow inheritance. | To define a contract that must be implemented by classes. |
| **Methods**                | Can have both abstract and concrete methods.      | Can only have abstract methods (before Java 8) and default methods (since Java 8). |
| **Multiple Inheritance**   | No, only single inheritance.                     | Yes, multiple interfaces can be implemented.          |
| **Use Case**               | For shared behavior and partial implementation.   | For defining a contract and achieving loose coupling. |

---

Abstraction is a fundamental concept in object-oriented programming that helps to design flexible, reusable, and maintainable systems. It allows the developer to focus on **what** an object does rather than **how** it does it, promoting cleaner code and better system design.

---



### **18. Multiple Inheritance Using Interface in Java**

In Java, **multiple inheritance** is the ability of a class to inherit from more than one class. However, Java does not support multiple inheritance with **classes** directly, as this can lead to complexities such as the **diamond problem**. To address this limitation, Java allows multiple inheritance through **interfaces**.

In Java, a class can implement multiple interfaces, which means it can inherit the behaviors (methods) defined in multiple interfaces. This approach allows Java to support **multiple inheritance** without the issues associated with inheriting from multiple classes.

---

### **18.1. Why Java Does Not Allow Multiple Inheritance with Classes**

Java avoids multiple inheritance with classes because it can lead to ambiguity when a class inherits methods from more than one parent class. Consider the **diamond problem**, where two parent classes have a method with the same signature. If a subclass inherits from both parent classes, it becomes unclear which method to use.

#### **Example of Diamond Problem:**

```java
class A {
    void show() {
        System.out.println("Class A");
    }
}

class B extends A {
    void show() {
        System.out.println("Class B");
    }
}

class C extends A {
    void show() {
        System.out.println("Class C");
    }
}

class D extends B, C {  // Error: Cannot extend multiple classes
    void display() {
        // Which show() method should be called here?
    }
}
```

In the above example, class `D` is inheriting from both `B` and `C`. But both `B` and `C` have a `show()` method. The compiler wouldn’t know which `show()` method to call, leading to ambiguity.

---

### **18.2. Multiple Inheritance Using Interfaces**

In contrast, Java allows multiple inheritance using **interfaces**. A class can implement multiple interfaces, and thus, it can inherit abstract methods from more than one interface. This avoids the ambiguity found in the diamond problem because the methods in the interfaces do not have implementation details, and the class is responsible for providing the implementation.

#### **How Multiple Inheritance Works with Interfaces:**
- A **class** can implement multiple **interfaces**, inheriting their abstract methods.
- An **interface** can extend multiple **interfaces**, allowing a subclass to inherit methods from multiple interfaces.
- Interfaces can only declare abstract methods, so the implementation responsibility lies with the **class** that implements the interfaces.

---

### **18.3. Example of Multiple Inheritance Using Interfaces**

```java
interface Animal {
    void eat();  // Abstract method
}

interface Vehicle {
    void move();  // Abstract method
}

class AnimalCar implements Animal, Vehicle {  // Implementing both interfaces
    @Override
    public void eat() {
        System.out.println("Eating food");
    }

    @Override
    public void move() {
        System.out.println("Moving forward");
    }
}

public class Main {
    public static void main(String[] args) {
        AnimalCar animalCar = new AnimalCar();
        animalCar.eat();  // Output: Eating food
        animalCar.move(); // Output: Moving forward
    }
}
```

#### **Explanation of the Example:**

- **Animal** and **Vehicle** are two interfaces, each declaring one abstract method.
- **AnimalCar** is a class that **implements both interfaces**, providing concrete implementations of both `eat()` (from `Animal`) and `move()` (from `Vehicle`).
- The **class** `AnimalCar` can now inherit methods from **both** interfaces, thus demonstrating multiple inheritance.

---

### **18.4. Multiple Inheritance with Interfaces and Default Methods**

In Java 8 and later, interfaces can also have **default methods**—methods that provide a default implementation. If a class implements multiple interfaces, and the interfaces have conflicting default methods, the class must explicitly override the method.

#### **Example with Conflicting Default Methods:**

```java
interface Animal {
    default void sound() {
        System.out.println("Animal makes a sound");
    }
}

interface Dog {
    default void sound() {
        System.out.println("Dog barks");
    }
}

class Pet implements Animal, Dog {
    @Override
    public void sound() {
        // Resolving conflict by overriding the method in the class
        System.out.println("Pet makes a sound");
    }
}

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.sound();  // Output: Pet makes a sound
    }
}
```

#### **Explanation:**

- Both the `Animal` and `Dog` interfaces define a default method `sound()`.
- The `Pet` class implements both interfaces, and since both interfaces have conflicting default implementations, `Pet` provides its own `sound()` method to resolve the conflict.

#### **Java's Handling of Method Conflicts:**

- If multiple interfaces provide a **default method** with the same signature, the **implementing class** must override the method to resolve the conflict.
- This is different from class inheritance, where the compiler cannot resolve conflicts automatically.

---

### **18.5. Multiple Inheritance in Java: Advantages and Limitations**

#### **Advantages:**

1. **Avoids Diamond Problem**: Java’s interface-based multiple inheritance avoids issues like the diamond problem, which is common in class inheritance.
2. **Flexibility**: Allows a class to inherit behavior from multiple sources (interfaces) while still being able to provide its own implementation.
3. **Loose Coupling**: Interfaces help in reducing dependencies between classes, making the system more modular and flexible.
4. **Multiple Behaviors**: A class can implement multiple interfaces to inherit different behaviors, thus increasing code reuse.

#### **Limitations:**

1. **No Field Inheritance**: Interfaces cannot have instance fields (variables), only constants. This limits the sharing of state between classes.
2. **Method Conflict Resolution**: If two interfaces provide default methods with the same signature, the implementing class must resolve the conflict by overriding the method.
3. **No Constructor in Interfaces**: Interfaces cannot have constructors. This limits their ability to control the creation of objects.

---

### **18.6. Summary of Multiple Inheritance Using Interfaces**

| **Feature**                         | **Multiple Inheritance in Classes** | **Multiple Inheritance in Interfaces** |
|-------------------------------------|------------------------------------|---------------------------------------|
| **Support**                         | Not supported (leads to ambiguity, e.g., diamond problem) | Supported, a class can implement multiple interfaces |
| **Method Conflicts**                | Leads to ambiguity when multiple parent classes have the same method signature | Can occur when interfaces have conflicting default methods, resolved by overriding in the implementing class |
| **Fields**                          | Inherited fields can cause ambiguity | No instance fields in interfaces; only constants (static final variables) |
| **Constructor**                     | Classes can have constructors | Interfaces cannot have constructors |
| **Use Case**                        | Not applicable | Use when you need to implement behaviors from multiple sources |

---

### **Conclusion:**

Java supports **multiple inheritance** through interfaces, allowing a class to implement more than one interface. While it does not support multiple inheritance through classes (to avoid issues like the diamond problem), interfaces offer a clean way to inherit behaviors from multiple sources without the associated complexities.

- **Multiple inheritance using interfaces** provides flexibility and avoids the problems of conflicting state, making it an essential feature for designing robust and modular applications.
---



### **19. Abstract Class vs Interface in Java**

In Java, both **abstract classes** and **interfaces** are used to achieve **abstraction**, allowing you to define methods that can be implemented by other classes. However, they differ significantly in their purpose, capabilities, and usage. Let's explore the key differences and when to use each.

---

### **19.1. Key Differences Between Abstract Class and Interface**

| **Feature**                 | **Abstract Class**                                       | **Interface**                                             |
|-----------------------------|----------------------------------------------------------|-----------------------------------------------------------|
| **Purpose**                 | To represent a common base for related classes, with the ability to provide some method implementations. | To define a contract for classes to follow, focusing only on the signatures of methods (before Java 8). |
| **Methods**                 | Can have both **abstract** methods (without a body) and **concrete** methods (with a body). | By default, methods are **abstract** (without a body), but since Java 8, interfaces can have **default** and **static** methods. |
| **Instance Variables**      | Can have **instance variables** (fields) that can be initialized in the constructor. | Can only have **public static final variables** (constants). Variables in interfaces are **implicitly final**, **static**, and **public**. |
| **Constructors**            | Can have **constructors** to initialize fields in the abstract class. | **Cannot** have constructors. Interfaces cannot create objects directly. |
| **Multiple Inheritance**    | A class can **extend only one abstract class** (single inheritance). | A class can **implement multiple interfaces** (multiple inheritance). |
| **Access Modifiers**        | Methods and fields can have various access modifiers (**private**, **protected**, **public**). | Methods are **public** by default; fields are **public static final** by default. |
| **Implementation**          | An abstract class can provide partial implementation for its methods. Subclasses can choose to override or use the implementation. | An interface **cannot provide method implementations** (except default methods in Java 8+), so implementing classes must provide the method implementations. |
| **Extending**               | A class can **extend only one abstract class** (no multiple inheritance). | A class can **implement multiple interfaces** (supports multiple inheritance). |
| **Use Case**                | Use when there is a common base class that may have some default behavior (method implementation) and also needs to be extended by other classes. | Use when you want to define a contract or capability that can be adopted by any class, without enforcing a specific implementation. |

---

### **19.2. Detailed Comparison**

#### **1. Purpose**

- **Abstract Class**: An abstract class is used when you have a base class that shares common behavior among its subclasses but still needs to leave some methods unimplemented. You can provide default behavior for some methods, while others remain abstract and must be implemented by the subclass.

- **Interface**: An interface is used to define a **contract** or **set of methods** that a class must implement. Interfaces focus only on the method **signatures** without providing any implementation details (except for default methods in Java 8 and later).

#### **2. Methods**

- **Abstract Class**: It can have **abstract methods** (without implementation) and **concrete methods** (with implementation). Abstract methods need to be overridden by subclasses, but concrete methods are inherited as is.

- **Interface**: Before Java 8, all methods in an interface were **abstract** (without a body), meaning implementing classes must provide the method implementation. From Java 8 onwards, interfaces can have **default methods** (methods with a body) and **static methods**, but still, the main purpose of an interface is to define method signatures that implementing classes must fulfill.

#### **3. Fields (Variables)**

- **Abstract Class**: Can have **instance fields** (variables) that can be initialized in the constructor or during declaration. Fields can have different access modifiers like `private`, `protected`, or `public`.

- **Interface**: Can only have **public static final variables** (constants). These are implicitly `public`, `static`, and `final` by default. You cannot have instance variables in an interface.

#### **4. Constructors**

- **Abstract Class**: Can have **constructors**, which are called when a subclass is instantiated. The abstract class can initialize some fields, and the subclass can call the superclass constructor using `super()`.

- **Interface**: Cannot have **constructors**. Interfaces are not meant to create objects; they are just contracts that are implemented by classes.

#### **5. Multiple Inheritance**

- **Abstract Class**: Java supports **single inheritance** when using abstract classes. A class can **extend only one abstract class**. This limitation is due to the potential complexity of multiple inheritance with classes.

- **Interface**: Java supports **multiple inheritance** with interfaces. A class can **implement multiple interfaces**, allowing it to inherit behaviors from more than one interface.

#### **6. Implementation Details**

- **Abstract Class**: An abstract class can provide **some implementation**, which can be used directly by subclasses or can be overridden if needed. This provides flexibility.

- **Interface**: An interface does not provide any method implementation (except default methods from Java 8 onwards). Implementing classes must provide concrete implementations for all methods declared in the interface (unless the class is abstract).

#### **7. Access Modifiers**

- **Abstract Class**: Methods and fields in an abstract class can have various **access modifiers** (e.g., `private`, `protected`, or `public`). This allows greater flexibility in controlling the accessibility of class members.

- **Interface**: Methods in an interface are **implicitly `public`**, and fields are **implicitly `public static final`**. Interfaces define a contract that is expected to be used universally, so they are restricted to being accessible publicly.

---

### **19.3. Examples**

#### **Abstract Class Example**

```java
abstract class Animal {
    String name;

    // Concrete method
    void eat() {
        System.out.println(name + " is eating.");
    }

    // Abstract method (must be implemented by subclasses)
    abstract void sound();
}

class Dog extends Animal {
    Dog(String name) {
        this.name = name;
    }

    // Implementing the abstract method
    @Override
    void sound() {
        System.out.println(name + " barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        dog.eat();   // Output: Buddy is eating.
        dog.sound(); // Output: Buddy barks.
    }
}
```

#### **Interface Example**

```java
interface Animal {
    void eat(); // Abstract method (without a body)
}

interface Mammal {
    void breathe(); // Abstract method (without a body)
}

class Dog implements Animal, Mammal {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void breathe() {
        System.out.println("Dog is breathing.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();    // Output: Dog is eating.
        dog.breathe(); // Output: Dog is breathing.
    }
}
```

---

### **19.4. When to Use Abstract Class vs Interface**

#### **Use an Abstract Class when:**

- You have common code that you want to share among related classes.
- You want to provide some default implementation that can be overridden in subclasses.
- You want to use instance fields and constructors.
- You want to represent a relationship between classes where one class shares common behavior with others.

#### **Use an Interface when:**

- You want to define a contract that can be implemented by any class, regardless of the class hierarchy.
- You need to allow **multiple inheritance** (a class can implement multiple interfaces).
- You need to define behavior that can be shared across different, unrelated class hierarchies.
- You want to support polymorphism by allowing classes to implement several different behaviors.

---

### **19.5. Summary: Abstract Class vs Interface**

| **Feature**                 | **Abstract Class**                                       | **Interface**                                             |
|-----------------------------|----------------------------------------------------------|-----------------------------------------------------------|
| **Purpose**                 | To provide a common base for related classes, with some default behavior. | To define a contract for behaviors, allowing any class to implement the methods. |
| **Methods**                 | Can have both abstract and concrete methods.             | Primarily abstract methods; default methods are allowed since Java 8. |
| **Instance Variables**      | Can have instance fields and constructors.               | Can have only static final variables (constants). |
| **Constructors**            | Can have constructors.                                   | Cannot have constructors. |
| **Multiple Inheritance**    | No (Single inheritance).                                 | Yes (Multiple inheritance). |
| **Access Modifiers**        | Methods and fields can have different access modifiers.  | Methods are implicitly public. Fields are public, static, and final. |
| **Use Case**                | When you need to provide common functionality and shared state for subclasses. | When you need to define a contract or behavior that can be implemented by unrelated classes. |

---

Both **abstract classes** and **interfaces** are essential tools in Java, each suited to different scenarios based on the design requirements. Choosing between them depends on whether you need shared behavior with implementation (abstract class) or just a contract for method signatures (interface).
---

### **20. Functional Interface in Java**

A **functional interface** in Java is an interface that has exactly **one abstract method**. It can have multiple **default** or **static methods**, but it must have only one abstract method. Functional interfaces are the foundation for **lambda expressions** and **method references** in Java, introduced in **Java 8**. They allow you to treat instances of these interfaces as **first-class citizens**, meaning they can be passed around and used in expressions.

---

### **20.1. Characteristics of Functional Interfaces**

- **One Abstract Method**: A functional interface must have exactly one abstract method, but it can have multiple **default** or **static** methods.
  
- **`@FunctionalInterface` Annotation**: This is an optional annotation that marks an interface as a functional interface. It helps to catch errors at compile time if the interface violates the rule of having exactly one abstract method.

- **Used with Lambda Expressions**: Functional interfaces are widely used with **lambda expressions**, which provide a clear and concise way to represent an instance of a functional interface.

---

### **20.2. Syntax of Functional Interface**

Here is an example of a **functional interface**:

```java
@FunctionalInterface
interface MyFunctionalInterface {
    // Single abstract method
    void sayHello();
    
    // Default method
    default void sayGoodbye() {
        System.out.println("Goodbye!");
    }

    // Static method
    static void greet() {
        System.out.println("Hello from static method!");
    }
}
```

In the above example:
- `sayHello()` is the **abstract method**, and it is the only method that must be implemented by a class or lambda expression.
- `sayGoodbye()` is a **default method** (it has a body, so it's not abstract).
- `greet()` is a **static method** (it can be called without creating an instance).

---

### **20.3. Example Using Lambda Expression**

A **lambda expression** is a shorthand way of implementing the **abstract method** of a functional interface. Here's how you can use a functional interface with a lambda expression:

```java
public class Main {
    public static void main(String[] args) {
        // Using lambda expression to provide implementation of abstract method
        MyFunctionalInterface myFunc = () -> System.out.println("Hello from Lambda!");
        
        // Calling the abstract method
        myFunc.sayHello();  // Output: Hello from Lambda!

        // Calling the default method
        myFunc.sayGoodbye();  // Output: Goodbye!

        // Calling the static method
        MyFunctionalInterface.greet();  // Output: Hello from static method!
    }
}
```

#### **Explanation:**
- The **lambda expression** `() -> System.out.println("Hello from Lambda!")` provides the implementation for the `sayHello()` method of the interface `MyFunctionalInterface`.
- `myFunc.sayGoodbye()` calls the **default method** in the interface.
- `MyFunctionalInterface.greet()` calls the **static method** in the interface.

---

### **20.4. Common Built-in Functional Interfaces**

Java provides several built-in functional interfaces in the **`java.util.function`** package. Some of the most common functional interfaces are:

1. **`Runnable`**:
   - It is a functional interface with the abstract method `run()`, which takes no arguments and returns no result.
   - It is commonly used in multithreading.

   ```java
   Runnable r = () -> System.out.println("Running in a separate thread");
   r.run();  // Output: Running in a separate thread
   ```

2. **`Consumer<T>`**:
   - It represents an operation that takes a single argument of type `T` and returns no result.
   - It is commonly used for operations that perform side effects.

   ```java
   Consumer<String> consumer = str -> System.out.println(str.toUpperCase());
   consumer.accept("hello");  // Output: HELLO
   ```

3. **`Supplier<T>`**:
   - It represents a supplier of results of type `T`. It takes no arguments and returns a value of type `T`.
   
   ```java
   Supplier<String> supplier = () -> "Hello, Supplier!";
   System.out.println(supplier.get());  // Output: Hello, Supplier!
   ```

4. **`Function<T, R>`**:
   - It takes an argument of type `T` and returns a result of type `R`.
   - It is used to transform one type to another.

   ```java
   Function<Integer, String> function = num -> "Number: " + num;
   System.out.println(function.apply(10));  // Output: Number: 10
   ```

5. **`Predicate<T>`**:
   - It represents a boolean-valued function of one argument, `T`.
   - It is often used for filtering or matching conditions.

   ```java
   Predicate<Integer> isEven = num -> num % 2 == 0;
   System.out.println(isEven.test(4));  // Output: true
   System.out.println(isEven.test(5));  // Output: false
   ```

---

### **20.5. Benefits of Functional Interfaces**

1. **Concise Code**: With lambda expressions, functional interfaces allow you to write more concise, readable, and maintainable code.
   
2. **Encourages Functional Programming**: Functional interfaces promote functional programming patterns by treating functions as first-class objects that can be passed around.

3. **More Flexible and Modular**: They allow for more flexible, modular, and reusable code by decoupling behavior from the implementation of classes.

4. **Enhanced Parallelism**: Functional interfaces, when used in conjunction with streams and lambdas, enable easier parallel processing in Java.

---

### **20.6. `@FunctionalInterface` Annotation**

The **`@FunctionalInterface`** annotation is used to mark an interface as a functional interface. It is optional but serves as documentation and helps the compiler catch errors if the interface does not meet the requirements of a functional interface.

```java
@FunctionalInterface
interface MyFunctionalInterface {
    void doSomething();

    // The following will cause a compile-time error because a functional interface can have only one abstract method.
    // void doSomethingElse();
}
```

- If you attempt to add a second abstract method to a functional interface, the compiler will raise an error. The `@FunctionalInterface` annotation helps identify such issues at compile time.

---

### **20.7. Summary of Functional Interface**

| **Feature**                | **Functional Interface**                                      |
|----------------------------|---------------------------------------------------------------|
| **Abstract Methods**        | Exactly **one** abstract method.                              |
| **Default Methods**         | Can have **default methods** (with implementations).         |
| **Static Methods**          | Can have **static methods**.                                  |
| **Annotation**              | **`@FunctionalInterface`** annotation is optional but helps identify functional interfaces. |
| **Usage**                   | Used extensively with **lambda expressions** and **method references** to pass behavior as arguments. |
| **Multiple Abstract Methods** | **Not allowed** (would cause a compile-time error).           |

---

### **20.8. Conclusion**

A **functional interface** is an interface that has exactly one abstract method and is designed to be used with **lambda expressions** and **method references**. It provides a powerful mechanism for functional programming in Java. The introduction of functional interfaces in **Java 8** has made it easier to write clean, concise, and expressive code, especially when working with streams and other functional programming constructs.

---


### **21. Lambda Expressions in Java**

A **lambda expression** in Java is a concise way to represent an instance of a functional interface. Lambda expressions allow you to express instances of single-method interfaces (functional interfaces) in a more readable and compact form. They were introduced in **Java 8** to enable functional programming features, making code more concise and easier to work with.

---

### **21.1. Syntax of Lambda Expressions**

A lambda expression consists of three main parts:

1. **Parameters** (optional): The input parameters to the lambda expression.
2. **Arrow Token (`->`)**: Separates the parameters from the body.
3. **Body**: Defines the action or behavior to be performed.

The basic syntax is:

```java
(parameters) -> expression
```

If the lambda expression contains more than one statement, the body must be enclosed in curly braces:

```java
(parameters) -> { statements }
```

---

### **21.2. Examples of Lambda Expressions**

#### **1. No Parameters**

If the lambda expression has no parameters, the syntax looks like this:

```java
Runnable r = () -> System.out.println("Hello, World!");
r.run();  // Output: Hello, World!
```

- **Explanation**: 
  - `Runnable` is a functional interface with a single method `run()`, which takes no parameters and returns no result.
  - The lambda expression `() -> System.out.println("Hello, World!")` provides the implementation for the `run()` method.

#### **2. One Parameter**

If the lambda expression has one parameter, the parentheses can be omitted:

```java
Consumer<String> printMessage = message -> System.out.println(message);
printMessage.accept("Hello, Lambda!");  // Output: Hello, Lambda!
```

- **Explanation**: 
  - `Consumer<String>` is a functional interface with a method `accept(T t)` that takes one argument and returns no result.
  - The lambda expression `message -> System.out.println(message)` provides the implementation for the `accept()` method.

#### **3. Multiple Parameters**

When the lambda expression has more than one parameter, the parameters are enclosed in parentheses:

```java
BinaryOperator<Integer> add = (a, b) -> a + b;
System.out.println(add.apply(5, 3));  // Output: 8
```

- **Explanation**: 
  - `BinaryOperator<Integer>` is a functional interface that represents an operation on two operands of the same type.
  - The lambda expression `(a, b) -> a + b` provides the implementation for the `apply()` method, which adds the two operands.

#### **4. Multiple Statements in the Body**

If the lambda expression contains more than one statement, the body must be enclosed in curly braces `{}`:

```java
Function<Integer, Integer> square = (a) -> {
    System.out.println("Calculating square...");
    return a * a;
};

System.out.println(square.apply(4));  // Output: Calculating square... \n 16
```

- **Explanation**: 
  - `Function<Integer, Integer>` is a functional interface that takes a single input and returns a result.
  - The lambda expression `(a) -> { System.out.println("Calculating square..."); return a * a; }` calculates the square of the input value.

---

### **21.3. Types of Lambda Expressions**

Lambda expressions can be categorized based on the number of parameters and the type of method they represent.

1. **No Parameter Lambda Expression**:

   ```java
   Runnable r = () -> System.out.println("Hello!");
   ```

2. **One Parameter Lambda Expression**:

   ```java
   Consumer<String> printMessage = message -> System.out.println(message);
   ```

3. **Multiple Parameters Lambda Expression**:

   ```java
   BinaryOperator<Integer> add = (a, b) -> a + b;
   ```

---

### **21.4. Functional Interfaces with Lambda Expressions**

Lambda expressions are primarily used with **functional interfaces**, which have only one abstract method. Here's how lambda expressions are commonly used with different functional interfaces.

#### **1. `Runnable` Interface**

`Runnable` represents a task that can be executed asynchronously in a separate thread.

```java
Runnable task = () -> System.out.println("Running in a separate thread.");
task.run();  // Output: Running in a separate thread.
```

#### **2. `Consumer<T>` Interface**

`Consumer<T>` accepts an argument and returns no result.

```java
Consumer<String> printMessage = message -> System.out.println(message);
printMessage.accept("Lambda Expressions are cool!");  // Output: Lambda Expressions are cool!
```

#### **3. `Function<T, R>` Interface**

`Function<T, R>` accepts an argument of type `T` and returns a result of type `R`.

```java
Function<Integer, String> square = x -> "Square: " + (x * x);
System.out.println(square.apply(4));  // Output: Square: 16
```

#### **4. `Predicate<T>` Interface**

`Predicate<T>` represents a boolean-valued function of one argument.

```java
Predicate<Integer> isEven = x -> x % 2 == 0;
System.out.println(isEven.test(4));  // Output: true
System.out.println(isEven.test(5));  // Output: false
```

#### **5. `Supplier<T>` Interface**

`Supplier<T>` provides a result of type `T` without taking any arguments.

```java
Supplier<String> getMessage = () -> "Hello from Supplier!";
System.out.println(getMessage.get());  // Output: Hello from Supplier!
```

---

### **21.5. Method References vs. Lambda Expressions**

While lambda expressions provide a concise way to implement methods, **method references** can be used to refer directly to a method (existing method) of a class or instance. It makes the code even more concise.

#### **Syntax of Method References**

There are four types of method references:

1. **Static Method Reference**:
   ```java
   class Example {
       static void printMessage(String message) {
           System.out.println(message);
       }
   }

   public class Main {
       public static void main(String[] args) {
           // Using method reference
           Consumer<String> printMessage = Example::printMessage;
           printMessage.accept("Hello, Method Reference!");
       }
   }
   ```

2. **Instance Method Reference**:
   ```java
   class Example {
       void printMessage(String message) {
           System.out.println(message);
       }
   }

   public class Main {
       public static void main(String[] args) {
           Example example = new Example();
           // Using method reference
           Consumer<String> printMessage = example::printMessage;
           printMessage.accept("Hello, Instance Method Reference!");
       }
   }
   ```

3. **Constructor Reference**:
   ```java
   class Example {
       Example(String message) {
           System.out.println(message);
       }
   }

   public class Main {
       public static void main(String[] args) {
           // Using constructor reference
           Function<String, Example> createExample = Example::new;
           createExample.apply("Hello from Constructor Reference!");
       }
   }
   ```

4. **Reference to an Instance Method of an Arbitrary Object of a Particular Type**:
   ```java
   List<String> list = Arrays.asList("apple", "banana", "cherry");
   // Using method reference to sort list
   list.sort(String::compareToIgnoreCase);
   list.forEach(System.out::println);  // Output: apple, banana, cherry
   ```

---

### **21.6. Benefits of Lambda Expressions**

1. **Concise and Readable Code**: Lambda expressions allow for cleaner and more concise code, especially when working with functional interfaces.

2. **More Flexible and Functional Programming**: They enable a more **functional programming** style by allowing functions to be passed around as arguments.

3. **Parallelism and Streams**: Lambda expressions work seamlessly with **streams** and **parallel operations**, which make operations like filtering, mapping, and reducing much easier to implement.

4. **Eliminate Boilerplate Code**: Lambda expressions remove the need for writing verbose anonymous class implementations.

---

### **21.7. Summary**

| **Feature**                  | **Lambda Expressions**                                   |
|------------------------------|-----------------------------------------------------------|
| **Syntax**                   | `(parameters) -> expression`                             |
| **Main Use**                 | Implementing functional interfaces with a concise and readable syntax. |
| **Functional Interfaces**    | Can be used with interfaces having exactly **one abstract method**. |
| **Common Interfaces**        | `Runnable`, `Consumer`, `Function`, `Predicate`, `Supplier`, etc. |
| **Method References**        | Alternative to lambdas for referring to methods directly. |
| **Benefits**                 | Concise, readable, eliminates boilerplate, promotes functional programming. |

---

### **21.8. Conclusion**

Lambda expressions in Java provide a powerful way to express behavior as code, making it more concise and easier to read. By enabling the use of **functional interfaces** with lambda expressions and **method references**, Java has adopted many principles of **functional programming**, leading to more efficient and flexible code.
---


### **22. Encapsulation in Java**

**Encapsulation** is one of the fundamental concepts of **Object-Oriented Programming (OOP)**. It is the technique of bundling or grouping related data (variables) and methods (functions) that operate on the data into a single unit called a **class**. Encapsulation helps to hide the internal details of an object and restrict direct access to its fields (data members) by providing public methods (getters and setters) to access and modify those fields. This helps in ensuring data integrity and security.

---

### **22.1. Key Concepts of Encapsulation**

1. **Private Variables**: The internal state (data members) of an object is marked as **private** so that it cannot be accessed directly from outside the class.
  
2. **Public Methods (Getters and Setters)**: The class provides **public methods** (known as getters and setters) to access and modify the private variables. These methods provide a controlled way to access and modify the data.

---

### **22.2. Benefits of Encapsulation**

1. **Data Hiding**: Encapsulation hides the internal object details from the outside world. This ensures that the data is accessed only through authorized methods.
  
2. **Improved Security**: By restricting direct access to the data, encapsulation prevents unauthorized access or modification of an object's state, ensuring better security.
  
3. **Data Integrity**: You can control how the data is modified by using setters and ensure that it is changed only in valid ways (e.g., validation checks within setters).
  
4. **Code Maintainability**: Encapsulation allows you to change the internal implementation of a class without affecting other parts of the program, making the code easier to maintain.

5. **Flexibility**: You can modify the internal implementation or logic without affecting the external code that uses the class. This helps to increase flexibility and reduce dependencies.

---

### **22.3. Example of Encapsulation**

Here is a simple example of how encapsulation is implemented in Java:

```java
class Person {
    // Private fields
    private String name;
    private int age;

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Setter method for age with validation
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an object of the Person class
        Person person = new Person();
        
        // Setting values using setter methods
        person.setName("John");
        person.setAge(25);
        
        // Getting values using getter methods
        System.out.println("Name: " + person.getName()); // Output: Name: John
        System.out.println("Age: " + person.getAge());   // Output: Age: 25
        
        // Attempting to set an invalid age
        person.setAge(-5);  // Output: Age cannot be negative
    }
}
```

#### **Explanation**:
- The `Person` class has two private fields: `name` and `age`. These fields are **not accessible** directly from outside the class.
- Public **getter** and **setter** methods are provided to access and modify the values of these fields.
- The setter method for `age` contains a **validation check** to ensure the age is not set to a negative value, ensuring **data integrity**.

---

### **22.4. Setter and Getter Methods**

- **Setter Method**: A setter method allows you to set or modify the value of a private variable.
  
- **Getter Method**: A getter method allows you to retrieve the value of a private variable.

#### **Syntax**:
```java
public class Example {
    private int number; // private field

    // Setter
    public void setNumber(int number) {
        this.number = number;
    }

    // Getter
    public int getNumber() {
        return number;
    }
}
```

- The **setter** method `setNumber()` is used to set the value of `number`.
- The **getter** method `getNumber()` is used to retrieve the value of `number`.

---

### **22.5. Encapsulation and Access Modifiers**

Encapsulation often uses **access modifiers** to control access to the fields and methods. Common access modifiers include:

1. **`private`**: The member is accessible only within the same class.
2. **`public`**: The member is accessible from anywhere.
3. **`protected`**: The member is accessible within the same package and by subclasses.
4. **`default`** (Package-private): The member is accessible only within the same package.

---

### **22.6. Encapsulation in Action: Example with Different Access Modifiers**

```java
class Employee {
    // Private fields (cannot be accessed directly from outside the class)
    private String name;
    private int salary;

    // Public method to access the private fields (getter)
    public String getName() {
        return name;
    }

    // Public method to modify the private fields (setter)
    public void setName(String name) {
        this.name = name;
    }

    // Public method to access the private fields (getter)
    public int getSalary() {
        return salary;
    }

    // Public method to modify the private fields (setter)
    public void setSalary(int salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an instance of Employee
        Employee emp = new Employee();
        
        // Setting values using setter methods
        emp.setName("Alice");
        emp.setSalary(50000);

        // Getting values using getter methods
        System.out.println("Employee Name: " + emp.getName());   // Output: Employee Name: Alice
        System.out.println("Employee Salary: " + emp.getSalary()); // Output: Employee Salary: 50000

        // Trying to set an invalid salary
        emp.setSalary(-1000);  // Output: Salary cannot be negative
    }
}
```

---

### **22.7. Importance of Encapsulation**

1. **Control Over Data**: You can control how data is accessed and modified. For example, you can ensure that a person’s age is never set to a negative value or that a bank account balance can’t be set directly.
  
2. **Reducing Complexity**: By hiding the internal workings of an object and exposing only necessary operations, encapsulation reduces the complexity of interacting with an object. Users of the object don’t need to understand its internal workings.
  
3. **Enhancing Flexibility**: If the implementation of an object needs to change (for instance, if the internal representation of a data member changes), encapsulation ensures that the rest of the program is unaffected as long as the getter and setter methods remain the same.

4. **Code Reusability and Maintainability**: Encapsulation helps you build more maintainable and reusable code. You can change the internal details of a class without affecting external code that uses it.

---

### **22.8. Encapsulation vs. Data Hiding**

While encapsulation refers to the bundling of data and methods in a single unit, **data hiding** is a concept closely related to encapsulation. **Data hiding** is achieved by making fields private and using getter and setter methods to control access. The goal is to **hide** the implementation details and expose only what is necessary.

---

### **22.9. Conclusion**

Encapsulation is a powerful feature in Java and Object-Oriented Programming. It ensures **data security**, **data integrity**, and **maintainability** of the code. By hiding the internal state of an object and providing controlled access to its properties through **getters** and **setters**, encapsulation makes it easier to write modular, reusable, and easy-to-maintain code.


---



### **23. "Is-a" vs. "Has-a" vs. "Uses-a" Relationship in Java**

In object-oriented programming (OOP), **"Is-a"**, **"Has-a"**, and **"Uses-a"** are important terms used to describe the relationships between classes. These relationships are used to model the way objects and classes interact with each other and their hierarchy. Let’s break down each one:

---

### **23.1. "Is-a" Relationship (Inheritance)**

The **"Is-a"** relationship is the most commonly used relationship in OOP and represents inheritance. It means that one class **is a type of another class**. When you say that one class "is a" another, you are describing an inheritance relationship. The subclass **inherits** the properties and behaviors of the superclass.

- **Key Concept**: Inheritance.
- **Used in**: **Single Inheritance**.

#### **Example**:
If `Dog` is a type of `Animal`, then a **Dog "is-a" Animal**.

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();  // Inherited method
        dog.bark(); // Dog-specific method
    }
}
```

- **Explanation**:
  - `Dog` **"is-a"** `Animal` because `Dog` inherits from `Animal`.
  - The `Dog` class has both its own methods and inherited methods from the `Animal` class.
  - **Inheritance** is the core concept that makes this "is-a" relationship possible.

---

### **23.2. "Has-a" Relationship (Composition)**

The **"Has-a"** relationship describes **composition** or **aggregation**. This relationship is used when one class **has an instance of another class**. In other words, an object of one class **contains** or **owns** an object of another class. Composition represents a "has-a" relationship between the two objects.

- **Key Concept**: Composition or Aggregation.
- **Used in**: **Composition (Strong relationship)** and **Aggregation (Weaker relationship)**.

#### **Example**:
A **Car** **has-a** **Engine**, meaning a car contains an engine object.

```java
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine; // "Car has an Engine"

    Car() {
        this.engine = new Engine(); // Car contains an Engine
    }

    void startCar() {
        engine.start(); // Car delegates the start operation to the Engine
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();  // Output: Engine started
    }
}
```

- **Explanation**:
  - `Car` **"has-a"** `Engine` because a `Car` object contains an `Engine` object.
  - **Composition** means the `Car` object depends on the `Engine` object, and the `Engine` cannot exist independently without the `Car`.
  - The `Car` class has a **strong relationship** with the `Engine` class, which means the `Engine` is created and managed by the `Car`.

---

### **23.3. "Uses-a" Relationship (Dependency)**

The **"Uses-a"** relationship describes **dependency**. It means that one class **uses** or **depends on** another class to perform its tasks. The **"Uses-a"** relationship doesn't necessarily imply ownership (like "Has-a") or inheritance (like "Is-a"). Instead, it indicates that a class may call methods from another class or require it to perform its functions.

- **Key Concept**: Dependency or Association.
- **Used in**: **Method parameters**, **local variables**, or **temporary dependencies**.

#### **Example**:
A **Driver** **uses-a** **Car** to drive, meaning a `Driver` interacts with a `Car` but doesn’t own it directly.

```java
class Car {
    void start() {
        System.out.println("Car started");
    }
}

class Driver {
    void drive(Car car) {
        car.start();  // Driver uses the Car object
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Driver driver = new Driver();
        driver.drive(car);  // Output: Car started
    }
}
```

- **Explanation**:
  - `Driver` **"uses-a"** `Car` because the `Driver` class interacts with the `Car` class through the `drive` method.
  - This is a **dependency** relationship because the `Driver` needs the `Car` object to perform its function, but it does not own the `Car`.
  - The relationship is more transient and less tightly coupled compared to the "Has-a" and "Is-a" relationships.

---

### **23.4. Comparison of "Is-a", "Has-a", and "Uses-a"**

| **Relationship**    | **Description**                                  | **Key Concept**         | **Example**                     |
|---------------------|--------------------------------------------------|-------------------------|---------------------------------|
| **Is-a**            | Inheritance relationship, subclass is a type of superclass. | Inheritance             | `Dog` **"is-a"** `Animal` (Dog inherits from Animal) |
| **Has-a**           | Composition or aggregation relationship, one class has another class as a part of itself. | Composition/Aggregation | `Car` **"has-a"** `Engine` (Car contains Engine) |
| **Uses-a**          | Dependency relationship, one class uses another class for a specific purpose. | Dependency/Association  | `Driver` **"uses-a"** `Car` (Driver interacts with Car) |

---

### **23.5. When to Use Each Relationship?**

1. **Use "Is-a" relationship (Inheritance)**:
   - When one class **is a type of another class** and should inherit properties and behaviors from the superclass.
   - Example: A `Dog` is an `Animal`. A `Square` is a `Shape`.

2. **Use "Has-a" relationship (Composition/Aggregation)**:
   - When one class **contains** or **owns** another class, representing a strong or weak dependency.
   - Example: A `Car` has an `Engine`. A `Library` has `Books`.

3. **Use "Uses-a" relationship (Dependency)**:
   - When one class **depends on** another class but doesn't own it.
   - Example: A `Driver` uses a `Car`. A `Shop` uses a `PaymentProcessor`.

---

### **23.6. Summary**

- **"Is-a"** describes an inheritance relationship, where one class is a specialized version of another.
- **"Has-a"** describes a composition or aggregation relationship, where one class contains or owns another.
- **"Uses-a"** describes a dependency relationship, where one class relies on another class to perform its tasks.

Each of these relationships models different aspects of real-world objects and their interactions and is crucial for designing flexible, maintainable, and efficient object-oriented systems.

---

### **1. Classes and Objects**
- **What is the difference between a class and an object in Java?**
- **How do you create an object in Java?**
- **What is a constructor in Java, and what is the difference between a constructor and a method?**
- **Can constructors be overloaded? Explain with an example.**

### **2. Local Variables vs Instance Variables**
- **What is the difference between local variables and instance variables in Java?**
- **Can local variables be initialized without a value? Why or why not?**
- **What are the default values of instance variables in Java?**

### **3. Polymorphism**
- **What is polymorphism in Java?**
- **Explain the difference between compile-time (method overloading) and run-time polymorphism (method overriding) in Java.**
- **Can we achieve polymorphism using constructors? Why or why not?**

### **4. Constructor Overloading**
- **What is constructor overloading? Can we overload constructors in Java?**
- **Can a constructor return a value? Why or why not?**

### **5. Method Overloading**
- **What is method overloading? How does it differ from method overriding?**
- **Can we overload a method based on the return type alone in Java? Why or why not?**

### **6. This Keyword**
- **What is the purpose of the `this` keyword in Java?**
- **When would you use `this` in a constructor?**
- **What is the difference between `this()` and `super()` in Java?**

### **7. Method vs Constructor**
- **What is the difference between a method and a constructor in Java?**
- **Can we call a constructor explicitly?**
- **What happens if we don’t define a constructor in a class?**

### **8. Inheritance**
- **What is inheritance in Java?**
- **What is the difference between single, multilevel, hierarchical, and hybrid inheritance in Java?**
- **What is multiple inheritance, and how is it achieved in Java?**
- **Can a subclass call a constructor of its parent class? How?**
- **Can we inherit from a final class in Java?**

### **9. Method Signature**
- **What is a method signature in Java?**
- **What components are included in a method signature?**
- **Why is method signature important for overloading and overriding?**

### **10. Run-Time Polymorphism (Method Overriding)**
- **What is method overriding, and how does it achieve run-time polymorphism?**
- **Can we override a private method in Java?**
- **What happens if a subclass method has the same signature but a different return type from the superclass method?**

### **11. This vs Super**
- **What is the difference between `this` and `super` keywords in Java?**
- **When would you use `super()` and `this()` in a constructor?**
- **Can we call a superclass constructor from a subclass? How?**

### **12. Upcasting**
- **What is upcasting in Java?**
- **Can we upcast an object to any type? Explain.**
- **What is the significance of upcasting when working with polymorphism?**

### **13. Final Keyword**
- **What is the `final` keyword in Java? How is it used with variables, methods, and classes?**
- **What happens if you declare a method as `final`?**
- **Can you inherit from a final class?**
- **What is the difference between `final`, `finally`, and `finalize` in Java?**

### **14. Method Hiding vs Method Overriding**
- **What is the difference between method hiding and method overriding?**
- **Can you hide a method in Java? Explain with an example.**
- **What is the effect of static methods on method hiding?**

### **15. Covariant Return Types**
- **What are covariant return types?**
- **How is covariant return type useful in Java?**
- **Can you have a covariant return type with an interface method?**

### **16. Final vs Static**
- **What is the difference between the `final` and `static` keywords in Java?**
- **Can a static method be overridden? Why or why not?**
- **What happens if you declare a variable as `final` and `static`?**

### **17. Access Modifiers (Private, Default, Protected, Public)**
- **What is the difference between `private`, `protected`, `default`, and `public access modifiers?**
- **Can we access a private member of a class from another class in the same package?**
- **What is the default access modifier for a class member if none is specified?**

### **18. Abstraction**
- **What is abstraction in Java, and why is it important?**
- **What is the difference between an abstract class and an interface?**
- **Can we instantiate an abstract class? Why or why not?**

### **19. Multiple Inheritance Using Interface**
- **What is the need for multiple inheritance in Java, and how is it achieved using interfaces?**
- **Can a class implement multiple interfaces in Java?**
- **What is the problem with multiple inheritance and how do interfaces solve it in Java?**

### **20. Abstract Class vs Interface**
- **What is the difference between an abstract class and an interface in Java?**
- **Can an abstract class have abstract and non-abstract methods?**
- **Can an interface have instance variables? Why or why not?**

### **21. Functional Interface**
- **What is a functional interface in Java?**
- **Can we create a functional interface with multiple abstract methods?**
- **What is the use of functional interfaces in lambda expressions?**

### **22. Lambda Expressions**
- **What are lambda expressions in Java?**
- **How does a lambda expression differ from an anonymous inner class?**
- **What is the syntax of a lambda expression?**
- **Can we use lambda expressions with any type of interface?**

### **23. Encapsulation**
- **What is encapsulation in Java, and why is it important?**
- **How do getter and setter methods support encapsulation?**
- **What is the role of access modifiers in encapsulation?**

### **24. Is-a vs Has-a vs Uses-a Relationship**
- **What is the difference between an "Is-a" and a "Has-a" relationship in Java?**
- **What does the "Uses-a" relationship mean in Java?**
- **Can you give an example of "Is-a" and "Has-a" relationships in real-world programming?**

---

### **General Interview Tips:**
1. **Understand OOP Concepts Thoroughly**: Interviewers often ask about inheritance, polymorphism, encapsulation, and abstraction.
2. **Practice Coding**: Be prepared to write code for basic algorithms, data structures, and common patterns.
3. **Explain Code**: Be able to explain your thought process and why you choose certain solutions.
4. **Behavioral Questions**: In addition to technical questions, be ready for questions about teamwork, conflict resolution, and problem-solving.

---
