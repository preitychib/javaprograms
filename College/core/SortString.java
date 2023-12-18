import java.util.Arrays;
import java.util.Comparator;

public class SortString {
    public static void main(String[] args) {
        String[] fruits={"apple", "banana", "kiwi", "orange", "grape"};
        System.out.println(Arrays.toString(fruits));
        Arrays.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return first.length() - second.length();
            }
        });
        //? uses lambda expressions
        // Arrays.sort(fruits, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(fruits));
    }
}
