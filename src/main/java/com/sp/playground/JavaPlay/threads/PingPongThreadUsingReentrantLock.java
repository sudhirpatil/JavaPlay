package com.sp.playground.JavaPlay.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongThreadUsingReentrantLock {
    /*
    Difference Synchronized & Reentrant locks
    Synchronized locks does not offer any mechanism of waiting queue in which after the execution of one thread any thread running in parallel can acquire the lock. Due to which the thread which is there in the system and running for a longer period of time never gets chance to access the shared resource thus leading to starvation.
    Reentrant locks are very much flexible and has a fairness policy in which if a thread is waiting for a longer time and after the completion of the currently executing thread we can make sure that the longer waiting thread gets the chance of accessing the shared resource hereby decreasing the throughput of the system and making it more time consuming.
     */
    private static ReentrantLock lock = new ReentrantLock(true);
    private Condition conditionMet = lock.newCondition(); // To wait for new condition to be met by lock

    public static void main(String[] args) {
        PingPongThreadUsingReentrantLock pingPong = new PingPongThreadUsingReentrantLock();
        Thread t1 = new Thread(() -> pingPong.pingpong("Ping", 5));
        Thread t2 = new Thread(() -> pingPong.pingpong("Pong", 5));
        t1.start();
        t2.start();
    }

    public void pingpong(String s, int times) {
        int counter = 1;
        while(counter<=times) {
            run(s, counter);
            counter = counter+1;
        }
    }

    public void run(String s, int counter) {
        lock.lock();
        try {
            conditionMet.await(2, TimeUnit.SECONDS); // wait for 2 sec, why not just use sleep?
            System.out.println(s + " (" + counter + ")");
            conditionMet.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
