import java.util.Scanner;

public class TestArrayAssignment {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the capacity of the array");
        int c= sc.nextInt();
        System.out.println("Enter the range to store element");
        int n = sc.nextInt();
        ArrayAssignment array1 = new ArrayAssignment(c);
        array1.store(n);
        System.out.println("Numbers in the given range are:");
        array1.display();
        ArrayAssignment array2 = new ArrayAssignment(c);
        array2.insertOddFirstinRange(n);
        System.out.println("Numbers in the range such that odd comes first:");
        array2.display();
        ArrayAssignment array3 = new ArrayAssignment(c);
        array3.insertEvenTwiceinRange(n);
        System.out.println("Numbers in the given range such that even number are repeated twice:");
        array3.display();
        sc.close();
    }
}
