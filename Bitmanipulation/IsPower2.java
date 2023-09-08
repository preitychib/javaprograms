public class IsPower2 {
    public static boolean isPowerOfTwo(int n) {
        // int num = (int) Math.pow(n, 2);
        if (n - (1 << (n - 1)) == 1)
            return true;
        return false;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println(isPowerOfTwo(i));
        }
    }
}