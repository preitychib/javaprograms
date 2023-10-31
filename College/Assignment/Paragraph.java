//* WAP in Java that takes the paragraph of the text as input form the user and performs the following operations:
//* 1) Count the number of characters, words, and lines. 
//* 2) Make the entire sentence in sentence case 
//* 3) Reverse the order of the words eg: "Hello Everyone" should be "Everyone Hello"
//* 4) Also reverse the entire paragraph eg: "Hello Java" should be "avaJ olleH" */ 

public class Paragraph {
    private String paraString;

    Paragraph(String para) {
        paraString = para;
    }

    //? Count the number of characters, words, and lines. 
    void countInPara() {
        int noOfChar = 0;
        int noOfWord = 1;
        int noOfLine = 0;
        String sentenceEnders = ".!?";
        for (int i = 0; i < paraString.length(); i++) {
            if (paraString.charAt(i) == ' ') {
                noOfWord++;
            } else if (sentenceEnders.indexOf(paraString.charAt(i)) != -1) {
                noOfLine++;
            }
            else {
                noOfChar++;
            }
        }
        System.out.println("The number of characters in paragraph are: " + noOfChar);
        System.out.println("The number of words in paragraph are: " + noOfWord);
        System.out.println("The number of lines in paragraph are: " + noOfLine);
    }
    
    //? Make in sentence case
    void makeInSentenceCase() {
        if (!paraString.isEmpty()) {
            paraString = Character.toUpperCase(paraString.charAt(0)) + paraString.substring(1);
            String sentenceEnders = ".!?";

            for (int i = 1; i < paraString.length() - 1; i++) {
                if (sentenceEnders.indexOf(paraString.charAt(i)) != -1
                        && Character.isLowerCase(paraString.charAt(i + 2))) {
                    paraString = paraString.substring(0, i + 2) + Character.toUpperCase(paraString.charAt(i + 2))
                            + paraString.substring(i + 3);
                    i += 2; // Skip the next two characters
                }
            }
        }
    }
    
    //?  Reverses the order of the words of every line
    String reverseParaOrder() {
        String reversedWords ="";
        int p1 = 0; // Pointer 1
        String sentenceEnders = ".!?"; // Define sentence-ending punctuation marks
        String word;
        for (int i = 1; i < paraString.length(); i++) {
            //? Check if it's the end of a word
            if (i == paraString.length() - 1 || paraString.charAt(i) == ' ') {
                //? Extract the word based on the presence of sentence-ending punctuation
                if (sentenceEnders.indexOf(paraString.charAt(i - 1)) != -1)
                    word = paraString.charAt(i - 1) + paraString.substring(p1, i - 1);
                else
                    word = paraString.substring(p1, i);
                //? Prepend the word to the result string
                reversedWords = word + " " + reversedWords;
                p1 = i + 1; // Move to the next character after the space
            }
        }
        
        reversedWords = paraString.substring(paraString.length() - 1) + reversedWords;
        return reversedWords.trim();
    }

    //? Reverses each character of each word of the paragaraph.
    String reversePara() {
        String reverseCharaString = "";
        for (int i = 0; i < paraString.length(); i++) { 
            reverseCharaString = paraString.charAt(i) + reverseCharaString;
        }
        return reverseCharaString;
    }

    //* @Override the toString method to print paragraph*/ 
    @Override
    public String toString()
    {
        return paraString;
    }
}
