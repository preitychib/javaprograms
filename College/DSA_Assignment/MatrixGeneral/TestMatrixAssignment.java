package MatrixGeneral;
import java.util.Scanner;

public class TestMatrixAssignment{
    public static void main(String[] args) {
        // Test matrix creation and operations
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row value");
        int row = sc.nextInt();
        System.out.println("Enter col value");
        int col = sc.nextInt();
        MatrixAssignment matrix1 = new MatrixAssignment(row, col);
        matrix1.read(sc);
        System.out.println("Matrix 1:");
        matrix1.print();

        MatrixAssignment matrix2 = new MatrixAssignment(row, col);
        matrix2.read(sc);
        System.out.println("Matrix 2:");
        matrix2.print();

        MatrixAssignment sumMatrix = matrix1.addMatrix(matrix2);
        if (sumMatrix != null) {
            System.out.println("Sum of Matrix 1 and Matrix 2:");
            sumMatrix.print();
        }

        MatrixAssignment productMatrix = matrix1.mulMatrix(matrix2);
        if (productMatrix != null) {
            System.out.println("Product of Matrix 1 and Matrix 2:");
            productMatrix.print();
        }

        // Test determinant calculation
        double determinant = matrix1.findDeterminant();
        System.out.println("Determinant of Matrix 1: " + determinant);

        // Test inverse calculation
        try {
            double[][] inverseMatrix = matrix1.inverse();
            System.out.println("Inverse of Matrix 1:");
            for (int i = 0; i < inverseMatrix.length; i++) {
                for (int j = 0; j < inverseMatrix[0].length; j++) {
                    System.out.printf("%.2f \t", inverseMatrix[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
