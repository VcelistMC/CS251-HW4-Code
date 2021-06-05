package src;

import java.util.Random;

public class RandomStrGen {
    static String gen(){
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder Str = new StringBuilder();
        Random rnd = new Random();
        while (Str.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            Str.append(CHARS.charAt(index));
        }
        String returnStr = Str.toString();
        return returnStr;
    }
}
