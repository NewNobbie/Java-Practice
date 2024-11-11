package Exercise.ToUpgrade.FlightReservationSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reservation {

    private Passenger passenger;
    private Flight flight;
    private LocalDate date;
    private int seatNumber;

    // Constructor
    public Reservation(Passenger passenger, Flight flight, LocalDate date, int seatNumber) {
        this.passenger = passenger;
        this.flight = flight;
        this.date = date;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "passenger=" + passenger +
                ", flight=" + flight.getFlightNumber() +
                ", date=" + date +
                ", seatNumber=" + seatNumber +
                '}';
    }

    // Main method for reservation management
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample flights for the system
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("FL123", "New York", 10));
        flights.add(new Flight("FL456", "Los Angeles", 5));
        flights.add(new Flight("FL789", "Chicago", 8));

        // List of reservations
        List<Reservation> reservations = new ArrayList<>();

        while (true) {
            System.out.println("\nFlight Reservation System\n" +
                    "1. Book a flight\n" +
                    "2. Cancel a reservation\n" +
                    "3. Show all reservations\n" +
                    "4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("Enter passport number: ");
                    String passportNumber = scanner.nextLine();
                    Passenger passenger = new Passenger(passengerName, passportNumber);

                    System.out.println("Available flights:");
                    for (int i = 0; i < flights.size(); i++) {
                        System.out.println((i + 1) + ". " + flights.get(i));
                    }
                    System.out.print("Select a flight by number: ");
                    int flightChoice = scanner.nextInt();
                    if (flightChoice < 1 || flightChoice > flights.size()) {
                        System.out.println("Invalid flight selection.");
                        break;
                    }
                    Flight selectedFlight = flights.get(flightChoice - 1);

                    System.out.print("Enter seat number: ");
                    int seatNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (selectedFlight.bookSeat(seatNumber)) {
                        Reservation reservation = new Reservation(passenger, selectedFlight, LocalDate.now(), seatNumber);
                        reservations.add(reservation);
                        System.out.println("Reservation successful: " + reservation);
                    }
                    break;

                case 2:
                    System.out.print("Enter passenger name to cancel reservation: ");
                    String nameToCancel = scanner.nextLine();
                    System.out.print("Enter flight number: ");
                    String flightToCancel = scanner.nextLine();
                    System.out.print("Enter seat number: ");
                    int seatToCancel = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Reservation reservationToCancel = null;
                    for (Reservation res : reservations) {
                        if (res.passenger.getName().equalsIgnoreCase(nameToCancel) &&
                                res.flight.getFlightNumber().equalsIgnoreCase(flightToCancel) &&
                                res.seatNumber == seatToCancel) {
                            reservationToCancel = res;
                            break;
                        }
                    }

                    if (reservationToCancel != null) {
                        reservations.remove(reservationToCancel);
                        reservationToCancel.flight.cancelSeat(seatToCancel);
                        System.out.println("Reservation canceled for " + nameToCancel);
                    } else {
                        System.out.println("Reservation not found.");
                    }
                    break;

                case 3:
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations found.");
                    } else {
                        System.out.println("All Reservations:");
                        for (Reservation res : reservations) {
                            System.out.println(res);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting the reservation system...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
