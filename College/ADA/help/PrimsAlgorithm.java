import java.util.Arrays;
public class PrimsAlgorithm{
     //Function t
     int minKey(int key[],boolean mstSet[], int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;
         for(int v =0;v<V;v++){
            if(!mstSet[v] && key[v]<min){
                min =key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
     // functiomj ot construct & print MST using Prims Algorihtm 
     void primeMST(int graph[][], int V) {
         int parent[] = new int[V];
         int key[] = new int[V]; // Key values used to pick minimum weight edge in cut
         boolean mstSet[] = new boolean[V];

         // Initialize all keys at infinite 
         Arrays.fill(key, Integer.MAX_VALUE);
         Arrays.fill(mstSet, false);

         //Always include first vertex in MST
         key[0] = 0; //Make key 0 so that this vertex is picked as the firstvertex 
         parent[0] = -1; // First node is always the root of MST

         for (int count = 0; count < V - 1; count++) {
             //Pick the minimum key vertex  from the set of vertices not not yet included in MST
             int u = minKey(key, mstSet, V);

             //Add he picke vertex to the MST set
             mstSet[u] = true;
             for (int v = 0; v < V; v++) {
                 if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                     parent[v] = u;
                     key[v] = graph[u][v];
                 }
             }
         }
     }

     void printMST(int parent[], int graph[][], int V) {
         System.out.print("Edge \tWeight");
         for (int i = 1; i < V; i++) {
             System.out.println(parent[i] + "-" + i + "\t" + graph[i][parent[i]]);
         }
     }

             public static void main(String args[]){
                PrimsAlgorithm Algorithm, t = new PrimsAlgorithm();

                int V = 5;
                 int graph[][] = new int[][]{
                    {0,2,0,6,0},
                    {2,0,3,8,5},
                    {0,3,0,0,7},
                    {6,8,0,0,9},
                    {0,5,7,9,0},
                    
                 };

             }

  }
       