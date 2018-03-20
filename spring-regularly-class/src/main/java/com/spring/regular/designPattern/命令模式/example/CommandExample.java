package com.spring.regular.designPattern.命令模式.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wanli zhou
 * @created 2018-03-13 10:20 AM.
 */
public class CommandExample {


    /**
     * 线程池就是一个命令模式，  threadPool 类似于 Client，
     * submit 方法类似于 Client的 setCommand方法
     * Callable 类似于 Command 命令具体干活的
     *
     * */
    public void threadPool() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.execute(() ->{
            System.out.println("---");
        });


        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(1000);
            return 1;
        });


        System.out.println(future.get());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommandExample commandExample = new CommandExample();
        commandExample.threadPool();
    }
}
