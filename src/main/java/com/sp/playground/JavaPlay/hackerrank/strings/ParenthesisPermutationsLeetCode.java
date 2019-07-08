package com.sp.playground.JavaPlay.hackerrank.strings;

import java.util.*;

public class ParenthesisPermutationsLeetCode {

    /**
     * Key here is to select possible element at each stage of recursion.
     * 1. Always Opening brace has to come before closing so opening size == closing size select opening char in output
     * 2. if opening size < closing size then one char from either be chosen as both permutations is required, so call recursion with one char from left and one char from right
     * 3. if opening is null just use char from close
     * 4. other conditions like open > close should not happen, if it is then some error case
     * @param open
     * @param close
     * @param output
     * @return
     */
    public static List<String> getParenthesis(String open, String close, String output){
        if(open.length() == 0 && close.length() == 0){
            System.out.println("output : "+output);
            return Arrays.asList(output);
        }

        List<String> list = new ArrayList<>();
        int oLen = open.length(), cLen = close.length();
        if(oLen == cLen){
            list.addAll(getParenthesis(open.substring(1), close, output+open.charAt(0)));
        }else if(oLen < cLen && oLen !=0){
            list.addAll(getParenthesis(open.substring(1), close, output+open.charAt(0)));
            list.addAll(getParenthesis(open, close.substring(1), output+close.charAt(0)));
        }else if(oLen == 0 && cLen >0) {
            list.addAll(getParenthesis(open, close.substring(1), output+close.charAt(0)));
        }else {
            System.out.println("Error: "+open+" "+close+" "+output);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getParenthesis("(((", ")))", ""));
    }
}
