package com.sp.playground.JavaPlay.others;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Result {

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

    public static int getMaxOccurrencesOld(String s, int minLength, int maxLength, int maxUnique) {
        // Write your code here
        int maxOccur = 0;
        Map<String , Integer> subStrCount = new HashMap<>();
        char[] sArr = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for(int q=0; q< minLength-2; q++) charSet.add(sArr[q]);
        for(int i=0;i<= sArr.length-minLength; i++){
            charSet.add(sArr[i+minLength-2]);

            for(int j=i+minLength-1; j< (i+maxLength) && j<sArr.length;j++){
                charSet.add(sArr[j]);
                if(charSet.size() > maxUnique){
                    break;
                }
                subStrCount.merge(s.substring(i,j+1),1, Integer::sum);

            }
            charSet.remove(sArr[i]);
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

        int result = Result.getMaxOccurrences(s, minLength, maxLength, maxUnique);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
        bufferedReader.close();
//        bufferedWriter.close();
    }
}

