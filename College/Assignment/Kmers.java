// * The k-mer refers to all the possible substrings of length k that are contained in a string. In genomics.k-mers refer to all the possible subsequences (of length k) in a given DNA Sequence. The number ofpossible k-mers given n possibilities (n-4 in the case of DNA eg. ACTG) is n'k. For example, if k = 1 there are 4 k-mers possible (ie. A, C, T, G ) in case of k = 2 16 k-mers are possible (e.g. AA AT AC AG TA TT TC TG CA CT CC CG GA GT GC GG). Write a program which takes a DNA sequence file and value of 'k as input from the user, and calculate the occurrence of k-mers, and store it to a CSV file(For example, if given DNA sequence S="ATTGCCC", K=2, then output should be as follows:
    //* K-mers,Ocurrences
    //*  AA,0
    //*  AC,0
    //*  AG,0
    //*  AT,1
    //*  CA,0
    //*  CC,2
    //*  CG,0
    //*  CT,0
    //*  GA,0
    //*  GC,1
    //*  GG,0
    //*  GT,0
    //*  TA,0
    //*  TC,0
    //*  TG,1
    //*  TT,1 */


import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Kmers {
    final String DNAseq = "ACTG";
    int k;
    ArrayList<String> kMers;

    Kmers(int kVal) {
        k = kVal;
        kMers = new ArrayList<>();
        generateKMers("");
    }

    void generateKMers(String kmer) {
        if (kmer.length() == k) {
            kMers.add(kmer);
            return;
        }
        for (int i = 0; i < DNAseq.length(); i++) {
            char firstch = DNAseq.charAt(i);
            generateKMers(kmer + firstch);
        }
    }
    
    Map<String, Integer> countKmersOccurence(String givenSeq) {
        Map<String, Integer> occurenceHashMap = new TreeMap<>();
        
        for (int i = 0; i < kMers.size(); i++) {
            int count = 0;
            int index = givenSeq.indexOf(kMers.get(i));

            while (index != -1) {
                count += 1;
                index += 1;
                index = givenSeq.indexOf(kMers.get(i), index);
            }

            occurenceHashMap.put(kMers.get(i), count);
        }
        return occurenceHashMap;
    }
    
    @Override
    public String toString() {
        return kMers.toString();
    }

}