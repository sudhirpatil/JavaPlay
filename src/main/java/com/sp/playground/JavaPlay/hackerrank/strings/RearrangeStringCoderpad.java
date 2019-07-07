package com.sp.playground.JavaPlay.hackerrank.strings;


import java.io.*;
import java.util.*;

/*
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
*/

public class RearrangeStringCoderpad {
    public static String rearrange(String str) {
        StringBuffer buffer = new StringBuffer();
        Map<Character, Integer> charMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            charMap.merge(ch, 1, Integer::sum);
        }
        System.out.println(charMap);

        int maxFreq = 0, sumFreq = 0;
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            sumFreq += entry.getValue();
            if (maxFreq < entry.getValue()) {
                maxFreq = entry.getValue();
            }
        }

        if (maxFreq > (sumFreq - maxFreq + 1)) {
            return "";
        }


        while (charMap.size() > 1) {
            Iterator<Map.Entry<Character, Integer>> it = charMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Character, Integer> entry = it.next();
                int freq = entry.getValue();
                char ch = entry.getKey();
                buffer.append(ch);
                if (freq == 1) {
                    it.remove();
                } else {
                    charMap.merge(ch, -1, Integer::sum);
                }

            }
            // for(Map.Entry<Character, Integer> entry: charMap.entrySet()){
            //     char ch = entry.getKey();
            //   int freq = entry.getValue();
            //   buffer.append(ch);
            //   if(freq ==1){
            //     charMap.remove(ch);
            //   }else{
            //     charMap.merge(ch, -1, Integer::sum);
            //   }
            // }
        }

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            char ch = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; freq > 0; i++) {
                if (buffer.charAt(i) != ch && (buffer.length() >= i + 1 || buffer.charAt(i + 1) != ch)) {
                    buffer.insert(i + 1, ch);
                    freq--;
                }
            }
        }
        return buffer.toString();
    }

    public static String reorganizeString(String S) {
        int length = S.length();
        int[] counts = new int[26];
        for (char c : S.toCharArray()) counts[c - 'a'] += 100;
        for (int i = 0; i < 26; ++i) counts[i] += i;
        //Encoded counts[i] = 100*(actual count) + (i)
        Arrays.sort(counts);

        char[] ans = new char[length];
        int index = 1;
        for (int code : counts) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (length + 1) / 2) return "";
            for (int i = 0; i < ct; ++i) {
                if (index >= length) {
                    System.out.println(" at index:"+index+" ch:"+ch+ " ct:"+ct);
                    index = 0;
                }
                ans[index] = ch;
                index += 2;
            }
        }

        return String.valueOf(ans);
    }

    public static String reorganizeStringOptimized(String inputStr) {
        int length = inputStr.length();
        int[] counts = new int[26];
        int maxCount = 0;
        int maxCountIndex = -1;
        // Get count of each character
        for (char c : inputStr.toCharArray()) {
            counts[c - 'a'] += 1;
            if(maxCount < counts[c-'a']) {
                maxCount = counts[c-'a'];
                maxCountIndex = c-'a';
            }
        }

        // if any character with count more than half then not possible
        if (maxCount > (length + 1) / 2) return "";

        // fill characters alternative indexes 0,2,4 etc, when index>lenght start from 1 & then 3,5 etc
        char[] outputStr = new char[length];
        int index = 0;
        //first fill the character with max frequency, to handle cases where frequency is == n/2 +1 e.g vvvlo
        for(int j=0; j<counts[maxCountIndex]; j++){
            if(index >=length) index = 1;

            outputStr[index] = (char)(maxCountIndex +'a');
            index += 2;
        }

        for(int i=0; i< 26;i++){
            if(i== maxCountIndex) continue;

            char ch = (char) ('a'+i);
            for(int j=0; j<counts[i]; j++){
                if(index >=length) index = 1;

                outputStr[index] = ch;
                index += 2;
            }
        }

        return String.valueOf(outputStr);
    }

    public static void main(String[] args) {
        //
        // System.out.println(rearrange("aaabbbc"));
        System.out.println(reorganizeStringOptimized("vvvlo"));
    }
}
