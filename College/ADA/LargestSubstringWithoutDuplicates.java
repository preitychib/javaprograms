
import java.util.Scanner;
import java.util.HashSet;

public class LargestSubstringWithoutDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String largestSubstring = findLargestSubstringWithoutDuplicates(input);
        
        System.out.println("Largest substring without duplicates: " + largestSubstring);
        System.out.println("Length of the largest substring: " + largestSubstring.length());
        
        scanner.close();
    }
    
    public static String findLargestSubstringWithoutDuplicates(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        String largestSubstring = "";
        
        // Brute force: check all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (hasNoDuplicates(substring) && substring.length() > largestSubstring.length()) {
                    largestSubstring = substring;
                }
            }
        }
        
        return largestSubstring;
    }
    
    public static boolean hasNoDuplicates(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
