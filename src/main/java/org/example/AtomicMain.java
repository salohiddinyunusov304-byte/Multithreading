package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMain {
//    private int count = 0; // Atomic emas !!!
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
//        count++; /// Atomic emas !!!
        count.incrementAndGet(); /// Atomic
    }

    public int getCount() {
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicMain atomicMain = new AtomicMain();
        Runnable task = () -> {
            for (int i = 0; i < 10_000; i++) {
                atomicMain.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(atomicMain.getCount());
    }
}
