package com.sp.playground.JavaPlay.hackerrank.strings;

import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;

//Special String Again
public class OneAwayCci1_5{

    public static boolean isOneAway(String str1, String str2){
        //check if length diff more than 2
        if(Math.abs(str1.length()- str2.length()) > 1){
            return false;
        }

        String strBig = str1, strSmall = str2;

        if(str1.length() < str2.length()){
            strBig =str2;
            strSmall = str1;
        }

        boolean oneDiff = false;
        for(int i=0,j=0; i<strBig.length()-1; i++){
            char big = strBig.charAt(i);
            char small = strSmall.charAt(j);
            // System.out.println("i"+i+" j"+j+" big"+big+" small"+small);
            if(big != small){
                // System.out.println("i"+i+" j"+j+" big"+big+" small"+small);
                if(strBig.length() == strSmall.length() || oneDiff){
                    return false;
                }else if(strBig.charAt(i+1) != small){
                    return false;
                }
                oneDiff = true;
            }else{
                j++;
            }

        }
        return true;
    }

//    @Test
//    public void isOneWayTest(){
//        Assert.assertTrue(isOneAway("abc", "abcd"));
//        Assert.assertFalse(isOneAway("abc", "abdd"));
//        Assert.assertFalse(isOneAway("abc", "abccab"));
//        Assert.assertFalse(isOneAway("abcabc", "adcaec"));
//    }
//
//    public static void main(String[] args){
//        // System.out.println(isOneAway("abc", "abdd"));
//        JUnitCore.main("Solution");
//    }
}
