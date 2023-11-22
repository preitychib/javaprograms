import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class TestKmers {

    static void outputSetToCSV(Map<String,Integer> occurenceMap) {
        
        try (FileWriter writer = new FileWriter("./OutputQuestion9.csv", false)) {
            // Writing header
            writer.append("K-mers,Ocurrences\n");
                           
            for (Map.Entry<String, Integer> occurence : occurenceMap.entrySet()) {
                writer.append(occurence.getKey()).append(",")
                        .append(occurence.getValue().toString()).append("\n");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of k");
        int k = sc.nextInt();
        sc.next();
        System.out.println("Enter the DNA Sequence");
        String dnaSeq = sc.nextLine();
        Kmers kmer = new Kmers(k);
        outputSetToCSV(kmer.countKmersOccurence(dnaSeq.toUpperCase()));
        sc.close();
    }
}
