import java.util.HashSet;
import java.util.Scanner;

class Point{
    int x;
    int y;

    Point(){
    }
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString(){
        return "[ "+x+", "+y+" ]";
    }

    void inputPoint(Scanner sc){
        System.out.println("Enter the x and y ordinate of the point:");
        x=sc.nextInt();
        y=sc.nextInt();
    }

    double distance(Point p2){
        return (Math.sqrt(((x-p2.x)*(x-p2.x)) + ((y-p2.y)*(y-p2.y))));
    }

}
public class ConvexHullBrute {

    static void read(Point a[], int n,Scanner sc){
        System.out.println("Enter all the points:");
        for(int i=0;i<n;i++){
            a[i]= new Point();
            a[i].inputPoint(sc);
        }
    }

    static void print(Point a[], int n){
        for(Point p: a)
            System.out.println(p.toString());
    }

   static void convexHull(Point[] p, int n){
        HashSet<Point> convexPoint= new HashSet<>();
        
        for(int i=0;i<n;i++){
            Point pI=p[i];
            for(int j=i+1;j<n;j++){
                Point pJ=p[j];
                int a=pJ.y- pI.y, b= pI.x- pJ.x, c=pI.x*pJ.y - pI.y*pJ.x;

                boolean flag=true;

                int newSign, oldSign=2;
                for(int k=0;k<n;k++){
                    if(k==i|| k==j) continue;

                    Point pK= p[k];

                    if(a*pK.x + b*pK.y<c) newSign=-1;
                    else if(a*pK.x + b*pK.y>c) newSign=1;
                    else newSign=0;

                    if(newSign==0 && (pI.distance(pK)+ pK.distance(pJ))> (pI.distance(pJ) + 0.00001)){
                        flag=false;
                        break;
                    }else if(oldSign !=2 && newSign!=0 && newSign!=oldSign){
                        flag=false;
                        break;
                    }else if(oldSign!=2 && newSign!=0){
                        oldSign=newSign;
                    }

                    
                }
                if(flag){
                    System.out.println("Edge of the convex hull i="+i+" j="+j+" end points of line segment "+ pI.toString()+ " "+ pJ.toString());
                    convexPoint.add(pI); convexPoint.add(pJ);
                }
            }
        }


        for(Point c: convexPoint){
            System.out.println(c.toString());
        }
    }
    public static void main(String[] args) {
        System.out.println("How many points you want to enter:");
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        Point[] points= new Point[n];
        read(points,n,sc);
        System.out.println("The points entered are:");
        print(points, n);
        convexHull(points, n);
    }
}
