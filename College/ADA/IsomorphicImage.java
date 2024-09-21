/*
 * write a program to read adjacency matrices of pattern graph Gp and Data graph Gd and find(print)
 *  i) all induced isomorphic images of Gp in Gd
 *  ii) all non induced isomorphic images of Gp in Gd
 * 
 * where the vertices of Gp and Gd 
 *  a) do not have a label
 *  b) does have a label
 */

import java.util.Scanner;

public class IsomorphicImage {

    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the patern graph vertices");
        int m= sc.nextInt();
        Graph p = new Graph(m);
        int n= sc.nextInt();
        Graph d = new Graph(n);

        
        




        sc.close();


    }
}
