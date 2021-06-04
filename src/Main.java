package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SystemHandler currSystem = new SystemHandler();
        while (true) {
            System.out.println("1. register\n2. login\n 3. exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    currSystem.register();
                    break;
                case 2:
                    System.out.println("1. player\n2. playground owner\n 3. exit");
                    choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            
                            break;
                    
                        default:
                            break;
                    }
                default:
                    break;
            }
        }
    }
}
