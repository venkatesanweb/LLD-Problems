import java.util.*;

class BookingSystem {
    private List<Taxi> taxis;
    private int bookingId;

    BookingSystem(int taxiCount) {
        taxis = new ArrayList<>();
        for (int i = 1; i <= taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }

    private int calculateCharges(char pickup, char drop) {
        int distance = Math.abs(pickup - drop) * 15; // each char step = 15 km
        int charges = 100;
        if (distance > 5) {
            charges += (distance - 5) * 10;
        }
        return charges;
    }

    Taxi findTaxi(char pickup, int pickupTime) {
        List<Taxi> freeTaxis = new ArrayList<>();
        for (Taxi t : taxis) {
            if (t.isFree(pickup, pickupTime)) {
                freeTaxis.add(t);
            }
        }

        if (freeTaxis.isEmpty()) {
            return null;
        }

        int minDistance = Integer.MAX_VALUE;
        for (Taxi t : freeTaxis) {
            int distance = Math.abs(pickup - t.getCurentSport());
            minDistance = Math.min(distance, minDistance);
        }

        List<Taxi> closest = new ArrayList<>();
        for (Taxi t : freeTaxis) {
            int distance = Math.abs(pickup - t.getCurentSport());
            if (distance == minDistance) {
                closest.add(t);
            }
        }

        Taxi selected = closest.get(0);
        for (Taxi t : closest) {
            if (t.getEarnings() < selected.getEarnings()) {
                selected = t;
            }
        }

        return selected;
    }

    void bookTaxi(Customer c) {
        Taxi selected = findTaxi(c.getpichup(), c.getpicTime());
        if (selected == null) {
            System.out.println("No Taxi is Available");
            return;
        }

        int travelTime = Math.abs(c.getpichup() - c.getdrop());
        int dropTime = c.getpicTime() + travelTime;
        int charges = calculateCharges(c.getpichup(), c.getdrop());
        Booking booking = new Booking(bookingId++, dropTime, charges, c);

        selected.assignBookings(booking);
        selected.setFreeTime(dropTime);
        selected.setEarnings(selected.getEarnings() + charges);
        selected.setCurentSport(c.getdrop());

        System.out.println("Taxi-" + selected.getTxiId() + " is allocated.");
    }

    void displayTaxi() {
        for (Taxi t : taxis) {
            System.out.println("Taxi-" + t.getTxiId() + " | Earnings: " + t.getEarnings());
            System.out.println("Booking Id\tCustomer Id\tFrom\tTo\tPickup Time\tDrop Time\tAmount");
            for (Booking b : t.getBookings()) {
                System.out.println(
                        b.getBookingId() + "\t\t" + b.getCustomerId() + "\t\t" +
                                b.getPiceupPoint() + "\t\t" + b.getDropPoint() + "\t\t" +
                                b.getPickUpTime() + "\t\t" + b.getDropTime() + "\t\t" + b.getAmount());
            }
            System.out.println();
        }
    }
}
