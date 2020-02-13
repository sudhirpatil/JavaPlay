package com.sp.playground.JavaPlay.helpers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class StackQueue {
    public static void dequeStack(List<Integer> list){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
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

        //convert queue to list
        List<Integer> listStack = stack.stream().collect(Collectors.toList());
    }

    public static void dequeAsQueue(List<Integer> list){
        Deque<String> queue = new ArrayDeque<>();
        // offer, poll, peek
        queue.offer("first");
        queue.offer("second");

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }


    public static void main(String[] args){
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<100;i++){
            queue.offer(i);
            stack.push(i);
        }
        System.out.println(queue.peek());
        System.out.println(stack.peek());
    }
}
