
---
In this presentation, we will cover the essential Object-Oriented Programming (OOP) concepts, including key topics and definitions that are frequently asked in interviews. We will focus on the core concepts that tech companies often inquire about, such as:

- **Access Modifiers** (e.g., private, public, default, protected, static, final, abstract)
- **Classes and Objects**
- **Methods and Constructors**
- **Polymorphism** (Method Overloading, Method Overriding)
- **Encapsulation**
- **Abstraction**
- **Interfaces** and **Functional Interfaces**
- **Inheritance** and its types
- **Constructor Overloading**
- **The use of `this` and `super` keywords**

The goal is to explain **where** and **how** to apply these concepts in practice, **when** to use each one, and the key differences between them. Each topic will be explored from a basic to advanced level, ensuring a comprehensive understanding of the concepts and their applications in Java. This will equip you with the knowledge to tackle both theoretical and practical questions in interviews and real-world scenarios.

---

In Java, a **class** is a blueprint or template for creating objects (instances). It defines the properties (fields) and behaviors (methods) that the objects created from the class will have. Essentially, a class is a way to structure and organize code.

### Key points:
- **Fields** (also called attributes or properties): Variables that hold data or state for the class.
- **Methods**: Functions or actions that define the behavior of the class.
- **Constructors**: Special methods used to initialize objects of the class when they are created.

### Example of a simple class:

```java
class Car {
    // Fields
    String make;
    String model;
    int year;

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method
    public void startEngine() {
        System.out.println("The engine is now running.");
    }
}
```

Here, `Car` is a class with:
- **Fields**: `make`, `model`, and `year`
- **Constructor**: To initialize a new `Car` object with these properties
- **Method**: `startEngine()` to define behavior for the car object.

To use this class, you would create an object (an instance) of the class like this:

```java
Car myCar = new Car("Toyota", "Corolla", 2020);
myCar.startEngine();  // Output: The engine is now running.
```

---