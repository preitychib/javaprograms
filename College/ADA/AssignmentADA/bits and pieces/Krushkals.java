

import java.util.*;



// User function Template for Java


class point2{
    int v;
    int w;
    
    public point2(int v, int w){
        this.v=v;
        this.w=w;
    }
}

class point3{
    int v1;
    int v2;
    int w;
    
    public point3(int v11,int v22, int ww){
        v1=v11;
        v2=v22;w=ww;
    }
}


class Krushkals {
    
    static int ultimate(int[]A, int X){
          //add code here.
          int temp= X;
          while(A[temp]!=temp){
              temp= A[temp];
          }
          int ans= temp;
          temp=X;
          while(A[temp]!=temp){
              int t2=temp;
              temp= A[temp];
              A[t2]= ans;
          }
          return ans;          

	}
    
    static int spanningTree(int vt, int ed, List<List<int[]>> adj) {
        // Code Here.
        //List<List<point2>> arr= new ArrayList<>();

        //List<String> lst= new ArrayList<>();
        int ans=0;
        int idx=0;
        point3[]arr= new point3[ed];
        boolean[]visited= new boolean[vt];
        for(int i=0;i<vt;i++){
            visited[i]=true;
            for(int[]a: adj.get(i)){
                if(visited[a[0]]){
                    continue;
                }
                point3 temp= new point3(i,a[0],a[1]);
                arr[idx]= temp;
                idx++;
            }
        }
        
        Arrays.sort(arr,(p1,p2)->{
            return Integer.compare(p1.w,p2.w);
        });
        

        //this is i am making disjoing sets of the vertex.
        int[]p= new int[vt];
        
        for(int i=0;i<vt;i++){
            p[i]=i;
        }

        //intitally
        int[]rank= new int[vt];
        for(point3 pt: arr){
            int vs= pt.v1;
            int ve= pt.v2;
            int wt= pt.w;
            int u1=ultimate(p,vs);
            int u2=ultimate(p,ve);
            if(u1==u2){
                continue;
            }
            else{

                ans+= wt;
                if(rank[u1]>rank[u2]){
                    p[u2]=u1;
                    rank[u1]++;
                    System.out.println(vs+"->"+ve);
                }
                else{
                    
                    p[u1]=u2;
                    rank[u2]++;
                    System.out.println(ve+"->"+vs);
                }
            }
        }
        
        return ans;
        
    }


    public static void main(String[] args) {
        int v,e;
        System.out.println("Enter the number of vertices and edges in the graph: ");
        Scanner sc= new Scanner(System.in);
        v=sc.nextInt();
        e=sc.nextInt();

        List<List<int[]>> list= new ArrayList<>();

        for(int i=0;i<v;i++){

            list.add(new ArrayList<>());
        }


        System.out.println("enter the edges one by one like- v1 v2 weight");

        for(int i=0;i<e;i++){
            int v1= sc.nextInt();
            int v2= sc.nextInt();
            int w= sc.nextInt();

            list.get(v1).add(new int[]{v2,w});
            list.get(v2).add(new int[]{v1,w});

        }

        System.out.println();
        int mstWeight = spanningTree(v, e, list);
        System.out.println("Length of Minimum Spanning Tree: " + mstWeight);
        
    }
}



