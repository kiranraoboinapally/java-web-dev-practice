
### **Backend (Spring Boot + MySQL)**

We will start with the **Spring Boot backend**, which will expose REST APIs for CRUD operations. In the backend, we will be using **Spring Data JPA** to interact with the **MySQL** database.

### **1. Spring Boot Backend Setup**

#### Step 1: Set Up Your Spring Boot Application

1. Create a Spring Boot project with dependencies like:
   - **Spring Web**
   - **Spring Data JPA**
   - **MySQL Driver**

#### Step 2: Configure MySQL in `application.properties`

Make sure you have MySQL running, and the database is created. You can use the following command to create the `amazon_orders` database:

```sql
CREATE DATABASE amazon_orders;
```

Configure the `application.properties` file for MySQL connection:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/amazon_orders
spring.datasource.username=root
spring.datasource.password=root_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

#### Step 3: Define the Entity Class (`Order.java`)

```java
package com.demo.model;

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

#### Step 4: Create a Repository Interface (`OrderRepository.java`)

```java
package com.demo.repository;

import com.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
    // Additional query methods can be added here if needed
}
```

#### Step 5: Create a Service Layer (`OrderService.java`)

```java
package com.demo.service;

import com.demo.model.Order;
import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(String orderId);
    void deleteOrder(String orderId);
    Order updateOrder(String orderId, Order order);
}
```

#### Step 6: Implement the Service Layer (`OrderServiceImpl.java`)

```java
package com.demo.service.impl;

import com.demo.model.Order;
import com.demo.repository.OrderRepository;
import com.demo.service.OrderService;
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

#### Step 7: Create Controller (`OrderController.java`)

```java
package com.demo.controller;

import com.demo.model.Order;
import com.demo.service.OrderService;
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

    // POST order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    // PUT order (update)
    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable String orderId, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(orderId, order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE order
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
```

### **2. Frontend (ReactJS)**

Now let's build the ReactJS frontend to perform CRUD operations with buttons for **Get**, **Post**, **Put (Update)**, and **Delete**.

#### Step 1: Set Up the React App

Use the command `npx create-react-app amazon-orders` to create your React app. Then, install Axios for making HTTP requests.

```bash
npm install axios
```

#### Step 2: Update `App.js` for CRUD Operations

Here’s how you can set up the React frontend with buttons for each operation:

```jsx
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

  // Fetch all orders on component mount
  useEffect(() => {
    axios.get("http://localhost:8080/orders")
      .then(response => {
        setOrders(response.data);
      })
      .catch(error => console.error("There was an error fetching the orders!", error));
  }, []);

  // Handle form input changes
  const handleChange = (e) => {
    setOrder({ ...order, [e.target.name]: e.target.value });
  };

  // Create new order
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

  // Update existing order
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

  // Delete order
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

### **3. Run the Application**

1. **Start the Spring Boot Backend**:
   Run your Spring Boot backend with:

   ```bash
   mvn spring-boot:run
   ```

2. **Start the React Frontend**:
   In the React project directory, run:

   ```bash
   npm start
   ```

### **Conclusion**

Now, you have a full-stack application with CRUD operations for Amazon orders. You can:

- **Create** orders with the "Create Order" button.
- **Update** orders with the "Update Order" button.
- **Delete** orders with the "Delete" button.
- **View** all orders on the page.

This setup includes Spring Boot backend and ReactJS frontend with proper integration.