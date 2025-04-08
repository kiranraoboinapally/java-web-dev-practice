

### **Step 1: `application.properties`**

The configuration file `application.properties` to set up the database connection.

```properties
spring.datasource.url=jdbc:mysql://localhost:3030/practice
spring.datasource.username=root
spring.datasource.password=kira
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### **Step 2: `Student.java` (Entity Class)**

This is the `Student` entity class which will represent the `student` table in the database.

```java
package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private String roll;
    private String name;
    private String email;
    private String section;
    private String studentClass;

    // Getters and Setters
    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
```

### **Step 3: `Dao.java` (Repository Interface)**

The `Dao` interface extends `CrudRepository` to provide basic CRUD operations for `Student` entities.

```java
package com.demo.repository;

import com.demo.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface Dao extends CrudRepository<Student, String> {
    // Additional query methods can be added here if needed
}
```

### **Step 4: `Service.java` (Service Interface)**

The service interface that defines the contract for the service layer.

```java
package com.demo.service;

import com.demo.model.Student;
import java.util.List;

public interface Service {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentByRoll(String roll);
    void deleteStudent(String roll);
}
```

### **Step 5: `ServiceImpl.java` (Service Implementation)**

The implementation of the `Service` interface. This class handles the business logic and calls the `Dao` repository.

```java
package com.demo.service.impl;

import com.demo.model.Student;
import com.demo.repository.Dao;
import com.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements Service {

    @Autowired
    private Dao dao;

    @Override
    public Student saveStudent(Student student) {
        return dao.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) dao.findAll();
    }

    @Override
    public Student getStudentByRoll(String roll) {
        Optional<Student> student = dao.findById(roll);
        return student.orElse(null);
    }

    @Override
    public void deleteStudent(String roll) {
        dao.deleteById(roll);
    }
}
```

### **Step 6: `MyController.java` (Controller Class)**

The controller class handles HTTP requests (POST, GET, DELETE) and maps them to the appropriate service methods.

```java
package com.demo.controller;

import com.demo.model.Student;
import com.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class MyController {

    @Autowired
    private Service service;

    // POST endpoint to create or update a student
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = service.saveStudent(student);
        return ResponseEntity.ok(savedStudent); // Return the saved student
    }

    // GET all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return ResponseEntity.ok(students); // Return the list of students
    }

    // GET student by roll number
    @GetMapping("/{roll}")
    public ResponseEntity<Student> getStudentByRoll(@PathVariable String roll) {
        Student student = service.getStudentByRoll(roll);
        if (student != null) {
            return ResponseEntity.ok(student); // Return student found
        }
        return ResponseEntity.notFound().build(); // Return 404 if not found
    }

    // DELETE student by roll number
    @DeleteMapping("/{roll}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String roll) {
        service.deleteStudent(roll);
        return ResponseEntity.noContent().build(); // Return 204 No Content after deletion
    }
}
```

### **Step 7: `StudentApplication.java` (Main Application Class)**

This is the entry point to the Spring Boot application. It starts the application.

```java
package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }
}
```

### **Step 8: Testing with Postman**

Now that you have everything set up, you can test the application with Postman using the following endpoints:

- **POST /students**  
  Create a new student or update an existing student.  
  **Example Request (JSON Body)**:
  ```json
  {
      "roll": "101",
      "name": "John Doe",
      "email": "john.doe@example.com",
      "section": "A",
      "studentClass": "10"
  }
  ```

- **GET /students**  
  Retrieve a list of all students.

- **GET /students/{roll}**  
  Retrieve a student by their roll number.  
  Example: `GET http://localhost:8080/students/101`

- **DELETE /students/{roll}**  
  Delete a student by their roll number.  
  Example: `DELETE http://localhost:8080/students/101`

---

### **Step 9: MySQL Database Setup**

Make sure that your MySQL server is running and that you have a database called `practice` created. You can create it with the following SQL command:

```sql
CREATE DATABASE practice;
```

### **Step 10: Run the Application**

To run the Spring Boot application, use the following command:

```bash
mvn spring-boot:run
```

---

