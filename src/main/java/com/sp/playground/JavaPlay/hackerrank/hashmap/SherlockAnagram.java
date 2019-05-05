package com.sp.playground.JavaPlay.hackerrank.hashmap;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAnagram {

    /**
     * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
     * Find total number of anagrams in substrings, words anagram if all characters are same
     *
     * Sol: if count of each character in words are same then they are anagram
     *  Get count of each character in word, Array is better as total number of alphabet is 26
     *  Get signature or hash of counts from character array
     *  prepare Map signature/hash -> count of occurrence of signature
     *  Anagram count = sum of ( n * (n-1) /2 for each signature)
     * @param s
     * @return
     */
    static int sherlockAndAnagrams(String s) {
        int anagramCount = 0;
        Map<String, Integer> subSigMap = new HashMap<>();

        for(int i=0; i< s.length(); i++){
            for(int j=i+1; j<= s.length(); j++){
                String subStr = s.substring(i,j);
//                System.out.println("orig:"+subStr+" anagramCount:"+anagramCount+" i:"+i+" j:"+j);

                // Get map char -> number of times
                // Get signature of ^^ map values
                // increment map of signature to occurrence count

                char[] subStrArr = subStr.toCharArray();
                int[] sigValues = new int[26];
                Arrays.fill(sigValues, 0);
                for(char ch : subStrArr){
                    sigValues[ch - 'a'] += 1;
                }

                char[] sigChar = new char[26];
                for(int k=0;k < 26; k++){
                    sigChar[k] = (char) sigValues[k];
                }
                subSigMap.merge(new String(sigChar), 1, Integer::sum);
            }
        }
        for(Map.Entry<String, Integer> entry: subSigMap.entrySet() ){
            anagramCount += (entry.getValue() * (entry.getValue() -1) )/2;
//            System.out.println("key:"+entry.getKey()+ "  value:"+entry.getValue());
        }

        return anagramCount;
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagramsOld(String s) {
        int anagramCount = 0;
        Map<String, Integer> subMap = new HashMap<>();

        for(int i=0; i< s.length(); i++){
            for(int j=i+1; j<= s.length(); j++){
                String subStr = s.substring(i,j);
//                System.out.println("orig:"+subStr+" anagramCount:"+anagramCount+" i:"+i+" j:"+j);

                // Get sorted string
                int subLen = subStr.length();
                char[] sorted = subStr.toCharArray();
                for(int subi=0; subLen > 1 && subi < subLen; subi++){

                    int index = subi;
                    for(int subj = subi +1; subj < subLen; subj++){
                        if(sorted[subi] > sorted[subj]){
                            char ch = sorted[subi];
                            sorted[subi] = sorted[subj];
                            sorted[subj] = ch;
                        }
                    }
                }

                String sortedStr = new String(sorted);

                if(subMap.containsKey(sortedStr)){
                    int val = subMap.get(sortedStr);
                    anagramCount += val;
                    System.out.println("orig:"+subStr+ "  sorted:"+ sortedStr+" anagramCount:"+anagramCount+" i:"+i+" j:"+j);
                    subMap.put(sortedStr, val + 1);
                }else{
                    subMap.put(sortedStr, 1);
                }

            }
        }

        return anagramCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println("result: "+result);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}