package com.sp.playground.JavaPlay.helpers;

import java.util.PriorityQueue;

public class Heaps {
    public static void heapHelper(){
        // minHeap -> to get min k elements, keeps max element at the top, compare 1st - 2nd
        // maxHeap -> to get max k elements, keeps min element at the top, compare 2nd - 1st
        // default priority queue is min heap
        PriorityQueue<String> minHeap = new PriorityQueue<>();

        // Bounded priority queue with comparator, min heap
        PriorityQueue<String> minHeapCompare = new PriorityQueue<>(2, (e1, e2)-> Integer.compare(e1.length(), e2.length()));
        // Objects with Comparable interface can only be used, or else have to implement comparator object as 2nd param
        //PriorityQueue(int initialCapacity, Comparator<? super E> comparator)

        minHeapCompare.add("12345"); // add element priority Queue
        minHeapCompare.offer("123"); // add element, similar to adding Queue
        minHeapCompare.add("1234"); // add element priority Queue
        minHeapCompare.peek(); // check head in heap i.e min element
        minHeapCompare.poll(); // remove min element from heap

        while (!minHeapCompare.isEmpty()){
            System.out.println(minHeapCompare.poll()); // remove min element from heap
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
