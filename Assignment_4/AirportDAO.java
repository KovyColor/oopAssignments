package Assignment_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTextArea;

public class AirportDAO {
    public void addAirport(String name) {
        String sql = "INSERT INTO airports (name) VALUES (?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("Airport added: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAirport(int id) {
        String sql = "DELETE FROM airports WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Airport deleted: ID " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listAirports(JTextArea displayArea) {
        String sql = "SELECT * FROM airports";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             var rs = stmt.executeQuery()) {
            while (rs.next()) {
                displayArea.append("Airport ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
