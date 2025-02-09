package Assignment_4;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    private final JTextArea displayArea;
    private final JButton showAirportsBtn;
    private final JButton showAircraftBtn;
    private final JButton showPassengersBtn;
    private final JButton addAirportBtn;
    private final JButton addAircraftBtn;
    private final JButton addPassengerBtn;
    private final JButton deleteAirportBtn;
    private final JButton deleteAircraftBtn;
    private final JButton deletePassengerBtn;
    private final JButton searchPassengerBtn;

    public MainGUI() {
        setTitle("Airport Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Airport Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        showAirportsBtn = new JButton("Show Airports");
        showAircraftBtn = new JButton("Show Aircraft");
        showPassengersBtn = new JButton("Show Passengers");
        addAirportBtn = new JButton("Add Airport");
        addAircraftBtn = new JButton("Add Aircraft");
        addPassengerBtn = new JButton("Add Passenger");
        deleteAirportBtn = new JButton("Delete Airport");
        deleteAircraftBtn = new JButton("Delete Aircraft");
        deletePassengerBtn = new JButton("Delete Passenger");
        searchPassengerBtn = new JButton("Search Passenger");

        buttonPanel.add(showAirportsBtn);
        buttonPanel.add(showAircraftBtn);
        buttonPanel.add(showPassengersBtn);
        buttonPanel.add(addAirportBtn);
        buttonPanel.add(addAircraftBtn);
        buttonPanel.add(addPassengerBtn);
        buttonPanel.add(deleteAirportBtn);
        buttonPanel.add(deleteAircraftBtn);
        buttonPanel.add(deletePassengerBtn);
        buttonPanel.add(searchPassengerBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        addEventListeners();

        setVisible(true);
    }

    private void addEventListeners() {
        AirportDAO airportDAO = new AirportDAO();
        AircraftDAO aircraftDAO = new AircraftDAO();
        PassengerDAO passengerDAO = new PassengerDAO();

        showAirportsBtn.addActionListener(e -> {
            displayArea.setText("Airports:\n");
            airportDAO.listAirports(displayArea);
        });

        showAircraftBtn.addActionListener(e -> {
            displayArea.setText("Aircraft:\n");
            aircraftDAO.listAircraft(displayArea);
        });

        showPassengersBtn.addActionListener(e -> {
            displayArea.setText("Passengers:\n");
            passengerDAO.listPassengers(displayArea);
        });

        addAirportBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Airport Name:");
            if (name != null) {
                airportDAO.addAirport(name);
                displayArea.setText("Airport Added: " + name);
            }
        });

        addAircraftBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Aircraft Name:");
            String maxPassengers = JOptionPane.showInputDialog("Enter Max Passengers:");
            String airportId = JOptionPane.showInputDialog("Enter Airport ID:");
            if (name != null && maxPassengers != null && airportId != null) {
                aircraftDAO.addAircraft(name, Integer.parseInt(maxPassengers), Integer.parseInt(airportId));
                displayArea.setText("Aircraft Added: " + name);
            }
        });

        addPassengerBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Passenger Name:");
            String seatNumber = JOptionPane.showInputDialog("Enter Seat Number:");
            String aircraftId = JOptionPane.showInputDialog("Enter Aircraft ID:");
            if (name != null && seatNumber != null && aircraftId != null) {
                passengerDAO.addPassenger(name, Integer.parseInt(seatNumber), Integer.parseInt(aircraftId));
                displayArea.setText("Passenger Added: " + name);
            }
        });

        deleteAirportBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Airport ID to Delete:");
            if (id != null) {
                airportDAO.deleteAirport(Integer.parseInt(id));
                displayArea.setText("Airport Deleted: ID " + id);
            }
        });

        deleteAircraftBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Aircraft ID to Delete:");
            if (id != null) {
                aircraftDAO.deleteAircraft(Integer.parseInt(id));
                displayArea.setText("Aircraft Deleted: ID " + id);
            }
        });

        deletePassengerBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Passenger ID to Delete:");
            if (id != null) {
                passengerDAO.deletePassenger(Integer.parseInt(id));
                displayArea.setText("Passenger Deleted: ID " + id);
            }
        });

        searchPassengerBtn.addActionListener(e -> {
            String aircraftName = JOptionPane.showInputDialog("Enter Aircraft Name:");
            String seatNumber = JOptionPane.showInputDialog("Enter Seat Number:");
            if (aircraftName != null && seatNumber != null) {
                String result = passengerDAO.searchPassenger(aircraftName, Integer.parseInt(seatNumber));
                displayArea.setText(result);
            }
        });
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
