package com.java8.threads;

import java.util.concurrent.*;

/**
 * @author ghl
 * @date 2021/1/11 15:01
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return getString();
    }

    private String getString() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello world";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        MyCallable callable = new MyCallable();
        ExecutorService service = Executors.newCachedThreadPool();

        Future<String> submit = service.submit(callable);
        System.out.println(submit.get());
        long time = System.currentTimeMillis() - start;
        System.out.println("time: " + time + " ms");

        Callable callable1;
        FutureTask task = new FutureTask<>(callable);
        long start2 = System.currentTimeMillis();
        service.submit(task);
        System.out.println(task.get());
        long end2 = System.currentTimeMillis() - start2;
        System.out.println("time2: " + end2 + " 毫秒");

        if (!service.isShutdown()) {
            service.shutdownNow();
        }
    }
}
