package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /// Atomicity - operatsiya buzilmasligi, 1 ta vazifa toliq bajarilishi kk, yarim yolda boshqa threadlar tomonidsn qoshilish bolmayd

        // get() - joriy qiymatni qaytaradi
        // set(..) - yangi qiymat ornatadi
        // incredmentAndGet() - qiymatni 1 ga oshiradi va qaytaradi
        // getAndIncrement() - Joriy qiymatni qaytaradi, keyin 1 ga oshiradi
        // addAndGet(..) - berilgan qiymatni oshiradi va qaytaradi
        // compareAndset(exp, upd) - agar joriy qiymat exp ga teng bolsa uni upg ga ozgartiradi

        /// Immutable class - 1 martta yaratilib ichidagi filed va metodlari ozgartirilmaydigan class (String, Integer, ...)
        // class final
        // fieldlar -> private final
        // setter -> bolmaydi
        // Construktor orqali boshlangich qiymat berilishi majburiy
        // agar filedlar muttable bolsa ularning nusxasi qaytariladi

        /// Afzalliklari
        // - thread-safe class kerak bolsa

        ImmutableClass immutableClass = new ImmutableClass("Salohiddin");
        System.out.println(immutableClass);
    }
}