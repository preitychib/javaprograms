import java.io.*;
import java.util.regex.*;

public class RemoveMultipleBlanks {
    public static void replaceMultipleSpacesInFile(String filePath) {
        // Create a temporary StringBuilder to store the modified content
        StringBuilder modifiedContent = new StringBuilder();

        // Use BufferedReader to read the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Regular expression to match multiple spaces
            Pattern pattern = Pattern.compile("\\s+");

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Replace multiple spaces with a single space
                String modifiedLine = pattern.matcher(line).replaceAll(" ");
                modifiedContent.append(modifiedLine).append(System.lineSeparator());
            }

            // Now, overwrite the original file with the modified content
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(modifiedContent.toString());
            }

            System.out.println("\nFile has been modified successfully.\n");
        } catch (IOException e) {
            System.out.println("\nAn error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "input.txt";  // Specify the file path
        replaceMultipleSpacesInFile(filePath);
    }
}
