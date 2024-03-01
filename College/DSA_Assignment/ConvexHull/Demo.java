package ConvexHull;

import java.util.Scanner;

public class Demo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("How many points? ");
        n = sc.nextInt();
        Point[] x = new Point[n];
        for (int i = 0; i < n; i++)
            x[i] = new Point();
        read(x, n, sc);
        System.out.println("The points are as:");
        print(x, n);
        // assign p0 to the minimum point 
        Point p0 = min(x, n);
        bubbleSort(x, n, p0);
        System.out.println("The points after sorting wrt p0 are as:");
        print(x, n);
        System.out.println("The points after performing convex hull are as:");
        getConvexHull(x, n);
    }

    static void read(Point[] a, int n, Scanner sc) {
        System.out.println("Read " + n + " points");
        for (int i = 0; i < n; i++)
            a[i].read(sc);
    }

    static void print(Point[] a, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + "\t");
        System.out.println();
    }

    static Point min(Point[] a, int n) {
        Point mn = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i].y < mn.y || (a[i].y == mn.y && a[i].x < mn.x))
                mn = a[i];
        }
        return mn;
    }

    static void bubbleSort(Point[] a, int n, Point p0) {
        for (int i = 1; i < n; i++) {
            boolean sorted = true;
            for (int j = 0; j < n - i; j++) {
                if (a[j].isGreaterThanWRTp0(a[j + 1], p0)) {
                    Point temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted)
                break;
        }
    }

    static void getConvexHull(Point[] a, int n) {
        DLL l = new DLL();
        l.create(a, n);
        Node x = l.getFirst(), xr, xrr, x0;
        x0 = x; 
        xr = x.next;
        xrr = xr.next;
        while (xrr != x0 || xr != xrr) {
            xrr = xr.next;
            if ((x.data).isLE180(xr.data, xrr.data)) {
                // xr is to the left hence deleted
                // as we need only the boundary elements
                l.del(xr);
                xr = x;
                x = x.prev;
            } else {
                x = xr;
                xr = xrr;
            }
        }
        l.display();
    }
    
}
