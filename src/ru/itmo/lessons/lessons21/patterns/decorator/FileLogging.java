package ru.itmo.lessons.lessons21.patterns.decorator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
// 17. �������� ����������, �.� ����� �������������� ����������, � ���������� ���� �� �����, ������ � �������� - �������� ����������.
public class FileLogging implements LogStrategy {
    @Override
    public void log(String data) { //16. � ��� ����� FileLogging ���������� � ����.
        try {
            Files.writeString(Path.of("log.txt"), data + "\r\n", StandardOpenOption.APPEND);
        } catch (IOException ignored) { }
    }
}