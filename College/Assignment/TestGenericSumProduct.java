import java.util.Scanner;

public class TestGenericSumProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //? For Integers 
        System.out.println("Enter three integer values");
        int aInt = sc.nextInt();
        int bInt = sc.nextInt();
        int cInt = sc.nextInt();
        GenericSumProduct<Integer> genericInt = new GenericSumProduct<>(aInt, bInt, cInt);
        genericInt.sum();
        genericInt.product();

        //? For Double
        System.out.println("Enter three Double values");
        double aDouble = sc.nextDouble();
        double bDouble = sc.nextDouble();
        double cDouble = sc.nextDouble();
        sc.nextLine();
        GenericSumProduct<Double> genericDouble = new GenericSumProduct<>(aDouble, bDouble, cDouble);
        genericDouble.sum();
        genericDouble.product();

        //? For String
        System.out.println("Enter three String values");
        String aString = sc.nextLine();
        String bString = sc.nextLine();
        String cString = sc.nextLine();
        GenericSumProduct<String> genericString = new GenericSumProduct<>(aString, bString, cString);
        genericString.sum();
        genericString.product();
        
        sc.close();
    }
}
