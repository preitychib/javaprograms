//* WAP in java to calculate the factorial of a number using BigInterger class and test it for a bigger number */ 

import java.math.BigInteger;
import java.util.Scanner;
public class FactBig{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //? Input bigger number
        int num = sc.nextInt();
        //? Store larger value in fact.
        BigInteger fact= new BigInteger("1");
        for (int i = num; i > 1; i--)
            fact = fact.multiply(BigInteger.valueOf(i));
        System.out.println("The Factorial of the given number is:"+fact);
        sc.close();
    }
}