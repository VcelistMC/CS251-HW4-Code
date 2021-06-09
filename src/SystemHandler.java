package src;
import java.util.ArrayList;
import java.util.Scanner;
public class SystemHandler {
    private ArrayList<Player> players;
    private ArrayList<Playground> playgrounds;
    private ArrayList<PlaygroundOwner> pOwners;
    private Scanner input;

    /**
     * default ctor
     */
    SystemHandler() {
        players = new ArrayList<Player>();
        playgrounds = new ArrayList<Playground>();
        pOwners = new ArrayList<PlaygroundOwner>();
        input = new Scanner(System.in);
    }

    /**
     * adds a new player to the database
     * @param player the player to be added
     */
    public void addPlayer(Player player) { this.players.add(player); }
    /**
     * adds a new playground to the database
     * @param playground the playground to be added
     */
    public void addPlayground(Playground playground) { this.playgrounds.add(playground); }
    /**
     * adds a new owner to the database
     * @param pOwner the owner to be added
     */
    public void addOwner(PlaygroundOwner pOwner) { this.pOwners.add(pOwner); }
    
    /**
     * regisers a new user and adds it to the database
     */
    public void register() {
        System.out.println("Register as a \n1. player\n2. playground owner");
        int choice = this.input.nextInt();

        System.out.println("enter name");
        String name = this.input.next();
        
        System.out.println("enter age");
        int age = this.input.nextInt();

        System.out.println("enter email");
        String email = this.input.next();

        System.out.println("enter password");
        String pswd = this.input.next();

        eWallet wallet = new eWallet();

        if(choice == 1)
            addPlayer(new Player(name, age, email, pswd, wallet));
        else
            addOwner(new PlaygroundOwner(name, age, email, pswd, wallet));
            
            
        System.out.println("Registered!!");
        //System.out.println(pOwners.get(0).getInfo());
    }

    /**
     * registers a new playground
     * @param owner the playground's owner
     * @return true if success, false otherwise
     */
    public boolean registerPlayground(PlaygroundOwner owner) {
        try{
            System.out.println("enter name");
            String name = this.input.next();
            
            System.out.println("enter location");
            String location = this.input.next();

            System.out.println("enter price per hour");
            float price_per_hour = this.input.nextFloat();

            Playground newPlayground = new Playground(name, location, price_per_hour, owner);
            System.out.println("Register your playground time slots");
            newPlayground.addTimeSlot();

            addPlayground(newPlayground);
            owner.addPlayground(newPlayground);

            System.out.println("Playground Added!!");
        }catch(Exception e){return false;}
        return true;
    }

    /**
     * player login screen
     * @return the player object
     */
    public Player loginAsPlayer() {
        Player player = null;
        System.out.println("enter email");
        String email = this.input.next();

        System.out.println("enter password");
        String pswd = this.input.next();

        for(int i = 0; i < players.size(); i++) {
            Player currPlayer = players.get(i);
            String e = currPlayer.getEmail();
            String pass = currPlayer.getPass();
            boolean emailMatches = e.equals(email);
            boolean passMatches = pass.equals(pswd);
            if(emailMatches && passMatches) {
                player = currPlayer;
                break;
            }
        }
        return player;
    }

    /**
     * owner login screen
     * @return the owner object
     */
    public PlaygroundOwner loginAspOwner() {
        PlaygroundOwner owner = null;
        System.out.println("enter email");
        String email = this.input.next();

        System.out.println("enter password");
        String pswd = this.input.next();

        for(int i = 0; i < pOwners.size(); i++) {
            PlaygroundOwner currOwner = pOwners.get(i);
            String e = currOwner.getEmail();
            String pass = currOwner.getPass();
            boolean emailMatches = e.equals(email);
            boolean passMatches = pass.equals(pswd);
            if(emailMatches && passMatches) {
                owner = currOwner;
                break;
            }
        }
        return owner;
    }

    /**
     * prints all playgrounds
     */
    public void viewAllPlaygrounds(){
        for(int i = 0; i < playgrounds.size(); i++) {
            System.out.println("---------------------"+(i+1)+"---------------------");
            System.out.println(playgrounds.get(i).getInfo());
        }
    }

    /**
     * player screen function
     * @param currPlayer the player to handle
     */
    public void handlePlayer(Player currPlayer) {
        int choice;
        do {
            System.out.println("1. Book playground\n2. view reservations\n3. back");
            choice = this.input.nextInt();
            switch (choice) {
                case 1:
                    viewAllPlaygrounds();
                    int playgroundChoice = this.input.nextInt();
                    if(playgroundChoice-1 < playgrounds.size()) {
                        Playground currPlayground = playgrounds.get(playgroundChoice-1);
                        currPlayground.reserve(currPlayer);
                    }
                    else
                        System.out.println("Wrong choice");
                    break;
                case 2:
                    ArrayList<Reservation> playerReservations = currPlayer.getReservations();
                    for(int i = 0; i < playerReservations.size(); i++)
                        System.out.println(playerReservations.get(i).getInfo());
                    break;
                case 3:
                    break;
                default:
                    continue;
            }
        }
        while(choice != 3);
    }

    /**
     * owner screen function
     * @param currOwner the owner to handle
     */
    public void handlePlaygroundOwner(PlaygroundOwner currOwner) {
        int choice;
        do {
            System.out.println("1. register playground\n2. manage playgrounds\n3. back");
            choice = this.input.nextInt();
            switch (choice) {
                case 1:
                    registerPlayground(currOwner);
                    break;
                case 2:
                    currOwner.managePlayground();
                    // currOwner.viewAllPlaygrounds();
                    // ArrayList<Playground> ownerPlaygrounds = currOwner.getPlaygrounds();
                    // System.out.println("select playground, enter -1 to go back");
                    // int chosenPlaygroundind = this.input.nextInt();
                    // if(chosenPlaygroundind - 1 < ownerPlaygrounds.size()) {
                    //     Playground chosenPlayground = playgrounds.get(chosenPlaygroundind-1);
                    //     ArrayList<Reservation> playgroundReservations = chosenPlayground.getReservations();
                    //     chosenPlayground.viewAllReservations();
                    //     System.out.println("Select reservation, enter -1 to go back");
                    //     int chosenReservationInd = this.input.nextInt();
                    //     if(chosenPlaygroundind-1 < playgroundReservations.size()) {
                    //         Reservation chosenReservation = playgroundReservations.get(chosenReservationInd-1);
                    //         System.out.println("1. Accept reservation\n2. Reject Reservation");
                    //         int reservationState = this.input.nextInt();

                    //         if(reservationState == 1)
                    //             currOwner.approveReservationRequest(chosenReservation);
                    //         else
                    //             currOwner.denyReservationRequest(chosenReservation);
                    //     }
                    // }
                    
                default:
                    continue;
            }
        }
        while(choice != 3);
    }
}
