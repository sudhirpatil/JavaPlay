package com.sp.playground.JavaPlay.helpers;

import java.util.*;
import java.util.stream.Collectors;

public class DataStructures {
    public void DatatypeConversion(){
        int aInt =0;

        // char -> int
        char c=(char)aInt;
    }

    public void arrayHelper(){
        // Instantiate array with specific length
        int[] maxArr = new int[10];
        // Fill array with 0's
        Arrays.fill(maxArr, 0);

        // Convert array to List of Integer
        int[] ints = {1, 2, 3};
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : ints)
        {
            intList.add(i);
        }
        // java 8 : functional way
        List<Integer> list = Arrays.stream(ints)		// IntStream
                .boxed() 		// Stream<Integer>
                .collect(Collectors.toList());

        // Sorting
        Arrays.sort(maxArr); // Sorting array of primitive type
        // Sorting Objects, using comparator
//        Arrays.sort(T[]a , Comparator<T> b);
    }

    public void helpList(){
        // List is interface, instantiate with ArrayList etc
        List<Integer> list = new ArrayList();
        // Initializing List
        List<String> initializedList = Arrays.asList("one", "two", "three");
        // Only in JDK 9
//        List<String> initializedList2 = List.of("one", "two", "three");

        // Iterate list
        for(String item : initializedList){
            System.out.println(item);
        }
        initializedList.forEach(item -> {
            System.out.println(item);
        });

        //Functional way to iterate
        initializedList.stream().
                filter(item -> item.contains("x")).
                forEach(System.out::println);

    }


    public void mapHelp(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Larry", 1);
        map.put("Steve", 2);
        map.put("James", 3);

        // Iterate, if needed to modify external variable
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        // Iterate functional way, but cannot modify external variables
        map.
                forEach((key, value) -> System.out.println(key + " " + value));
        map.entrySet().
                forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));


        // Put value if key doesn't exist
        map.putIfAbsent("Darwin", 6);
        // Compute value if key doesn't exist, new String() can be any method
        map.computeIfAbsent("test", k -> new Integer(2));

        // Increment map value
        map.merge("test",1, Integer::sum);
    }

    public void mathFunctions(){
        // Math round off, ceil etc
        // Cast data types
    }

	public static void main(String[] args){

    }

}
