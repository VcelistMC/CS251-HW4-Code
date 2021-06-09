package src;

import java.util.ArrayList;

public class Reservation {
    private Playground playground;
    private Player player;
    private String date;
    private ArrayList<TimeSlot> timeSlots;
    private String reservationState;
    /**
     * Constructs a new reservation object with a playground , player ,date and time slots
     *
     * @param player sets the player  for this reservation
     * @param playground sets the playground for this reservation
     * @param date  sets the date for this reservation
     * @param timeSlots   sets the timeslots for this reservation
     */
    Reservation(Playground playground, Player player, String date, ArrayList<TimeSlot> timeSlots) {
        this.player = player;
        this.playground = playground;
        this.date = date;
        this.timeSlots = timeSlots;
        this.reservationState = "Not yet decided";
    }
    /**
     * Sets the reservationState
     *
     * @param reservationState The reservationState value for the reservation to be set to
     *
     */
    public void setReservationState(String state) {this.reservationState = state;}
    /**
     * Sets the Timeslots
     *
     * @param timeSlots The timeslots value for the reservation to be set to
     *
     */
    public void setTimeSlots(ArrayList<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }
    /**
     * Returns timeslots
     *
     * @return ArrayList - the current timeslots
     */
    public ArrayList<TimeSlot> getTimeSlots() {
        return timeSlots;
    }
    /**
     * Returns player
     *
     * @return object - the current player
     */
    public Player getPlayer() {
        return player;
    }
    /**
     * Returns playground
     *
     * @return object - the current playground
     */
    public Playground getPlayground() {
        return playground;
    }
    /**
     * Sets the date
     *
     * @param date The date value for the reservation to be set to
     *
     */
    public void setDate(String date) {
        this.date = date;
    }
    /**
     * Returns date
     *
     * @return String - the current date
     */
    public String getDate() {
        return date;
    }
    /**
     * Sets the player info
     *
     * @param player The player value for the reservation to be set to
     *
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
    /**
     * Sets the playground info
     *
     * @param playground The playerground value for the reservation to be set to
     *
     */
    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    /**
     * get all the info about the reservation
     */

    public String getInfo() {
        String returnVal =
            playground.getInfo() + "\n" +
            "-----------------------" + "\n" +
            player.getInfo() +
            "-----------------------" + "\n" +
            "Date: " + date + "\n" +
            "State: " + reservationState;
        return returnVal;
    }

}
