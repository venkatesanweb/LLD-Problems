public class Passenger {
    private String name;
    private String bookingId;
    private int age;
    private int seatsBooking;

    public Passenger(String name, String bookingId, int age, int seatsBooking) {
        this.name = name;
        this.bookingId = bookingId;
        this.age = age;
        this.seatsBooking = seatsBooking;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", age=" + age +
                ", seatsBooking=" + seatsBooking +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getBookingId() {
        return bookingId;
    }

    public int getAge() {
        return age;
    }

    public int getSeatsBooking() {
        return seatsBooking;
    }
}
