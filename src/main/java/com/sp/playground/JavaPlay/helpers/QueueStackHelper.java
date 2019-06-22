package com.sp.playground.JavaPlay.helpers;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueStackHelper {
    public void ArrayDequeHelper(){
        // Resizable array with add/delete from both sides of queue
        // ArrayDeque class is likely to be faster than Stack when used as a stack.
        // ArrayDeque class is likely to be faster than LinkedList when used as a queue.

        // Intializing an deque
        Deque<Integer> deque = new ArrayDeque<Integer>(10);
        // add() method to insert
        deque.add(10);
        deque.add(20);
        for (Integer element : deque)
        {
            System.out.println("Element : " + element);
        }

        // addFirst() method to insert at start
        deque.addFirst(564);
        // addLast() method to insert at end
        deque.addLast(24);
        // element() method : to get Head element
        System.out.println("\nHead Element using element(): " +
                deque.element());
        // getFirst() method : to get Head element
        System.out.println("Head Element using getFirst(): " +
                deque.getFirst());
        // getLast() method : to get last element
        System.out.println("Last Element using getLast(): " +
                deque.getLast());
    }
}
