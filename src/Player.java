package src;

import java.util.ArrayList;

public class Player extends User {
    private ArrayList<Reservation> reservations;

    Player() {
        super();
    }

    Player(String name, int age, String email, String password, eWallet wallet) {
        super(name, age, email, password, wallet);
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
