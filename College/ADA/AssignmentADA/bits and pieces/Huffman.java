// import java.util.HashMap;
// import java.util.PriorityQueue;
// import java.util.Scanner;

import java.util.*;

class node{
    char s;
    int fr;
    node left;
    node right;
}

public class Huffman {

    static HashMap<Character, String> mp;
    public Huffman(){
        mp=  new HashMap<>();
    }
    public static node huffman(char[]arr, int[]freq, int n){
        PriorityQueue<node> pq= new PriorityQueue<>((a, b) -> a.fr - b.fr);
        for(int i=0;i<n;i++){
            node temp= new node();
            temp.s=arr[i];
            temp.fr= freq[i];
            temp.left=temp.right=null;

            pq.add(temp);
        }

        for(int i=0;i<n-1;i++){
            node temp1= pq.poll();
            node temp2= pq.poll();

            node temp= new node();
            temp.s=' ';
            temp.left= temp1;
            temp.right= temp2;

            temp.fr= temp1.fr+temp2.fr;
            pq.add(temp);
        }

        return pq.poll();

    }


    public static void printHuffmanTree(node nd, String code) {
        if (nd == null) {
            return;
        }

        if (nd.left == null && nd.right == null) {
            mp.put(nd.s,code);
            System.out.println(nd.s + ": " + code);
        }

        printHuffmanTree(nd.left, code + "0");
        printHuffmanTree(nd.right, code + "1");
    }


    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        String st;
        System.out.println("Enter the String: ");
        HashMap<Character,Integer> map= new HashMap<>();

        st= sc.next();
        int n= st.length();

        for(int i=0;i<n;i++){
            char ch = st.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        int idx=0;
        char[]arr= new char[map.size()];
        int[]freq= new int[map.size()];
        for(char ch: map.keySet()){
            arr[idx]=ch;
            freq[idx]= map.get(ch);
            idx++;
        }
        node tree= huffman(arr, freq, arr.length);
        Huffman obj= new Huffman();
        printHuffmanTree(tree, "");

        System.out.println("The code for the given string will be: ");
        
        for(int i=0;i<n;i++){
            char ch= st.charAt(i);
            System.out.print(mp.get(ch));
        }

    }
}
