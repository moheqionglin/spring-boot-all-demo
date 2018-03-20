package com.spring.regular.bioNio.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wanli zhou
 * @created 2018-03-19 8:17 PM.
 */
public class BioMultipleThreadServer {
    /**
     *
     * 1. 2个阻塞点：  ss.accept()  和 读取客户端请求
     * 2. 一个线程只能 接收一个 client请求， 其他客户端来请求，只能挂起。
     *
     *
     * */
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8889);

            while (true){
                Socket s = ss.accept();
                System.out.println("== 新客户端 =====");

                new Thread(() -> {
                    InputStream in = null;
                    try {
                        in = s.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        while (true){
                            System.out.println(reader.readLine());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
