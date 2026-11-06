package org.example;

public class Main {
    public static void main(String[] args) {
        /// Thread - dastur ichidagi eng kichik mustaqil birlik
        // run() - oddiy chaqirsak oddiy method kabi sihlaydi
        // start() - yangi thredni ishga tushiradi
        // sleep() - belgilangan millisekundga toxtatib turadi
        // interapt() - toxtatish uchun signal yuborai, agar state wait() da bolsa exception tashlaydi
        // join() - bir thread boshqa threadni kutadi
        // setPriority(int Priority) - ustuvorlik darajasini belgilaydi
        // getPriority() - thredni joriy ustuorligi
        // isAlive() - threadi faol yoki tugaganini tekshirish
        // getName() - threadni nomini qaytaradi
        // stop() - eskirgan, threadni istalgan joyda toxtatib yuboradi
        // setName() - nom berish Threadga

        // 1-way (xtending Thread)
//        MyThread thread = new MyThread();
//        thread.start();

        // 2-way (implemending Runnable)
//        MyRunnable runnable = new MyRunnable();
//        Thread thread1 = new Thread(runnable);
//        thread1.start();

        // 3-way (lambda)
//        Thread thread = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//        thread.start();

        /// interapt
//        Thread thread  = new Thread();
//        thread.start();
//        thread.interrupt();

        /// join
//        thread.start();
//        thread.join(); // Main threaad tugashini kutadi

        /// isAlive
//        thread.start();
//        System.out.println(thread.isAlive()); // true

        /// stop()
//        thread.stop();

        /// Name - Threadga nom berish
//        Thread thread1 = new Thread();
//        System.out.println(thread1.getName());
//        thread1.setName("Thread Demo");
//        System.out.println(thread1.getName());

        /// Handler
        MyThread2 thread = new MyThread2();
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName() + " :: " + e.getMessage());
        });
        thread.start();
    }
}