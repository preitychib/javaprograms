import java.util.*;

public class RemoveDuplicates {
    

    public static String removeDuplicate(String str) {
        // Use a HashSet to store characters and ensure uniqueness
        HashSet<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();

        // Traverse through the string
        for (char c : str.toCharArray()) {
            // If character is not in the set, append to result and add to set
            if (!set.contains(c)) {
                set.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("\nEnter the String: ");
        String st= sc.next();
        // HashSet<Character> set= new HashSet<>();

        // String c= st+"";

        // int n= c.length();

        System.out.println("String after removing duplicates: "+removeDuplicate(st));

    }
}
