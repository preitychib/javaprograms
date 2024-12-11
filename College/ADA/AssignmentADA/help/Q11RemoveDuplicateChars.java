package AssignmentADA.help;

import java.util.Scanner;

public class Q11RemoveDuplicateChars {
    public static String removeDuplicates(String str) {
        // Create a boolean array to mark characters
        boolean[] seen = new boolean[128];
        
        // StringBuilder for efficient string manipulation
        StringBuilder result = new StringBuilder();
        
        // Iterate through each character in the string
        for (char ch : str.toCharArray()) {
            // If character hasn't been seen before, add it to result
            if (!seen[ch]) {
                seen[ch] = true;
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Original string: " + str);
        System.out.println("After removing duplicates: " + removeDuplicates(str));
        sc.close();
    }
}