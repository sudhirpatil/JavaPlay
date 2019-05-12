package com.sp.playground.JavaPlay.others;

import java.math.BigInteger;

public class PrintSubArray {
    public static void subArrayContiuousCubic(int[] arr){
        for(int i=0 ;i<arr.length;i++){
            for(int j=i; j< arr.length; j++){
                String s = "";
                for(int k=i; k<=j; k++){
                    s += arr[k];
//                    System.out.println(arr[k]);
                }
                System.out.println(s);
            }
        }

    }

    public static  void subArrayAllPossible(int[] arr){
        /* Number of subsequences is (2**n -1)*/
        int opsize = (int)Math.pow(2, arr.length);

        for(int counter=1 ;counter<opsize;counter++){
            for(int j=0; j< arr.length; j++){
                if(BigInteger.valueOf(counter).testBit(j))
                    System.out.print(arr[j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        subArrayAllPossible(arr);
    }
}
