import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Node{
    char ch;
    int frequency;
    Node left;
    Node right;

    Node(char ch,int freqeuncy){
        this.ch = ch;
        this.frequency=freqeuncy;
        left=null;
        right=null;
    }
}

class FrequencyComparator implements Comparator<Node>{
    public int compare(Node n1,Node n2){
        return n1.frequency - n2.frequency;
    }
}

public class HuffmanCoding {

    public static void generateCodes(Node root, String code, Map<Character, String> huffmanCodes){
        if(root == null){
            return;
        }
        if(root.left==null && root.right==null){
            huffmanCodes.put(root.ch,code);
        }

        generateCodes(root.left, code + "0", huffmanCodes);
        generateCodes(root.right, code + "1", huffmanCodes);
    }

    public static Node buildHuffmanTree(char[] charArray, int[] charFrequency) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(charArray.length, new FrequencyComparator());

        for (int i = 0; i < charArray.length; i++) {
            Node node = new Node(charArray[i], charFrequency[i]);
            priorityQueue.add(node);
        }
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();

            Node sum = new Node('-', left.frequency + right.frequency);
            sum.left = left;
            sum.right = right;
            priorityQueue.add(sum);
        }
        return priorityQueue.poll();

    }

        public static String encode(String text, Map<Character,String>huffmanCodes){
            
            StringBuilder encodedString= new StringBuilder();
            for(char ch:text.toCharArray()){
                encodedString.append(huffmanCodes.get(ch));
            }
            return encodedString.toString();
        }
        
        public static String decode(String encodedString,Node root){
            StringBuilder decodedString = new StringBuilder();
            Node current=root;
            for(int i=0; i<encodedString.length();i++){
                char bit=encodedString.charAt(i);
                if(bit == '0'){
                    current=current.left;
                }else{

                    current = current.right;
                }

                if(current.left==null && current.right==null){
                    decodedString.append(current.ch);
                    current =root;
                }
            }

            return decodedString.toString();
        }

        
        public static void main(String[] args){
            char[] charArray = {'a','b','c','d','e','f'};
            int[] charFrequency = {5,9,12,13,16,45};

            Node root = buildHuffmanTree(charArray,charFrequency);
            Map<Character,String> huffmanCodes= new HashMap<>();
            generateCodes(root,"",huffmanCodes);
            System.out.println("Huffman Codes:" + huffmanCodes);

            String text = "abcdef";
            String encodedString = encode(text, huffmanCodes);
            System.out.println("Encoded string: " + encodedString);

            String decodedString = decode(encodedString,root);
            System.out.println("Decode string: " + decodedString);
        }
}



        