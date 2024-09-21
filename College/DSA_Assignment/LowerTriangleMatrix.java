import java.util.Arrays;
import java.util.Scanner;

public class LowerTriangleMatrix {
    int[] lowerArr; // flattened matrix 
    int dim;        // dimensions of matrix
    int size;       // size of array

    LowerTriangleMatrix(int n) {
        dim = n;
        size = n*(n+2)/2;
        lowerArr = new int[size];
        Arrays.fill(lowerArr, 0);
    }


    void read(Scanner sc) {
        System.out.println("Enter the not null elements of the lower triangular matrix");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < i + 1; j++) {
                int index=i * (i + 1) / 2 + j;
                lowerArr[index] = sc.nextInt();
            }
        }
    }
    

    void print() {
        System.out.println("The lower Triangular Matrix is:");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (j>i)
                    System.out.print(0 + " ");
                else
                {
                    int index=i * (i + 1) / 2 + j;
                    System.out.print(lowerArr[index] + " ");
                }
            }
            System.out.println();
        }
    }


    //mapping function to return value of lower triangular matrix
    int get(int i, int j) {
        if (i >= dim || j>=dim || i<0 || j<0)
            return -1;
        int index = i * (i + 1) / 2 + j;
        return lowerArr[index];
    }


    LowerTriangleMatrix mulLowerTriangleMatrix(LowerTriangleMatrix B) {
        if (dim != B.dim)
            return null;
    
        LowerTriangleMatrix C = new LowerTriangleMatrix(dim);
    
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                int sum = 0;
                for (int k = 0; k <= Math.min(i, j); k++) {
                    sum += get(i, k) * B.get(k, j);
                }
                C.lowerArr[i * (i + 1) / 2 + j] = sum;
            }
        }
    
        return C;
    }
    
    public LowerTriangleMatrix LTMintoDM(DiagonalMatrix DM) {
        int j = 0;
        LowerTriangleMatrix C = new LowerTriangleMatrix(dim);

        for (int i = 0; i < size; i++) {
            C.lowerArr[i] = lowerArr[i] * DM.diagonals[j];

            if ((i + 1) % dim == 0) {
                j++;
            }
        }
        return C;
    }
    
    public LowerTriangleMatrix DMintoLTM(DiagonalMatrix DM) {
        int j = 0;
        LowerTriangleMatrix C = new LowerTriangleMatrix(dim);
    
        for (int i = 0; i < size; i++) {
            C.lowerArr[i] = lowerArr[i] * DM.diagonals[j];
    
            if ((i % dim == dim - 1)) {
                j++;
            }
        }
        return C;
    }
    
}
