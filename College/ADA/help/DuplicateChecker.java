import java.util.HashSet;
public class DuplicateChecker {
    public static boolean ishasDuplicateChar(String s) {
        // use a HashSet to store characters
        HashSet<Character> charSet = new HashSet<>();

        // Iterate over each character in the string
        for(char c:s.toCharArray()) {
            // If the character is already in the set, return
            if (!charSet.add(c)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String testString1 = "hello";
        String testString2 = "world";
        System.out.println(ishasDuplicateChar(testString1));
        System.out.println(ishasDuplicateChar(testString2));
    }
    public class LargestUniqueSubstring {
        public static boolean hasUniqueChars(String s, int start,int end){
            boolean[] charSet= new boolean[128];
            for(int i = start; i <= end; i++) {
                char c = s.charAt(i);
                if(charSet[c]) {
                    return false;
                }
                charSet[c] = true;
            }
            return true;
        }
        public static String findLargestUniqueSubsString(String s){
            int n = s.length();
            String largestUniqueSubString = "";
            for(int i =0;i<n;i++){
                for(int j=i;j<n;j++){
                    if(hasUniqueChars(s, j, n)){
                        if(j-i+1>largestUniqueSubString.length()) {
                            largestUniqueSubString = s.substring(i,j+1);
                        }
                    }
                }
            }
            return largestUniqueSubString;
        }
        public static void main(String[] args){
            String input = "abcabcbb";
            String result = find LargestUniqueSubstring (input);
            System.out.println("Largest unique Substring:" + result);
        }
    }
}



        }


                        }
                    }
                }
            }

        }
        }
    }

            