package com.mvaldez.threads;


/**
 *
 */
public class ThreadTest implements Runnable {


    @Override
    public void run() {
        System.out.println("Entering ThreadTest#run()");

        try {
            for (long i = 0; i < 1000000000; i++) {
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                i = i + 100;
                if (i % 1000000 == 0) {
                    System.out.println("ThreadTest#run() " + Thread.currentThread());
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted " + Thread.currentThread());
        }
        System.out.println("Exiting ThreadTest#run()");
    }

    public static void main(String[] args) {
        System.out.println("Entering main");
        ThreadTest t = new ThreadTest();
        Thread thr = new Thread(t);
        thr.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        System.out.println("Exiting main");
    }
}
