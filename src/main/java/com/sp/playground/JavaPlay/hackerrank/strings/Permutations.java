package com.sp.playground.JavaPlay.hackerrank.strings;

import java.util.Arrays;

public class Permutations {
    public static void getPermutations(String str){
        getAllUnique(str, "");
    }

    /**
     * at each index level of string run loop of possible characters & call recursivly input - charAt(i) , output + charAt(i)
     * e.g if input abcd , at index 0 possible chars is 4 (abcd), at index 2 possible chars is 3 (if a is at 0 index then bcd), similarly 2 & 1
     * @param input
     * @param output
     */
    public static void getAll(String input, String output){
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }

        int l = input.length();
        for(int i =0; i< l; i++){
            String newInput = input.substring(0,i)+input.substring(i+1, l);
            String newOutput = output+ input.charAt(i);
            getAll(newInput, newOutput);
        }
    }

    public static void getAllUnique(String input, String output){
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }

        boolean[] chars = new boolean[26];
        Arrays.fill(chars, false);
        int l = input.length();
        for(int i =0; i< l; i++){
            String newInput = input.substring(0,i)+input.substring(i+1, l);
            String newOutput = output+ input.charAt(i);
            char ch = input.charAt(i);
            if(!chars[ch - 'a']){
                chars[ch - 'a'] = true;
                getAllUnique(newInput, newOutput);
            }

        }
    }


    public static void main(String[] args) {
        getPermutations("abca");
    }
}
