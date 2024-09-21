import java.util.Scanner;

public class LCS {
    private String s1, s2;

    public LCS(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public int dcLCSLen(int a, int b) {
        if(a == 0 || b == 0) return 0;
        if(s1.charAt(a - 1) == s2.charAt(b - 1)) {
            return 1 + dcLCSLen(a - 1, b - 1);
        } else {
            return Math.max(dcLCSLen(a, b - 1), dcLCSLen(a - 1, b));
        }
    }

    public int dpLCSLen() {
        int n1=s1.length();
        int n2=s2.length();
        int[] prev= new int[n2+1];
        for(int i=1;i<=n1;i++){
            int[] cur= new int[n2+1];
            for(int j=1;j<=n2;j++){
                // If the characters match, 
                // update cur[j] to be one plus the LCS length 
                // found by moving diagonally (i.e., from prev[j - 1]).
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    cur[j]=1+ prev[j-1];
                }
                else 
                // If the characters don't match, 
                // you take the maximum LCS length from 
                // either the top (prev[j]) or the left (cur[j - 1]).
                    cur[j]= Math.max(cur[j-1],prev[j]);
            }
            prev=cur;
        }

        return prev[n2];
    }

    public String getLCS() {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] prev = new int[n2 + 1];
    
        for(int i=1;i<=n1;i++){
            int[] cur= new int[n2+1];
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    cur[j]=1+ prev[j-1];
                }
                else 
                cur[j]= Math.max(cur[j-1],prev[j]);
            }
            prev=cur;
        }
    
        StringBuilder lcsStr = new StringBuilder();
        int i = n1, j = n2;
        while(i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcsStr.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (prev[j] >= prev[j - 1]) {
                i--;
            } else {
                j--;
            }
        }
    
        return lcsStr.reverse().toString();
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the first string: ");
        String str1 = sc.nextLine();

        System.out.print("Type the second string: ");
        String str2 = sc.nextLine();

        LCS l = new LCS(str1, str2);

        int lengthDC = l.dcLCSLen(str1.length(), str2.length());
        System.out.println("LCS length via divide-conquer: " + lengthDC);

        int lengthDP = l.dpLCSLen();
        System.out.println("LCS length (using dp): " + lengthDP);

        String lcsResult = l.getLCS();
        System.out.println("LCS: " + lcsResult);

        sc.close();
    }
}
