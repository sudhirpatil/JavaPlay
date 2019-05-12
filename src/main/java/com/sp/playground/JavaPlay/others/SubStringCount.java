package com.sp.playground.JavaPlay.others;

import java.util.Arrays;

/**
 * Find number of times substring appears in bigString
 * Knuth-Morris-Pratt algorithm : Find largest prefix and suffix pattern in Substring and use this to skip matching few characters
 * Prepare auxillary array which tells what characters we should start comparing when characters don't match, instead of going back to 0 again
 */

public class SubStringCount {
    public static int[] getAuxArr(char[] subArr){
        int[] auxArr = new int[subArr.length];
        Arrays.fill(auxArr, 0);
        int ahead = 1, behind =0;
        while(ahead < subArr.length){
            if(subArr[ahead] == subArr[behind]){
                auxArr[ahead] = behind + 1;
                ahead += 1;
                behind += 1;
            }else if(subArr[ahead] != subArr[behind] && behind != 0){
                behind -= 1;
            }else {
                auxArr[ahead] = 0;
                ahead += 1;
            }
        }

        return auxArr;
    }

    public static void main(String[] args){
        char[] subArr = "Duck".toCharArray();
        char[] arr = "duceDuckxDucyDuck".toCharArray();
        int[] auxArr = getAuxArr(subArr);
        for(int val: auxArr){
            System.out.println(val);
        }

        int subStrCnt = 0;
        //If mismatch auxArr will tell which index from subArr to check next
        int arrIndex = 0, subIndex =0;
        //Arr loop
        while (arrIndex < arr.length){
            if(arr[arrIndex] == subArr[subIndex]){
                arrIndex += 1;
                subIndex += 1;
                if(subIndex == subArr.length){
                    System.out.println("Found match at index :"+ (arrIndex - subArr.length));
                    subStrCnt += 1;
                    subIndex = auxArr[subIndex - 1];
                }
            }else if(arr[arrIndex] != subArr[subIndex]){
                if(subIndex == 0){
                    arrIndex += 1;
                }else {
                    subIndex = auxArr[subIndex - 1];
                }
            }
        }
        System.out.println("Total substrings found :"+ subStrCnt);
    }
}
