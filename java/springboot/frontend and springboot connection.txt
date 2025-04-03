Yes, you can absolutely build this full-stack application using **Spring Tool Suite (STS)**. Spring Tool Suite is an IDE specifically tailored for Spring-based development and works well with Spring Boot applications. Below are the steps for setting up and developing the backend with Spring Boot and frontend with React using Spring Tool Suite.

---

### **1. Set Up Spring Boot Backend in Spring Tool Suite (STS)**

#### **Step 1: Create a New Spring Boot Project in STS**
1. **Open Spring Tool Suite (STS)**: If you don’t have STS installed, you can download it from the [official site](https://spring.io/tools).
   
2. **Create a New Spring Boot Project**:
   - In STS, go to **File > New > Spring Starter Project**.
   - In the "New Spring Starter Project" window:
     - **Project Name**: `springboot-react-demo`
     - **Group**: `com.example`
     - **Artifact**: `springboot-react-demo`
     - **Dependencies**: Choose the following:
       - Spring Web
       - Spring Data JPA (Optional, if you plan to use a database)
       - H2 Database (for an in-memory database)
   
3. **Finish** the project setup by clicking on the **Finish** button.

#### **Step 2: Configure the `application.properties` File**
Inside the `src/main/resources/application.properties`, add the following configuration for H2 database:

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

#### **Step 3: Create a Simple REST API in Spring Boot**
1. **Create a REST Controller**: In the `src/main/java/com/example/springbootreactdemo` package, create a controller class like this:

```java
package com.example.springbootreactdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }
}
```

#### **Step 4: Run Your Spring Boot Application**
- Right-click on your **`DemoApplication.java`** (the main class with `@SpringBootApplication`) and select **Run As > Spring Boot App**.
- Your Spring Boot backend will run on **http://localhost:8080** by default.

---

### **2. Set Up React Frontend**

#### **Step 1: Create a React Project**
You can create a React project either using **Command Line** or from within **Spring Tool Suite**.

1. **Using Command Line**:
   - Open a terminal and navigate to the directory where you want to create your React app.
   - Run the following commands to create a React app:
   
   ```bash
   npx create-react-app my-app
   cd my-app
   npm start
   ```

2. **Using STS**:
   - You can also use **STS** to create a React project by going to **File > New > Project** and selecting **General > Project**.
   - Then, create the project folder and use **npm** to install dependencies later. But for simplicity, it's easier to use the **Command Line** for React app creation.

#### **Step 2: Install Axios**
Navigate to your React project folder (`my-app`) and install **Axios** to make HTTP requests.

```bash
npm install axios
```

#### **Step 3: Modify `App.js` to Call the Backend API**
In the React app (`src/App.js`), modify the component to fetch data from the Spring Boot backend.

```javascript
import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    axios.get("http://localhost:8080/api/hello")
      .then(response => {
        setMessage(response.data);
      })
      .catch(error => {
        console.error("There was an error calling the API!", error);
      });
  }, []);

  return (
    <div>
      <h1>{message}</h1>
    </div>
  );
}

export default App;
```

#### **Step 4: Run the React Application**
1. Go to the `my-app` folder and run:

```bash
npm start
```

This will start the React frontend on **http://localhost:3000**.

---

### **3. Enable CORS in Spring Boot**
Since the frontend (React) runs on port 3000, and the backend (Spring Boot) runs on port 8080, you'll need to enable **CORS** (Cross-Origin Resource Sharing) in Spring Boot to allow React to make requests to the backend.

1. **Create a CORS Configuration**: Create a new class in `src/main/java/com/example/springbootreactdemo/WebConfig.java`:

```java
package com.example.springbootreactdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000") // React's default port
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
```

This will allow the React app running on `http://localhost:3000` to make requests to the backend.

---

### **4. Test the Application**

#### **Step 1: Start Spring Boot**
- In **STS**, right-click on your `DemoApplication.java` file and choose **Run As > Spring Boot App**.
- This will start the backend server on **http://localhost:8080**.

#### **Step 2: Start React**
- In your **React project**, run the following command:

```bash
npm start
```

- This will start the frontend server on **http://localhost:3000**.

#### **Step 3: Open React App in Browser**
- Open your browser and go to **http://localhost:3000**.
- You should see the message **"Hello from Spring Boot!"** displayed in the React application.

---

### **Summary**

At this point, you've set up a simple full-stack application using **Spring Tool Suite** for the backend and **React** for the frontend. Here’s a summary of the steps:

1. **Spring Boot Backend**: 
   - Created a simple REST API endpoint (`/api/hello`).
   - Enabled CORS to allow requests from React.
   - Ran the Spring Boot application on **http://localhost:8080**.

2. **React Frontend**:
   - Created a React app using **Create React App**.
   - Installed **Axios** and set it up to make HTTP requests to the Spring Boot backend.
   - Ran the React app on **http://localhost:3000**.

You can extend this application further by adding a database (e.g., MySQL, PostgreSQL), handling more advanced routes, or adding user authentication.

Would you like to explore any specific features or dive into further details for any part of the process?