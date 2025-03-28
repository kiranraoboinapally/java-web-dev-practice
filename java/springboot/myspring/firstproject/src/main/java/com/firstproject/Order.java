package com.firstproject;


public class Order {

    int orderId;          
    String productName;   
    int quantity;         
    double price;
    String name;

    public Order(int orderId, String productName, int quantity, double price, String name) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.name = name;
    }

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productName=" + productName + ", quantity=" + quantity + ", price="
				+ price + ", name=" + name + "]";
	}

}
