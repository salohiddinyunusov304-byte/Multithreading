package org.example;

/// Volotile - key wordi bn elon qilingandi uni qiymatini cash xotiraga emas srazu main memory ga saqlaydi
/// visibility ni taminlash uchun
/// Atomicity ni taminlmaydi , faqat 1 ta thread yozishi kk, qolganlari oqishi kk
public class VolatileDemo {
    // volatile yo'q - Thread 2 bu o'zgarishni abadiy ko'rmasligi mumkin!
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        // Thread 1: flag true bo'lishini kutadi
        new Thread(() -> {
            while (!flag) {
                // Protsessor keshida flag = false qolib ketadi va tsikl cheksiz aylanadi
            }
            System.out.println("Thread 1 to'xtadi!");
        }).start();

        Thread.sleep(1000);

        // Thread 2: flag ni true qiladi
        new Thread(() -> {
            System.out.println("Flag true ga o'zgartirilmoqda...");
            flag = true;
        }).start();
    }
}
