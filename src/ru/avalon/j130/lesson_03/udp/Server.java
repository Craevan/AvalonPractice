package ru.avalon.j130.lesson_03.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

    private static final int PORT = 15250;
    private static final int DATA_LENGTH = 64;

    public void start() {
        try(DatagramSocket socket = new DatagramSocket(PORT)) {
            DatagramPacket packet = new DatagramPacket(new byte[DATA_LENGTH], DATA_LENGTH);
            while(true) {
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Получено сообщение: " + msg);
            }
        } catch (IOException ioe) {

        }
    }
}
