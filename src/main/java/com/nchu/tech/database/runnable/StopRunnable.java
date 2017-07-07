package com.nchu.tech.database.runnable;

/**
 * Created by fujianjian on 2017/7/6.
 */
public class StopRunnable implements Runnable {
    public volatile boolean flag = true;
    @Override
    public void run() {
        System.out.println("thread is runinng");
        while (flag) {

        }
        System.out.println("thread is done");

    }

    public static void main(String[] args) throws Exception{
        while (true) {
            StopRunnable runnable = new StopRunnable();
            Thread thread = new Thread(runnable);
            thread.start();

            Thread.sleep(10000);
            runnable.flag = false;
        }

    }
}
