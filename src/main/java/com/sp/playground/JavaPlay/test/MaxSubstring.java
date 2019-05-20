package com.sp.playground.JavaPlay.test;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Result2 {

    /*
     * Complete the 'getMaxOccurrences' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER minLength
     *  3. INTEGER maxLength
     *  4. INTEGER maxUnique
     */

    public static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
        int maxCount = 0;
        // Get substrings with min length & check maxUnique condition
        // count sub strings

        // map to detect unique chars in sub string
        Map<Character, Integer> charCount = new HashMap<>();
        for (int j=0; j< minLength-1; j++){
            char ch = s.charAt(j);
            charCount.merge(ch, 1, Integer::sum);
        }

        // map for substring count
        Map<String, Integer> subCount = new HashMap<>();
        // any sub string with max length will have same number of substring with minLength
        for(int i=minLength-1; i< s.length(); i++){
            char ch = s.charAt(i);
            charCount.merge(ch, 1, Integer::sum);
            // increment count for substring
            if(minLength<= maxUnique && charCount.size() <=maxUnique){
                System.out.println("start index:"+(i-(minLength-1))+" minlength:"+i);
                String minSubStr = s.substring(i-(minLength-1),i);
                subCount.merge(minSubStr, 1, Integer::sum);
            }

            // Decrement or remove first  char from map to find unique char
            char firstChar = s.charAt(i-(minLength-1));
            System.out.println("index:"+(i-(minLength-1)));
            System.out.println("charat:"+s.charAt(i-(minLength-1)));
            int cnt = charCount.get(firstChar);
            if(cnt ==1){
                charCount.remove(firstChar);
            }else {
                charCount.put(firstChar, cnt-1);
            }
        }

        // find out max frequency sub string from sub string map
        for(Map.Entry<String, Integer> entry: subCount.entrySet()){
            if(maxCount < entry.getValue()) maxCount = entry.getValue();
        }

        return maxCount;
    }

    public static int getMaxOccurrencesOld(String s, int minLength, int maxLength, int maxUnique) {
        // Write your code here
        int maxOccur = 0;
        Map<String , Integer> subStrCount = new HashMap<>();
        char[] sArr = s.toCharArray();

        //Can array be used instead of map? how to find number of characters?
        Map<Character, Integer> subCharCount = new HashMap<>();
        //Initialize with min length -2 chars count
        for(int q=0; q< minLength-2; q++) {
            subCharCount.merge(sArr[q], 1, Integer::sum);
        }
        // Only finding sub strings with min length is enough
        for(int i=minLength-1;i<sArr.length; i++){
            int subArrStart = i-(minLength-1);
            //Add current char
            subCharCount.merge(sArr[i], 1, Integer::sum);
            subStrCount.merge(s.substring(subArrStart, i+1),1, Integer::sum);

            //remove first char for substring
            subCharCount.merge(sArr[subArrStart], -1, Integer::sum);
            if(subCharCount.get(sArr[subArrStart]) ==0) subCharCount.remove(sArr[subArrStart]);
        }
        for (Map.Entry<String, Integer> entry : subStrCount.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            if(maxOccur < entry.getValue()) maxOccur = entry.getValue();
        }

        return maxOccur;
    }

}

public class MaxSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int minLength = Integer.parseInt(bufferedReader.readLine().trim());

        int maxLength = Integer.parseInt(bufferedReader.readLine().trim());

        int maxUnique = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result2.getMaxOccurrences(s, minLength, maxLength, maxUnique);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
        bufferedReader.close();
//        bufferedWriter.close();
    }
}

