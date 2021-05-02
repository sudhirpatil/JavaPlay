package com.sp.playground.JavaPlay.helpers;

import java.util.*;
import java.util.stream.Collectors;

public class StackQueue {
    public static void dequeStack(List<Integer> list){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.pop();
        // push , peek, pop
        // push to stack
        for(int item: list){
            stack.push(item);
        }
        // Element at top of stack, does not remove element
        System.out.println(stack.peek());
        // pop from stack, pop method throws NoSuchElementException when a stack is empty.
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        /*
        Since elements are added removed from head aka first index
        push == addFirst
        pop == removeFirst
        peek = peekFirst
         */

        // Iterate stack in reverse order i.e LIFO ( stack is FIFO)
        Iterator<Integer> revIter = stack.descendingIterator();
        while (revIter.hasNext()){
            System.out.println(revIter.next());
        }

        //convert queue to list
        List<Integer> listStack = stack.stream().collect(Collectors.toList());
    }

    public static void dequeAsQueue(List<Integer> list){
        Deque<String> queue = new ArrayDeque<>();
        // offer, poll, peek
        queue.offer("first");
        queue.poll();
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        /*
        add at last , get from first
        offer == addLast
        poll == removeFirst
        peek == peekFirst
         */
    }


    public static void main(String[] args){
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<100;i++){
            queue.offer(i);
//            stack.push(i);
        }
        System.out.println(queue.peek());
        queue1 = queue;
//        queue.clear();
        System.out.println(queue1.peek());
//        System.out.println(stack.peek());
    }
}
