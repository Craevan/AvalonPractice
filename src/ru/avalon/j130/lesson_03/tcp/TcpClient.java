package ru.avalon.j130.lesson_03.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

    private static final int PORT = 15260;
    private static final String HOST = "127.0.0.1";

    public void start() {
        System.out.println("CLIENT STARTED");
        try (Socket socket = new Socket(HOST, PORT)) {
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            String msg = "TEST";
            os.write(msg.getBytes());
            socket.shutdownOutput();
            StringBuilder sb = new StringBuilder();
            byte[] buff = new byte[256];
            int var;
            while((var = is.read(buff)) > -1) {
                sb.append(new String(buff, 0, var));
            }
            System.out.println(sb);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("CLIENT STOPPED");
    }
}
