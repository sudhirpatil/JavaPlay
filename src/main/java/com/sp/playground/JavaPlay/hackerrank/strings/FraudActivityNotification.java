package com.sp.playground.JavaPlay.hackerrank.strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudActivityNotification {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int fraudCount = 0;
        Arrays.sort(expenditure);
        Arrays.toString(expenditure);
        int median1 =0, median2 = 0;
        double medianValue = 0.0;
        if(d%2 == 0){
            median1 = d/2 -1;
            median2 = median1 + 1;
        }else {
            median1 = (int) d/2;
        }

        for (int i = d ; i< expenditure.length; i++){
            int startDay = i - d;
            //get median
            if(median2 == 0){
                medianValue = expenditure[median1+startDay];
            }else {
                medianValue = ((double)expenditure[median1+startDay] + expenditure[median2+startDay])/2;
                System.out.println("med1:"+expenditure[median1+startDay] + "  med2:"+expenditure[median2+startDay]);
            }
            System.out.println("expenditure:"+expenditure[i]+ " d:"+d+" medianValue:"+medianValue);
            if(expenditure[i] >= medianValue * 2){
                fraudCount += 1;
            }
        }
        return fraudCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        String[] nd = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nd[0]);
//
//        int d = Integer.parseInt(nd[1]);
////        System.out.println("n:"+n+" d:"+d);
//
//        int[] expenditure = new int[n];
//
//        String[] expenditureItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int expenditureItem = Integer.parseInt(expenditureItems[i]);
//            expenditure[i] = expenditureItem;
//        }
//
//        int result = activityNotifications(expenditure, d);
//        System.out.println(result);
        int[] ints = {2 ,3 ,4 ,2 ,3 ,6 ,8 ,4 ,5};
        System.out.println(activityNotifications(ints, 5));

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}