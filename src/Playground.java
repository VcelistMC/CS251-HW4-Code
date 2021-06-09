package src;
import java.util.ArrayList;
import java.util.Scanner;

public class Playground {
    private String playgroundId;
    private String name;
    private String location;
    private float rating;
    private float pricePerHour;
    private PlaygroundOwner owner;
    private ArrayList<TimeSlot> timeSlots;
    private ArrayList<Reservation> reservations;
    private boolean isSuspended;

    /**
     * Constructs a new playground object with a playground name, location,price and owner
     *
     * @param name    sets the name for this playground
     * @param location sets the address for this playground
     * @param price   sets the price for this playground
     * @param owner   sets the owner for this playground
     */
    Playground(String name, String location, float price, PlaygroundOwner owner) {
        this.playgroundId = RandomStrGen.gen();
        this.name = name;
        this.location = location;
        this.pricePerHour = price;
        this.rating = 0;
        this.owner = owner;
        this.timeSlots = new ArrayList<TimeSlot>();
        this.reservations = new ArrayList<Reservation>();
        this.isSuspended = false;
    }
/**
 * display all reservations
 */
    public void viewAllReservations(){
        for(int i = 0; i < reservations.size(); i++){
            System.out.println("---------------------"+(i+1)+"---------------------");
            System.out.println(reservations.get(i).getInfo());
        }
    }
    /**
     * Sets the playground name
     *
     * @param name The name value for the playground to be set to
     *
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns playgroun's name
     *
     * @return String - the current playground name
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the playground location
     *
     * @param location The location value for the playground to be set to
     *
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * Returns playgroun's location
     *
     * @return String - the current playground location
     */
    public String getLocation() {
        return location;
    }
    /**
     * Sets the playground owner
     *
     * @param owner The owner value for the playground to be set to
     *
     */
    public void setOwner(PlaygroundOwner owner) {
        this.owner = owner;
    }
    /**
     * Returns playgroun's owner
     *
     * @return object - the current playground owner info
     */
    public PlaygroundOwner getOwner() {
        return owner;
    }
    /**
     * Sets the playground pricePerHour
     *
     * @param pricePerHour The pricePerHour value for the playground to be set to
     *
     */
    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
    /**
     * Returns playgroun's price
     *
     * @return float - the current playground price
     */
    public float getPricePerHour() {
        return pricePerHour;
    }
    /**
     * Returns playgroun's pricerating
     *
     * @return float - the current playground rating
     */
    public float getRating() {
        return rating;
    }

    /**
     * Returns playgroun's timeslots
     *
     * @return arraylist - the current playground timeslots
     */
    public ArrayList<TimeSlot> getTimeSlots() {
        return timeSlots;
    }
    /**
     * Sets the playground suspended
     *
     * @param suspended The suspended value for the playground to be set to
     *
     */
    public void setSuspended(boolean suspended) {
        isSuspended = suspended;
    }
    /**
     * Returns playgroun's suspended
     *
     * @return boolean - the current playground suspended
     */
    public boolean isSuspended() {
        return isSuspended;
    }
    /**
     * Sets the playground timeslots
     *
     * @param timeSlots The timeslots value for the playground to be set to
     *
     */
    public void setTimeSlots(ArrayList<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }
    /**
     * get all the info about the play ground
     */
    public String getInfo() {
        String returnVal = 
            "Name: " + name + "\n" +
            "Location: " + location + "\n" +
            "Rating: " + rating + "\n" +
            "Price Per Hour: " + pricePerHour;
        
        return returnVal;

    }
    /**
     * display all time slots
     */
    public void viewAllTimeSlots() {
        for(int i = 0; i < timeSlots.size(); i++){
            System.out.println("---------------------"+(i+1)+"---------------------");
            System.out.println(timeSlots.get(i).getInfo());
        }
    }
    /**
     * Returns playgroun's reservation
     *
     * @return arraylist - the current playground reservations
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    /**
     * adding new time slot
     */
    public void addTimeSlot(){
        int start;
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("enter the start time, Time slots are one hour each, enter -1 to exit");
            start = input.nextInt();
            if(start == -1)
                break;
            timeSlots.add(new TimeSlot(start, start+1));
        }

    }
    /**
     * player make reserve for the playground
     */
    public void reserve(Player player) {
        Scanner input = new Scanner(System.in);
        String date;
        ArrayList<TimeSlot> reservationTimeSlots = new ArrayList<TimeSlot>();

        while(true) {
            System.out.println("Choose a time slot, enter -1 to exit");
            viewAllTimeSlots();
            int choice = input.nextInt() - 1;
            if(choice != -1)
                break;
            if(!(choice < timeSlots.size()))
                continue;
            TimeSlot timeslot = timeSlots.get(choice);
            if(!timeslot.isBooked) {
                reservationTimeSlots.add(timeslot);
                timeslot.changeBookingState();
            }
            else{System.out.println("Wrong chocie!!");}
            
        }
        System.out.println("Enter the date");
        date = input.next();
        Reservation reservation = new Reservation(this, player, date, reservationTimeSlots);
        player.addReservation(reservation);
        reservations.add(reservation);
    }
}
