package com.hexaware.dao;

import java.sql.Connection;
import com.hexaware.connectionutil.DBConnection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import com.hexaware.entity.Courier;

import java.sql.PreparedStatement;

public class CourierServiceDb {
    private static Connection connection;

    // Constructor to initialize connection using DBConnection class
    public CourierServiceDb() {
        connection = DBConnection.getConnection();
    }

    // Main method for testing or running the application
    public static void main(String[] args) {
        CourierServiceDb courierService = new CourierServiceDb();
        // Now you can use the connection to perform database operations
        // For example:
        System.out.println("Database connection established: " + connection);
    }
    
    public void grantPrivileges(String databaseName, String username, String password) throws SQLException {
        String sql = "GRANT ALL PRIVILEGES ON " + databaseName + ".* TO ?@'localhost' IDENTIFIED BY ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
        }
        
        
    }// Other methods for database operations
    
   
}
