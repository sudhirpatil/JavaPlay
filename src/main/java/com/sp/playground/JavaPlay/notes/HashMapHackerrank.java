package com.sp.playground.JavaPlay.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapHackerrank {

    /**
     * https://www.hackerrank.com/challenges/frequency-queries/problem
     *
     * -  : Insert x in your data structure.
     * -  : Delete one occurence of y from your data structure, if present.
     * -  : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.
     * Solutions : Maintain 2 maps one for value -> freq and count -> number of values with this freq
     *  While Inserting new record or deleting important to update previous count -> freq mapping
     * @param queries
     * @return
     */

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(int[][] queries) {
        List<Integer> frequencies = new ArrayList<>();
        Map<Integer, Integer> valueFrequency = new HashMap<>();
        Map<Integer, Integer> frequencyCount = new HashMap<>();

        for(int[] query : queries){
            Integer queryType = query[0];
            Integer queryValue = query[1];

            Integer count = 0;
            Integer reverseCount = 0;
            if(queryType == 1){
                //Update map count for queryValue with count+1
                valueFrequency.merge(queryValue, 1, Integer::sum);
                //ReverseMap :: increase count for current count
                count = valueFrequency.get(queryValue);
                frequencyCount.merge(count,1, Integer::sum);
                //reverseMap :: decrease count for prev count and delete key if count becomes 0
                reverseCount = frequencyCount.get(count -1);
                if(reverseCount != null){
                    if(reverseCount == 1) {
                        frequencyCount.remove(count - 1);
                    }else {
                        frequencyCount.put(count-1, reverseCount -1);
                    }
                }
            }else if(queryType == 2){
                count = valueFrequency.get(queryValue);
                if(count != null){
                    // Update map with count - 1 & delete if count -1 ==0
                    if(count == 1){
                        valueFrequency.remove(queryValue);
                    }else{
                        valueFrequency.put(queryValue, count -1);
                    }

                    // Increase the count for reverseMap prev count
                    if(count > 1){
                        frequencyCount.merge(count-1, 1, Integer::sum);
                    }
                    //ReverseMap :: decrease count for current count
                    reverseCount = frequencyCount.get(count);
                    if(reverseCount == 1){
                        frequencyCount.remove(count);
                    }else {
                        frequencyCount.put(count, reverseCount -1);
                    }

                }
                //Delete from map if any of the values are 0 in map & reverse map
            }else if(queryType == 3){
                // Check if count exists in reverse map & count >0 then add to frequency list
                frequencies.add(frequencyCount.get(queryValue) == null ? 0 : 1);
//                if(reverseMap.containsKey(queryValue)){
//                    frequencies.add(1);
//                }else {
//                    frequencies.add(0);
//                }
            }
        }

        return frequencies;
    }


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
}
