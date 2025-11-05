import java.util.*;

public class TicketSystem {

    private final List<String> avaliabeBreath = new ArrayList<>(Arrays.asList("L", "U", "M"));
    private final Queue<Pasanger> racQueue = new LinkedList<>();   
    private final Queue<Pasanger> waitingListQueue = new LinkedList<>();
    private final List<Pasanger> confirmedPassangers = new ArrayList<>();

    private int ticketCounter = 1;

    public void bookticket(String name, int age, String gender, String berthPreference) {
        String ticketId = "T" + ticketCounter++;
        Pasanger pasanger;

        if (!avaliabeBreath.isEmpty()) {
            String berthAllocate = allocatedBearth(age, gender, berthPreference);
            pasanger = new Pasanger(name, age, gender, berthPreference, berthAllocate, ticketId);
            confirmedPassangers.add(pasanger);
            avaliabeBreath.remove(berthAllocate);
            System.out.println("Ticket confirmed: " + pasanger);
        } 
        else if (racQueue.size() < 1) {
            pasanger = new Pasanger(name, age, gender, berthPreference, "RAC", ticketId);
            racQueue.offer(pasanger);
            System.out.println("Ticket in RAC: " + pasanger);
        } 
        else if (waitingListQueue.size() < 1) {
            pasanger = new Pasanger(name, age, gender, berthPreference, "Waiting List", ticketId);
            waitingListQueue.offer(pasanger);
            System.out.println("Ticket in Waiting List: " + pasanger);
        } 
        else {
            System.out.println("No Tickets available");
        }
    }

    public String allocatedBearth(int age, String gender, String preference) {
        if ((age > 60 || gender.equalsIgnoreCase("female")) && avaliabeBreath.contains("L")) {
            return "L";
        }
        if (avaliabeBreath.contains(preference)) {
            return preference;
        }
        return avaliabeBreath.get(0);
    }

    public void cancelTicket(String ticketId) {
        Optional<Pasanger> passengerOpt = confirmedPassangers.stream()
                .filter(p -> p.ticketId.equals(ticketId))
                .findFirst();

        if (passengerOpt.isPresent()) {
            Pasanger pasanger = passengerOpt.get();
            confirmedPassangers.remove(pasanger);
            avaliabeBreath.add(pasanger.allocateBerth); // fixed variable name

            if (!racQueue.isEmpty()) {
                Pasanger racPasanger = racQueue.poll();
                String allocateBerth = allocatedBearth(racPasanger.age, racPasanger.gender, racPasanger.berthpreference);
                racPasanger.allocateBerth = allocateBerth;
                confirmedPassangers.add(racPasanger);
                avaliabeBreath.remove(allocateBerth);
                System.out.println("RAC ticket moved to confirmed: " + racPasanger);
            }

            if (!waitingListQueue.isEmpty()) {
                Pasanger waitingPasanger = waitingListQueue.poll();
                racQueue.offer(waitingPasanger);
                waitingPasanger.allocateBerth = "RAC";
                System.out.println("Waiting list ticket moved to RAC: " + waitingPasanger);
            }

            System.out.println("Ticket cancelled successfully for ID: " + ticketId);
        } 
        else {
            System.out.println("No Ticket found with ID: " + ticketId);
        }
    }

    public void printBookedTickets() {
        if (confirmedPassangers.isEmpty()) {
            System.out.println("No Confirmed Tickets.");
        } else {
            System.out.println("Confirmed Tickets:");
            for (Pasanger pass : confirmedPassangers) {
                System.out.println(pass);
            }
        }
    }

    public void printAvaliableTicekets() { // kept your original name for compatibility
        System.out.println("Available Berths: " + avaliabeBreath.size());
        System.out.println("Available RAC Tickets: " + (1 - racQueue.size()));
        System.out.println("Available Waiting List Tickets: " + (1 - waitingListQueue.size()));
    }

    public void viewRecTickets() {
        if (racQueue.isEmpty()) {
            System.out.println("No RAC Tickets.");
        } else {
            System.out.println("RAC Tickets:");
            for (Pasanger pss : racQueue) {
                System.out.println(pss);
            }
        }
    }

    public void viewWaitingListTickets() {
        if (waitingListQueue.isEmpty()) {
            System.out.println("No Waiting List Tickets.");
        } else {
            System.out.println("Waiting List Tickets:");
            for (Pasanger pss : waitingListQueue) {
                System.out.println(pss);
            }
        }
    }
}
