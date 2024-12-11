import java.util.*;


class node{
    int l;
    int b;
    int[]arr;
}
class SalesmanBranch3{

    public static int bound(int n,node nd, int[][]w){
        int bound=0;
        int m= nd.l;
        int[]ar= nd.arr;
        int[]v= new int[n];
        for(int i=1;i<m;i++){
            v[ar[i-1]]= w[ar[i-1]][ar[i]];


            
        }
        for(int i=0;i<n;i++){
            if(v[i]!=0){
                continue;
            }
            if(i==ar[m]){
                v[i]= Integer.MAX_VALUE;
            }
                
        }


        return bound;
    }
    public static int path(int[][]w, int n){
        PriorityQueue<node> pq= new PriorityQueue<>();

        int minLength= Integer.MAX_VALUE;
        
        
        return minLength;
    }
}