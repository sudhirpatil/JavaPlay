package com.sp.playground.JavaPlay.hackerrank;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class MaxArraySum {

    // Max Sum from alternative numbers, numbers cannot be next to each other, can skip any numbers
    static int maxSubsetSum(int[] arr) {
        int[] maxArr = new int[arr.length];
        Arrays.fill(maxArr, 0);
        //*** Key is to create an max array with max at each index. max of (current + max[cur -2] or max[cur -1] or max[cur - 2]
        // max at a[i] == Max(m[i-2], m[i-1], a[i]+max[i-2]) ***
        // Calculating running minSum and get maxSum by current - minSum wont work here, as numbers are alternative
        for (int i = 0; i < arr.length; i++) {
            if(i==0 || i ==1){
                if(i==0) {
                    maxArr[i] = Math.max(0, arr[i]);
                }else if (i == 1){
                    maxArr[i] = Math.max(Math.max(0, arr[i]), maxArr[i-1]);
                }
            }else {
                maxArr[i] = Math.max(Math.max(maxArr[i-1], maxArr[i-2]), (arr[i] + maxArr[i-2]));
            }
        }
        return maxArr[arr.length-1];
    }

    // Complete the maxSubsetSum function below.
    static int maxSubsetSumOld(int[] arr) {
        int runningSum1=0, runningSum2=0;
        int maxSum =0;
        int minSum1 =0, minSum2 =0;

        for (int i = 0; i < arr.length; i++) {
            if(i%2 == 0){
                runningSum1 += arr[i];
                if(runningSum1 - minSum1 > maxSum){
                    maxSum = runningSum1 - minSum1;
                }
                if(runningSum1 < minSum1){
                    minSum1 = runningSum1;
                }

            }else {
                runningSum2 += arr[i];
                if(runningSum2 - minSum2 > maxSum){
                    maxSum = runningSum2 - minSum2;
                }
                if(runningSum2 < minSum2){
                    minSum2 = runningSum2;
                }
            }
        }
        return maxSum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);
        System.out.println(res);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
