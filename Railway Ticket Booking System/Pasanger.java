public class Pasanger {

    String name;
    int age;
    String gender;
    String berthpreference;
    String allocateBerth;
    String ticketId;

    public Pasanger(String name, int age, String gender, String berthpreference, String allocateBerth, String ticketId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthpreference = berthpreference;
        this.allocateBerth = allocateBerth;
        this.ticketId = ticketId;
    }

    
    public String toString() {
        return "Ticket ID: " + ticketId +
               ", Name: " + name +
               ", Age: " + age +
               ", Gender: " + gender +
               ", Berth: " + allocateBerth;
    }
}
