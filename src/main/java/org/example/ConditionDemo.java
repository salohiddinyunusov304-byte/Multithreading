package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/// Condition - bu Lock obyekti bilan boglangan maxsus sinxronizatsiya vositasi bolib threadni malumot bit
/// shart bajarulgincha kutishga majbur qiladi
/// Lock.newCondition orqali
public class ConditionDemo {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static boolean ready = false;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer malumotlari tayyorlanmoqda...");
                Thread.sleep(3000);
                ready = true;
                condition.signal(); // Consumerga signal yuborish
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        Thread consumer = new Thread(() -> {
            lock.lock();
            try {
                while (!ready) {
                    System.out.println("Consumer: kutilyapti...");
                    condition.await();
                }
                System.out.println("Consumer: Malumot qabul qilindi");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });

        consumer.start();
        producer.start();
    }
}
