import java.util.Arrays;
import java.util.Scanner;

public class FactorialLargeNum {
    static int numberOfMultiplication(int n){
        int mul=0;
        for(int i=1;i<n;i++){
            double d=0;
            for(int j=2;j<=i;j++){
                d+=Math.log10(j);
            }
            int digitCount= (int)Math.floor(d) +1;
            mul+=digitCount;
            System.out.println(digitCount+" "+mul);
        }
        return mul;
    }
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

        int mul=0;
        for(int i=2;i<=n;i++){
            int carry=0;
            for(int k=digitCount-1; k>=j;k--){
                int x= fact[k]*i +carry;
                mul++;
                fact[k]= x%10;
                carry= x/10;
            }

            while(carry!=0){
                j=j-1;
                int x= fact[j]+carry;
                fact[j]= x%10;
                carry/=10;
            }
        }
        System.out.println(Arrays.toString(fact));

        System.out.println("Number of multiplications are "+mul+" "+n);
       
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number enter kro: ");
        int n=sc.nextInt();
        System.out.println("Factorial of the number is: ");
        findFact(n);
        System.out.println("--------\nnumber of multiplication in n: "+ numberOfMultiplication(n));
        sc.close();
    }
}
