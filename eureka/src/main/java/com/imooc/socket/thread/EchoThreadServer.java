package com.imooc.socket.thread;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoThreadServer {
    public static void main(String[] args) throws Exception{
        ServerSocket server = null;
        Socket client = null;
        server = new ServerSocket(8888);
        boolean f = true;
        while (f) {
            System.out.println("服务器正在运行，等待客户端连接！");
            client = server.accept();
            new Thread(
                    new EchoThread(client)
            ).start();
        }
    }
}
