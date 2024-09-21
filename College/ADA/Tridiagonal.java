import java.util.Arrays;
import java.util.Scanner;

public class Tridiagonal {
    
    static private int n;
    static private int[][] a;
    static private int[][] b;
    static private int[][] c;


    static int[] mapTridiagonal(int x, int y) {
        int i = x;
        int j = y - Math.max(x - 2 + 1, 0);
        if(j<0 || (y>=(Math.min(x+2,n))))
            return new int[]{ -1, -1 }; // not valid
        return new int[] { i, j };
    }
    

    static int[] mapPentadiagonal(int x, int y) {
        int i = x;
        int j = y - Math.max(x - 3 + 1, 0);
        if (j < 0 || (y >= (Math.min(x + 3, n))))
            return new int[] { -1, -1 }; // not valid
        return new int[] { i, j };
    }
    
    static public void mul() {

        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i - 2); j <= Math.min(i + 2, n - 1); j++) {
                int[] mapPenta = mapPentadiagonal(i, j);

                // c[mapPenta[0]][mapPenta[1]] = 0;
                for (int k = Math.max(Math.max(i - 1, j - 1), 0); k <= Math.min(Math.min(i + 1, j + 1), n - 1); k++) {

                    int[] mapTriIK = mapTridiagonal(i, k);
                    int[] mapTriKJ = mapTridiagonal(k, j);

                    c[mapPenta[0]][mapPenta[1]] += a[mapTriIK[0]][mapTriIK[1]] * b[mapTriKJ[0]][mapTriKJ[1]];

                }

            }

        }

    }
    
    static void printPentaDiagonal() {

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (j <= (Math.max(0, i - 3)) || (j >= (Math.min(j + 3, n)))) {
        //             System.out.print(0 + "\t");
        //         } else {
        //             int[] mapPenta = mapPentadiagonal(i, j);
        //             System.out.print(c[mapPenta[0]][mapPenta[1]] + " ");
        //         }
        //     }
        //     System.out.println();
        // }

        for (int[] i : c) {
            for (int a : i) {
                System.out.print(a + "\t");
            }
            System.out.println();
        }
    }

    void initializeTridiagonal(int x) {

    }
    
    void initializePentadiagonal(int x) {
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n = sc.nextInt();
        // a = new int[3 * n][];
        // b = new int[3 * n][];
        // c = new int[5 * n][];
        n=3;
        // b = new int[3 * n][3*n];
        c = new int[3][5];
        

        // a = new int[][] {
        //     {1, 1},
        //     {1, 2, 2},
        //     {2, 3, 3},
        //     {4, 4, 4},
        //     { 2, 5, 7 },
        //     {1,6}
        // };
        
        
        // b = new int[][] {
        //     {1, 2},
        //     {3, 4, 5},
        //     {6, 7, 8},
        //     {9, 10, 11},
        //     { 12, 13, 14 },
        //     {15,16}
        // };

        a = new int[][] {
            {1, 2},
            {3, 4, 5},
            {6, 7},
        };
        b = new int[][] {
            {1, 2},
            {3, 4, 5},
            {6, 7},
        };

        mul();

        printPentaDiagonal();

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         // System.out.print(Arrays.toString(mapTridiagonal(i, j)) + "\t");
        //         System.out.print(Arrays.toString(mapPentadiagonal(i, j)) + "\t");

        //     }
        //     System.out.println();
        //     for (int j = 0; j < n; j++) {
        //         // System.out.print("["+i+": "+j+"]" + "\t");

        //     }
        //     System.out.println();
        // }

        // Input values for matrix a
        //  System.out.println("Enter values for matrix a:");
        //  for (int i = 0; i < 3 * n; i++) {

        //      int m = Math.max(0, i - 2);
        //      int n = Math.min(j + 2, n);
        //      for (int j = 0; j < 3; j++) {
        //          a[i][j] = sc.nextInt();
        //      }
        //  }

        // // Input values for matrix b
        // System.out.println("Enter values for matrix b:");
        // for (int i = 0; i < 3 * n; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         b[i][j] = sc.nextInt();
        //     }
        // }



        sc.close();
    }
}