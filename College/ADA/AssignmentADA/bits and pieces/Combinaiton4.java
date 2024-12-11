
// question4
import java.util.*;
class Combination4{

    public static void main(String[] args) {
        int n,m;
        //this to calculate nCm;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the value of n and m: ");
        n= sc.nextInt();
        m= sc.nextInt();

        int[]nCr= new int[m+1];
        nCr[0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, m); j > 0; j--) {
                nCr[j] = nCr[j] + nCr[j - 1];
            }
        }

        System.out.println(nCr[m]);
    }
}