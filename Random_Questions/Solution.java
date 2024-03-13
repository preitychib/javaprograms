import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static char findRepeatingChars(String inputStr) {
        boolean found = false;
        Map<Character, Integer> charCount = new HashMap<>();

        // Populate the hashmap with character counts
        for (char c : inputStr.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Check even indices for repeating characters
        for (int i = 0; i < inputStr.length(); i += 2) {
            char currentChar = inputStr.charAt(i);
            if (charCount.get(currentChar) == 1) {
                System.out.println(currentChar);
                found = true;
                break;
            }
        }

        if(!found)
            for (int i = 1; i < inputStr.length(); i += 2) {
                char currentChar = inputStr.charAt(i);
                if (charCount.get(currentChar) == 1) {
                    System.out.println(currentChar);
                    found = true;
                    break;
                }
            }

            System.out.println(-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Call the function and display the result
        char result = findRepeatingChars(userInput);
        if (result != '\0') {
            System.out.println("The first repeating character is: " + result);
        }
    }
}

