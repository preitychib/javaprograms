import java.util.*;
public class GraphIsomorphism {
    public static int[][] readAdjacencyMatrix(Scanner sc,int n){
        int[][] matrix = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
    public static boolean isInducedIsomorphic(int[][] Gp,int[][] Gd,int[] mapping){
        int n = Gp.length;
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                if(Gp[i][j] != Gd[mapping[i]][mapping[j]]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void generateMappings(int[] mapping,boolean[] used,int idx, List<int[] mappings){
        int n = mapping.length;
        if(idx==n){
            mappings.add(mapping.clone());
            return;
        }
        for(int i =0;i<n;i++){
            if(!used[i]) {
                used[i] = true;
                mapping[idx] =i;
                generateMappings(mapping,used,idx+1,mappings);
                used[i] = false;
            }
        }
    }
    public static void findInducedIsomorphisms(int[][] Gp,int[][] Gd){
        int n = Gp.length;
        int[] mapping = new int[n];
        boolean[] used = new boolean[n];
        List<int[]> mappings = new ArrayList<>();
        generateMappings(mapping,used,0,mappings);
        System.out.println("Induced Isomorphic Images:");
        for(int[] map:mappings){
            if(isInducedIsomorphic(Gp,Gd,map)) {
                System.out.println(Arrays.toString(map));
            }
        }
    }
    public static void findInducedIsomorphisms(int[][] Gp,int[][] Gd) {
        int n = Gp.length;
        int[] mapping = new int[n];
        boolean[] used = new boolean[n];
        List<int[]> mappings = new ArrayList<>();

        generateMappings(mapping,used,0,mappings);
        System.out.println("Non-induced Isomorphic Images:");
        for(int[] map:mappings){
            if(isNonInducedIsomorphic(Gp,Gd,map)){
                System.out.println(Arrays.toString(map));
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices in pattern graph Gp:");
        int np = sc.nextInt();
        int[][] Gp = readAdjacencyMatrix(sc,np);

        System.out.println("Enter the number of vertices in data graph Gd:");
        int nd = sc.nextInt();
        int[][]  Gd = readAdjacencyMatrix(sc,nd);

        findInducedIsomorphisms(Gp,Gd);
        findNonInducedIsomorphisms(Gp,Gd);
        sc.close();
    }
}

