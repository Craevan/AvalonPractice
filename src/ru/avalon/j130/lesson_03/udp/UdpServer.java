package ru.avalon.j130.lesson_03.udp;

public class UdpServer {

    public static void main(String[] args) {
        System.out.println("Server started");
        Server server = new Server();
        server.start();
        System.out.println("Server finished");
    }
}
