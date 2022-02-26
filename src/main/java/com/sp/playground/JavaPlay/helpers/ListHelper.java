package com.sp.playground.JavaPlay.helpers;

import java.util.*;
import java.util.function.Predicate;

public class ListHelper {
    public void helpList(){
        // List is interface, instantiate with ArrayList etc
        List<Integer> list = new ArrayList();
        // Initializing Fixed Length List, since list is just wrapper over array. Can do add & remove
        // Also can be used to quickly create tuple
        List<String> sList = Arrays.asList("one", "two");
//        Integer[] arr = list.toArray(Integer[]:: new);
        // Iterate list
        for(String item : sList){
            System.out.println(item);
        }
        sList.forEach(item -> {
            System.out.println(item);
        });
        // append to list
        list.add(2);
        // check if list is empty
        list.isEmpty();

        LinkedList<String> linkedList = new LinkedList<>();
        // Whats the difference?
        linkedList.removeFirst();
        linkedList.pollFirst();
        linkedList.poll();
        linkedList.addFirst("1");

        // Collections methods
        Integer arr[] = {10, 20, 30, 40, 50};
        // Rotates elements of list, elements are moved like in circular list
        Collections.rotate(Arrays.asList(arr), 2); // [40, 50, 10, 20, 30]
        Collections.rotate(Arrays.asList(arr), -2); // [10, 20, 30, 40, 50]
        // Swap elements
        Collections.swap(sList, 1,2);
        // Search
        Collections.binarySearch(sList, "two");
        // Min Max
        Collections.max(sList);
        Collections.min(sList, (a, b) -> a.compareTo(b));
        Collections.min(sList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        //List Object methods
        //Check if empty
        sList.isEmpty();
        // iterator, helpful to keep track of current element
        sList.iterator();
        // sublist
        sList.subList(1,4);
        // convert to Array only for objects or non primitive types
        String[] arrStr = sList.toArray(new String[0]);
        // primitive types like int/long.. etc have to be through for loop

        // Sort
        sList.sort((a, b) -> a.compareTo(b));
        Collections.sort(sList, (a, b) -> a.compareTo(b));
        // Appends item at the end of list
        sList.add("append");
        // add element at index 2 and shifts if any existing elements
        sList.add(2, "test");
        // Replaces element at index, make sure element at 2 already exists before set
        sList.set(2, "replace");
        sList.addAll(Arrays.asList("four", "five"));
        sList.replaceAll(value -> value+"new");
        sList.removeAll(Arrays.asList("four", "five"));
        sList.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("o");
            }
        });
        // Clear all elements
        sList.clear();


        //Functional way to iterate
        sList.stream().
                filter(item -> item.contains("x")).
                forEach(System.out::println);

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8,1,3);
        Collections.sort(list);
    }
}
