package com.sp.playground.JavaPlay.others;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'substringCalculator' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static long substringCalculatorOld(String s) {
        Set<String> subStrSet = new HashSet<>();
        char[] charArr = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char[] arrSub = new char[len-i];
            for (int j = i; j < len; j++) {
                arrSub[j-i] = charArr[j];
                String subStr = new String(arrSub);
                if (!subStrSet.contains(subStr)) {
                    subStrSet.add(subStr);
                    System.out.println("i:" + i + " j:" + j + " count: substr:" + subStr);
                }
            }
        }
        return subStrSet.size();
    }

    public static long substringCalculator(String s) {
        Trie tr = new Trie(s);
        return tr.getNodeCount();
    }

    static class TrieNode{
        TrieNode[] nodes = new TrieNode[26];
        TrieNode(){
            Arrays.fill(nodes, null);
        }

        void insert(String str){
            // add node at for first char (char range 1-26)
            if(str.length() > 0) {
                char index = (char) (str.charAt(0) - 'a');
                if (nodes[index] == null) {
                    nodes[index] = new TrieNode();
                }
                nodes[index].insert(str.substring(1));
            }
        }
    }

    static class Trie{
        TrieNode parent;

        Trie(String str){
            parent = new TrieNode();
            for(int i=0; i<str.length();i++){
                parent.insert(str.substring(i));
            }
        }

        //How to count nodes in Trie?
        public long countNodes(TrieNode node){
            long count =0;
            if(node == null) {
                return count;
            }
//                count += 1;
                for(int i=0; i<26;i++){
                    if(node.nodes[i] != null){
                        count += countNodes(node.nodes[i]);
                    }
                }
            return count+1;
        }

        public long getNodeCount(){
            return countNodes(parent)-1;
        }
    }
}

public class SubstringDistinctCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long result = Result.substringCalculator(s);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
        bufferedReader.close();
//        bufferedWriterriter.close();
    }
}
