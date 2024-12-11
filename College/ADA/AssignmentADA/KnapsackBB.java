//? Question 16
package AssignmentADA;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    int level, profit, weight;
    double bound;

    Node(int level,int profit,int weight,double bound) {
        this.level=level;
        this.profit=profit;
        this.weight=weight;
        this.bound=bound;
    }
}

public class KnapsackBB {
    public static int knapsack_BestFS(int n,int[] p,int[] w,int W) {
        PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparing(a->-a.bound));
        Node v=new Node(0,0,0,bound(0,0,0,w,p,W,n));
        pq.offer(v);
        int maxProfit=0;

        while(!pq.isEmpty()) {
            v=pq.poll();
            if(v.bound>maxProfit) {
                Node u=new Node(v.level+1,v.profit+p[v.level],v.weight+w[v.level],0);
                if(u.weight<=W&&u.profit>maxProfit) {
                    maxProfit=u.profit;
                }
                u.bound=bound(u.level,u.profit,u.weight,w,p,W,n);
                if(u.bound>maxProfit) {
                    pq.offer(u);
                }
                u=new Node(v.level+1,v.profit,v.weight,0);
                u.bound=bound(u.level,u.profit,u.weight,w,p,W,n);
                if(u.bound>maxProfit) {
                    pq.offer(u);
                }
            }
        }
        return maxProfit;
    }

    static double bound(int level,int profit,int weight,int[] w,int[] p,int W,int n) {
        if(weight>=W) {
            return 0;
        }
        double bound=profit;
        int totalWeight=weight;
        int j=level;
        while(j<n&&totalWeight+w[j]<=W) {
            totalWeight+=w[j];
            bound+=p[j];
            j++;
        }
        if(j<n) {
            bound+=(W-totalWeight)*((double)p[j]/w[j]);
        }
        return bound;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n=scanner.nextInt();
        int[] p=new int[n],w=new int[n];

        System.out.println("Enter the profits and weights of the items:");
        for(int i=0;i<n;i++) {
            System.out.print("Profit "+(i+1)+": ");
            p[i]=scanner.nextInt();
            System.out.print("Weight "+(i+1)+": ");
            w[i]=scanner.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int W=scanner.nextInt();

        int maxProfit=knapsack_BestFS(n,p,w,W);
        System.out.println("Maximum profit: "+maxProfit);

        scanner.close();
    }
}

