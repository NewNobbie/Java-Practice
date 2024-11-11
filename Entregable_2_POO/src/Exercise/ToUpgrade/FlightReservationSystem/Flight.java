package Exercise.ToUpgrade.FlightReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class Flight {

    private String flightNumber;
    private String destination;
    private int totalSeats;
    private List<Integer> bookedSeats;

    // Constructor
    public Flight(String flightNumber, String destination, int totalSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = new ArrayList<>();
    }

    // Check if a seat is available
    public boolean isSeatAvailable(int seatNumber) {
        return seatNumber <= totalSeats && !bookedSeats.contains(seatNumber);
    }

    // Book a seat
    public boolean bookSeat(int seatNumber) {
        if (isSeatAvailable(seatNumber)) {
            bookedSeats.add(seatNumber);
            return true;
        } else {
            System.out.println("Seat " + seatNumber + " is not available.");
            return false;
        }
    }

    // Cancel a seat booking
    public boolean cancelSeat(int seatNumber) {
        if (bookedSeats.contains(seatNumber)) {
            bookedSeats.remove((Integer) seatNumber);
            return true;
        } else {
            System.out.println("Seat " + seatNumber + " is not currently booked.");
            return false;
        }
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", destination='" + destination + '\'' +
                ", totalSeats=" + totalSeats +
                ", bookedSeats=" + bookedSeats +
                '}';
    }
}
