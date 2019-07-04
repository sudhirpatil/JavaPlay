package com.sp.playground.JavaPlay.helpers;

import java.util.*;

public class MapHelper {
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


        // Put value if key doesn't exist,
        map.putIfAbsent("Darwin", 6);
        // Compute value if key doesn't exist, new String() can be any method
        map.computeIfAbsent("test", k -> new Integer(2));

        // merge only works for primitive types
        // Increment map value
        map.merge("test",1, Integer::sum);
        //or
        map.put("key1", map.getOrDefault("key1", 0)+1);

        // Append to String Value
        Map<String, String> friends = new HashMap<String, String>();
        friends.merge("key1", "value1", String::concat);

        Map<String, List<Integer>> mapList = new HashMap<>();
        // to update list/collection value, avoid if else
        List<Integer> list = mapList.getOrDefault("test1", new ArrayList<>());
        list.add(1);
        // OR
        mapList.putIfAbsent("test2", new ArrayList<>());
        mapList.get("test2").add(1);

        System.out.println();
    }

    static void setHelper(){
        // Initialize hashset
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2));

    }


}
