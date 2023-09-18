import javax.swing.JOptionPane;

public class TestTriangle {
    
    //* @returns sides of the triangle if they are valid */
    static double[] inputSides() {

        String[] triangleSides = JOptionPane.showInputDialog(null, "Enter three sides of triangle separated by space.").split(" ");
        double[] triangleSideValues = new double[3];

        //? Check if there are exactly three elements in the array
        if (triangleSides.length == 3) {
            try {
                for (int i = 0; i < 3; i++)
                    triangleSideValues[i] = Double.parseDouble(triangleSides[i]);

            } catch (NumberFormatException e) {

                //? Handle the case where the input is not a valid double
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numeric values.");
                System.exit(1);
            }
        }
        else {
            //? Handle the case where the input does not contain exactly three values
            JOptionPane.showMessageDialog(null, "Please enter exactly three values.");
            System.exit(1);
        }

        //? Checks if the entered input makes a valid triangle.
        if (!((triangleSideValues[0] + triangleSideValues[1] >= triangleSideValues[2])
                && (triangleSideValues[1] + triangleSideValues[2] >= triangleSideValues[0])
                && (triangleSideValues[2] + triangleSideValues[0] >= triangleSideValues[1]))) {

            //? Handle the case where triangle is not valid.
            JOptionPane.showMessageDialog(null, "Invalid triangle. Please enter valid sides of triangle.");
            System.exit(1);
        }
        
        return triangleSideValues;
    }
        
    public static void main(String[] args) {
        
        //? function to input sides of triangle
        double[] triangleSide = inputSides();
        //? Object Creation of valid triangel
        Triangle aTriangle = new Triangle(triangleSide[0], triangleSide[1], triangleSide[2]);
        
        JOptionPane.showMessageDialog(null, aTriangle.findTriangleType() + " is the type of the given triangle. \nThe area of triangle is: "+ aTriangle.findArea()+" square units.");
    }
}