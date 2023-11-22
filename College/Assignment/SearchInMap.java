//* Write a program that generates 1000 random integers in TreeSet and HashSet . Now perform search on both and deploy search time. */
import java.util.*; 
public class SearchInMap { 
    public static void main(String[] args) { 
        Set<Integer> treeSet = new TreeSet<>(); 
        Set<Integer> hashSet = new HashSet<>(); 
        Random random = new Random(); 
        for (int i = 0; i < 1000; i++) { 
            int randomNumber = random.nextInt(10000);  
            treeSet.add(randomNumber); 
            hashSet.add(randomNumber); 
        }

        //? Perform search and measure time for TreeSet 
        int target = random.nextInt(10000); 
        long startTimeTreeSet = System.nanoTime(); 
        boolean treeSetResult = treeSet.contains(target); 
        long endTimeTreeSet = System.nanoTime(); 
        long totalTimeTreeSet = endTimeTreeSet - startTimeTreeSet; 


        //? Perform search and measure time for HashSet 
        long startTimeHashSet = System.nanoTime(); 
        boolean hashSetResult = hashSet.contains(target); 
        long endTimeHashSet = System.nanoTime(); 
        long totalTimeHashSet = endTimeHashSet - startTimeHashSet;
        
        //? Display results 
        System.out.println("The result of the TreeSet: " + treeSetResult); 
        System.out.println("Time taken by TreeSet: " + totalTimeTreeSet + " nanoseconds"); 
        System.out.println("HashSet search result: " + hashSetResult); 
        System.out.println("Time taken for HashSet search: " + totalTimeHashSet + " nanoseconds"); 
    } 
}

