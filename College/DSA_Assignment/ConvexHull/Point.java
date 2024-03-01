package ConvexHull;

import java.util.*;
import java.lang.Math;

class Point {
    int x, y;

    void read(Scanner sc) {

        System.out.println("Enter x and y ordinates of the point ");
        x = sc.nextInt();
        y = sc.nextInt();
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    boolean isGreaterThanWRTp0(Point p2, Point p0)
    // here  p1(x,y) p2(p2.x,p2.y) p0(p0.x,p0.y)
    // we are calculating slope of the given vectors
    // if p2(this) slope > p2 slope we return true.
    // if slope is equal we are checking if this vector magnitude(distance) is greater than p2.
    {
        if ((p2.x - p0.x) * (y - p0.y) > (x - p0.x) * (p2.y - p0.y)
                || ((p2.x - p0.x) * (y - p0.y) == (x - p0.x) * (p2.y - p0.y) && dist(p0) > p2.dist(p0))) {
            return true;
        } else
            return false;
    }

    double dist(Point p0) {
        return (Math.sqrt(((x - p0.x) * (x - p0.x)) + ((y - p0.y) * (y - p0.y))));
    }

    // finds cross product of two vector using determinant of the coordinates of the vector
    // returns true if direction of the resultant vector is counter clockwise
    boolean isLE180(Point p2, Point p3) {
        if ((p2.x - x) * (p3.y - p2.y) <= (p2.y - y) * (p3.x - p2.x)) {
            return true;
        } else
            return false;
    }
}
