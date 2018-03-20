package com.spring.regular.javase.threadLocal;

/**
 * @author wanli zhou
 * @created 2018-03-13 8:35 PM.
 */
public class MainTest {

    public static void main(String[] args) {
        new Thread(() -> {
            ThreadLocalTest.setThreadLocal("thread-1" + Thread.currentThread().getId());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ThreadLocalTest.getThreadLocalStr());
        }).start();
    }
}
