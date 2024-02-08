package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.hexaware.entity.Order;

public class CourierDAO {
    private Connection connection;

    public CourierDAO(Connection connection) {
        this.connection = connection;
    }

    // Other methods...
    public void placeNewCourierOrder(Order order) throws SQLException {
        String sql = "INSERT INTO ordertable (CustomerName, CustomerAddress, ItemDescription, OrderDate) " +
                     "VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            //statement.setInt(1, order.getOrderID());
            statement.setString(1, order.getCustomerName());
            statement.setString(2, order.getCustomerAddress());
            statement.setString(3, order.getItemDescription());
            //statement.setInt(5, order.getCourierID());
            java.sql.Date sqlDate = new java.sql.Date(order.getOrderDate().getTime());
            statement.setDate(4, sqlDate);
            statement.executeUpdate();
        }
    }

    public String getOrderStatus(int courierID) throws SQLException {
        String status = "";
        String sql = "SELECT Status FROM Courier WHERE CourierID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, courierID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    status = resultSet.getString("Status");
                }
            }
        }
        return status;
    }

    public boolean cancelCourierOrder(int courierID) throws SQLException {
        String sql = "DELETE FROM OrderTable WHERE CourierID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, courierID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public List<String> getDeliveryHistory(int courierID) throws SQLException {
        List<String> history = new ArrayList<>();
        String sql = "SELECT * FROM OrderTable WHERE CourierID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, courierID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String entry = "OrderID: " + resultSet.getInt("OrderID") + ", " +
                                   "CustomerName: " + resultSet.getString("CustomerName") + ", " +
                                   "CustomerAddress: " + resultSet.getString("CustomerAddress") + ", " +
                                   "ItemDescription: " + resultSet.getString("ItemDescription");
                    history.add(entry);
                }
            }
        }
        return history;
    }
    
    public static void generateShipmentStatusReport(Connection connection) {
		String sql = "SELECT TrackingNumber, Status FROM Courier";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Shipment Status Report:");
			while (resultSet.next()) {
				String trackingNumber = resultSet.getString("TrackingNumber");
				String status = resultSet.getString("Status");
				System.out.println("Tracking Number: " + trackingNumber + ", Status: " + status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void generateRevenueReport(Connection connection) {
		String sql = "SELECT C.TRACKINGNUMBER,C.STATUS,P.AMOUNT FROM COURIER C INNER JOIN PAYMENT P ON C.COURIERID = P.COURIERID; ";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			double totalRevenue = 0.0;
			System.out.println("Revenue Report:");
			while (resultSet.next()) {
				String trackingNumber = resultSet.getString("TrackingNumber");
				String status = resultSet.getString("Status");
				int amount = resultSet.getInt("Amount");
				totalRevenue += amount;
				System.out.println("Tracking Number: " + trackingNumber + ", Revenue: $" + amount);
			}
			System.out.println("Total Revenue: $" + totalRevenue);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

