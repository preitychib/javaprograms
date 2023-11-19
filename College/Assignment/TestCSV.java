
//* Tester Class */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class TestCSV {

    // ? this input a,b,c set from given csv file ist, 2nd, and third column
    // respectively.
    static void inputSetFromCSV(HashsetQuestion11 a, HashsetQuestion11 b, HashsetQuestion11 c) {
        try (Scanner sc = new Scanner(new File("./Question11.csv"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split(",");
                if (values.length >= 3) {
                    a.addElement((values[0]));
                    b.addElement(values[1]);
                    c.addElement(values[2]);
                }
            }
            sc.close(); // closes the scanner
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // ? this output csv file ist, 2nd, and third column from a,b,c set
    static void outputSetToCSV(HashsetQuestion11 a, HashsetQuestion11 b, HashsetQuestion11 c) {
        Set<String> column1 = a.getSet();
        Set<String> column2 = b.getSet();
        Set<String> column3 = c.getSet();
        try (FileWriter writer = new FileWriter("./OutputQuestion11.csv", false)) {
            // Writing header
            writer.append("Column1,Column2,Column3\n");

            // Writing data
            int size = Math.max(Math.max(column1.size(), column2.size()),
                    column3.size());
                                                        
            for (int i = 0; i < size; i++) {
                // ? converting ith index of column to array for random access
                // ? toArray(new String[0]) ensures element are of String
                String value1 = i < column1.size() ? 
                        column1.toArray(new String[0])[i] : "";
                
                String value2 = i < column2.size() ? 
                        column2.toArray(new String[0])[i] : "";
                
                String value3 = i < column3.size() ? 
                        column3.toArray(new String[0])[i] : "";
                
                writer.append(value1).append(",").append(value2).
                        append(",").append(value3).append("\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        HashsetQuestion11 a = new HashsetQuestion11();
        HashsetQuestion11 b = new HashsetQuestion11();
        HashsetQuestion11 c = new HashsetQuestion11();

        // ? Inputing set from csv file
        inputSetFromCSV(a, b, c);

        // ? (i) A U B U C
        HashsetQuestion11 partOne = a.unioStringSet(b)
                .unioStringSet(c);

        // ? (ii) A ∩ B ∩ C
        HashsetQuestion11 partTwo = a.intersectionStringSet(b)
                .intersectionStringSet(c);
                                    
        // ? (iii) (A ∩ B) U (A ∩ C) U (B ∩ C)
        HashsetQuestion11 partThree = (a.intersectionStringSet(b))
                .unioStringSet((a.intersectionStringSet(c)))
                .unioStringSet((b.intersectionStringSet(c)));
        
        // ? Function to store output in the csv file
        outputSetToCSV(partOne, partTwo, partThree);
    }

}
