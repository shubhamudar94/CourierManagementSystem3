package com.hexaware.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
	int orderId;
	String customerName;
	String product;

	Order(int orderId, String customerName, String product) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.product = product;
	}
}

public class Task2First {
	public static void main(String[] args) {
		List<Order> orders = initializeOrders();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter customer name to display orders: ");
		String customerToDisplay = scanner.nextLine();

		displayOrdersForCustomer(orders, customerToDisplay);

		scanner.close();
	}

	private static List<Order> initializeOrders() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1, "Shubham", "ProductA"));
		orders.add(new Order(2, "Vishal", "ProductB"));
		orders.add(new Order(3, "Shubham", "ProductC"));
		orders.add(new Order(4, "Shyam", "ProductD"));
		return orders;
	}

	private static void displayOrdersForCustomer(List<Order> orders, String customerName) {
		System.out.println("Orders for customer " + customerName + ":");

		for (Order order : orders) {
			if (order.customerName.equalsIgnoreCase(customerName)) {
				System.out.println("Order ID: " + order.orderId + ", Product: " + order.product);
			}
		}
	}
}
