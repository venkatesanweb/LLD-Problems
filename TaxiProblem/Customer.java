public class Customer{
    private int customerId;
    private char pickup;
    private char drop;
    private int picTime;
    public Customer(int customerId, char pickup, char drop, int picTime) {
        this.customerId = customerId;
        this.pickup = pickup;
        this.drop = drop;
        this.picTime = picTime;
    }
    
    public int getcustomerId() 
    {
        return customerId;
    }
    public char getpichup()
    {
        return pickup;    
    }
    public char getdrop()
    {
        return drop;
    }
    public int getpicTime()
    {
        return picTime;
    }

    
    
}