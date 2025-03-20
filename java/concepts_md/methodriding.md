### **Method Overriding in Java**
**Method overriding** occurs when a **subclass provides a specific implementation** of a method that is already defined in its **superclass**. The overridden method in the child class must have the **same method signature** (same name, return type, and parameters) as the method in the parent class.

---

### **Rules for Method Overriding**
1. ✅ The method in the subclass must have **the same name, return type, and parameters** as the superclass method.
2. ✅ The method in the subclass **cannot have a lower access modifier** than the superclass method. (e.g., `public` in the superclass cannot be `private` in the subclass.)
3. ✅ The subclass method **can have a more specific return type** (called **covariant return type**).
4. ✅ **Only instance methods** can be overridden. **Static methods** and **constructors** cannot be overridden.
5. ✅ If the superclass method is `final`, it **cannot** be overridden.
6. ✅ The `@Override` annotation is optional but recommended for better code readability and error detection.

---

### **Example of Method Overriding**
```java
// Superclass
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

// Subclass
class Dog extends Animal {
    @Override
    void makeSound() {  // Overriding the method
        System.out.println("Dog barks.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        myAnimal.makeSound(); // Output: Animal makes a sound.

        Animal myDog = new Dog(); // Dynamic method dispatch (polymorphism)
        myDog.makeSound(); // Output: Dog barks.
    }
}
```

---

### **Method Overriding with Super Keyword**
The `super` keyword can be used to **call the overridden method from the superclass**.

```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        super.makeSound(); // Calling superclass method
        System.out.println("Cat meows.");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat myCat = new Cat();
        myCat.makeSound();
    }
}
```
**Output:**
```
Animal makes a sound.
Cat meows.
```

---

### **Method Overriding with Covariant Return Type (Java 5+)**
A subclass method **can return a subclass type instead of the parent type**.

```java
class Parent {
    Parent getInstance() {
        return new Parent();
    }
}

class Child extends Parent {
    @Override
    Child getInstance() {  // Covariant return type
        return new Child();
    }
}
```

---

### **Final Keyword Preventing Overriding**
If a method is declared as `final`, it **cannot** be overridden.

```java
class Parent {
    final void show() {
        System.out.println("Final method in Parent.");
    }
}

class Child extends Parent {
    // @Override
    // void show() { }  // ❌ Compilation error: Cannot override final method
}
```

---

### **Key Takeaways**
✅ **Method overriding provides runtime polymorphism** (dynamic method dispatch).  
✅ **The subclass method must have the same signature as the superclass method.**  
✅ **Use `@Override` annotation to avoid mistakes.**  
✅ **Final methods cannot be overridden.**  
✅ **Super keyword can be used to call the parent class’s method.**  

Would you like more details on **overriding vs overloading**? 🚀