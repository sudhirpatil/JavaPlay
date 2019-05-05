package com.sp.playground.JavaPlay.notes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringHackerrank {

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

}
