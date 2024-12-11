import java.util.Scanner;

public class IntegerToByte {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int num = sc.nextInt();

        int reduced = num % 256; // Modulo 256 to keep within one byte range
        if (reduced > 127) {
            reduced -= 256; // Adjust to signed byte range
        } else if (reduced < -128) {
            reduced += 256; // Adjust to signed byte range
        }

        System.out.println("The byte equivalent of " + num + " is: " + reduced);
        System.out.println("The byte equivalent of " + num + "(calculated directly) is: " + (byte)num);

    }
}
