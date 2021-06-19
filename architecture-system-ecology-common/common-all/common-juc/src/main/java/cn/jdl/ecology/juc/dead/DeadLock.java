package cn.jdl.ecology.juc.dead;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/15 18:54
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class DeadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";


    public static void main(String[] args) {
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }
}

class Lock1 implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Lock1 running");
            while (true) {
                synchronized (DeadLock.obj1) {
                    System.out.println("Lock1 lock obj1");
                    Thread.sleep(3000);
                    synchronized (DeadLock.obj2) {
                        System.out.println("Lock1 lock obj2");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Lock2 implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Lock2 running");
            while (true) {
                synchronized (DeadLock.obj2) {
                    System.out.println("Lock2 lock obj2");
                    Thread.sleep(3000);
                    synchronized (DeadLock.obj1) {
                        System.out.println("Lock2 lock obj1");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *功能：一次申请全部资源
     * @param null 1
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/6/15 19:11
     */
    static class Allocator {
        private List<Object> als = new ArrayList<Object>();

        // 一次性申请所有资源
        synchronized boolean apply(Object from, Object to) {
            if (als.contains(from) || als.contains(to)) {
                return false;
            } else {
                als.add(from);
                als.add(to);
            }
            return true;
        }

        synchronized void clean(Object from, Object to) {
            als.remove(from);
            als.remove(to);
        }
    }
}