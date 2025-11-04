import java.util.*;
public class Taxi {
    private int txiId;
    private char curentSport;
    private int freeTime;
    private int earnings;
    private List <Booking> bookings;


    public Taxi(int id){
        this.txiId=id;
        this.curentSport='A';
        this.freeTime=0;
        this.earnings=0;
        bookings=new ArrayList<>();
        
    }
    
    public void assignBookings(Booking booking){
        bookings.add(booking);
    }

    public boolean isFree(char picup,int pichupTime){

        int travelTime=Math.abs(picup-curentSport);
        int val=freeTime+travelTime;
        if(val<=pichupTime){
            return true;
        }
        return false;
    }


    public int getTxiId() {
        return txiId;
    }


    public char getCurentSport() {
        return curentSport;
    }


    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freetime){
        this.freeTime=freetime;
    }


    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings){
        this.earnings=earnings;
    }


    public List<Booking> getBookings() {
        return bookings;
    }

    public void setTxiId(int txiId) {
        this.txiId = txiId;
    }

    public void setCurentSport(char curentSport) {
        this.curentSport = curentSport;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    
    
    
    

}
