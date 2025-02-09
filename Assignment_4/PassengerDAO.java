package Assignment_4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextArea;

public class PassengerDAO {
    public void addPassenger(String name, int seatNumber, int aircraftId) {
        String sql = "INSERT INTO passengers (name, seat_number, aircraft_id) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, seatNumber);
            stmt.setInt(3, aircraftId);
            stmt.executeUpdate();
            System.out.println("Passenger added: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePassenger(int id) {
        String sql = "DELETE FROM passengers WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Passenger deleted: ID " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listPassengers(JTextArea displayArea) {
        String sql = "SELECT * FROM passengers";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                displayArea.append("Passenger ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Seat No: " + rs.getInt("seat_number") +
                        ", Aircraft ID: " + rs.getInt("aircraft_id") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String searchPassenger(String aircraftName, int seatNumber) {
        String sql = "SELECT p.* FROM passengers p " +
                "JOIN aircraft a ON p.aircraft_id = a.id " +
                "WHERE a.name = ? AND p.seat_number = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aircraftName);
            stmt.setInt(2, seatNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return "Passenger Found: " + rs.getString("name") +
                        ", Seat: " + rs.getInt("seat_number") +
                        ", Aircraft ID: " + rs.getInt("aircraft_id");
            } else {
                return "No passenger found.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error searching passenger.";
        }
    }
}
