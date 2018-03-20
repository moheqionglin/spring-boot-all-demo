package com.spring.regular.bioNio.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wanli zhou
 * @created 2018-03-19 8:29 PM.
 */
public class BioThreadPoolServer {

    public static void main(String[] args) {
        //jstack -l 75333 | grep pool-1 固定3个
//        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            ServerSocket ss = new ServerSocket(8888);

            while (true){
                Socket s = ss.accept();
                System.out.println("== 处理 socket=====");
                threadPool.submit(() -> {
                    InputStream in = s.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    while (true){
                        System.out.println(reader.readLine());
                    }
                });

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
