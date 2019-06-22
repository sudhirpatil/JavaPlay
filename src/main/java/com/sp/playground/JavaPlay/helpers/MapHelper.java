package com.sp.playground.JavaPlay.helpers;

import java.util.HashMap;
import java.util.Map;

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


        // Put value if key doesn't exist
        map.putIfAbsent("Darwin", 6);
        // Compute value if key doesn't exist, new String() can be any method
        map.computeIfAbsent("test", k -> new Integer(2));

        // Increment map value
        map.merge("test",1, Integer::sum);
    }


}
