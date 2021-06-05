package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SystemHandler currSystem = new SystemHandler();
        int choice = 0;
        do {
            System.out.println("1. register\n2. login\n3. exit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    currSystem.register();
                    break;

                case 2:
                    System.out.println("1. player\n2. playground owner\n3. back");
                    choice = input.nextInt();

                    switch (choice) {
                        case 1:
                            Player currPlayer = currSystem.loginAsPlayer();
                            if(currPlayer != null)
                                currSystem.handlePlayer(currPlayer);
                            else
                                System.out.println("wrong login");
                            break;

                        case 2:
                            PlaygroundOwner currOwner = currSystem.loginAspOwner();
                            if(currOwner != null)
                                currSystem.handlePlaygroundOwner(currOwner);
                            else
                                System.out.println("wrong login");

                        case 3:
                            break;
                    
                        default:
                            continue;
                    }
                case 3:
                    break;
                default:
                    continue;
            }
        }
        while(choice != 3);
        input.close();
    }
}
