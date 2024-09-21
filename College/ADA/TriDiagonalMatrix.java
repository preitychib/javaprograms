import java.util.Scanner;

public class TriDiagonalMatrix {
    public static void read(int[] a, int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements of the tri-diagonal matrix:");
        
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print("a[" + i + "][" + (i-1) + "]: ");
                a[3*i-1] = scanner.nextInt();
            }
            System.out.print("a[" + i + "][" + i + "]: ");
            a[3*i] = scanner.nextInt();
            if (i < n-1) {
                System.out.print("a[" + i + "][" + (i+1) + "]: ");
                a[3*i+1] = scanner.nextInt();
            }
        }
    }

    public static void print(int[] a, int n) {
        System.out.println("Tri-diagonal matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i-1) {
                    System.out.print(a[3*i-1] + "\t");
                } else if (j == i) {
                    System.out.print(a[3*i] + "\t");
                } else if (j == i+1) {
                    System.out.print(a[3*i+1] + "\t");
                } else {
                    System.out.print("0\t");
                }
            }
            System.out.println();
        }
    }

    public static int[] mul(int[] a, int[] b, int n) {
        int[] result = new int[3*n-2];
        
        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i-2); j <= Math.min(i+2, n-1); j++) {
                int sum = 0;
                for (int k = Math.max(Math.max(i-1, j-1), 0); k <= Math.min(Math.min(i+1, j+1), n-1); k++) {
                    int aVal = (k == i-1) ? a[3*i-1] : (k == i) ? a[3*i] : (k == i+1) ? a[3*i+1] : 0;
                    int bVal = (k == j-1) ? b[3*j-1] : (k == j) ? b[3*j] : (k == j+1) ? b[3*j+1] : 0;
                    sum += aVal * bVal;
                }
                if (j == i-1) {
                    result[3*i-1] = sum;
                } else if (j == i) {
                    result[3*i] = sum;
                } else if (j == i+1) {
                    result[3*i+1] = sum;
                }
            }
        }
        
        return result;
    }

    public static void printResult(int[] a, int n) {
        System.out.println("Resultant matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i-j) <= 2) {
                    if (j == i-1) {
                        System.out.print(a[3*i-1] + "\t");
                    } else if (j == i) {
                        System.out.print(a[3*i] + "\t");
                    } else if (j == i+1) {
                        System.out.print(a[3*i+1] + "\t");
                    } else if (j == i-2) {
                        System.out.print(a[3*i-2] + "\t");
                    } else if (j == i+2) {
                        System.out.print(a[3*i+2] + "\t");
                    }
                } else {
                    System.out.print("0\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the tri-diagonal matrix: ");
        int n = scanner.nextInt();

        int[] a = new int[3*n-2];
        int[] b = new int[3*n-2];

        System.out.println("For matrix A:");
        read(a, n);
        System.out.println("\nFor matrix B:");
        read(b, n);

        System.out.println("\nMatrix A:");
        print(a, n);
        System.out.println("\nMatrix B:");
        print(b, n);

        int[] result = mul(a, b, n);
        System.out.println("\nResult of A * B:");
        printResult(result, n);

        scanner.close();
    }
}