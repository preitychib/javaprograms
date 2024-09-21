import java.util.Scanner;
import java.util.Arrays;

public class TravelingSalesMan {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of cities: ");
        int n = scanner.nextInt();

        int[][] W = new int[n][n];
        System.out.println("Enter the distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                W[i][j] = scanner.nextInt();
            }
        }

        int[][] P = new int[n][1 << (n - 1)];
        int minLen = travel(n, W, P);

        System.out.println("Minimum tour length: " + minLen);
        printTour(n, P);

        scanner.close();
    }

    public static int travel(int n, int[][] W, int[][] P) {
        int[][] D = new int[n][1 << (n - 1)];

        // Initialize D[i][ϕ]
        for (int i = 1; i < n; i++) {
            D[i][0] = W[i][0];
        }

        // Main DP loop
        for (int k = 1; k < n - 1; k++) {
            for (int subset = 1; subset < (1 << (n - 1)); subset++) {
                if (Integer.bitCount(subset) == k) {
                    for (int i = 1; i < n; i++) {
                        if ((subset & (1 << (i - 1))) == 0) {
                            D[i][subset] = INF;
                            for (int j = 1; j < n; j++) {
                                if ((subset & (1 << (j - 1))) != 0) {
                                    int cost = W[i][j] + D[j][subset ^ (1 << (j - 1))];
                                    if (cost < D[i][subset]) {
                                        D[i][subset] = cost;
                                        P[i][subset] = j;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // Compute optimal tour length
        int minLen = INF;
        int fullSet = (1 << (n - 1)) - 1;
        for (int j = 1; j < n; j++) {
            int cost = W[0][j] + D[j][fullSet ^ (1 << (j - 1))];
            if (cost < minLen) {
                minLen = cost;
                P[0][fullSet] = j;
            }
        }

        return minLen;
    }

    public static void printTour(int n, int[][] P) {
        int[] tour = new int[n + 1];
        boolean[] visited = new boolean[n];
        int fullSet = (1 << (n - 1)) - 1;

        tour[0] = tour[n] = 0;
        int index = 1;
        int current = 0;

        while (index < n) {
            int next = P[current][fullSet];
            tour[index++] = next;
            visited[next] = true;
            fullSet ^= (1 << (next - 1));
            current = next;
        }

        System.out.print("Optimal tour: ");
        for (int city : tour) {
            System.out.print(city + " ");
        }
        System.out.println();
    }
}