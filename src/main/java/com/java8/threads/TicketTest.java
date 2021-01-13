package com.java8.threads;

/**
 * @author ghl
 * @date 2021/1/11 16:53
 * 模拟多线程买票问题
 */
public class TicketTest implements Runnable {

    private int ticket = 20;

    @Override
    public void run() {
        while (true) {
            if (ticket <= 1) {
                break;
            }
            // 出票操作
            try {

                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取当前线程对象的名字
            String name = Thread.currentThread().getName();
           synchronized (this){
               System.out.println(name + " 正在卖票：" + ticket--);
           }
        }
    }

    public static void main(String[] args) {
        TicketTest ticketTest = new TicketTest();
        Thread t1 = new Thread(ticketTest);
        Thread t2 = new Thread(ticketTest);
        Thread t3 = new Thread(ticketTest);
        t1.start();
        t2.start();
        t3.start();
    }
}
