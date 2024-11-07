import java.util.Scanner;
class TSP{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many cities? ");
        int n = sc.nextInt();
        int p[][][] = new int[n-1][][];
        p[0] = new int[1][];
        for(int i=1; i<n-1; i++)
            p[i] = new int[p[i-1].length * (n-i)][];
        for(int i=0; i<n-1; i++){
            for(int j=0; j<p[i].length; j++){
                p[i][j] = new int[i+1];
            }
        }
        for(int i=0; i<n-1; i++){
            System.out.println("i="+i+" #element="+p[i].length);
            for(int j=0; j<p[i].length; j++){
                System.out.println("size of element a["+i+"]["+j+"]="+p[i][j].length);
            }
        }
        //storing partial path
        p[0][0][0] = 1;
        for(int i=1; i<n-1; i++){
            //storing value of its parent nodes
            for(int m=0; m<p[i-1].length; m++){
                for(int j=0; j<n-i; j++){
                    int jj = m * (n-i) + j;
                    for(int k=0; k<i; k++){
                       // System.out.println("Testing i=" + i + "j=" + jj + "k = " + k );
                        p[i][jj][k] = p[i-1][m][k];
                    }
                }
                int jj=0;
                int k = i;
                //storing last value
                for(int l=2; l<=n; l++){
                    //searching in the parent nodes
                    boolean isFound = false;
                    for(int kk=0; kk<p[i-1][m].length; kk++){
                        System.out.println("Testing l=" + l + "i=" + i + "m = " + m + "k = " + kk + "l == p[i-1][m][kk] = " + (l == p[i-1][m][kk]));
                        if(l == p[i-1][m][kk]){
                            isFound = true;
                            break;
                        }
                    }
                    if(isFound == false){
                        p[i][jj][k] = l;
                        jj++;
                    }
                } 
            }
        }
        //printing partial paths
        for(int i=0; i<n-1; i++){
            System.out.print("\ni="+i+"\t\t");
            for(int j=0; j<p[i].length; j++){
                System.out.print("[");
                for(int k=0; k<p[i][j].length; k++){
                    System.out.print(p[i][j][k]+ ", ");
                }
                System.out.print("\b\b]\t");
            }
        }
    }
}