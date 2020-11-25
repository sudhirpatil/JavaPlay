package com.sp.playground.JavaPlay.helpers;

import java.util.*;

public class MapHelper {
    public void mapHelp(){
        // Initializing map
        Map<String, Integer> map = new HashMap<>();
        map.put("Larry", 1);
        map.put("Steve", 2);
        map.put("James", 3);
        //
        Map<String, Integer> mapNew = new HashMap<String, Integer>(){{
            put("Larry", 1);
            put("Steve", 2);
            put("James", 3);
        }};

        //Iteration
        // Iterate, if needed to modify external variable
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        // Iterate functional way, but cannot modify variables defined outside
        map.
                forEach((key, value) -> System.out.println(key + " " + value));
        map.entrySet().
                forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        // get Collection<> with .values
        for(int value: map.values()){
            System.out.println("Value: "+value);
        }
        // get Set of keys with .keySet
        for(String key: map.keySet()){
            System.out.println("Key: "+key);
        }

        map.containsKey("Larry");
        map.getOrDefault("key1", 0);
        // Add key with default value if not exists, if exists increment value
        map.put("key1", map.getOrDefault("key1", 0)+1);
        // Put value if key doesn't exist,
        map.putIfAbsent("Darwin", 6);
        // Compute value using function & insert to map, if key doesn't exist
        map.computeIfAbsent("test", k -> new Integer(2));
        // compute new value with function if key already exists
        map.computeIfPresent("key", (key, value) -> value + 10);
        // merge only works for primitive types
        // Increment map value
        map.merge("test",1, Integer::sum);
        // Append to String Value
        Map<String, String> friends = new HashMap<String, String>();
        friends.merge("key1", "value1", String::concat);
        // Empty map or delete all elements in map
        map.clear();

        // Collections as map values
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

        /**************** LinkedHashMap for map + queue features ******************/
        //LinkedHashMap :: Default is insertion order, Note remove & add is required to maintain order for existing value updates
        LinkedHashMap<String, String> linkedMap = new LinkedHashMap<String, String>();
        // To maintain Access order, pass 3rd param as True
        LinkedHashMap<String, String> mapAccess = new LinkedHashMap<String, String>(10, 0.8f, true);
        // ** LinkedHashMap can be used for LRU cache with o(1) access to each node, removeEldestEntry can be used to remove oldest entry automatically
        // put, putIfAbsent, get, getOrDefault, compute, computeIfAbsent, computeIfPresent, or merge methods move element to least recently used
        // Iterations will print least recently used first & most recently used last

        // LRU with fixed size & remove oldest element automatically, using removeEldestEntry
        // Queue order By access (3rd param true)
        LinkedHashMap<String, String> linkedMapFixSize = new LinkedHashMap<String, String>(2, 0.8f, true){
            // if size exceeds capacity return true to remove oldest entry
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> e){
                return this.size() > 2;
            }
        };
        // Get first entry in linked Hashmap, make sure check for size of map
        Map.Entry<String, String> first = linkedMap.entrySet().iterator().next();
        first = linkedMap.size()>0 ? linkedMap.entrySet().iterator().next() : null;
        // Get last entry in linked hashmap, Iterate and get last element
        Iterator<Map.Entry<String, String>> iterator = linkedMap.entrySet().iterator();
        Map.Entry<String, String> lastElement;
        while (iterator.hasNext())
        {
            lastElement = iterator.next();
        }





        /************************* Sets *************************************/
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> newSet = new HashSet<Integer>(set);
        set.add(1);
        set.contains(1);
        set.remove(1);
        // Intersection, retain only common elements
        newSet.retainAll(set);
        // Find difference
        newSet.removeAll(set);
        // Linked HashSet to maintain the insertion order
        Set<String> lh = new LinkedHashSet<String>();

        // TreeSet to iterate elements in ascending order. descendingIterator can be used to iterate in descending order
        TreeSet<Integer> treeSet = new TreeSet<>(set);
        // set with all the elements smaller
        treeSet.headSet(1, true);
        // Set with all the elements greater
        treeSet.tailSet(1, true);
        // get subset between numbers
        treeSet.subSet(1, true, 3, true);
        // get first number
        treeSet.first();
        // get Last number
        treeSet.last();
        // remove first & last element like stack/queue
        treeSet.pollFirst();
        treeSet.pollLast();
        //modification of set using iterator
        Iterator<Integer> setIter = set.iterator();
        while(setIter.hasNext()){
            int x = (int) setIter.next();
            if(x%2 ==0) setIter.remove();
        }
        // print each element
        set.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {

        // TreeMap :: for sorted map by keys
        //we have to define object as TreeMap to use NavigableMap functions
        TreeMap<Integer,String> map = new TreeMap<>();
        for(int i=0;i<10;i++) {
            map.put(i, 10-i+"");
        }
        System.out.println(map);

        // Lowest & Highest entry
        Map.Entry<Integer,String> entry = map.firstEntry();
        entry = map.lastEntry();

        //poll and remove first, last entries
        entry = map.pollFirstEntry();
        entry = map.pollLastEntry();

        Map<Integer, String> reversedMap = map.descendingMap();
        System.out.println("Reversed Map: "+reversedMap);

        // get top(n) and smallest(n) records
        Map<Integer, String> subMap = map.subMap(2, true, 6, true);
        subMap = map.headMap(5, true);
        subMap = map.tailMap(5, true);

        //Find entry objects strictly lower, higher with given key
        map.lowerEntry(5);
        System.out.println("Closest Lower key than 5 is "+entry);
        entry = map.higherEntry(5);
        System.out.println("Closest Higher key than 5 is "+entry);
        // Find Keys higher/lower than given key in map
        System.out.println("Closest Lower key than 4 is "+map.lowerKey(4));
        // Closest lower or equal key in the map
        entry = map.floorEntry(5);
        System.out.println("Closest lower/floor entry than 5 is "+entry);
        entry = map.ceilingEntry(4);
        System.out.println("Closest higher/ceiling key than 4 is "+entry);


    }

    static void setHelper(){


    }


}
