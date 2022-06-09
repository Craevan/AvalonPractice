package ru.avalon.j130.lesson_03.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.logging.Logger;

public class Client {

    private static final int PORT = 15250;
    private static final int DATA_LEN = 64;

    public void start() {
        try (DatagramSocket socket = new DatagramSocket()) {
            DatagramPacket packet = new DatagramPacket(new byte[DATA_LEN], DATA_LEN, InetAddress.getByName("192.168.16.157"), PORT);
            System.out.println("Введите сообщение:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String msg = reader.readLine();
                byte[] temp = msg.getBytes();
                for (int i = 0; i < temp.length; i += DATA_LEN - 1) {
                    int length = DATA_LEN - 1;
                    int len = (i + length) < temp.length ? length : temp.length - i;
                    packet.setData(temp, i, len);
                    socket.send(packet);
                }
            }

        } catch (SocketException se) {
            Logger.getLogger("log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
