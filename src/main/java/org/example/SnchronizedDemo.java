package org.example;

/// Synchronized - key word orqali hal qilish mumkin Race Condition ni
public class SnchronizedDemo {
    private static int count = 0;
    private static final Object object = new Object(); // Qulflash uchun

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

        // Muammo hal qilindi
        System.out.println(count);


    }

    // bir vaqtning ozida faqat 1 ta thread shu methodga murojat qiloladi
    public static synchronized void increment() {
        count++;
    }
}
