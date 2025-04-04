
### **1. Spring Boot Backend Setup**

1. **Create Spring Boot Project**:
   - Create a new Spring Boot project in **Spring Tool Suite (STS)** or **IntelliJ IDEA**.
   - Go to `File > New > Spring Starter Project`.
   - Project Name: `springboot-react-demo`
   - Group: `com.example`
   - Artifact: `springboot-react-demo`
   - Dependencies: **Spring Web**, **Spring Data JPA** (optional, if using a database), **H2 Database** (for in-memory database).

2. **Configure `application.properties`** (`src/main/resources/application.properties`):
   Configure the in-memory H2 database (you can later switch this to another database like MySQL or PostgreSQL if needed).

   ```properties
   # H2 in-memory database configuration
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Create the REST Controller** (`src/main/java/com/example/springbootreactdemo/controller/HelloController.java`):

   We’ll use `@CrossOrigin` to handle CORS directly in the Spring Boot controller. This allows us to make requests from the React frontend.

   ```java
   package com.example.springbootreactdemo.controller;

   import org.springframework.web.bind.annotation.CrossOrigin;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.RestController;

   @RestController
   @CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for React running on port 3000
   public class HelloController {

       @GetMapping("/api/hello")
       public String sayHello() {
           return "Hello from Spring Boot!";
       }
   }
   ```

4. **Run the Spring Boot Application**:
   - In STS or IntelliJ IDEA, locate your `DemoApplication.java` (the main class with `@SpringBootApplication`).
   - Right-click and select `Run As > Spring Boot App` to start the backend on `http://localhost:8080`.

---

### **2. React Frontend Setup**

1. **Create React App**:
   If you're using the **Command Line** to create the React app:

   ```bash
   npx create-react-app my-app
   cd my-app
   npm start
   ```

   This will set up a React app and run it on `http://localhost:3000`.

2. **Install Axios (optional, for API calls)**:
   - In your React project directory, install Axios (you could also use `fetch` as in the example):

   ```bash
   npm install axios
   ```

3. **Modify `App.js`** (to make API calls to the Spring Boot backend):

   Here's the code for the React `App.js` to call the Spring Boot backend and fetch the message:

   ```javascript
   import React, { useState } from "react";

   function App() {
       const [message, setMessage] = useState("");

       const fetchMessage = async () => {
           try {
               const response = await fetch("http://localhost:8080/api/hello");  // Ensure this is correct
               const data = await response.text();
               setMessage(data);
           } catch (error) {
               console.error("Error fetching message:", error);
               setMessage("Failed to connect to server");
           }
       };

       return (
           <div>
               <h1>React to Spring Boot Connection</h1>
               <button onClick={fetchMessage}>Get Message</button>
               <p>Server Response: {message}</p>
           </div>
       );
   }

   export default App;
   ```

4. **Run the React Application**:
   - In your React project directory, run:

   ```bash
   npm start
   ```

   This will start the React app on `http://localhost:3000`.

---

### **3. Testing the Application**

1. **Start the Spring Boot Backend**:
   - Ensure that your Spring Boot backend is running on `http://localhost:8080`.

2. **Start the React Frontend**:
   - Ensure that your React app is running on `http://localhost:3000`.

3. **Test the Connection**:
   - Open `http://localhost:3000` in your browser.
   - Click the "Get Message" button, and you should see "Hello from Spring Boot!" displayed in your React app.

---

### **Summary of Changes**

#### **Spring Boot Backend**:
- **Controller**: Created a simple REST API (`/api/hello`) using `@CrossOrigin` to enable CORS and allow requests from `http://localhost:3000` (the React app).
- **Database**: Configured an in-memory H2 database for simplicity (can be replaced with other databases like MySQL or PostgreSQL).

#### **React Frontend**:
- **React Component**: Created a button that calls the Spring Boot backend (`/api/hello`) and displays the response ("Hello from Spring Boot!").
- **CORS**: CORS was handled using `@CrossOrigin` in Spring Boot to allow the React app to make requests to the backend running on a different port (3000 for React and 8080 for Spring Boot).

---

