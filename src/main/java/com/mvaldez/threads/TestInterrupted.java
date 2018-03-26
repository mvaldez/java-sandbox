package com.mvaldez.threads;

/**
 */
public class TestInterrupted {

    public static void main(String[] args) {
        System.out.println("Entering main");
        Thread thr = new Thread(new ThreadTest());
        thr.start();

        try {
            Thread.sleep(10);
            thr.interrupt();
        } catch (InterruptedException e) {
        }
        System.out.println("Exiting main");
    }
}
