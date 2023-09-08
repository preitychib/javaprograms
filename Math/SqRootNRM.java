//! Finds square root of the number using Newton Raphson Method
//? Newton Raphson Method is a numerical method to approximate the roots of any given real-valued function. In this method, we used various iterations to approximate the roots, and the higher the number of iterations the less error in the value of the calculated root. 

import java.util.Scanner;

public class SqRootNRM{

    static double findSqareRoot(int num) {
        
        double root;
        double x=num;
        while (true) {
            root = 0.5 * (x+ (num/ x));

            if (Math.abs(root - x) < 0.5)
                break;
            
            x = root;
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        System.out.println("The Square root of the number is: "+findSqareRoot(num) );
        sc.close();
    }

}