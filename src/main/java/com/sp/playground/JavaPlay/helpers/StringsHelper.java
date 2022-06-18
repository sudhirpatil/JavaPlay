package com.sp.playground.JavaPlay.helpers;

public class StringsHelper {
    public void stringMethods(){
        String str = "xyzabc";
        // check if it starts with xy
        str.startsWith("xy");
        // check if it ends with xy
        str.endsWith("abc");

        //Size of string
        str.length();
        //substring:: endIndex in exclusive i.e index 4 is not included but startIndex is included
        str.substring(0, 4);
        //substring starting from  index
        str.substring(1);

        // Character at specific index
        str.charAt(1);

        // first occurrence of string "abc"
        str.indexOf("abc");
        // first occurrence after index 2
        str.indexOf("abc", 2);
        str.lastIndexOf("b");

        // Check if 2 strings equal
        str.equals("xyx"); // Returns boolean, returns false if string in null
        // Check if string is empty
        str.isEmpty();

        // Compare 2 strings
        // return diff value 0 if equal, >0 if lexically ahead, <0 if lexically behind
        // exception if string is null
        // bit costly as it go through each of the character comparisons
        str.compareTo("abc");

        // to Character array
        char[] chArray = str.toCharArray();
        // to char stream for chaining map etc
        str.chars().map(c -> c+1);

        // To lower case
        "xx".toLowerCase();
        // To upper case
        str.toUpperCase();

        //Split string
        str.split("[ !?',;.]");

    }

    public void charMethods(){
        //Check if character is letter or digit
        Character.isLetterOrDigit('0');
        //Convert character to number/int
        Character.getNumericValue('2');
    }

    public static void main(String[] args) {
        int i = 13, j=5;
        System.out.println((int)(i/j));
    }
    /* String Problem solving notes

import org.junit.*;
import org.junit.runner.*;

   @Test
   public void solutionTest(){

     Assert.assertTrue("a4".equals(stringCompress("aaaa")));
     Assert.assertTrue("abaa".equals(stringCompress("abaa")));
     Assert.assertTrue("abcd".equals(stringCompress("abcd")));
     Assert.assertEquals("a3c2d2x5",stringCompress("aaaccddxxxxx"));

   }

    public static void main(String[] args) {
      JUnitCore.main("Solution");
    }

    Total number of all substrings e.g for abc -> a, b, c ab bc abc
    n * (n+1) / 2

    To find count of special substrings i.e sub string with same character or only middle character different::
    get same continuous character at each index store in array, get substring count by n * (n+1)/2
    all indexes with same character should have same count in array
    to get substrings with only one char different, check if right & left char is same & get count from array above.
    count of in  array is number of substrings with middle char different.
    Miss:: couldn't think about n*.. formula & using array to store repeat characters and using it for count of string

    missing () after method str.length()
    mistake in assigning variables, after any change review code again
    uninitialized variable even if there is both if else part;
    missing edge condition for long string with multiple character not matching,

    wrong condition in while loop, could not find that error for very long time
        re verify all test conditions
        anything strange go back and check all the conditions
   did not do length checks : do array length check always
   not good with junit : practise junit

     */
}
