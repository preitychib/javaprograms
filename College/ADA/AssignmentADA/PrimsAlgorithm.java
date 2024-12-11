// ? Question 10
package AssignmentADA;

import java.util.Arrays;

public class PrimsAlgorithm {
    public static void primMST(int[][] graph,int n) {
        int[] nearest=new int[n];
        int[] distance=new int[n];
        boolean[] visited=new boolean[n];
        int[][] mst=new int[n-1][2];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        nearest[0]=-1;

        for(int count=0;count<n-1;count++) {
            int min=Integer.MAX_VALUE;
            int u=-1;
            for(int i=0;i<n;i++) {
                if(!visited[i]&&distance[i]<min) {
                    min=distance[i];
                    u=i;
                }
            }
            visited[u]=true;

            for(int v=0;v<n;v++) {
                if(graph[u][v]!=0&&!visited[v]&&graph[u][v]<distance[v]) {
                    distance[v]=graph[u][v];
                    nearest[v]=u;
                }
            }

            mst[count][0]=nearest[u];
            mst[count][1]=u;
        }

        System.out.println("The mininum spanning tree is:");
        for(int i=0;i<n-1;i++) {
            System.out.println(mst[i][0]+"-"+mst[i][1]);
        }
    }

    public static void main(String[] args) {
        int[][] graph={
            {0,2,0,6,0},
            {2,0,3,8,5},
            {0,3,0,0,7},
            {6,8,0,0,9},
            {0,5,7,9,0}
        };
        primMST(graph,5);
    }
}

