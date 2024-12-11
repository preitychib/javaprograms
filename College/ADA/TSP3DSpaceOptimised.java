import java.util.Arrays;

public class TSP3DSpaceOptimised {
    // Calculates a lower bound for an incomplete path
    static int bound(int[] v, int n, int[][] W) {
        int inf = Integer.MAX_VALUE;
        int[] V = new int[n];
        int m = v.length;
        int[] p = Arrays.copyOf(v, n);

        // Calculate the cost of existing path segments
        for (int i = 0; i < m - 1; i++) {
            V[p[i] - 1] = W[p[i] - 1][p[i + 1] - 1];
        }

        // Calculate minimum cost for unvisited cities
        for (int i = 0; i < n; i++) {
            if (V[i] != 0) { 
                continue;
            }
            if (i == p[m - 1] - 1) {
                V[i] = inf;
                for (int j = 0; j < n; j++) {
                    boolean found = false;
                    for (int k = 0; k < m; k++) {
                        if (p[k] == j + 1) {
                            found = true;
                            break;
                        }
                    }
                    if (!found && W[i][j] < V[i]) {
                        V[i] = W[i][j];
                    }
                }
            } else {
                V[i] = W[i][0];
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    boolean found = false;
                    for (int k = 0; k < m; k++) {
                        if (p[k] == j + 1) {
                            found = true;
                            break;
                        }
                    }
                    if (!found && W[i][j] < V[i]) {
                        V[i] = W[i][j];
                    }
                }
            }
        }

        int bound = 0;
        for (int i = 0; i < n; i++) {
            bound += V[i];
        }
        return bound;
    }
    
    // Calculate the total tour length
    static int calculateTourLength(int[] tour, int[][] W) {
        int totalLength = 0;

        // Calculate the path length between consecutive cities
        for (int i = 0; i < tour.length - 1; i++) {
            // System.out.println("From " + tour[i] + " to " + tour[i + 1] + ": " + W[tour[i] - 1][tour[i + 1] - 1]);
            totalLength += W[tour[i] - 1][tour[i + 1] - 1];
        }

        // Add the distance from the last city back to the first city to complete the cycle
        // System.out.println("From " + tour[tour.length - 1] + " to " + tour[0] + ": " + W[tour[tour.length - 1] - 1][tour[0] - 1]);
        totalLength += W[tour[tour.length - 1] - 1][tour[0] - 1];

        return totalLength;
    }

    public static void main(String[] args) {
        int inf = Integer.MAX_VALUE;
        int[][] W = {
            { 0, 10, 15, 20 },
            { 10, 0, 35, 25 },
            { 15, 35, 0, 30 },
            { 20, 25, 30, 0 }
        };

        int n = 4; // Number of cities

        // 3D array to store partial paths
        int p[][][] = new int[n-1][][];  // Initialize partial paths array for cities 1 to n-1
        p[0] = new int[1][];

        // Allocate space for partial paths
        for(int i = 1; i < n-1; i++)
            p[i] = new int[p[i-1].length * (n-i)][];

        // Initialize partial path arrays
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < p[i].length; j++){
                p[i][j] = new int[i+1];
            }
        }

        // Start with city 1 in the first path
        p[0][0][0] = 1;

        // Generate partial paths
        for(int i = 1; i < n-1; i++){
            // Copy parent nodes
            for(int m = 0; m < p[i-1].length; m++){
                for(int j = 0; j < n-i; j++){
                    int jj = m * (n-i) + j;
                    for(int k = 0; k < i; k++){
                        p[i][jj][k] = p[i-1][m][k];
                    }
                }

                int jj = m * (n-i);
                int k = i;

                // Add new cities to the path, ensuring no city is revisited
                for(int l = 2; l <= n; l++){
                    boolean isFound = false;
                    for(int kk = 0; kk < p[i-1][m].length; kk++){
                        if(l == p[i-1][m][kk]){
                            isFound = true;
                            break;
                        }
                    }

                    // Add city if not already in path
                    if(!isFound){
                        p[i][jj][k] = l;
                        jj++;
                    }
                }
            }
        }

        // Print partial paths and their bounds/lengths
        System.out.println("TSP Problem Solution:");
        for(int i = 0; i < n-1; i++){
            System.out.print("\ni=" + i + "\t\t");
            for(int j = 0; j < p[i].length; j++){
                System.out.print("[");

                // Check if this is a leaf node (a complete tour)
                if (p[i][j].length == n-1) {
                    // For leaf nodes, complete the tour by adding the return to the starting city
                    int[] completeTour = new int[n];
                    System.arraycopy(p[i][j], 0, completeTour, 0, n-1);

                    // Dynamically add the remaining city
                    int remainingCity = 0;
                    for (int city = 1; city <= n; city++) {
                        boolean cityFound = false;
                        for (int m = 0; m < n-1; m++) {
                            if (completeTour[m] == city) {
                                cityFound = true;
                                break;
                            }
                        }
                        if (!cityFound) {
                            remainingCity = city;
                            break;
                        }
                    }
                    completeTour[n-1] = remainingCity;  // Add the remaining city
                    completeTour[0] = p[i][j][0];      // Return to the starting city

                    int tourLength = calculateTourLength(completeTour, W);
                    System.out.print("Tour Length = " + tourLength);
                } else {
                    // For non-leaf nodes, calculate and print the bound
                    System.out.print("Bound = " + bound(p[i][j], n, W));
                }

                System.out.print("]\t");
            }
        }
    }
}