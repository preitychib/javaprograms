//! 125. Valid Palindrome
//* A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers */ 
//* Given a string s, return true if it is a palindrome, or false otherwise. */ 
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.

public class Palindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                sb.append((char)(s.charAt(i)+32));
            }
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                sb.append(s.charAt(i));
            }
        }
        boolean check = true;
        int start = 0;
        int end = sb.length()-1;
        while(start<end){
            char char1 = sb.charAt(start);
            char char2 = sb.charAt(end);
            if(char1 != char2){
                check = false;
                break;
            }
            start++;
            end--;
        }
        return check;
    }
}