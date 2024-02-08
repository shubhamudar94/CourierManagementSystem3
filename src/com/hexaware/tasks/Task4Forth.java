package com.hexaware.tasks;

import java.util.Scanner;

public class Task4Forth {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter customer's name: ");
		String customerName = scanner.nextLine();

		System.out.print("Enter order number: ");
		String orderNumber = scanner.nextLine();

		System.out.print("Enter delivery address: ");
		String deliveryAddress = scanner.nextLine();

		System.out.print("Enter expected delivery date: ");
		String expectedDeliveryDate = scanner.nextLine();

		String confirmationEmail = generateOrderConfirmationEmail(customerName, orderNumber, deliveryAddress,
				expectedDeliveryDate);
		System.out.println("Order Confirmation Email:\n" + confirmationEmail);

		scanner.close();
	}

	private static String generateOrderConfirmationEmail(String customerName, String orderNumber,
			String deliveryAddress, String expectedDeliveryDate) {
		String emailContent = "Dear " + customerName + ",\n\n"
				+ "Thank you for placing an order with us. Here are the details of your order:\n\n" + "Order Number: "
				+ orderNumber + "\n" + "Delivery Address: " + deliveryAddress + "\n" + "Expected Delivery Date: "
				+ expectedDeliveryDate + "\n\n"
				+ "We appreciate your business. If you have any questions, feel free to contact us.\n\n"
				+ "Sincerely,\nShubham's Courier Company Ltd.";

		return emailContent;
	}
}