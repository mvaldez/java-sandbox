package com.mvaldez.threads;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 *
 */
public class TestExecutor {

    public static void main(String[] args) {
        System.out.println("Entering main");

        // anon class version
        final ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return  new Thread(r);
            }
        };

        int POOL_SIZE = 2;
        final Executor executor = Executors.newFixedThreadPool(POOL_SIZE, threadFactory);

        for (int i = 0; i < POOL_SIZE; i++) {
            executor.execute(new ThreadTest());
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("Leaving main");
    }
}
