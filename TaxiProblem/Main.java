public class Main {
    
    public static void main(String[] args) {
        Customer c1=new Customer(1, 'A', 'B', 9);
        Customer c2=new Customer(2, 'B', 'D', 9);
        Customer c3=new Customer(3, 'B', 'C', 12);


        BookingSystem bookSysystem=new BookingSystem(4);
        bookSysystem.bookTaxi(c1);
        bookSysystem.bookTaxi(c2);
        bookSysystem.bookTaxi(c3);
        bookSysystem.displayTaxi();
    }
}
