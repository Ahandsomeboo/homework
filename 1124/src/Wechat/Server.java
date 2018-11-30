package Wechat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("服务器已启动，等待连接");
        ExecutorService service = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接....");

            service.submit(() -> {
                try {
                    handle(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void handle(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        while (true) {
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            if (len == -1) {
                break;
            }
            String echo = new String(buf, 0, len, "utf-8");
            System.out.println(echo);
            out.write(("服务器回答：" + echo).getBytes("utf-8"));
        }
    }

}

