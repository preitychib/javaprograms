import java.util.Scanner;
public class TestMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimension of the matrix:");
        int m = sc.nextInt();
        int n =sc.nextInt();
        Matrix mat = new Matrix(m,n);
        System.out.println("Enter the lower and upper range values of the matrix:");
        int l = sc.nextInt();
        int h= sc.nextInt();
        mat.populate(l, h);
        System.out.println("Enter the dimension of the matrix:");
         m = sc.nextInt();
        n =sc.nextInt();
        Matrix mat2 = new Matrix(m,n);
        System.out.println("Enter the lower and upper range values of the matrix:");
        l = sc.nextInt();
        h= sc.nextInt();
        mat2.populate(l, h);
        Matrix mat3 = mat.add(mat2);
        System.out.println("The matrix 1 is:\n"+mat);
        System.out.println("The matrix 2 is:\n"+mat2);
        System.out.println("The matrix 3 is:\n"+mat3);
        sc.close();
    }
}