import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LCS {
    public static int lcsLengthDC(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + lcsLengthDC(X, Y, m - 1, n - 1);
        else
            return Math.max(lcsLengthDC(X, Y, m, n - 1), lcsLengthDC(X, Y, m - 1, n));
    }

    // Dynamic Programming approach
    public static int lcsLengthDP(String X, String Y) {
        int m = X.length();
        int n = Y.length(); 
        int[][] C = new int[m + 1][n + 1];
        String[][] b = new String[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            C[i][0] = 0;
        for (int j = 0; j <= n; j++)
            C[0][j] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                    b[i][j] = "↖";
                } else if (C[i - 1][j] >= C[i][j - 1]) {
                    C[i][j] = C[i - 1][j];
                    b[i][j] = "↑";
                } else {
                    C[i][j] = C[i][j - 1];
                    b[i][j] = "←";
                }
            }
        }

        System.out.println("Longest Common Subsequence (using b array):");
        printLCS(b, X, m, n);
        System.out.println();

        System.out.println("Longest Common Subsequence (without using b array):");
        printLCSWithoutB(C, X, Y, m, n);
        System.out.println();

        return C[m][n];
    }

    private static void printLCS(String[][] b, String X, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (b[i][j].equals("↖")) {
            printLCS(b, X, i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if (b[i][j].equals("↑")) {
            printLCS(b, X, i - 1, j);
        } else {
            printLCS(b, X, i, j - 1);
        }
    }

    private static void printLCSWithoutB(int[][] C, String X, String Y, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            printLCSWithoutB(C, X, Y, i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if (C[i - 1][j] > C[i][j - 1]) {
            printLCSWithoutB(C, X, Y, i - 1, j);
        } else {
            printLCSWithoutB(C, X, Y, i, j - 1);
        }
    }
    public static Set<String> findAllLCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] C = new int[m + 1][n + 1];

        // Fill C table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    C[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    C[i][j] = C[i - 1][j - 1] + 1;
                else
                    C[i][j] = Math.max(C[i - 1][j], C[i][j - 1]);
            }
        }

        return backtrack(C, X, Y, m, n);
    }

    private static Set<String> backtrack(int[][] C, String X, String Y, int i, int j) {
        Set<String> result = new HashSet<>();

        if (i == 0 || j == 0) {
            result.add("");
            return result;
        }

        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            Set<String> subLCS = backtrack(C, X, Y, i - 1, j - 1);
            for (String s : subLCS) {
                result.add(s + X.charAt(i - 1));
            }
        } else {
            if (C[i - 1][j] >= C[i][j - 1]) {
                result.addAll(backtrack(C, X, Y, i - 1, j));
            }
            if (C[i][j - 1] >= C[i - 1][j]) {
                result.addAll(backtrack(C, X, Y, i, j - 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter the first string (X): ");
        String X = scanner.nextLine();
    
        System.out.print("Enter the second string (Y): ");
        String Y = scanner.nextLine();
    
        int lcsLengthDC = lcsLengthDC(X, Y, X.length(), Y.length());
        System.out.println("Length of LCS (Divide and Conquer): " + lcsLengthDC);

        int lcsLengthDP = lcsLengthDP(X, Y);
        System.out.println("Length of LCS (Dynamic Programming): " + lcsLengthDP);
    
        Set<String> allLCS = findAllLCS(X, Y);
        System.out.println("All Longest Common Subsequences:");
        for (String lcs : allLCS) {
            System.out.println(lcs);
        }
    
        scanner.close();
    }
}