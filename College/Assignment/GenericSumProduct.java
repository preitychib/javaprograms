// * Define a generic class to store set of three values (a,b,c) of generic type. The class contains two methods, namely sum() and product() of these three values. Write a test program which test the defined classes for three different data types.

public class GenericSumProduct<T> {
    T a;
    T b;
    T c;
    GenericSumProduct() {
        a = null;
        b = null;
        c = null;
    }

    GenericSumProduct(T x, T y, T z) {
        a = x;
        b = y;
        c = z;
    }

    void sum() {
        if (a instanceof String) {
            System.out.println("The sum of given strings are as:" + (String) a + (String) b + (String) c);
        }
        else if (a instanceof Double) {
            System.out.println("The sum of given Doubles are as:" + ((Double) a + (Double) b + (Double) c));
        }else if (a instanceof Integer) {
            System.out.println("The sum of given Integers are as:" + ((Integer) a + (Integer) b + (Integer) c));
        } else {
            System.out.println("The sum of given data type is not possible");  
        }
    }
    void product() {
        if (a instanceof Double) {
            System.out.println("The product of given numbers are as:"+(Double)a *(Double)b * (Double)c);
        } else if (a instanceof Integer) {
            System.out.println("The product of given numbers are as:"+(Integer)a *(Integer)b * (Integer)c);
        } else {
            System.out.println("The product of given data type is not possible"); 
        }
    }
}
