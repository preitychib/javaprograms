package AssignmentADA.help;

// Write an efficient program to remove multiple blank spaces from a given file and determine its time complexity.

import java.io.*;
import java.util.Scanner;

public class Q14RemoveSpacesInFile {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the input file path:");
        String inputFilePath = s.nextLine();

        System.out.println("Enter the output file path:");
        String outputFilePath = s.nextLine();

        removeExtraSpaces(inputFilePath, outputFilePath);

        System.out.println("Processing complete. Check the output file.");
    }

    public static void removeExtraSpaces(String inputFilePath, String outputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String cleanedLine = line.replaceAll("\\s+", " ").trim();
                writer.write(cleanedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
