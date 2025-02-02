package Assignment_4.main;

import Assignment_4.airport.Airport;
import Assignment_4.aircraft.Aircraft;
import Assignment_4.passenger.Passenger;

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport("Astana International");

        Aircraft aircraft1 = new Aircraft("Boeing 747", 2);
        Aircraft aircraft2 = new Aircraft("Airbus A320", 3);

        airport.addAircraft(aircraft1);
        airport.addAircraft(aircraft2);

        Passenger passenger1 = new Passenger("Alice", 1, "Boeing 747");
        Passenger passenger2 = new Passenger("Bob", 2, "Airbus A320");
        Passenger passenger3 = new Passenger("Charlie", 3, "Airbus A320");
        Passenger passenger4 = new Passenger("David", 4, "Airbus A320");

        aircraft1.addPassenger(passenger1);
        aircraft2.addPassenger(passenger2);
        aircraft2.addPassenger(passenger3);
        aircraft2.addPassenger(passenger4);

        System.out.println("Passengers in Airbus A320:");
        for (Passenger p : aircraft2.getPassengers()) {
            System.out.println("Name: " + p.getName() + ", Seat No: " + p.getSeatNumber());
        }

        Passenger found = airport.searchPassenger("Airbus A320", 3);
        System.out.println("\nSearched Passenger:");
        System.out.println("Name: " + found.getName() + ", Seat No: " + found.getSeatNumber());
    }
}
