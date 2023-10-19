package Random_Questions;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.nextLine();
        StringBuilder revStr = new StringBuilder();
        for(int j=str.length()-1;j>0;j--)
        {
            revStr.append(str.charAt(j));
        }

        System.out.println(revStr);
        sc.close();
    }
}
