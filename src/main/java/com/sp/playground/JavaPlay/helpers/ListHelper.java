package com.sp.playground.JavaPlay.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListHelper {
    public void helpList(){
        // List is interface, instantiate with ArrayList etc
        List<Integer> list = new ArrayList();
        // Initializing List
        List<String> iList = Arrays.asList("one", "two", "three");
        // Only in JDK 9
//        List<String> initializedList2 = List.of("one", "two", "three");

        // Iterate list
        for(String item : iList){
            System.out.println(item);
        }
        iList.forEach(item -> {
            System.out.println(item);
        });

        iList.add(2, "test"); // add element at index 2 and shifts if any existing elements
        iList.replaceAll(value -> value+"new");

        iList.sort((a, b) -> a.compareTo(b));
        Collections.max(iList);
        //Functional way to iterate
        iList.stream().
                filter(item -> item.contains("x")).
                forEach(System.out::println);

        // Rotates elements of list, elements are moved like in circular list
        Collections.rotate(iList, -2);

    }
}
