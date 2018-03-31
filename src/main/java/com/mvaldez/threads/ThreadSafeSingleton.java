package com.mvaldez.threads;

import java.io.Serializable;

/**
 * @author mvaldez
 */
public class ThreadSafeSingleton implements Serializable {

    public static final long serialVersionUID = -299482035708790407L;

    // volatile keyword ensures the variable is not cached
    private volatile static ThreadSafeSingleton _instance = null;

    private ThreadSafeSingleton() {}

    /**
     * minimizes the cost of synchronization and improve performance by
     * only locking on the section of code that creates the instance
     *
     * @return {@link ThreadSafeSingleton}
     */
    public static ThreadSafeSingleton getInstance() {
        if (_instance == null) {
            // double checked
            synchronized (ThreadSafeSingleton.class) {
                if (_instance == null) {
                    _instance = new ThreadSafeSingleton();
                }
            }
        }
        return _instance;
    }

    protected Object readResolve() {
        return _instance;
    }
}
