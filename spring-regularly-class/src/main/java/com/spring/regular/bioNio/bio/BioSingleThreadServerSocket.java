package com.spring.regular.bioNio.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wanli zhou
 * @created 2018-03-19 8:10 PM.
 */

public class BioSingleThreadServerSocket {

    /**
     *
     * 1. 2个阻塞点：  ss.accept()  和 读取客户端请求
     * 2. 一个线程只能 接收一个 client请求， 其他客户端来请求，只能挂起。
     *
     * 3. 问题：  客户端:Thread = 1：1
     *
     * BIO餐厅模型：  一个服务员 接待客户，同时站在客户旁边，一直听客户下单，吃完饭以后在为下一个客户服务。
     *              我们也可以让一个服务员专门负责接待， 接待以后，转给其他服务会员。但是其他服务员还是会被阻塞。
     * NIO餐厅模型：
     * */
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);

            while (true){
                Socket s = ss.accept();
                System.out.println("== 处理 socket=====");
                InputStream in = s.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                while (true){
                    System.out.println(reader.readLine());
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
