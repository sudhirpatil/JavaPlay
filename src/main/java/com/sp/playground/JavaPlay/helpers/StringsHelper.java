package com.sp.playground.JavaPlay.helpers;

public class StringsHelper {
    public void stringMethods(){
        String str = "xyzabc";

        // check if it starts with xy
        str.startsWith("xy");

        //substring:: endIndex in exclusive i.e index 4 is not included but startIndex is included
        str.substring(0, 4);
        //substring starting from  index
        str.substring(1);

        // Character at specific index
        str.charAt(1);

        // to Character array
        char[] chArray = str.toCharArray();
    }

    public void charMethods(){
        Character.isLetterOrDigit('0');  // To detect number characters

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
