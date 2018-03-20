package com.spring.regular.javase.threadLocal;

/**
 * @author wanli zhou
 * @created 2018-03-13 8:32 PM.
 */
public class ThreadLocalTest {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setThreadLocal(String str){
        threadLocal.set(str);
    }
    public static String getThreadLocalStr(){
        return threadLocal.get();
    }

}
