//! Find Square root of a number 
//? Uses Binary Search to find the square root of the number. 
//? time complexity log(n), which is great !  

// As of now doesn't works for 
import java.util.Scanner;

public class SquareRoot {

    //? returns interger value and runs for long int values too. 
    static int findSquareRoot(int num) {
        if (num == 0 || num == 1)
            return num;
        long mid = 0, start = 2;
        long end = num / 2;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (mid * mid == num)
                return (int) mid;
            else if (mid * mid > num)
                end = mid - 1;
            else {
                start = mid + 1;
            }
        }
        return (int) end;
    }
    
    //? Somewhat needs inprovement as the method above has solved it 
    //? Return a double value with the given precision 
    static double findSquareRoot(int num, int p){
        int mid=0, start = 0;
        int end = num;
        while (start <= end) {
            mid = start +(end-start)/2;
            if (mid * mid == num)
            return mid;
            else if (mid * mid > num)
            end = mid - 1;
            else
            start = mid + 1;
        }
        double decimal = 0.1;
        double squareRoot=(double) mid;
        for (int i = 0; i < p; i++) {
            while (squareRoot * squareRoot < num) {
                squareRoot += decimal;
            }

            squareRoot -= decimal;
            decimal /= 10;
        }
        return squareRoot;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();
        System.out.println("Enter the precision");
        int p = sc.nextInt();
        System.out.println("The square root of "+num+" is: "+findSquareRoot(num,p));
        sc.close();
        // 6.32455532034 for 40 
    }
}
