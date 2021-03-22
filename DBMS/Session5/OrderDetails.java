package com.jdbc;
import java.sql.Date;

//Class to represent the structure of Order Details
public class OrderDetails {
	private String ID;
	private Date orderDate;
	private Double orderTotal;

	public OrderDetails(String iD, Date orderDate, Double orderTotal) {
		super();
		ID = iD;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
	}

	@Override
	public String toString() {
		return "\n  { Order ID: " + ID + ",\n    Order Date: " + orderDate + ",\n    Order Total: " + orderTotal
				+ " }\n";
	}
}
