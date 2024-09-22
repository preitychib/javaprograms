import java.util.Scanner;

public class Isomorph {

    static int[][] p = null;    // pattern graph adjacency matrix
    static int[][] d = null;    // data graph adjacency matrix
    static int[] em = null;    // embeddings (mappings)
    static int m = 0;    // number of nodes in pattern graph
    static int n = 0;    // number of nodes in data graph

    static boolean isPromising(int i) {
        boolean promising = true;
        for (int k = 0; k < i; k++) {
            if (em[k] == em[i]) {
                promising = false;
            }
            else if (p[i][k] == 1 && d[em[i]][em[k]] == 0) {
                promising = false;
            }
            else if (p[i][k] == 0 && d[em[i]][em[k]] == 1) {    // for induced
                promising = false;
            }
            if (promising == false) {
                break;
            }
        }
        return promising;
    }

    static void getEmbeddings(int i) {
        if (isPromising(i)) {
            if (i == m-1) {
                System.out.print("{");
                for (int j = 0; j < m; j++) {
                    System.out.print("(" + j + ", " + em[j] + "), ");
                }
                System.out.println("\b\b}");
            }
            else {
                for (int j = 0; j < n; j++) {
                        em[i+1] = j;
                        getEmbeddings(i+1);
                }
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the pattern graph");
        m = sc.nextInt();
        System.out.println("Enter the number of nodes in data graph");
        n = sc.nextInt();

        p = new int[m][m];
        d = new int[n][n];

        System.out.println("Enter pattern graph adjacency matrix");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                    p[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter data graph adjacency matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                    d[i][j] = sc.nextInt();
            }
        }

        em = new int[m];

        for (int j = 0; j < n; j++) {
            em[0] = j;
            getEmbeddings(0);
        }
        sc.close();
    }
}
