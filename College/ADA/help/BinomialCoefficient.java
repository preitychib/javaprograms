import java.math.BigInteger;

public class BinomialCoefficient {

    // Method to compute factorial using BigInteger
    private static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // Method to compute nCk using the factorial method
    private static BigInteger binomialCoefficient(int n, int k) {
        if (k > n) return BigInteger.ZERO;
        if (k == 0 || k == n) return BigInteger.ONE;

        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(k).multiply(factorial(n - k));
        return numerator.divide(denominator);
    }

    public static void main(String[] args) {
        int n = 1000; // You can set n to a specific value
        long startTime, endTime;

        System.out.println("Computing binomial coefficients for n = " + n);
        
        for (int k = 10; k <= 900; k += 10) {
            startTime = System.nanoTime();
            BigInteger result = binomialCoefficient(n, k);
            endTime = System.nanoTime();
            
            long elapsedTime = endTime - startTime;
            System.out.printf("k = %d: nCk = %s, Time = %d ns%n", k, result.toString(), elapsedTime);
        }
    }
}