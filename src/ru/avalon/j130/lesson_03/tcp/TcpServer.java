package ru.avalon.j130.lesson_03.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    private static final int PORT = 15260;

    public void start() {
        System.out.println("SERVER STARTED");
        try (ServerSocket server = new ServerSocket(PORT)) {
            Socket socket = server.accept();
            InputStream is = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            StringBuilder sb = new StringBuilder();
            byte[] buff = new byte[256];
            int var;
            while((var = is.read(buff)) > 1) {
                sb.append(new String(buff, 0, var));
            }
            String response = "Принято сообщение: " + sb;
            System.out.println(response);
            out.write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("SERVER STOPPED");
    }
}
