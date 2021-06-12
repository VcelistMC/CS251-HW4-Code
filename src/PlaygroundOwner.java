package src;
import java.util.ArrayList;
import java.util.Scanner;

public class PlaygroundOwner extends User{
    private ArrayList<Playground> playgrounds;

    PlaygroundOwner(){
        super();
        playgrounds = new ArrayList<Playground>();
    }
    /**
     * Constructs a new playgroundowner object with a playground name, age,email,pswd and wallet
     *
     * @param name    sets the name for this playgroundowner
     * @param age sets the age for this playgroundowner
     * @param email   sets the email  for this playgroundowner
     * @param pswd   sets the password for this playgroundowner
     * @param wallet   sets the wallet for this playgroundowner
     */
    PlaygroundOwner(String name, int age, String email, String pswd, eWallet wallet) {
        super(name, age, email, pswd, wallet);
        playgrounds = new ArrayList<Playground>();
    }
    /**
     * accept a reservationrequest
     */
    public void approveReservationRequest(Reservation res){
        res.setReservationState("Accepted");
    }
    /**
     * reject a reservationrequest
     */
    public void denyReservationRequest(Reservation res) {
        res.setReservationState("Denied");
    }
    /**
     * adding a new playground
     */
    public void addPlayground(Playground playground) {
        playgrounds.add(playground);
    }
    /**
     * display all the playgrounds info
     */
    public void viewAllPlaygrounds() {
        for(int i = 0; i < playgrounds.size(); i++){
            System.out.println("---------------------"+(i+1)+"---------------------");
            System.out.println(playgrounds.get(i).getInfo());
        }

    }
    /**
     * Sets the playgrounds for the playgroundowner
     *
     * @param playgrounds The playgrounds value for the playgroundowner to be set to
     *
     */
    public void setPlaygrounds(ArrayList<Playground> playgrounds) {
        this.playgrounds = playgrounds;
    }

    /**
     * Returns playground's reservation
     *
     * @return arraylist - the current playground playgroundowner
     */
    public ArrayList<Reservation> getReservation(Playground playground) {
        return playground.getReservations();
    }
    /**
     * Returns playgrouns
     *
     * @return arraylist - the current playground playgroundowner
     */
    public ArrayList<Playground> getPlaygrounds(){
        return playgrounds;
    }

    /**
     * a function to manage all the setting of your playground by adding time slots and manage the reservation request
     */
    public void managePlayground() {
        Scanner input = new Scanner(System.in);
        viewAllPlaygrounds();
        System.out.println("select playground, enter -1 to go back");
        int playgroundInd = input.nextInt();
        if(playgroundInd -1 < playgrounds.size() && playgroundInd != -1) {
            Playground chosenPlayground = playgrounds.get(playgroundInd-1);
            int userChoice;
            do {
                System.out.println("1. add a time slot\n2. manage reservation requests\n3. back");
                userChoice = input.nextInt();
                switch (userChoice) {
                    case 1:
                        chosenPlayground.addTimeSlot();
                        break;
                    
                    case 2:
                        chosenPlayground.viewAllReservations();
                        ArrayList<Reservation> playgroundReservations = chosenPlayground.getReservations();
                        System.out.println("Select reservation, enter -1 to go back");
                        int chosenReservationInd = input.nextInt();
                        if(chosenReservationInd-1 < playgroundReservations.size() && chosenReservationInd != -1) {
                            Reservation chosenReservation = playgroundReservations.get(chosenReservationInd-1);
                            System.out.println("1. Accept reservation\n2. Reject Reservation");
                            int reservationState = input.nextInt();

                            if(reservationState == 1)
                                approveReservationRequest(chosenReservation);
                            else
                                denyReservationRequest(chosenReservation);
                        }

                    default:
                       continue;
                }
            }
            while(userChoice != 3);
        }
        
    }
}
