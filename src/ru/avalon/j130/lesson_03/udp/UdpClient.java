package ru.avalon.j130.lesson_03.udp;

public class UdpClient {

    public static void main(String[] args) {
        Client client = new Client();
        System.out.println("Client started");
        client.start();
        System.out.println("Client finished");
    }
}
