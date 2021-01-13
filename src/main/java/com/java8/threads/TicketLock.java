package com.java8.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ghl
 * @date 2021/1/12 17:13
 */
public class TicketLock implements Runnable {
    private int ticket = 20;
    Lock locks = new ReentrantLock();

    @Override
    public void run() {

        while (true) {

            if (ticket > 0) {
                locks.lock();
                try {
                    //报锁睡 当然只有一个线程执行
                    Thread.sleep(200);
                    String name = Thread.currentThread().getName();
                    System.out.println("线程 " + name + " 卖出车票 " + ticket--);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    locks.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        TicketLock ticketLock = new TicketLock();
        Thread t1 = new Thread(ticketLock);
        Thread t2 = new Thread(ticketLock);
        Thread t3 = new Thread(ticketLock);
        t1.start();
        t2.start();
        t3.start();
    }
}
