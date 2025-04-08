Sure! Here's the complete and properly arranged setup for your Spring Boot backend with MySQL and ReactJS frontend, with capitalized package names as you requested:

---

### Spring Boot Backend Setup (With Capitalized Package Names)

#### 1. Project Structure
```
src/
 └── main/
      └── java/
           └── com/
                └── demo/
                     ├── Config/
                     │    └── WebConfig.java
                     ├── Controller/
                     │    └── OrderController.java
                     ├── Model/
                     │    └── Order.java
                     ├── Repository/
                     │    └── OrderRepository.java
                     ├── Service/
                     │    └── OrderService.java
                     ├── ServiceImpl/
                     │    └── OrderServiceImpl.java
                     └── AmazonOrdersApplication.java
```

---

#### 2. Setup Spring Boot Application

**`pom.xml`** (Spring Boot with dependencies for MySQL, Spring Data JPA, and Spring Web)

```xml
<dependencies>
    <!-- Spring Boot Starter Web (REST APIs) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- Spring Boot Starter Data JPA (JPA repositories) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <!-- MySQL Driver -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
    <!-- Spring Boot Starter Test (for testing) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

#### 3. Spring Boot Backend Code

##### **`application.properties`** (MySQL Configuration)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/amazon_orders
spring.datasource.username=root
spring.datasource.password=root_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

##### **`WebConfig.java`** (Enable CORS)

```java
package com.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")  // React frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
```

##### **`Order.java`** (Model Class)

```java
package com.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {

    @Id
    private String orderId;
    private String customerName;
    private String productName;
    private int quantity;
    private double price;

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
```

##### **`OrderRepository.java`** (Repository Interface)

```java
package com.demo.Repository;

import com.demo.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
    // Additional query methods can be added here if needed
}
```

##### **`OrderService.java`** (Service Interface)

```java
package com.demo.Service;

import com.demo.Model.Order;
import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(String orderId);
    void deleteOrder(String orderId);
    Order updateOrder(String orderId, Order order);
}
```

##### **`OrderServiceImpl.java`** (Service Implementation)

```java
package com.demo.ServiceImpl;

import com.demo.Model.Order;
import com.demo.Repository.OrderRepository;
import com.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(String orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.orElse(null);
    }

    @Override
    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order updateOrder(String orderId, Order order) {
        if (orderRepository.existsById(orderId)) {
            order.setOrderId(orderId);
            return orderRepository.save(order);
        }
        return null;
    }
}
```

##### **`OrderController.java`** (Controller Class)

```java
package com.demo.Controller;

import com.demo.Model.Order;
import com.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable String orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable String orderId, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(orderId, order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
```

##### **`AmazonOrdersApplication.java`** (Main Application)

```java
package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmazonOrdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazonOrdersApplication.class, args);
    }
}
```

---

### ReactJS Frontend Setup (With Capitalized Package Names)

1. **Create React App**: 
   ```bash
   npx create-react-app amazon-orders
   cd amazon-orders
   npm install axios
   ```

2. **`App.js`** (Main React Component)

```javascript
import React, { useState, useEffect } from "react";
import axios from "axios";

function App() {
  const [orders, setOrders] = useState([]);
  const [order, setOrder] = useState({
    orderId: "",
    customerName: "",
    productName: "",
    quantity: "",
    price: "",
  });

  useEffect(() => {
    axios.get("http://localhost:8080/orders")
      .then(response => {
        setOrders(response.data);
      })
      .catch(error => console.error("There was an error fetching the orders!", error));
  }, []);

  const handleChange = (e) => {
    setOrder({ ...order, [e.target.name]: e.target.value });
  };

  const handleCreateOrder = (e) => {
    e.preventDefault();
    axios.post("http://localhost:8080/orders", order)
      .then(response => {
        setOrders([...orders, response.data]);
        setOrder({
          orderId: "",
          customerName: "",
          productName: "",
          quantity: "",
          price: "",
        });
      })
      .catch(error => console.error("There was an error creating the order!", error));
  };

  const handleUpdateOrder = (e) => {
    e.preventDefault();
    axios.put(`http://localhost:8080/orders/${order.orderId}`, order)
      .then(response => {
        const updatedOrders = orders.map((o) =>
          o.orderId === order.orderId ? response.data : o
        );
        setOrders(updatedOrders);
        setOrder({
          orderId: "",
          customerName: "",
          productName: "",
          quantity: "",
          price: "",
        });
      })
      .catch(error => console.error("There was an error updating the order!", error));
  };

  const handleDeleteOrder = (orderId) => {
    axios.delete(`http://localhost:8080/orders/${orderId}`)
      .then(() => {
        setOrders(orders.filter((order) => order.orderId !== orderId));
      })
      .catch(error => console.error("There was an error deleting the order!", error));
  };

  return (
    <div className="App">
      <h1>Amazon Orders Management</h1>

      <form onSubmit={handleCreateOrder}>
        <input type="text" name="orderId" placeholder="Order ID" value={order.orderId} onChange={handleChange} />
        <input type="text" name="customerName" placeholder="Customer Name" value={order.customerName} onChange={handleChange} />
        <input type="text" name="productName" placeholder="Product Name" value={order.productName} onChange={handleChange} />
        <input type="number" name="quantity" placeholder="Quantity" value={order.quantity} onChange={handleChange} />
        <input type="number" name="price" placeholder="Price" value={order.price} onChange={handleChange} />
        <button type="submit">Create Order</button>
      </form>

      <button onClick={handleUpdateOrder}>Update Order</button>

      <h2>All Orders</h2>
      <ul>
        {orders.map((order) => (
          <li key={order.orderId}>
            {order.customerName} - {order.productName} - ${order.price}
            <button onClick={() => handleDeleteOrder(order.orderId)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
```

---

### Running the Application

1. **Start the Spring Boot Backend:**

   ```bash
   mvn spring-boot:run
   ```

2. **Start the ReactJS Frontend:**

   ```bash
   npm start
   ```

---
