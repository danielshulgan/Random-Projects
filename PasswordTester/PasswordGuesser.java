package PasswordTester;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PasswordGuesser {
    
    private static final Set<String> commonPasswords = loadCommonPasswords();
    //Read from Text File
    private static Set<String> loadCommonPasswords() {
        Set<String> passwords = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/danie/Desktop/java vs code/practice/src/PasswordTester/common_passwords.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line using spaces
                String[] passwordArray = line.split("\\s+");
                for (String password : passwordArray) {
                    passwords.add(password.trim().toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passwords;
    }
    
    public static void passStrength(String password) {
        boolean containsUppercase = false;
        boolean containsLowercase = false;
        boolean containsSpecialChar = false;
        boolean containsNumber = false;
        boolean containsConsecutiveChar = false;

        final int MIN_PASSWORD_LENGTH = 8;
        final int MIN_STRENGTH_THRESHOLD = 3;

        String[] passLevels = {"Weak", "Medium", "Strong"};
        int passIntStrength = 0;
        //Iterates over string and tests conditions and sets booleans
        for (int i = 1; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            char previousChar = password.charAt(i - 1);
            if (Character.isUpperCase(currentChar)) {
                containsUppercase = true;
            } else if (Character.isLowerCase(currentChar)) {
                containsLowercase = true;
            } else if (Character.isDigit(currentChar)) {
                containsNumber = true;
            } else if (currentChar == previousChar) {
                containsConsecutiveChar = true;
            } else {
                containsSpecialChar = true;
            }

        }
        //based on booleans adds or subtracts number value to passIntStrength
        if (containsLowercase) passIntStrength++;
        if (containsNumber) passIntStrength++;
        if (containsUppercase) passIntStrength++;
        if (containsSpecialChar) passIntStrength++;
        if (password.length() >= MIN_PASSWORD_LENGTH) passIntStrength += 3;
        if (password.length() <= MIN_STRENGTH_THRESHOLD) passIntStrength--;
        if (containsConsecutiveChar) passIntStrength--;
        //Checking common passwords
        if (commonPasswords.contains(password.toLowerCase())) {
            passIntStrength -= 3;
        }

        if (passIntStrength <= 3) {
            System.out.println(passLevels[0]);//Weak
        } else if (passIntStrength > 3 && passIntStrength <= 6) {
            System.out.println(passLevels[1]);//Medium
        } else {
            System.out.println(passLevels[2]);//Strong
        }
    }

    public static void main(String[] args) {
        String input = "password";
        passStrength(input);
    }
}
