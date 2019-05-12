package com.sp.playground.JavaPlay.others;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result1 {

    /*
     * Complete the 'kSub' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY nums
     */
    public static long kSubOptimal(int k, List<Integer> nums) {
        long count = 0;

        // Array with running sum
        // get sum of i to j with sum[j]-sum[i]
        // get mod remaining for each i and update count for mod, modCount[modValue] + 1
        // all possible arrays divisible by k = Sum ( for each modCount n * n-1 / 2)
        return count;
    }

    public static long kSub(int k, List<Integer> nums) {
        // Find out all the min combinations divvisible by k
        // Find combinations by nCr formula

        long count = 0;
//        for(int i= 0; i< nums.size(); i++){
//            int num = nums.get(i);
//            if(num%k == 0){
//                count += 1;
//                System.out.println("divisible");
//                continue;
//            }else{
//
//                for (int j=i+1; j<nums.size();j++ ){
//                    if()
//                }
//            }
//
//        }
        return count;
    }

}

public class kSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int numsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> nums = IntStream.range(0, numsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = new Result1().kSub(k, nums);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

