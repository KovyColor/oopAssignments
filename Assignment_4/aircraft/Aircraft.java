package Assignment_4.aircraft;

import java.util.ArrayList;
import java.util.List;
import Assignment_4.passenger.Passenger;

public class Aircraft {
    private String name;
    private int maxPassengers;
    private List<Passenger> passengers;
    private String airportName;

    public Aircraft(String name, int maxPassengers) {
        this.name = name;
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < maxPassengers) {
            passengers.add(passenger);
        } else {
            System.out.println("Aircraft is full!");
        }
    }

    public void removePassenger(int seatNumber) {
        passengers.removeIf(p -> p.getSeatNumber() == seatNumber);
    }

    public String getName() {
        return name;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}

