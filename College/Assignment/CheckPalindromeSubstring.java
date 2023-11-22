//* Given a string, find all distinct palindrome sub-strings of length>1. For example, str="abaaa" then possible palindromic sub-strings are: aa,aaa,aba. */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class CheckPalindromeSubstring {

    static boolean isPalindromic(String str) {
            for(int i=0;i<str.length()/2;i++){
                if (str.charAt(i) != str.charAt(str.length()-1-i))
                    return false;
            }
        return true;
    }
    
    static Set<String> palindromeSubstring(String str) {
        
        Set<String> palindromeSubStrings = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String subString = str.substring(i, j);
                if (isPalindromic(subString) && subString.length() > 1 && subString.length() < str.length())
                    palindromeSubStrings.add(subString);
            }
        }
        return palindromeSubStrings;
    }
    
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        System.out.println(palindromeSubstring(str));
        sc.close();
    }

}
