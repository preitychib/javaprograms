import java.util.Arrays;
import java.util.Scanner;

public class FactorialLargeNum {

    static void findFact(int n){
        double d=0;
        for(int i=2;i<=n;i++){
            d+=Math.log10(i);
        }
        int digitCount= (int)Math.floor(d) +1;
        int fact[] = new int[digitCount];
        System.out.println(digitCount);
        fact[digitCount-1]=1;
        int j=digitCount-1;
        for(int i=2;i<=n;i++){
            int carry=0;
            for(int k=digitCount-1; k>=j;k--){
                int x= fact[k]*i +carry;
                fact[k]= x%10;
                carry= x/10;
            }

            while(carry!=0){
                j=j-1;
                int x= fact[j]+carry;
                fact[j]= x%10;
                carry/=10;
            }
            
            // System.out.println(Arrays.toString(fact));

        }
        System.out.println(Arrays.toString(fact));
       
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number enter kro: ");
        int n=sc.nextInt();
        System.out.println("Factorial of the number is: ");
        findFact(n);
        sc.close();
    }
}
