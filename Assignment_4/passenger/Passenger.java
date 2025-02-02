package Assignment_4.passenger;

public class Passenger {
    private String name;
    private int seatNumber;
    private String aircraftName;

    public Passenger(String name, int seatNumber, String aircraftName) {
        this.name = name;
        this.seatNumber = seatNumber;
        this.aircraftName = aircraftName;
    }

    public String getName() {
        return name;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
    }
}
