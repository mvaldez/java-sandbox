package com.mvaldez.threads;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author mvaldez
 */
public class ThreadSafeSingletonTest implements Runnable {

    public static void main(String[] args) {
        System.out.println("Entering main");
        final ThreadFactory threadFactory = r -> new Thread(r);

        int POOL_SIZE = 2;

        final Executor executor = Executors.newFixedThreadPool(POOL_SIZE, threadFactory);

        for (int i = 0; i < POOL_SIZE; i++) {
            executor.execute(new ThreadSafeSingletonTest());
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Leaving main");
    }

    @Override
    public void run() {
        try {
            for (long i = 0; i < 10000000000L; i++) {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                i = i + 100;
                if (i % 1000000 == 0) {
                    System.out.println(ThreadSafeSingleton.getInstance().hashCode());
                    System.out.println("Thread ID: " + Thread.currentThread().getId());
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
