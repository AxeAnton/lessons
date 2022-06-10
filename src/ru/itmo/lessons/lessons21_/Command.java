package ru.itmo.lessons.lessons21_;

import java.io.IOException;

@FunctionalInterface
public interface Command {
    void execute();

    // ��������� �����
    static Command getInstance(String commandText, EchoServer server){
        if (commandText.equalsIgnoreCase("count")) {
            return () -> {
                String messageText = "count = " + server.getCount();
                try {
                    server.getConnection()
                            .sendMessage(SimpleMessage.getMessage("server", messageText));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };
        } else if (commandText.equalsIgnoreCase("ping")){
            return () -> {
                try {
                    server.getConnection()
                            .sendMessage(SimpleMessage.getMessage("server", "ping"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };
        } else {
            return () -> {
                try {
                    server.getConnection()
                            .sendMessage(SimpleMessage.getMessage("server", "������� �� ����� ���� ����������"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };
        }
    }
}
