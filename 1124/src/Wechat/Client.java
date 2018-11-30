package Wechat;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);

        OutputStream out = socket.getOutputStream();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Scanner scanner = new Scanner(System.in);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        out.write(line.getBytes());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024*8];
        while(true) {
            int len = in.read(bytes);
            if(len == -1) {
                break;
            }
            String result = new String(bytes, 0, len, "utf-8");
            System.out.println(result);
        }
    }
}

