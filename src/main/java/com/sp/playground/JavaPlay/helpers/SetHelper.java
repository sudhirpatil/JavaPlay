package com.sp.playground.JavaPlay.helpers;

import java.util.*;

public class SetHelper {

    public void mapHelp(){
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
        // Iterate over set elements
        for(Integer i : set){
            System.out.println("set element : "+i);
        }

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
}
