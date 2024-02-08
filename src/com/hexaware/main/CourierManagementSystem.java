package com.hexaware.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.hexaware.entity.Order;
import com.hexaware.dao.CourierDAO;
import com.hexaware.dao.CourierServiceDb;
import com.hexaware.connectionutil.DBConnection;
import com.hexaware.exception.InvalidCourierIdException;

public class CourierManagementSystem {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = DBConnection.getConnection()) {
			CourierDAO courierDAO = new CourierDAO(connection);
			CourierManagementSystem cms = new CourierManagementSystem();
			CourierServiceDb courierServiceDb = new CourierServiceDb();
			Scanner scanner = new Scanner(System.in);
			int choice;

			do {
				System.out.println("Courier Management System Menu:");
				System.out.println("1. Place a new courier order");
				System.out.println("2. Get order status");
				System.out.println("3. Cancel a courier order");
				System.out.println("4. Get delivery history of a parcel");
				System.out.println("5. Generate and display shipment status report");
				System.out.println("6. Generate and display revenue report");
				System.out.println("7. Exit");
				System.out.print("Enter your choice: ");

				choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					placeNewCourierOrder(scanner, courierDAO);
					break;
				case 2:
					getOrderStatus(scanner, courierDAO);
					break;
				case 3:
					cancelCourierOrder(scanner, courierDAO);
					break;
				case 4:
					getDeliveryHistory(scanner, courierDAO);
					break;
				case 5:
					cms.generateShipmentStatusReport(courierDAO, connection);
					break;
				case 6:
					cms.generateRevenueReport(courierDAO, connection);
					break;
				case 7:
					System.out.println("Exiting Courier Management System. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
				}
			} while (choice != 7);

		} catch (SQLException | InvalidCourierIdException e) {
			e.printStackTrace();
		}
	}

	private static void placeNewCourierOrder(Scanner scanner, CourierDAO courierDAO) throws SQLException {
		System.out.print("Enter customer name: ");
		String customerName = scanner.nextLine();
		System.out.print("Enter customer address: ");
		String customerAddress = scanner.nextLine();
		System.out.print("Enter item description: ");
		String itemDescription = scanner.nextLine();
		java.sql.Date orderDate = new java.sql.Date(System.currentTimeMillis());

		Order order = new Order(customerName, customerAddress, itemDescription, orderDate);
		courierDAO.placeNewCourierOrder(order);
		System.out.println("New courier order placed successfully.");
	}

	private static void getOrderStatus(Scanner scanner, CourierDAO courierDAO)
			throws SQLException, InvalidCourierIdException {
		System.out.print("Enter courier ID: ");
		int courierID = scanner.nextInt();
		scanner.nextLine();
		String status = courierDAO.getOrderStatus(courierID);
		if (status == null) {
			throw new InvalidCourierIdException("Invalid courier ID: " + courierID);
		}
		System.out.println("Order status: " + status);
	}

	private static void cancelCourierOrder(Scanner scanner, CourierDAO courierDAO)
			throws SQLException, InvalidCourierIdException {
		System.out.print("Enter courier ID: ");
		int courierID = scanner.nextInt();
		scanner.nextLine();
		boolean success = courierDAO.cancelCourierOrder(courierID);
		if (!success) {
			throw new InvalidCourierIdException("Failed to cancel courier order. Invalid courier ID: " + courierID);
		}
		System.out.println("Courier order canceled successfully.");
	}

	private static void getDeliveryHistory(Scanner scanner, CourierDAO courierDAO) throws SQLException {
		System.out.print("Enter courier ID: ");
		int courierID = scanner.nextInt();
		scanner.nextLine();
		List<String> deliveryHistory = courierDAO.getDeliveryHistory(courierID);
		System.out.println("Delivery history for courier ID " + courierID + ":");
		for (String entry : deliveryHistory) {
			System.out.println(entry);
		}
	}

	public void generateShipmentStatusReport(CourierDAO courierDAO, Connection connection) {
		courierDAO.generateShipmentStatusReport(connection);
	}

	public void generateRevenueReport(CourierDAO courierDAO, Connection connection) {
		courierDAO.generateRevenueReport(connection);
	}
}
