package com.sp.playground.JavaPlay.hackerrank.strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlternatingCharacter {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int delCount = 0;
        char[] sArr = s.toCharArray();
        char prevChar = sArr[0];
        for(int i = 1; i< sArr.length; i++){
            if(sArr[i] == prevChar){
                delCount += 1;
            }else {
                prevChar = sArr[i];
            }
        }

        return delCount;
    }

    static int alternatingCharactersOld(String s) {
        int delCount = 0;
        // Get count of achars & bchars
        // if only achars or bchars , count -1
        // else mod(achars - bchars)
        int aCount =0, bCount =0;
        for(char ch: s.toCharArray()){
            if(ch == 'A') aCount += 1;
            else if(ch == 'B') bCount += 1;
        }

        if(aCount > 0 && bCount > 0){
            delCount = Math.abs(aCount - bCount);
        }else if (aCount > 0 && bCount == 0){
            delCount = aCount - 1;
        }else if(aCount == 0 && bCount > 0){
            delCount = bCount -1;
        }

        return delCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(result);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}