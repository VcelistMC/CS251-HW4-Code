package src;
import java.util.ArrayList;
import java.util.Scanner;
public class SystemHandler {
    private ArrayList<Player> players;
    private ArrayList<Playground> playgrounds;
    private ArrayList<PlaygroundOwner> pOwners;
    private Scanner input;

    SystemHandler() {
        players = new ArrayList<Player>();
        playgrounds = new ArrayList<Playground>();
        pOwners = new ArrayList<PlaygroundOwner>();
        input = new Scanner(System.in);
    }

    public void addPlayer(Player player) { this.players.add(player); }
    public void addPlayground(Playground playground) { this.playgrounds.add(playground); }
    public void addOwner(PlaygroundOwner pOwner) { this.pOwners.add(pOwner); }
    
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

            System.out.println("Playground Added!!");
        }catch(Exception e){return false;}
        return true;
    }

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

    public Player loginAspOwner() {
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

    public void viewAllPlaygrounds(){
        for(int i = 0; i < playgrounds.size(); i++)
            playgrounds.get(i).getInfo();
    }

}
