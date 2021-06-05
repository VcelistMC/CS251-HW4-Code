package src;

import java.util.ArrayList;

public class Player extends User {
    private ArrayList<Reservation> reservations;
    /**
     * default constructor
     */
    Player() {
        super();
    }

    /**
     * parameterized constructor
     * @param name player name
     * @param age palyer's age
     * @param email player's email
     * @param password player's password
     * @param wallet player's eWallet
     */
    Player(String name, int age, String email, String password, eWallet wallet) {
        super(name, age, email, password, wallet);
    }

    /**
     * get player's reservations
     * @return ArrayList<Reservation>
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    /**
     * adds a reservation to the player's personal list
     * @param reservation the reservation to be added
     */
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
