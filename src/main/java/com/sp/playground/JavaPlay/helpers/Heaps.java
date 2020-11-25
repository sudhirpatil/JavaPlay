package com.sp.playground.JavaPlay.helpers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Heaps {
    public static void heapHelper(){
        /*
        minHeap -> keeps min element at the top, compare 1st - 2nd i.e 1-2 >=0
                    used to find top-k elements, since min element can be removed easily
        maxHeap -> keeps max element at the top, compare 2nd - 1st
                    to find min - k elements
        default priority queue is min heap
         */
        PriorityQueue<String> minHeap = new PriorityQueue<>();
        // same methods as queue , as it's a type of queue
        minHeap.add("12345"); // add element priority Queue
        minHeap.offer("12"); // add
        minHeap.peek(); // check head in heap i.e min element
        minHeap.poll(); // remove min element from heap

        new PriorityQueue<String>(new ArrayList<>()); // Create PQ from collection

        // min heap priority queue with custom comparator
        PriorityQueue<String> minHeapCompare = new PriorityQueue<>( (e1, e2)-> Integer.compare(e1.length(), e2.length()));
        // Objects with Comparable interface can only be used, or else have to implement comparator object as 2nd param
        //PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        while (!minHeapCompare.isEmpty()){
            System.out.println(minHeapCompare.poll()); // remove min element from heap
        }

        // Max heap, change the sequence of comparator
        PriorityQueue<String> maxHeap = new PriorityQueue<>( (e1, e2)-> Integer.compare(e2.length(), e1.length()));

        /* Imp
        MinHeap : To keep top n elements , as min element maintained at head so easier to pop, compare and insert new element
        MaxHeap : to keep min n elements

        Iterable (interface) -> Collection (interface) -> Queue -> Deque -> PriorityQueue
                                                                         -> Deque -> ArrayDeque
                                                                                  -> LinkedList
         */
    }

    public static void main(String[] args) {
        heapHelper();
    }
}
