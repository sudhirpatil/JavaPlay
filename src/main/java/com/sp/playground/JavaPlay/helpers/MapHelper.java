package com.sp.playground.JavaPlay.helpers;

import java.util.*;

public class MapHelper {
    public void mapHelp(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Larry", 1);
        map.put("Steve", 2);
        map.put("James", 3);

        Map<String, Integer> mapNew = new HashMap<String, Integer>(){{
            put("Larry", 1);
            put("Steve", 2);
            put("James", 3);
        }};

        // Iterate, if needed to modify external variable
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        // Iterate functional way, but cannot modify variables defined outside
        map.
                forEach((key, value) -> System.out.println(key + " " + value));
        map.entrySet().
                forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));


        // Put value if key doesn't exist,
        map.putIfAbsent("Darwin", 6);
        // Compute value using function & insert to map, if key doesn't exist
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

        // To remove item from map while looping, using iterator and not for loops
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String, Integer> entry = it.next();
            int freq = entry.getValue();
            if(freq ==1){
                it.remove();
            }else{
                map.merge("key", -1, Integer::sum);
            }

        }

        // TreeMap for sorted map by keys
    }

    public static void testLinkHashMap() {
        //Maintains only insert order no Access order
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        // To maintain insertion order + access order
        // Order elements by access, can be used for LRU implementation
        //(int initialCapacity, float loadFactor, boolean accessOrder <true use access order, false use insert order>)
        LinkedHashMap<String, String> mapAccess = new LinkedHashMap<String, String>(10, 0.8f, true); //Maintains only insert order no Access order
        // put, putIfAbsent, get, getOrDefault, compute, computeIfAbsent, computeIfPresent, or merge methods move element to least recently used
        // Iterations will print least recently used first & most recently used last

        // LRU with fixed size & remove oldest element automatically, using removeEldestEntry
        new LinkedHashMap<Integer, Integer>(10, 0.8f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e){
                return this.size() > 10;
            }
        };
    }

    static void setHelper(){
        // Initialize hashset
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2));

    }


}
