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
        /** Stack **/
        deque.push(1); // add at top/head of stack
        deque.pop(); // remove from top/head of stack
        deque.peek(); // check element at the top of stack

        /** Queue **/
        deque.offer(1); // add at the end/tail of the queue
        deque.poll(); // remove from front/head of the queue
        deque.peek(); // check element at the front/head of the queue

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

        //peek methods
        // element() method : to get Head element, d
        System.out.println("\nHead Element using element(): " +
                deque.peek());
        // getFirst() method : to get Head element
        System.out.println("Head Element using getFirst(): " +
                deque.peekFirst());
        // getLast() method : to get last element
        System.out.println("Last Element using getLast(): " +
                deque.peekLast());

        //remove first and last element
        deque.pollFirst();
        deque.pollLast();
    }
}
