import java.util.Scanner;

public class XORRange {
    
    static int xorRange(int l, int u) {
        if (l > 0) {
            System.out.println("The lower limit should be greater than zero.");
            return -1;
        }
        int ans=xor0Ton(u)^xor0Ton(l-1);

        return ans;
    }
    
    static int xor0Ton(int n) {
        if (n % 4 == 0)
            return n;
        if (n % 4 == 1)
            return 1;
        if (n % 2 == 2)
            return n + 1;
        return 0;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the lower limit and uppper limit:");
        int l = sc.nextInt();
        int u = sc.nextInt();
        System.out.println("The Xor in range is:"+xorRange(l, u));
        sc.close();
    }
}