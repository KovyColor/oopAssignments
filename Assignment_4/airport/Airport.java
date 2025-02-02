package Assignment_4.airport;

import java.util.ArrayList;

import java.util.List;
import Assignment_4.aircraft.Aircraft;
import Assignment_4.passenger.Passenger;

public class Airport {
    private String name;
    private List<Aircraft> aircraftVehicles;

    public Airport(String name) {
        this.name = name;
        this.aircraftVehicles = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft) {
        aircraft.setAirportName(name);
        aircraftVehicles.add(aircraft);
    }

    public void removeAircraft(String aircraftName) {
        aircraftVehicles.removeIf(a -> a.getName().equals(aircraftName));
    }

    public Passenger searchPassenger(String aircraftName, int seatNumber) {
        for (Aircraft aircraft : aircraftVehicles) {
            if (aircraft.getName().equals(aircraftName)) {
                for (Passenger passenger : aircraft.getPassengers()) {
                    if (passenger.getSeatNumber() == seatNumber) {
                        return passenger;
                    }
                }
            }
        }
        return new Passenger("Not Found", -1, "");
    }

    public String getName() {
        return name;
    }
}
