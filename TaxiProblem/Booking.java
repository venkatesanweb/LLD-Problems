public class Booking {

    private int bookingId; 
    private int dropTime;
    private int amount;
    private Customer customer;
    public Booking(int bookingId, int dropTime, int amount, Customer customer) {
        this.bookingId = bookingId;
        this.dropTime = dropTime;
        this.amount = amount;
        this.customer = customer;
    }
    public int getBookingId() {
        return bookingId;
    }
    public int getDropTime() {
        return dropTime;
    }
    public int getAmount() {
        return amount;
    }
    public Customer getCustomer() {
        return customer;
    }
    public int getCustomerId(){
        return this.customer.getcustomerId();

    }
    public int getPiceupPoint(){
        return this.customer.getpichup();
    }
    public int getPickUpTime(){
        return this.customer.getpicTime();
    } 
    public int getDropPoint(){
        return this.customer.getdrop();
    }
}