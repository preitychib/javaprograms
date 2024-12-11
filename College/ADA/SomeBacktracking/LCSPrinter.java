package SomeBacktracking;

public class LCSPrinter {
    static int m, n, lcsLength;
    static char[] x, y, lcs;

    public static void printAllLCS(int i, int j, int k) {
        System.out.println("i:" +i+" j:"+j+" k:"+k);
        if (isPromising(i, j, k)) {
            if (k == lcsLength - 1) {
                System.out.println(new String(lcs, 0, k + 1));
            } else {
                for (int ii = i + 1; ii < m; ii++) {
                    for (int jj = j + 1; jj < n; jj++) {
                        if (x[ii] == y[jj]) {
                            lcs[k + 1] = x[ii];
                            printAllLCS(ii, jj, k + 1);
                        }
                    }
                }
            }
        }
    }


    public static boolean isPromising(int i, int j, int k) {
        if (k == lcsLength - 1)
            return true;
        return !(m - i < lcsLength - k || n - j < lcsLength - k);
    }
    
    public static int lcsDivideAndConquer(String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return 1 + lcsDivideAndConquer(X, Y, m - 1, n - 1);
        else
            return Math.max(lcsDivideAndConquer(X, Y, m - 1, n), lcsDivideAndConquer(X, Y, m, n - 1));
    }

    public static void main(String[] args) {
        // Example initialization (adjust as needed)
        // x = "ABCBDAB".toCharArray();
        // y = "BDCAB".toCharArray();
        String xx = "adce";
        String yy = "bdec";
        x = xx.toCharArray();
        y = yy.toCharArray();
        m = x.length;
        n = y.length;
        lcsLength = lcsDivideAndConquer(xx, yy, m, n); // Example LCS length (set appropriately)
        lcs = new char[lcsLength];
        printAllLCS(-1, -1, -1);
    }
}

