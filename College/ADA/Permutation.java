import java.util.Scanner;

public class Permutation {

    static int count;
    public static int permute(int[] arr, int start, int end) {
        if (start == end) {
            printArray(arr);
            count++;
        } else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                permute(arr, start + 1, end);
                swap(arr, start, i); 
            }
        }
        return count;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Number of elements must be positive.");
            scanner.close();
            return;
        }

        int[] elements = new int[n];
        System.out.println("Enter the " + n + " elements:");
        for (int i = 0; i < n; i++) {
            elements[i] = scanner.nextInt();
        }


        long startTime = System.nanoTime();
        int count=permute(elements, 0, n - 1);
        System.out.println("Total permutations: " +count);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Execution time: " + (duration / 1000000.0) + " ms");

        scanner.close();
    }
}
