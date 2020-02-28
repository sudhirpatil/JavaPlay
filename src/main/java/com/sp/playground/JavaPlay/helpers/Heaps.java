package com.sp.playground.JavaPlay.helpers;

import java.util.PriorityQueue;

public class Heaps {
    public static void heapHelper(){
        // Object should be compareable i.e implement compare
        PriorityQueue<String> minDefaultPqueue = new PriorityQueue<>();

        // Bounded priority queue with comparator, min heap
        PriorityQueue<String> minHeap = new PriorityQueue<>(2, (e1, e2)-> Integer.compare(e1.length(), e2.length()));
        // Objects with Comparable interface can only be used, or else have to implement comparator object as 2nd param
        //PriorityQueue(int initialCapacity, Comparator<? super E> comparator)

        minHeap.add("12345"); // add element priority Queue
        minHeap.offer("123"); // add element, similar to adding Queue
        minHeap.add("1234"); // add element priority Queue
        minHeap.peek(); // check head in heap i.e min element
        minHeap.poll(); // remove min element from heap

        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll()); // remove min element from heap
        }

        /* Imp
        MinHeap : To keep top n elements , as min element maintained at head so easier to pop, compare and insert new element
        MaxHeap : to keep min n elements
         */
    }

    public static void main(String[] args) {
        heapHelper();
    }
}
