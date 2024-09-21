import java.util.Scanner;

public class Combination {
public static int Direct(int n, int k){
    int ans=1;
    for(int i=1; i<=k; i++){
        ans=(ans*n)/i;
        n--;
    }
    return ans;
}
public static int RecursionDAD(int n, int k){
    if(k>n){
        return 0;
    }
    if(k==0||k==n){
        return 1;
    }
    return RecursionDAD(n-1, k-1)+RecursionDAD(n-1, k);
}
public static int DP(int n, int k, int dp[][]){
    if (k > n) {
        return 0;
    }
    if (n < 0 || k < 0) {
        return 0;
    }
    if (k == 0 || k == n) {
        return 1;
    }
    if (dp[n][k] != 0) {
        return dp[n][k];
    }
    return dp[n][k] = DP(n - 1, k, dp) + DP(n - 1, k - 1, dp);
}
public static int DP1(int n, int k){
    int[] B = new int[n + 1];
    B[0] = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = i; j >= 1; j--) {
            if (j == i) {
                B[j] = 1;
            } else {
                B[j] = B[j] + B[j - 1];
            }
        }
    }
    return B[k];
}
public static int DP2(int n, int k){
    int[] B = new int[k + 1];
    B[0] = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = Math.min(i, k); j > 0; j--) {
            B[j] += B[j - 1];
        }
    }
    return B[k];
}
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Direct method
        long startTime = System.nanoTime();
        int directResult = Combination.Direct(n, k);
        long endTime = System.nanoTime();
        long directExecutionTime = endTime - startTime;
        System.out.println("Direct method result: " + directResult);
        System.out.println("Direct method execution time: " + directExecutionTime + " nanoseconds");

        // Recursion method
        startTime = System.nanoTime();
        int recursionResult = Combination.RecursionDAD(n, k);
        endTime = System.nanoTime();
        long recursionExecutionTime = endTime - startTime;
        System.out.println("Recursion method result: " + recursionResult);
        System.out.println("Recursion method execution time: " + recursionExecutionTime + " nanoseconds");

        // DP method with 2D array
        startTime = System.nanoTime();
        int[][] dp = new int[n + 1][k + 1];
        int dpResult = Combination.DP(n, k, dp);
        endTime = System.nanoTime();
        long dpExecutionTime = endTime - startTime;
        System.out.println("DP method (2D array) result: " + dpResult);
        System.out.println("DP method (2D array) execution time: " + dpExecutionTime + " nanoseconds");

        // DP method with 1D array of size n
        startTime = System.nanoTime();
        int dpResult1 = Combination.DP1(n, k);
        endTime = System.nanoTime();
        long dpExecutionTime1 = endTime - startTime;
        System.out.println("DP method (1D array of size n) result: " + dpResult1);
        System.out.println("DP method (1D array of size n) execution time: " + dpExecutionTime1 + " nanoseconds");

        // DP method with 1D array of size k
        startTime = System.nanoTime();
        int dpResult2 = Combination.DP2(n, k);
        endTime = System.nanoTime();
        long dpExecutionTime2 = endTime - startTime;
        System.out.println("DP method (1D array of size k) result: " + dpResult2);
        System.out.println("DP method (1D array of size k) execution time: " + dpExecutionTime2 + " nanoseconds");
    }
}
