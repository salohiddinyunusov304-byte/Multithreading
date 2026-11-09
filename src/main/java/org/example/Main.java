package org.example;

import java.util.Date;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /// Callable - Runnable bilan bir xil vazifa bajarib lekin malumot qaytaradi.
        /// Future - callabledan qaytgan qiymatni ushlash uchun

        /// Avzaliklari:
        // Exceptionlarni ushlash mumkin

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Integer>  task = () -> {
            System.out.println("Fonda og'ir hisob kitob ...");
            Thread.sleep(3000);
            int n = 10 * 5;
            return n;
        };

        Future<Integer> submit = executorService.submit(task);

        try {
            System.out.println(submit.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}