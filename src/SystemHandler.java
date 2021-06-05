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
        System.out.println("Register as a 1. player or 2. playground owner");
        int choice = this.input.nextInt();

        System.out.println("enter name");
        String name = this.input.nextLine();
        
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
            addOwner(new PlayergroundOwner(name, age, email, pswd, wallet));
            
            
        System.out.println("Registered!!");
    }

    /**
     * registers a new playground
     * @param owner the playground's owner
     * @return true if success, false otherwise
     */
    public boolean registerPlayground(PlaygroundOwner owner) {
        try{
            System.out.println("enter name");
            String name = this.input.nextLine();
            
            System.out.println("enter location");
            String location = this.input.next();

            System.out.println("enter price per hour");
            float price_per_hour = this.input.nextFloat();

            System.out.println("enter booking hours");
            String bookingHours = this.input.next();
            Playground newPlayground = new Playground(name, location, price_per_hour, bookingHours, owner);

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
            if(players.get(i).getEmail() == email && players.get(i).password == pswd) {
                player = players.get(i);
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
            if(pOwners.get(i).getEmail() == email && pOwners.get(i).password == pswd) {
                owner = pOwners.get(i);
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
            System.out.println("---------------------"+i+1+"---------------------");
            playgrounds.get(i).getInfo();
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
                        playerReservations.get(i).getInfo();
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
            System.out.println("1. register playground\n 2.manage reservation requests\n3. back");
            choice = this.input.nextInt()
            switch (choice) {
                case 1:
                    registerPlayground(currOwner);
                    break;
                case 2:
                    System.out.println("select playground");
                    viewAllPlaygrounds();
                    int chosenPlaygroundind = this.input.nextInt();
                    Playground chosenPlayground = playgrounds.get(chosenPlaygroundind-1);
                    
                default:
                    continue;
            }
        }
        while(choice != 3);
    }
}
