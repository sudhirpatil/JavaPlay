package com.sp.playground.JavaPlay.hackerrank.strings;

import java.io.*;
import java.util.*;

//Special String Again
public class CompressStringCci1_6{
    public static String stringCompress(String str1){
        int len = str1.length();
        char[] comp = new char[len];

        int arrIndex = 0;
        char prevChar = str1.charAt(0);
        for(int i=1;i<len;i++){
            int count =1;
            while(i<len && str1.charAt(i) == prevChar){
                i++;
                count++;
            }
            // System.out.println(i+" "+str1.charAt(i)+" "+prevChar);

            String cntStr = String.valueOf(count);
            int cntLen = cntStr.length();
            if((arrIndex + cntLen + 1) >= len){
                // System.out.println("len exceed"+arrIndex+" cnt len:"+ (arrIndex + cntLen + 1) +" len:"+len);
                return str1;
            }
            comp[arrIndex] = prevChar;
            arrIndex++;
            for(char ch: cntStr.toCharArray()){
                comp[arrIndex] = ch;
                arrIndex++;
            }

            if(i<len) prevChar = str1.charAt(i);
            // System.out.println(i);
        }

        return String.valueOf(comp).trim();
    }

    // wrong condition in while loop, could not find that error for very long time
    //   reverify all test conditions
    //    anything strange go back and check all the conditions
    // did not do length checks : do array length check always
    // not good with junit : practise junit

//    @Test
//    public void solutionTest(){
//
//        Assert.assertTrue("a4".equals(stringCompress("aaaa")));
//        Assert.assertTrue("abaa".equals(stringCompress("abaa")));
//        Assert.assertTrue("abcd".equals(stringCompress("abcd")));
//        Assert.assertEquals("a3c2d2x5",stringCompress("aaaccddxxxxx"));
//
//    }
//
//    public static void main(String[] args){
//        // System.out.println(stringCompress("aaaa"));
//        JUnitCore.main("Solution");
//    }
}
