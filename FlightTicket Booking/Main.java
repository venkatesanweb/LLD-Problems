import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlightReservationSystem sys = new FlightReservationSystem();

        while (true) {
            System.out.println("\n--- Flight Reservation System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Print Flight Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1:
                    System.out.print("Enter flight name (Indigo/SpiceJet): ");
                    String flightName = sc.nextLine();
                    if (sys.flights.containsKey(flightName)) {
                        sys.displayFlightDetails(flightName);

                        System.out.print("Enter passenger name: ");
                        String passengerName = sc.nextLine();

                        System.out.print("Enter passenger age: ");
                        int age = sc.nextInt();

                        System.out.print("Enter number of seats to book: ");
                        int seats = sc.nextInt();
                        sc.nextLine(); // consume newline

                        String bookingId = sys.bookTicket(flightName, passengerName, age, seats);
                        if (bookingId != null) {
                            System.out.println("Booking successful! Your booking ID is: " + bookingId);
                        }
                    } else {
                        System.out.println("Invalid flight name. Please try again.");
                    }
                    break;

                case 2:
                    System.out.print("Enter flight name (Indigo/SpiceJet): ");
                    flightName = sc.nextLine();
                    System.out.print("Enter booking ID: ");
                    String bookingId = sc.nextLine();
                    sys.cancelTicket(flightName, bookingId);
                    break;

                case 3:
                    System.out.print("Enter flight name (Indigo/SpiceJet): ");
                    flightName = sc.nextLine();
                    sys.printFlightDetails(flightName);
                    break;

                case 4:
                    System.out.println("Exiting system. Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
