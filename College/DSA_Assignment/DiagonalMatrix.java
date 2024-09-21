import java.util.Scanner;

public class DiagonalMatrix {
    int[] diagonals;
    int size;
    
    DiagonalMatrix(int n) {
        size = n;
        diagonals = new int[size];
    }


    void read(Scanner sc) {
        System.out.println("Enter the diagonal elements");
        for (int i = 0; i < size; i++)
            diagonals[i] = sc.nextInt();
    }
    

    void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j)
                    System.out.print(diagonals[i] + " ");
                else
                    System.out.print(0 + " ");
            }
            System.out.println();
        }
    }


    //mapping function to return value of diagonal matrix
    int get(int i, int j) {
        if (i >= size || j >= size || i < 0 || j < 0)
            return -1;
        return i==j?diagonals[i]:0;
    }

}
