// * Suppose we have three sets A,B,C with its elements as strings in thousands. The content of each set A,B,C are stored in a .CSV file seperated by commas.
// * For example,
// *  a1,b1,c1
// *  a2,b2,c2
// * here the values of A={a1,a2}, B={b1,b2}, C={c1,c2}.
// * Write a program in java which reads the contents of set A,B, and C from the .CSV file and perform
// *    (i) A U B U C
// *    (ii) A ∩ B ∩ C
// *    (iii) (A ∩ B) U (A ∩ C) U (B ∩ C)
// *   Store these results in diferent colums of .CSV file.

import java.util.HashSet;
import java.util.Set;

public class HashsetQuestion11 {
    private Set<String> hashSet;

    HashsetQuestion11() {
        hashSet = new HashSet<>();
    }

    HashsetQuestion11(Set<String> hSet) {
        hashSet = hSet;
    }

    //? add elements
    void addElement(String str) {
        hashSet.add(str);
    }

    //? return hashset
    Set<String> getSet() {
        return hashSet;
    } 
    
    //? performs union of two set
    HashsetQuestion11 unioStringSet(HashsetQuestion11 hSet2) {
        Set<String> union = new HashSet<>(hashSet);
        union.addAll(hSet2.hashSet);
        return new HashsetQuestion11(union);
    }
    
    //? perform intersection of two set
    HashsetQuestion11 intersectionStringSet(HashsetQuestion11 hSet2) {
        Set<String> intersection = new HashSet<>(hashSet);
        intersection.retainAll(hSet2.hashSet);
        return new HashsetQuestion11(intersection);

    }

    @Override
    public String toString() {
        return hashSet.toString();
    }
}
