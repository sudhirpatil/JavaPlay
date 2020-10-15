package com.sp.playground.JavaPlay.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchNSort {
    public static void search(){
        String[] arr = {"first", "two", "three"};
        // returns -1 if not found, if found returns index
        Collections.binarySearch(Arrays.asList(arr), "test", (a, b) -> a.compareTo(b));
        Arrays.binarySearch(arr, "test");


    }
}
