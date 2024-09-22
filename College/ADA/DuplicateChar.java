import java.util.Scanner;

public class DuplicateChar {
    static int comp=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=sc.next();
        System.out.println("Maximum length string having unique characters: " +maxUniqueSubString(str));
        System.out.println(comp);
        sc.close();
    }
    static String maxUniqueSubString(String str){
        int n=str.length();
        String ans=null;
        found:
        for(int k=n; k>=1; k--){
            String[] s = KGrams(str, k);
            for(String string: s){
                if (!hasDuplicateChar(string)) {
                    ans = string;
                    break found;
                }
            }
        }
        return ans;
    }
    static String[] KGrams(String str, int k){
        int n=str.length();
        String[] kGrams=new String[n-k+1];
        for (int i = 0; i <= str.length() - k; i++) {
            kGrams[i] = str.substring(i, i + k);
        }
        return kGrams;
    }

    static boolean hasDuplicateChar(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                comp++;
                if (str.charAt(i) == str.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}