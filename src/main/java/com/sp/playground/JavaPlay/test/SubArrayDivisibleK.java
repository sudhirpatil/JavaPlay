package com.sp.playground.JavaPlay.test;

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
    public static long kSub(int k, List<Integer> nums) {
        long count = 0;

        // any number divisible by k mod ==0
        // running sum with mod at each store in map & increase count
        // for any sum[i,j] to be divisible by k, mod(sum(0,j)) - mod(sum(0,i)) == 0
        // so count of all sub array is sum (n * (n-1)) of all mod counts > 1

        // Use array instead of map as all 0 - k-1 mods needs to store
        int[] modArr = new int[k];
        Arrays.fill(modArr, 0);
//        modArr[0] = 1; //??
        int runningSum = 0;
        for(int i=0; i<nums.size(); i++){
            runningSum += nums.get(i);
            // mod of mod to get correct mod for -ve numbers
            modArr[((runningSum %k)+k)%k]++;
        }

        count += modArr[0];
        for(int modCount : modArr){
            count += (modCount * (modCount-1))/2;
        }
        return count;
    }

    public static long kSubOld(int k, List<Integer> nums) {
        long count = 0;

        // any number divisible by k mod ==0
        // running sum with mod at each store in map & increase count
        // for any sum[i,j] to be divisible by k, mod(sum(0,j)) - mod(sum(0,i)) == 0
        // so count of all sub array is sum (n * (n-1)) of all mod counts > 1
        Map<Integer, Integer> modCount = new HashMap<>();
        int runningSum = 0;
        for(int i=0; i< nums.size(); i++){
            int num = nums.get(i);
            // if(num % k == 0) modCount.merge(0, 1, Integer::sum);

            runningSum += num;
            int mod = ((runningSum % k)+k)%k;
            modCount.merge(mod, 1, Integer::sum);
        }

        for(Map.Entry<Integer, Integer> entry: modCount.entrySet()){
            int value = entry.getValue();
            if(value > 1) {
                count += (value * (value - 1)) / 2;
            }
        }

        return count + modCount.get(0);
    }

}

public class SubArrayDivisibleK {
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
        System.out.println("result :"+result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

