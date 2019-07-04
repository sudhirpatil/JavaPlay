package com.sp.playground.JavaPlay.hackerrank.strings;

import java.io.*;
        import java.util.*;
        import org.junit.*;
        import org.junit.runner.*;

/*
Your previous Plain Text content is preserved below:

Your previous Java content is preserved below:

Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
 */

public class MatchingParenthesis {
    public boolean matchParenthesis(String str){
        // queue of integer to be used to stre sequence of char in string
        // need it in the end to compare ((** and to avoid false positives int the case of "(*))**(("
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> starStack = new ArrayDeque<>();
        for(int i=0; i< str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else if( ch == '*'){
                starStack.push(i);
            }else if(ch == ')' && !stack.isEmpty()){
                stack.pop();
            }else if( ch == ')' && !starStack.isEmpty()){
                starStack.pop();
            }else{
                return false;
            }
        }

        if(starStack.size() < stack.size()) return false;

        while(!stack.isEmpty()){
            int brace = stack.pop();
            int star = starStack.pop();
            if(brace>star){
                return false;
            }
        }

        return true;
    }

//    @Test
//    public void matchTest1(){
//        Assert.assertEquals(true, matchParenthesis("()"));
//        Assert.assertEquals(true, matchParenthesis("(*)"));
//        Assert.assertEquals(true, matchParenthesis("(*))"));
//        Assert.assertEquals(false, matchParenthesis("(*))**(("));
//        Assert.assertEquals(true, matchParenthesis("(*))((***"));
//        Assert.assertEquals(true, matchParenthesis("(*))(**(***"));
//    }

    public static void main(String[] args) {
//        JUnitCore.main("Solution");
    }
}















