package com.sp.playground.JavaPlay.helpers;

import java.util.PriorityQueue;

public class Heaps {
    public static void heapHelper(){
        // Object should be compareable i.e implement compare
        PriorityQueue<Integer> minDefaultPqueue = new PriorityQueue<>();

        // Bounded priority queue with comparator, min heap
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(10, (e1, e2)-> Integer.compare(e1, e2));
        //PriorityQueue(int initialCapacity, Comparator<? super E> comparator)


        // add elements to heap
        pQueue.add(10);
        pQueue.offer(20);
        // check head in heap
        pQueue.peek();
        // get head element in queue and remove head from heap
        int headElement = pQueue.poll();

    }
}
