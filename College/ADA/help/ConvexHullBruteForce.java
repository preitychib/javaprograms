import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Point {
    int x,y;
    public  Point(){
        x=y=0;
    }
    public Point(int a,int b){
        x=a;
        y=b;
    }
    public double dist(Point p2) {

        return Math.sqrt((x-p2.x) * (x-p2.x) + (y-p2.y) * (y-p2.y));
    }
    public String toString(){
        return "("+ x + "," + y + ")";
        }
        public static void read(Point[] a,int n,Scanner sc) {
            System.out.println("Read " + n + " points:");
            for(int i =0;i<n;i++){
                a[i] = new Point(sc.nextInt(),sc.nextInt());
            }
        }
        public static void print(Point[] a,int n) {
            for(int i=0;i<n;i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
    public class ConvexHullBruteForce{
        public static void getConvexHull(Point[] p,int n){
            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();
            for (int i =0;i<n-1;i++){
                Point p_i = p[i];
                for(int j = i+1;j<n;j++) {
                    Point p_j = p[j];
                    int a = p_j.y-p_i.y;
                    int b = p_i.x-p_j.x;
                    int c = p_i.x*p_j.y-p_i.y*p_j.x;
                     boolean flag = true;
                     int newSign, oldSign = 2;
                     for(int k =0;k<n;k++){
                        if(k==i||k==j) continue;
                        Point p_k =p[k];
                        if(a*p_k.x+b*p_k.y<c) newSign = -1;
                        else  if(a*p_k.x + b*p_k.y>c) newSign = 1;
                        else newSign = 0;
                        if(k==0) oldSign = newSign;
                        else if(newSign == 0 && p_i.dist(p_j)+p_k.dist(p_j)>p_i.dist(p_j) + 0.00001) {
                            flag = false;
                            break;
                        }
                        else if(oldSign ==2 && newSign !=0) {
                            oldSign = newSign;

                        }
                    }
                    if(flag){
                        x.add(p_i.x);
                        y.add(p_i.y);
                        x.add(p_j.x);
                        y.add(p_j.y);
                    }
                }
            }
            System.out.println("Edges of Convex Hull:");
            for(int i=0;i<x.size();i+=2){
                System.out.println("(" + x.get(i) + ", " + y.get(i) + ") ->("+x.get(i+1) + ", " + y.get(i+1) + ")");
            }
        }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.println("How many points? ");
            int n = sc.nextInt();
            Point[] points = new Point[n];
            Point.read(points,n,sc);
            System.out.println("The set of points is:");
            Point.print(points,n);
            getConvexHull(points, n);
            sc.close();
        }
    }


    
                        