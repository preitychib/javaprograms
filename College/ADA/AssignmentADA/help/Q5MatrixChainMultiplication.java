package AssignmentADA.help;

/**
 * This class implements the Matrix Chain Multiplication algorithm.
 * It provides both a standard version and a space-optimized version using a jagged array.
 */
public class Q5MatrixChainMultiplication {
    
    /**
     * Standard version of the matrix chain multiplication algorithm.
     * 
     * @param d Array containing the dimensions of the matrices
     * @param P 2D array to store the optimal split positions
     * @param n Number of matrices
     * @return The minimum number of scalar multiplications needed
     */
    public static int minMul(int[] d, int[][] P, int n) {
        int[][] M = new int[n + 1][n + 1];
        
        // Initialize the cost for single matrix (diagonal of M)
        for (int i = 1; i <= n; i++) {
            M[i][i] = 0;
        }
        
        // Fill the M table
        for (int diagonal = 1; diagonal <= n - 1; diagonal++) {
            for (int i = 1; i <= n - diagonal; i++) {
                int j = i + diagonal;
                M[i][j] = Integer.MAX_VALUE;
                
                // Try all possible split positions
                for (int k = i; k <= j - 1; k++) {
                    int cost = M[i][k] + M[k + 1][j] + d[i - 1] * d[k] * d[j];
                    if (cost < M[i][j]) {
                        M[i][j] = cost;
                        P[i][j] = k;
                    }
                }
            }
        }
        
        return M[1][n];
    }
    
    /**
     * Optimized version of the matrix chain multiplication algorithm using a jagged array for M.
     * 
     * @param d Array containing the dimensions of the matrices
     * @param P 2D array to store the optimal split positions
     * @param n Number of matrices
     * @return The minimum number of scalar multiplications needed
     */
    public static int minMulOptimized(int[] d, int[][] P, int n) {
        // Create jagged array for M
        int[][] M = new int[n][];
        for (int i = 0; i < n; i++) {
            M[i] = new int[n - i];
        }
        
        // Fill the M table
        for (int diagonal = 1; diagonal < n; diagonal++) {
            for (int i = 0; i < n - diagonal; i++) {
                int j = i + diagonal;
                M[i][diagonal] = Integer.MAX_VALUE;
                
                // Try all possible split positions
                for (int k = i; k < j; k++) {
                    int cost = (k > i ? M[i][k - i] : 0) + 
                               (k + 1 < j ? M[k + 1][j - k - 1] : 0) + 
                               d[i] * d[k + 1] * d[j + 1];
                    if (cost < M[i][diagonal]) {
                        M[i][diagonal] = cost;
                        P[i + 1][j + 1] = k + 1;
                    }
                }
            }
        }
        
        return M[0][n - 1];
    }
    
    /**
     * Prints the optimal parenthesization of the matrix chain.
     * 
     * @param i Start index of the subchain
     * @param j End index of the subchain
     * @param P 2D array containing the optimal split positions
     */
    public static void order(int i, int j, int[][] P) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            int k = P[i][j];
            System.out.print("(");
            order(i, k, P);
            order(k + 1, j, P);
            System.out.print(")");
        }
    }
    
    /**
     * Main method to demonstrate the usage of both standard and optimized versions.
     */
    public static void main(String[] args) {
        int[] d = {5, 4, 6, 2, 7};
        int n = d.length - 1;
        int[][] P = new int[n + 1][n + 1];
        
        // Using standard version
        int minMultiplications = minMul(d, P, n);
        System.out.println("Minimum number of multiplications: " + minMultiplications);
        System.out.print("Optimal parenthesization: ");
        order(1, n, P);
        System.out.println();
        
        // Reset P for optimized version
        P = new int[n + 1][n + 1];
        
        // Using optimized version
        int minMultiplicationsOptimized = minMulOptimized(d, P, n);
        System.out.println("Minimum number of multiplications (optimized): " + minMultiplicationsOptimized);
        System.out.print("Optimal parenthesization (optimized): ");
        order(1, n, P);
        System.out.println();
    }
}