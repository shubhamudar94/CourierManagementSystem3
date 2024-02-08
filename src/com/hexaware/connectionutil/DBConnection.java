package com.hexaware.connectionutil;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Connection connection = null;
    private static String propertiesFilePath = "C:/Users/Pinkey/eclipse-workspace/CourierManagementSystem3/src/com/hexaware/connectionutil/db.properties";

    // Method to establish database connection
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties prop = new Properties();
                FileInputStream fileInputStream = new FileInputStream(propertiesFilePath);
                prop.load(fileInputStream);
                String url = prop.getProperty("db.url");
                String username = prop.getProperty("db.username");
                String password = prop.getProperty("db.password");
                connection = DriverManager.getConnection(url, username, password);
                fileInputStream.close();
                System.out.println("Database connection established successfully." + connection);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
                System.err.println("Failed to establish database connection: " + e.getMessage());
            }
            return connection;
        }
    }
}




/*package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static Connection connection;

	public static Connection getConnection() {

		String path = "C:/Users/Pinkey/eclipse-workspace/couriermanagementsystem3/src/com/hexaware/util/db.properties";

		try {
			connection = DriverManager.getConnection(PropertyUtil.getConnectionString(path));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public static void main(String[] args) {
		System.out.println(getConnection());

	}

}*/



