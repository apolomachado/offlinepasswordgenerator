package pt.apolomachado.opg.utils;

import java.util.Random;

public class PasswordGenerator {

    protected static char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    protected static int[] numbersArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    protected static char[] symbolsArray = { '!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', ']', '^', '_', '`', '{', '|', '}'};

    public static String generatePassword(int size, boolean letters, boolean numbers, boolean symbols) {
        StringBuilder password = new StringBuilder();
        int points = 3;
        for(int round = 0; round < size; round++) {
            Random random = new Random();
            int type = random.nextInt(points);
            if(type == 0) {
                if(letters) {
                    password.append(alphabet[random.nextInt(alphabet.length)]);
                } else {
                    type = 1;
                }
            }
            if(type == 1) {
                if(numbers) {
                    password.append(numbersArray[random.nextInt(numbersArray.length)]);
                } else {
                    type = 2;
                }
            }
            if(type == 2) {
                if(symbols) {
                    password.append(symbolsArray[random.nextInt(symbolsArray.length)]);
                } else {
                    if(letters) {
                        password.append(alphabet[random.nextInt(alphabet.length)]);
                    }
                }
            }
        }
        return password.toString();
    }
}
