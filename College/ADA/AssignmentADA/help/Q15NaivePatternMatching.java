package AssignmentADA.help;

import java.util.Scanner;

public class Q15NaivePatternMatching {
    // Function to find all valid shifts of a pattern in text using naive approach
    public static void findPattern(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        
        // Time complexity: O(n*m)
        // Space complexity: O(1)
        
        // Check for empty strings
        if (n == 0 || m == 0 || m > n) {
            System.out.println("Invalid input strings");
            return;
        }
        
        // Print header
        System.out.println("Finding all occurrences of pattern: " + pattern);
        System.out.println("In text: " + text);
        
        boolean patternFound = false;
        
        // Try all possible shifts from 0 to n-m
        for (int shift = 0; shift <= n - m; shift++) {
            boolean matchFound = true;
            
            // For current shift, check if pattern matches
            for (int j = 0; j < m; j++) {
                if (text.charAt(shift + j) != pattern.charAt(j)) {
                    matchFound = false;
                    break;
                }
            }
            
            // If pattern matches at current shift
            if (matchFound) {
                patternFound = true;
                System.out.println("Pattern found at shift " + shift);
                // Print visualization of the match
                printMatch(text, pattern, shift);
            }
        }
        
        if (!patternFound) {
            System.out.println("Pattern not found in text");
        }
    }
    
    // Helper function to visualize the pattern match
    private static void printMatch(String text, String pattern, int shift) {
        System.out.println("Text:    " + text);
        System.out.print("Pattern: ");
        // Print spaces for the shift
        for (int i = 0; i < shift; i++) {
            System.out.print(" ");
        }
        System.out.println(pattern);
        System.out.println();
    }

    // Main method with example usage
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = sc.nextLine();
        System.out.print("Enter the pattern to find: ");
        String pattern = sc.nextLine();
        sc.close();
        // Find and print all valid shifts
        findPattern(text, pattern);
    }
}