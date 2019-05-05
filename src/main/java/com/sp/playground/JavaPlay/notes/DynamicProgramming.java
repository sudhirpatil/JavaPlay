package com.sp.playground.JavaPlay.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {
    // By solving smaller problems of same kind
    // Any problems where solution can be expressed recursively by solving smaller problem

    // EPI :: ch 16 example
    // Find sub array with max sum, numbers have to be consecutive in subarray
    public static int findMaximumSubarray(List<Integer> A) {
        // ** at each index maxSum = runningSum - minSum;
        // running sum at each level by adding and get minSum (runningSum) so far
        int minSum = 0, runningSum = 0, maxSum = 0;
        for (int i = 0; i < A.size(); ++i) {
            runningSum += A.get(i);
            if (runningSum < minSum) {
                minSum = runningSum;
            }
            if (runningSum - minSum > maxSum) {
                maxSum = runningSum - minSum;
            }
        }

        List<Integer> list = new ArrayList();
        return maxSum;
    }

    // Hackerrank
    // https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
    // Max Sum from alternative numbers, numbers cannot be next to each other, can skip any numbers
    static int maxSubsetSum(int[] arr) {
        int[] maxArr = new int[arr.length];
        Arrays.fill(maxArr, 0);
        //*** Key is to create an max array with max at each index. max of (current + max[cur -2] or max[cur -1] or max[cur - 2]
        // max at a[i] == Max(m[i-2], m[i-1], a[i]+max[i-2]) ***
        // Calculating running minSum and get maxSum by current - minSum wont work here, as numbers are alternative
        for (int i = 0; i < arr.length; i++) {
            // Caustious
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


}
