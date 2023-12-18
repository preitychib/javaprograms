//* Define a class called Triangle which stores all the three sides of triangle. Use constructor to initialise the sides. Write a method called findArea which calculate area of triangle using herons formula. Also check the types of the triangle. Write this java application using GUI I/O. */ 

public class Triangle {
    double a;
    double b;
    double c;

    //* This Parameterised Constructor first checks the triangle is valid and then enter values in the triangle */
    Triangle(double x, double y, double z) {     
        a = x;
        b = y;
        c = z;
    }

    //* @returns perimeter of the triangle */ 
    double findPerimeter() {
        return a + b + c;
    }

    //* @returns area of the triangle using Heron's Formula */
    double findArea() {
        double semiPerimeter = findPerimeter() / 2.0;
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    //* @returns true if triangle is right angled */
    boolean isRightTriangle() {
        if (a * a == b * b + c * c)
            return true;
        else if (b * b == a * a + c * c)
            return true;
        else if (c * c == a * a + b * b)
            return true;
        return false;
    }

    //* @returns type of the triangle */
    String findTriangleType() {
        
        //? Equilateral Triangle is never right angled
        if (a == b &&  b== c)
            return "Equilateral Triangle";
        //? Checks if Triangle is Right Angled Triangle 
        String triangleType= isRightTriangle()?"Right Angled Triangle & ":"";
        if(a!=b && b!=c && c !=a)
            triangleType += "Scalene Triangle";
        else
            triangleType += "Isosceles Triangle";
        
        return triangleType;
    }
    
}