package com.sp.playground.JavaPlay.hackerrank.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountTriplets {
    /**
     * https://www.hackerrank.com/challenges/count-triplets-1/problem
     * You are given an array and you need to find number of tripets of indices  such that the elements at those indices are in geometric progression for a given common ratio  and .
     *
     * For example, . If arr = [1,4,16,64] & r =4, we have 2 triplets [1,4,16] and [4,16,64]
     *
     * Create 2 Maps, right (value -> value frequency) Initialized from Array and left (value -> frequency) updated after iterating.
     * iterate through each element
     *  right decrease count for key
     *  count += left(value/r) * right(value * r)
     *  left increase count for key
     *
     * 2nd map important to preserve order
     * iterating through array and not map
     * anchoring at middle element of triplet and find value/r for left and value*r for right
     * @param arr
     * @param r
     * @return
     */
    static long countTriplets(List<Long> arr, long r) {

        Map<Long,  Long> left = new HashMap<>();
        Map<Long,  Long> right = new HashMap<>();

        long tripleCount  = 0;


        for(long val : arr){
            if(right.containsKey(val)){
                right.put(val, right.get(val) + 1);
            }else{
                right.put(val, 1L);
            }
        }

        for(long item : arr){
            // imp for un ordered cases, also have to done at this point for cases where r=1
            right.put(item, right.get(item) -1);

            // Iterate array in sequence & compute count with right, left map
            if(left.containsKey(item/r) && right.containsKey(item * r)){
                // Key to calculate count, anchoring on middle element of triplet and multiplying prev & next
                // have to maintain 2 maps
                tripleCount += left.get(item/r) * right.get(item * r);
            }

            long count = 0;
            if(left.containsKey(item)){
                count = left.get(item);
            }
            left.put(item, count + 1);
        }

        return tripleCount;
    }

    // Complete the countTriplets function below.
    static long countTripletsOld(List<Long> arr, long r) {
        Map<Long,  Long> mapping = new HashMap<>();
        long tripleCount  = 0;

        // Create map of number & count for input array
        for(long val : arr){
            if(mapping.containsKey(val)){
                mapping.put(val, mapping.get(val) + 1);
            }else{
                mapping.put(val, 1L);
            }
        }

        // For each element in map find if another 2 numbers exists with num * r & num * r * r, count
        // Count will be count1 * count2 * count3
        // What if r = 1;
        for(Map.Entry<Long, Long> mapEntry : mapping.entrySet()){
            long value = mapEntry.getKey();
            long valCount = mapEntry.getValue();
            System.out.println("Starting value:"+value+" ,valCount:"+valCount);

            long multiVal = value * r;
            int count = 1;
            long innerTriplets = mapping.get(value);
            while(count < 3 && mapping.containsKey(multiVal)){
                innerTriplets *= mapping.get(multiVal);
                count++;
                System.out.println("= multiVal:"+multiVal+" innerTriplets:"+innerTriplets+ " count:"+count);
                multiVal *= r;
            }

            if(count ==3){
                tripleCount += innerTriplets;
                System.out.println("= Fount Triplet total Triplets:"+tripleCount);
            }

        }

        return tripleCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(String.valueOf(ans));
        System.out.println("\n");
//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

