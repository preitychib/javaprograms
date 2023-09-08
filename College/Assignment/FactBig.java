import java.math.BigInteger;
import java.util.Scanner;
public class FactBig{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        BigInteger A = sc.nextBigInteger();
        BigInteger fact= new BigInteger("1");
        for ( BigInteger i = A; i.compareTo(new BigInteger("1"))==1; i=i.subtract(new BigInteger("1"))) {
            fact=fact.multiply(i);
        }
        System.out.println("The Factorial of the given number is:"+fact);
        sc.close();
    }
}