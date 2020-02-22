package com.sp.playground.JavaPlay.helpers;

import java.util.Arrays;
import java.util.Comparator;

public class CompareHelper {
    /* To compare Java Objects it has implement either Comparable or Comparator Interfaces
    Comparable : overrides CompareTo(Object obj) method in the Comparable Class
    Comparator : New Comparator Class overriding compare(obj1, obj2) method
     */

    static class Pair implements Comparable<Pair>{
        String key; int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair newPair) {
            // Ascending this > new Value in Sort
            return this.value - newPair.value;

            // For descending
//            return newPair.value - this.value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    // Comparator using new instance of this object
    static Comparator<Pair> pairComparator = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            //descending
            return o2.value - o1.value;
        }
    };

    public static void sort(){
        Pair[] pairs = {new Pair("1", 4), new Pair("2", 2), new Pair("3", 1), new Pair("4", 3)};

        // Sort using Comparable interface , uses compareTo method
        Arrays.sort(pairs);
        System.out.println(pairs);

        // Using Comparator object
        Arrays.sort(pairs, pairComparator);
        System.out.println(pairs);
    }

    public static void main(String[] args) {
        sort();
    }

}
