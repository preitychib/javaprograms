import java.util.*;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    // Implement the dist method
    public double dist(Point other) {
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Function to read n number of points
    public static Point[] readPoints(int n) {
        Point[] points = new Point[n];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            System.out.println("Enter x and y coordinates for point " + (i + 1) + ":");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }

        return points;
    }

    // Function to print n number of points
    public static void printPoints(Point[] points) {
        System.out.println("Points:");
        for (Point point : points) {
            System.out.println(point);
        }
    }

    // Updated convex hull function
    public static void convexHull(Point[] p, int n) {
        ArrayList<Point> hullPoints = new ArrayList<>();

        for(int i = 0; i < n - 1; i++) {
            Point p_i = p[i];
            for(int j = i + 1; j < n; j++) {
                Point p_j = p[j];
                int a = p_j.y - p_i.y;
                int b = p_i.x - p_j.x;
                int c = p_i.x * p_j.y - p_i.y * p_j.x;
                boolean flag = true;
                int newSign = 2, oldSign = 2;
                for(int k = 0; k < n; k++) {
                    if(k == i || k == j) continue;
                    Point p_k = p[k];
                    if(a*p_k.x + b*p_k.y < c) newSign = -1;
                    else if(a*p_k.x + b*p_k.y > c) newSign = 1;
                    else if(a*p_k.x + b*p_k.y == c) newSign = 0;

                    if(newSign == 0 && p_i.dist(p_k)+p_k.dist(p_j) > p_i.dist(p_j)+0.00001) {
                        flag = false;
                        break;
                    } else if(oldSign != 2 && newSign != 0 && newSign != oldSign) {
                        flag = false;
                        break;
                    } else if(oldSign == 2 && newSign != 0) {
                        oldSign = newSign;
                    }
                }
                if(flag) {
                    hullPoints.add(p_i);
                    hullPoints.add(p_j);
                }
            }
        }

        // Print edges of convex hull
        System.out.println("Edges of convex hull: ");
        for (int i = 0; i < hullPoints.size(); i+=2) {
            Point current = hullPoints.get(i);
            Point next = hullPoints.get((i + 1) % hullPoints.size());
            System.out.println(current + " -> " + next);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of points: ");
        int n = scanner.nextInt();

        Point[] points = readPoints(n);
        System.out.println("Original points:");
        printPoints(points);

        convexHull(points, n);
        scanner.close();
    }
}