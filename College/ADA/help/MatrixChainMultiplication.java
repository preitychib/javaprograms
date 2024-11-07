public class MatrixChainMultiplication {
    public static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length;
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int length = 2; length < n; length++) {
            for (int i = 1; i < n - length + 1; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                    }
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args){
        int[] dimensions ={10,20,30,40,30};
        int result = matrixChainOrder(dimensions);
        System.out.println("Minimum number of multiplications is: " + result);
    }
}
