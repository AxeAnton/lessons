package ru.itmo.lessons.lessons21_;

import java.io.IOException;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Client {

    private int port;
    private String ip;
    private Scanner scanner;

    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
    }


    public void start() throws Exception {
        System.out.println("������� ���");
        String name = scanner.nextLine();
        String messageText;

        while (true){
            // exit
            // ping
            System.out.println("������� ���������");
            messageText = scanner.nextLine();
            sendAndPrintMessage(SimpleMessage.getMessage(name, messageText));
        }
    }

    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(getSocket())){ // getSocket ������ ��� ����, ����� ���������� ������ ������

            LocalDateTime time = null;
            if (message.getText().equalsIgnoreCase("ping")) {
                time = LocalDateTime.now();
            }
            connection.sendMessage(message);

            SimpleMessage formServer = connection.readMessage();
            if (formServer.getText().equalsIgnoreCase("ping")) {
                String str = "ping: " + Duration.between(time, LocalDateTime.now()).getNano();
            }


            System.out.println("����� �� �������: " + formServer);
        }
    }

    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }

    public static void main(String[] args) {
        int port = 8090;
        String ip = "127.0.0.1";

        try {
            new Client(port, ip).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
