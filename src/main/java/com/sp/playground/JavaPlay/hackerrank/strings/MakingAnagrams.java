package com.sp.playground.JavaPlay.hackerrank.strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int delCount = 0;
        // Hashmap of character count for a
        // Iterate b characters and remove from aHashmap & count missing chars in map
        // Count of characters still remaining in map
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        Map<Character, Integer> aFreq = new HashMap<>();
        for(char aChar: aArr){
            aFreq.merge(aChar, 1, Integer::sum);
        }

//        for(Map.Entry<Character, Integer> entry: aFreq.entrySet()){
//            System.out.println(entry.getKey() + "/" + entry.getValue());
//        }

        for(Character bChar: bArr){
            if(aFreq.containsKey(bChar)){
                int cnt = aFreq.get(bChar);
                if(cnt == 1) aFreq.remove(bChar);
                else aFreq.put(bChar, cnt -1);
            }else {
                delCount += 1;
            }
        }

        for(Map.Entry<Character, Integer> entry: aFreq.entrySet()){
//            System.out.println(entry.getKey() + "/" + entry.getValue());
            delCount += entry.getValue();
        }

        return delCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);
        System.out.println(res);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}