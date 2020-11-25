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

        /* Sort using Comparator
        -1 if a is big, 0 if equal , 1 if b is big
        Return should be consistent (a ? -1 : b ? 1 : 0) will not work as
        when a=true, b=true return value may be -1 or 1
         */
        Boolean[] bArr = new Boolean[10];
        Arrays.sort(bArr, (a, b) -> {
            if(a != b)
                return Boolean.compare(a, b);

            // result have to be transitive e.g if both a.start & b.start are both true it  might return -1 or 1, ideally return should be 0
            return a && !b ? -1 : !a && b ? 1 : 0;
        });
    }
}
