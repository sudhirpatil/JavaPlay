package com.sp.playground.JavaPlay.helpers;

import java.util.*;
import java.util.function.Predicate;

public class ListHelper {
    public void helpList(){
        // List is interface, instantiate with ArrayList etc
        List<Integer> list = new ArrayList();
        // Initializing List
        List<String> sList = Arrays.asList("one", "two", "three");
//        sList.remove(2); // cannot do this? test it
        // Only in JDK 9
//        List<String> initializedList2 = List.of("one", "two", "three");

        // Iterate list
        for(String item : sList){
            System.out.println(item);
        }
        sList.forEach(item -> {
            System.out.println(item);
        });

        sList.add(2, "test"); // add element at index 2 and shifts if any existing elements
        sList.sort((a, b) -> a.compareTo(b));
        sList.addAll(Arrays.asList("four", "five"));
        sList.replaceAll(value -> value+"new");
        sList.removeAll(Arrays.asList("four", "five"));
        sList.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("o");
            }
        });


        //Functional way to iterate
        sList.stream().
                filter(item -> item.contains("x")).
                forEach(System.out::println);

        // Collection methods
        // Rotates elements of list, elements are moved like in circular list
        Integer arr[] = {10, 20, 30, 40, 50};
        Collections.rotate(Arrays.asList(arr), 2); // [40, 50, 10, 20, 30]
        Collections.rotate(Arrays.asList(arr), -2); // [10, 20, 30, 40, 50]

        Collections.swap(sList, 1,2);
        Collections.max(sList);
        Collections.min(sList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
    }
}
