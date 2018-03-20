package com.spring.regular.bioNio.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author wanli zhou
 * @created 2018-03-19 8:47 PM.
 */
/**
 *
 * 有一个问题，毕竟是一个thread 处理所有的client请求， 如果某个client请求 处理时间过长，或者 client过多，还是会足额色其他请求。
 *
 *
 *  netty ：  boss线程池 负责accept
 *            worker线程池，负责IO   默认线程池8
 *            真正的业务代码需要单独开启多线程处理。
 *
 *            boss worker：  循环selector， 设置selector状态为， 处理任务队列， 处理自己的业务
 * */
public class NioServer {
    private Selector selector;
    public static void main(String[] args) throws IOException {
        NioServer nioServer = new NioServer();
        nioServer.initServer();
        nioServer.listenSelector();
    }

    private void initServer() throws IOException {
        this.selector = Selector.open();

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.socket().bind(new InetSocketAddress(8888));;

        serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器初始化成功.... 端口 " + 8888);
    }

    private void handler(SelectionKey selectionKey) throws IOException {
        if(selectionKey.isAcceptable()){
            System.out.println("新的客户端来了....");
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(this.selector, SelectionKey.OP_READ);

        }else if (selectionKey.isReadable()){

            SocketChannel channel = (SocketChannel) selectionKey.channel();
            channel.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int readData = channel.read(buffer);
            if(readData > 0){
                String receive = new String(buffer.array(), "utf-8").trim();
                System.out.println(receive);
                ByteBuffer writeBuffer = ByteBuffer.wrap(("[接收到数据] " + receive).getBytes("utf-8"));
                channel.write(writeBuffer);
            }
        }
    }

    private void listenSelector() throws IOException {
        while (true){
            this.selector.select();
            for(Iterator<?> key = this.selector.selectedKeys().iterator(); key.hasNext();){
                SelectionKey selectionKey = (SelectionKey) key.next();
                handler(selectionKey);
                key.remove();
            }

        }
    }
}
