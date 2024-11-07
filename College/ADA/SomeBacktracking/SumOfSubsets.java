import java.util.Scanner;
import java.util.Arrays;

public class SumOfSubsets {
    private int[] w; // weights
    private int W; // target sum
    private boolean[] include; // subset inclusion flag
    private int n; // number of items

    public void readInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        n = scanner.nextInt();

        w = new int[n];
        include = new boolean[n];

        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        W = scanner.nextInt();
    }

    public void sumOfSubsets(int i, int weight, int total) {
        if (isPromising(i, weight, total)) {
            if (weight == W) {
                printInclude();
            } else {
                include[i] = true;
                sumOfSubsets(i + 1, weight + w[i], total - w[i]);
                include[i] = false;
                sumOfSubsets(i + 1, weight, total - w[i]);
            }
        }
    }

    private boolean isPromising(int i, int weight, int total) {
        if (weight > W) {
            return false;
        }
        if (weight == W) {
            return true;
        }
        if (i == n) {
            return false;
        }
        return (weight + w[i] <= W) || isPromising(i + 1, weight, total - w[i]);
    }

    private void printInclude() {
        for (int i = 0; i < n; i++) {
            if (include[i]) {
                System.out.print(w[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SumOfSubsets sos = new SumOfSubsets();
        sos.readInput();
        sos.sumOfSubsets(0, 0, Arrays.stream(sos.w).sum());
    }
}