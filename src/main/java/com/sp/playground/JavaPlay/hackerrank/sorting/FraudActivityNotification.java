package com.sp.playground.JavaPlay.hackerrank.sorting;

import java.io.*;
import java.util.*;

public class FraudActivityNotification {

    static int activityNotifications(int[] expenditure, int d) {
        int fraudCount = 0;
        int median1 =-1, median2 = -1;
        double medianValue = 0.0;
        if(d%2 == 0){
            median1 = d/2 -1;
            median2 = median1 + 1;
        }else {
            median1 = (int) d/2;
        }

        int[] freqSubArray = new int[201];
        Arrays.fill(freqSubArray, 0);
        // Fill subarray for range from main array with frequency
        for(int j=0; j< d-1; j++){
            freqSubArray[expenditure[j]] += 1;
        }

        // Error in taking range indexes, did not take correct sub array variable, again selecting indexes
        for (int i = d ; i< expenditure.length; i++){
            int startIndex = i-d, endIndex = i-1;
            // increase the frequence for endIndex value
            freqSubArray[expenditure[endIndex]] += 1;
            // iterate subarray to ge median value
            int indexCount =0;
            medianValue = -1;
            for(int k= 0; k< freqSubArray.length; k++){
                int freq = freqSubArray[k];
                if(freq == 0) continue;

                indexCount += freq;
                if(medianValue == -1 && (indexCount -1)>= median1){
                    medianValue  = k;
                    if(median2 == -1) break;
                }

                if(median2 !=-1  && (indexCount-1) >= median2){
                    medianValue = (medianValue + k)/2;
                    break;
                }
            }

            // update fraud count
            if(expenditure[i] >= medianValue * 2){
                fraudCount += 1;
            }

            // decrease fequency for value of start index
            freqSubArray[expenditure[startIndex]] -= 1;

        }
        return fraudCount;
    }

    // Complete the activityNotifications function below.
    static int activityNotificationsOld(int[] expenditure, int d) {
        int fraudCount = 0;
        int median1 =0, median2 = 0;
        double medianValue = 0.0;
        if(d%2 == 0){
            median1 = d/2 -1;
            median2 = median1 + 1;
        }else {
            median1 = (int) d/2;
        }

        // Error in taking range indexes, did not take correct sub array variable, again selecting indexes
        for (int i = d ; i< expenditure.length; i++){
            // range of indexes was wrong
            int[] subArray = Arrays.copyOfRange(expenditure, i-d, i);
            Arrays.sort(subArray);
            //get median
            if(median2 == 0){
                medianValue = subArray[median1];
            }else {
                medianValue = ((double)subArray[median1] + subArray[median2])/2;
//                System.out.println("med1:"+expenditure[median1+startDay] + "  med2:"+expenditure[median2+startDay]);
            }
//            System.out.println("expenditure:"+expenditure[i]+ " d:"+d+" medianValue:"+medianValue);
            if(expenditure[i] >= medianValue * 2){
                fraudCount += 1;
            }
        }
        return fraudCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//        System.out.println("n:"+n+" d:"+d);

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);
//        int[] ints = {2, 3, 4, 2, 3, 6, 8, 4, 5};
//        System.out.println(activityNotifications(ints, 4));

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}