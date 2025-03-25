LOOSE COUPLING:

To implement the interface-based approach in your code, you will need to create a common interface, `MyInterface`, which can be implemented by the `First`, `Second`, and `Third` classes. This allows you to call the `method1()` of the interface via `myinterface.method1()` in the `Second` class.

Here’s how you can refactor your code to use the `MyInterface`:

1. **Create the Interface** (`MyInterface.java`):
```java
package com.spring1;

public interface MyInterface {
    void method1();
}
```

2. **Modify the `First` class** to implement `MyInterface`:
```java
package com.spring1;

public class First implements MyInterface {
    @Override
    public void method1() {
        System.out.println("I am method1 in First");
    }
}
```

3. **Modify the `Third` class** to implement `MyInterface`:
```java
package com.spring1;

public class Third implements MyInterface {
    @Override
    public void method1() {
        System.out.println("I am method1 in Third");
    }
}
```

4. **Modify the `Second` class** to use `MyInterface`:
```java
package com.spring1;

public class Second {
    MyInterface first = new First();  // First class implements MyInterface
    MyInterface third = new Third();  // Third class implements MyInterface
    
    public static void main(String args[]) {
        Second second = new Second();
        second.method1();
    }
    
    public void method1() {
        System.out.println("I am method1 in Second");
        first.method1();  // Calls method1 from First class
        third.method1();  // Calls method1 from Third class
    }
}
```
(OR)

```java
package com.spring1;

public class Second {
    MyInterface myInterface;  // Declare the reference for MyInterface
    
    public static void main(String args[]) {
        Second second = new Second();
        second.method1();
    }
    
    public void method1() {
	System.out.println("I am method1 in Second");
        // First call
        myInterface = new First();  // Assigning an object of First class
        myInterface.method1(); // Calls method1 of First

        // Third call
        myInterface = new Third();  // Assigning an object of Third class
        myInterface.method1(); // Calls method1 of Third
    }
}

```



### Explanation:
1. **`MyInterface`** is an interface with a method `method1()`.
2. Both `First` and `Third` classes implement this interface, so they provide their specific implementation for `method1()`.
3. In the `Second` class, you declare `MyInterface first` and `MyInterface third`, which are references to objects of `First` and `Third` classes, respectively. This allows you to invoke `method1()` through the interface in `Second`.

Now, when you run the `Second` class, you will get the following output:

```
I am method1 in Second
I am method1 in First
I am method1 in Third
``` 

