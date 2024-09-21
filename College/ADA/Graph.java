public class Graph {
    private boolean adjMat[][];
    private int numVertices;

    Graph(int num) {
        adjMat = new boolean[num][num];
        numVertices = num;
    }

    void addEdge(int i, int j) {
        adjMat[i][j] = true;
        adjMat[j][i] = true;
    }

    void deleteEdge(int j, int i) {
        adjMat[i][j] = false;
        adjMat[j][i] = false;
    }


    @Override
    public String toString() {
        
        StringBuilder graph= new StringBuilder();

        for(int i=0;i<numVertices;i++){
            graph.append(i+":");
            for(boolean j: adjMat[i]){
                graph.append((j?1:0)+" ");
            }

            graph.append("\n");
        }
        return graph.toString();
    }


}
