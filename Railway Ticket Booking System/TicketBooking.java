import java.util.*;

public class TicketBooking {
    public static void main(String[] args) {
        TicketSystem ticketSystem = new TicketSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nRailway Booking System: ");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Confirmed Tickets");
            System.out.println("4. View Available Tickets");
            System.out.println("5. View RAC Tickets");
            System.out.println("6. View Waiting List Tickets");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (n) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Gender (Male/Female): ");
                    String gen = sc.nextLine();
                    System.out.print("Enter Berth Preference (L/U/M): ");
                    String breth = sc.nextLine();
                    ticketSystem.bookticket(name, age, gen, breth);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to Cancel: ");
                    String ticid = sc.nextLine();
                    ticketSystem.cancelTicket(ticid);
                    break;

                case 3:
                    ticketSystem.printBookedTickets();
                    break;

                case 4:
                    ticketSystem.printAvaliableTicekets();
                    break;

                case 5:
                    ticketSystem.viewRecTickets();
                    break;

                case 6:
                    ticketSystem.viewWaitingListTickets();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
