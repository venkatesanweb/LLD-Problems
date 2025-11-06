import java.util.*;

public class Flight {
    private String flightName;
    private int availableTickets;
    private int ticketPrice;
    private Map<String, Passenger> bookings;
    private int bookingCount;

    public Flight(String flightName) {
        this.flightName = flightName;
        this.availableTickets = 50;
        this.ticketPrice = 5000;
        this.bookings = new HashMap<>();
        this.bookingCount = 0;
    }

    public String bookTickets(String passengerName, int age, int seats) {
        if (seats <= availableTickets) {
            bookingCount++;
            String bookingId = "T" + bookingCount;
            Passenger passenger = new Passenger(passengerName, bookingId, age, seats);
            bookings.put(bookingId, passenger);
            availableTickets -= seats;
            System.out.println("Total cost: Rs " + (ticketPrice * seats));
            return bookingId;
        } else {
            System.out.println("Booking failed: Not enough tickets available.");
            return null;
        }
    }

    public boolean cancelTickets(String bookingId) {
        Passenger passenger = bookings.get(bookingId);
        if (passenger != null) {
            int seats = passenger.getSeatsBooking();
            availableTickets += seats;
            bookings.remove(bookingId);
            System.out.println("Booking canceled successfully. Refund issued for " + seats + " seat(s).");
            return true;
        } else {
            System.out.println("Cancellation failed: Booking ID not found.");
            return false;
        }
    }

    public void displayDetails() {
        System.out.println("Flight: " + flightName);
        System.out.println("Available seats: " + availableTickets);
        System.out.println("Ticket price per seat: Rs " + ticketPrice);
    }

    public void printPassengerDetails() {
        System.out.println("Flight: " + flightName);
        System.out.println("Available seats: " + availableTickets);
        System.out.println("Ticket price: Rs " + ticketPrice);
        System.out.println("Passengers:");
        for (Passenger p : bookings.values()) {
            System.out.println(p);
        }
    }
}
