package ru.itmo.lessons.lessons19;

import java.io.IOException;
import java.nio.file.*;

public class WatchersExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        // ��� ���� - � ������ nio ���� ����� Falils (S �� �����), ����� ����� ������� ��� ������ � �������.


        // WatchService, � ������ nio ����
        // (����� ������� �� ��������� �� ���������� � ���������� ����)
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // ������� ������ ���� Path - ������ ������� File � io
        // Paths.get(���� � ����� ��� ����������); //
        Path path = Paths.get(args[0]);

        // ������������ path � WatchService �� �������:
        // �������� / �������� / ���������
        path.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        // �������� ����
        while ((key = watchService.take()) != null) {
            // �������� ������ ������������ �������
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.kind() + " : " + event.context());
            }
            key.reset();
        }



    }
}
