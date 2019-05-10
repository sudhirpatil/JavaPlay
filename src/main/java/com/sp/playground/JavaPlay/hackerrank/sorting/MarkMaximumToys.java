package com.sp.playground.JavaPlay.hackerrank.sorting;

import java.io.*;
import java.util.*;

public class MarkMaximumToys {

        // Complete the maximumToys function below.
        static int maximumToys(int[] prices, int k) {
            List<Integer> priceList = new ArrayList<Integer>();
            for (int i : prices)
            {
                priceList.add(i);
            }
            Collections.sort(priceList);

            int numToys = 0, totalPrice = 0;
            while (totalPrice < k){
                totalPrice += priceList.get(numToys);
                numToys +=1;

            }
            return numToys-1;

        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] prices = new int[n];

            String[] pricesItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int pricesItem = Integer.parseInt(pricesItems[i]);
                prices[i] = pricesItem;
            }

            int result = maximumToys(prices, k);
            System.out.println(result);

//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
//
//            bufferedWriter.close();

            scanner.close();
        }

}
