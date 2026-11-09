package org.example;

public class Main {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        /// Race Conditon - 2 ta thread 1 ta data ga murojat qilganda
        // Synchronization
        // Rentrant Lock

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
        count++;
    }
}