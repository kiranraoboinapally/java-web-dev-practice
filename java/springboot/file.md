### **Spring Boot Project Using Stereotype Annotations** 🚀  

This is a **Spring Boot project** demonstrating the use of **stereotype annotations** (`@Component`, `@Service`, `@Repository`, `@Controller`, and `@RestController`).  

---

### **📌 Project Structure**
```
spring-stereotypes-demo/
│-- src/main/java/com/example/demo/
│   ├── DemoApplication.java         (Main Spring Boot Application)
│   ├── component/                   
│   │   ├── MyComponent.java         (@Component Example)
│   ├── service/
│   │   ├── MyService.java           (@Service Example)
│   ├── repository/
│   │   ├── MyRepository.java        (@Repository Example)
│   ├── controller/
│   │   ├── MyController.java        (@Controller Example - MVC)
│   │   ├── MyRestController.java    (@RestController Example - REST API)
│
│-- pom.xml                          (Maven Dependencies)
```

---

### **1️⃣ Main Spring Boot Application**
📌 **`DemoApplication.java`**
```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Enables @ComponentScan and AutoConfiguration
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

---

### **2️⃣ @Component Example (Generic Bean)**
📌 **`MyComponent.java`**
```java
package com.example.demo.component;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    public String getComponentMessage() {
        return "Hello from @Component!";
    }
}
```

---

### **3️⃣ @Service Example (Business Logic Layer)**
📌 **`MyService.java`**
```java
package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public String getServiceMessage() {
        return "Hello from @Service!";
    }
}
```

---

### **4️⃣ @Repository Example (Data Access Layer)**
📌 **`MyRepository.java`**
```java
package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
    public String fetchData() {
        return "Data fetched from @Repository";
    }
}
```

---

### **5️⃣ @Controller Example (Spring MVC)**
📌 **`MyController.java`**
```java
package com.example.demo.controller;

import com.example.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class MyController {
    
    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/message")
    public String showMessage(Model model) {
        model.addAttribute("message", myService.getServiceMessage());
        return "messagePage"; // This will be resolved to a Thymeleaf or JSP page
    }
}
```
- **This returns a view** (for example, a **Thymeleaf page**).

---

### **6️⃣ @RestController Example (REST API)**
📌 **`MyRestController.java`**
```java
package com.example.demo.controller;

import com.example.demo.service.MyService;
import com.example.demo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private final MyService myService;
    private final MyRepository myRepository;

    @Autowired
    public MyRestController(MyService myService, MyRepository myRepository) {
        this.myService = myService;
        this.myRepository = myRepository;
    }

    @GetMapping("/service")
    public String getServiceMessage() {
        return myService.getServiceMessage();
    }

    @GetMapping("/data")
    public String fetchData() {
        return myRepository.fetchData();
    }
}
```
- **This returns JSON responses**, like:
  ```json
  {
    "message": "Hello from @Service!"
  }
  ```

---

### **7️⃣ application.properties**
📌 **(If using Thymeleaf for MVC, otherwise not needed)**
```properties
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

---

### **8️⃣ Testing the APIs**
#### **📌 Spring MVC (`@Controller`)**
- **URL:** `http://localhost:8080/mvc/message`
- **Response:** A Thymeleaf or JSP view with the message.

#### **📌 REST API (`@RestController`)**
- **URL:** `http://localhost:8080/api/service`
  - **Response:** `"Hello from @Service!"`

- **URL:** `http://localhost:8080/api/data`
  - **Response:** `"Data fetched from @Repository"`

---

### **Conclusion**
✔ **`@Component`** → Generic Bean  
✔ **`@Service`** → Business Logic Layer  
✔ **`@Repository`** → Data Access Layer  
✔ **`@Controller`** → Spring MVC (Returns View)  
✔ **`@RestController`** → REST API (Returns JSON)  

---
