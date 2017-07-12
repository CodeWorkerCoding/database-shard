package com.nchu.tech.database.runnable;

/**
 * Created by fujianjian on 2017/7/6.
 */
public class CustomerRunnable implements Runnable {
    private int id = 0;
    private Common common;

    public CustomerRunnable(int no, Common object) {
        common = object;
        id = no;
    }

    public void run() {
        System.out.println("Running Thread" + Thread.currentThread().getName());
        try {
            if (id == 0) {
                common.synchronizedMethod1();
            } else {
                common.method1();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
