
---

### **1. Backend (Spring Boot)**

#### Project Structure

```
amazon-orders-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── demo/
│   │   │   │   │   ├── Config/
│   │   │   │   │   │   └── WebConfig.java
│   │   │   │   │   ├── Controller/
│   │   │   │   │   │   └── OrderController.java
│   │   │   │   │   ├── Model/
│   │   │   │   │   │   └── Order.java
│   │   │   │   │   ├── Repository/
│   │   │   │   │   │   └── OrderRepository.java
│   │   │   │   │   ├── Service/
│   │   │   │   │   │   ├── OrderService.java
│   │   │   │   │   │   └── Impl/
│   │   │   │   │   │       └── OrderServiceImpl.java
│   │   │   │   │   └── AmazonOrdersApplication.java
│   └── resources/
│       └── application.properties
├── pom.xml
└── target/
```

---

### **Backend Files**

#### **1. `application.properties`**

Configure MySQL database connection:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/amazon_orders
spring.datasource.username=root
spring.datasource.password=root_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

#### **2. WebConfig.java (CORS Configuration)**

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
                .allowedOrigins("http://localhost:3000") // React frontend runs on port 3000
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
```

#### **3. Order.java (Entity)**

```java
package com.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="Orders")
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

#### **4. OrderRepository.java**

```java
package com.demo.Repository;

import com.demo.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
    // Custom query methods can be added here if needed
}
```

#### **5. OrderService.java**

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

#### **6. OrderServiceImpl.java**

```java
package com.demo.Service.Impl;

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

#### **7. OrderController.java**

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

    // GET all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // GET order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable String orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.notFound().build();
    }

    // POST order (Create)
    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.saveOrder(order);
        return ResponseEntity.status(201).body("Order created successfully: " + createdOrder.getOrderId());
    }

    // PUT order (Update)
    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable String orderId, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(orderId, order);
        if (updatedOrder != null) {
            return ResponseEntity.ok("Order updated successfully: " + updatedOrder.getOrderId());
        }
        return ResponseEntity.status(404).body("Order not found for update: " + orderId);
    }

    // DELETE order
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Successfully deleted order with ID: " + orderId);
    }
}
```

#### **8. AmazonOrdersApplication.java (Main Spring Boot App)**

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

### **2. Frontend (ReactJS)**

#### Project Structure

```
amazon-orders-frontend/
├── src/
│   ├── App.js
│   ├── index.js
├── public/
│   ├── index.html
├── package.json
├── node_modules/
└── .gitignore
```

---

#### **App.js**

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
        console.log("Response from POST (Create Order): ", response.data); 
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
        console.log("Response from PUT (Update Order): ", response.data); 
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
      .then(response => {
        setOrders(orders.filter((order) => order.orderId !== orderId));
        console.log("Response from DELETE (Delete Order): ", response.data); 
      })
      .catch(error => console.error("There was an error deleting the order!", error));
  };

  return (
    <div className="App">
      <h1>Amazon Orders Management</h1>

      <form onSubmit={handleCreateOrder}>
        <input type="text" name="

orderId" placeholder="Order ID" value={order.orderId} onChange={handleChange} />
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

### **3. Running the Application**

#### **Backend**
1. Ensure MySQL is running and the database is set up (`amazon_orders`).
2. Run the backend with Maven:
   ```bash
   mvn spring-boot:run
   ```

#### **Frontend**
1. Install the dependencies:
   ```bash
   npm install
   ```
2. Start the frontend development server:
   ```bash
   npm start
   ```

---

### **4. Testing CRUD Operations**
- **POST**: Create a new order by sending a POST request to `http://localhost:8080/orders`.
- **GET**: View all orders by sending a GET request to `http://localhost:8080/orders`.
- **PUT**: Update an order by sending a PUT request to `http://localhost:8080/orders/{orderId}`.
- **DELETE**: Delete an order by sending a DELETE request to `http://localhost:8080/orders/{orderId}`.

