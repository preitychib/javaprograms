import java.util.*;

class node1 {
    int w;    // weight
    int p;    // profit
    double pw; // profit-to-weight ratio
}
class node2{
    int l;
    int w;
    int p;
}
public class knapsack_Bound {
    
    static int calProfit(node1[]arr, int W){
        int n=arr.length-1;
        int max_profit=0;
        Queue<node2> q= new LinkedList<>();
        node2 temp= new  node2();
        temp.l=0;
        temp.w=0;
        temp.p=0;
        q.add(temp);
        while(!q.isEmpty()){

            node2 prev= q.poll();
            node2 next= new node2();
            next.l= prev.l+1;
            next.w= prev.w+ arr[next.l].w;
            next.p= prev.p+arr[next.l].p;

            if(next.w<=W && next.p>max_profit){
                max_profit= next.p;
            }

            if(bound(arr,W,next,n)>max_profit){
                q.add(next);

            }
            node2 next2= new node2();
            next2.l= next.l;
            next2.w=prev.w;
            next2.p= prev.p;
            if(bound(arr,W,next2,n)>max_profit){
                q.add(next2);

            }
            
        }
        return max_profit;
    }

    static int bound(node1[]arr, int W, node2 node, int n){
        if(node.w>W){return 0;}
        int cal=node.p;
        int wt= node.w;
        int i=node.l+1;
        while(i<=n && wt+(arr[i].w)<=W){
            wt+=arr[i].w;
            cal+=arr[i].p;

            i++;
        }

        if(i<=n){
            cal+= (W-arr[i].w)*Math.ceil(arr[i].pw);
        }



        return cal;
    }

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        // Read the number of items
        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        node1[] sack = new node1[n+1]; // Create an array of node1 objects
        node1 tt= new node1();
        tt.p=0;
        tt.w=0;
        tt.pw= Integer.MAX_VALUE;
        sack[0]=tt;
        // Input weights and profits
        for (int i = 1; i <=n; i++) {
            sack[i] = new node1(); // Initialize each node1 object
            System.out.print("Enter the weight and profit of object " + (i) + ": ");
            sack[i].w = sc.nextInt();
            sack[i].p = sc.nextInt();
            sack[i].pw = (double) sack[i].p / sack[i].w; // Calculate profit-to-weight ratio
        }

        // Read the maximum weight of the sack
        System.out.print("\nEnter the Maximum limit of sack: ");
        int W = sc.nextInt();

        // Sort the array based on pw in descending order
        Arrays.sort(sack, (a, b) -> Double.compare(b.pw, a.pw));

        // Print the sorted items
        System.out.println("\nItems sorted by profit-to-weight ratio (decreasing):");
        for (node1 item : sack) {
            System.out.println("Weight: " + item.w + ", Profit: " + item.p + ", PW Ratio: " + item.pw);
        }

        int max_profit= calProfit(sack,W);
        System.out.println("\n\nMaximum Profit= "+max_profit);

    }
}
