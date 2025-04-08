

```java
package com.demo.Controller;

import com.demo.Model.Student;
import com.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class MyController {

    @Autowired
    private Service service;

    // POST endpoint for adding or updating a student
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        // Save or update the student and return the response
        Student savedStudent = service.saveStudent(student);
        return ResponseEntity.ok(savedStudent); // Send the saved student back in the response
    }

    // GET all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // GET student by roll number
    @GetMapping("/{roll}")
    public ResponseEntity<Student> getStudentByRoll(@PathVariable String roll) {
        Student student = service.getStudentByRoll(roll);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE student by roll number
    @DeleteMapping("/{roll}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String roll) {
        service.deleteStudent(roll);
        return ResponseEntity.noContent().build();
    }
}
```

### Explanation of `@PostMapping`:

- **`@PostMapping`:** This annotation is used to map HTTP `POST` requests to the `addStudent()` method. It's typically used for creating new resources on the server.
- **`@RequestBody`:** This annotation binds the incoming JSON data in the request body to the `Student` object. This way, when you send a JSON payload with a `POST` request, it gets automatically converted into a `Student` Java object.
- **`ResponseEntity.ok(savedStudent)`:** This returns the saved `Student` entity as a response, along with an HTTP status code of 200 (OK).

### Example of Postman Request for Adding a Student (POST):

**URL**: `http://localhost:8080/students`  
**HTTP Method**: POST  
**Request Body (JSON)**:
```json
{
    "roll": "101",
    "name": "John Doe",
    "email": "john.doe@example.com",
    "section": "A",
    "studentClass": "10"
}
```

**Expected Response** (after sending the POST request):

```json
{
    "roll": "101",
    "name": "John Doe",
    "email": "john.doe@example.com",
    "section": "A",
    "studentClass": "10"
}
```