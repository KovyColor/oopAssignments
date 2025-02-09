package Assignment_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/airport_management";
    private static final String USER = "root";  // Make sure this is correct
    private static final String PASSWORD = "P*n7(@LjvY_&M6a9"; // Enter your correct password

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed!", e);
        }
    }
}
