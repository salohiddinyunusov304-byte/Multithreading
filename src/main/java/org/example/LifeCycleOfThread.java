package org.example;

public class LifeCycleOfThread {
    public static void main(String[] args) throws InterruptedException {
        /// NEW - Thread yaratilgan lekin hali ishga tushmagan
//        Thread thread = new Thread();
//        System.out.println(thread.getState());

        /// Runnable - Thread ishga tushgan start() bajarilgan lekin hali CPU unga vazifa ajratmagan
//        Thread thread = new Thread();
//        thread.start();
//        System.out.println(thread.getState());

        /// Blocked/Waiting - Thread sleep holtida boladi
//        Thread thread = new Thread();
//        thread.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        /// Terminated/Dead - tugagan thredni qayta ishga tushurib bolmaydi, sababi state "terminated" ga otib boladi
        Thread thread = new Thread();
        thread.start();
        thread.join();
        System.out.println(thread.getState());
    }
}
