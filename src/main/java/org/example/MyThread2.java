package org.example;

class MyThread2 extends Thread{
    public void run() {
        throw new RuntimeException("Xatolik !!!");
    }
}
