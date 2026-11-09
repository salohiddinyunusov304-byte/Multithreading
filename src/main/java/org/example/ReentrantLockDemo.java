package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/// ReentrantLock - metod boshahsini kutib turadi, chunki qulflangan boladi
public class ReentrantLockDemo {
    private static int count = 0;
    private static final Lock lock = new ReentrantLock(); // Aniq lock obyekti

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = (() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }

    public static void increment() {
        lock.lock(); // Qulfni ochamiz
        try {
            count++; // oshiramiz
        } finally {
            lock.unlock(); // Qulfni ochamiz, finally shart
        }
    }
}
