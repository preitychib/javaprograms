import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the matrices:");
        int size = scanner.nextInt();

        DiagonalMatrix d = new DiagonalMatrix(size);
        System.out.println("Enter the diagonal elements:");
        d.read(scanner);

        LowerTriangleMatrix l1 = new LowerTriangleMatrix(size);
        LowerTriangleMatrix l2 = new LowerTriangleMatrix(size);
        System.out.println("Enter the not null element Lower Triangular Matrix 1:");
        l1.read(scanner);
        System.out.println("Enter the not null element Lower Triangular Matrix 2:");
        l2.read(scanner);

        System.out.println("Diagonal Matrix:");
        d.print();
        System.out.println();

        System.out.println("Lower Triangular Matrix 1:");
        l1.print();
        System.out.println();

        System.out.println("Lower Triangular Matrix 2:");
        l2.print();
        System.out.println();

        // multiplication of LowerTriangleMatrix with DiagonalMatrix (LTMintoDM method)
        LowerTriangleMatrix resultL = l1.LTMintoDM(d);
        System.out.println("Result of LTMintoDM:");
        resultL.print();
        System.out.println();

        // multiplication of DiagonalMatrix with LowerTriangleMatrix (DMintoLTM method)
        LowerTriangleMatrix resultD = l1.DMintoLTM(d);
        System.out.println("Result of DMintoLTM:");
        resultD.print();
        System.out.println();

        // multiplication of LowerTriangleMatrix with LowerTriangleMatrix (mulLowerTriangleMatrix method)
        LowerTriangleMatrix multipliedMatrix = l1.mulLowerTriangleMatrix(l2);
        System.out.println("Result of multiplication of LowerTriangleMatrix with LowerTriangleMatrix:");
        multipliedMatrix.print();

        scanner.close();
    }
}
