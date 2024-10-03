import java.util.Scanner;
import java.util.Arrays;

class Factorial {
	public static int[] factorial(int n) {
		double sum = 0;
		for(int i = 2; i <= n; i++) {
			sum += Math.log10(i);
		}
		
		int m = (int) Math.floor(sum) + 1;
		int[] f = new int[m];
		int j = m - 1;
		f[m-1] = 1;
		int mul = 0;
		
		for(int i = 2; i <= n; i++) {
				int c = 0;
				for(int k = m - 1; k >= j; k--) {
						int x = i * f[k] + c;
						f[k] = x % 10;
						c = x / 10;
						mul++;
				}
				
				while(c != 0) {
					j = j - 1;
					f[j] = c % 10;
					c = c / 10;
				}
		}
		System.out.println("No. of Multiplications: "+mul);
		return f;
	}
	
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the value of n: ");
			int n = sc.nextInt();
			int[] f = factorial(n);
			System.out.println(Arrays.toString(f));
			sc.close();
	}
}

