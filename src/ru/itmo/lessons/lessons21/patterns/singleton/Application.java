package ru.itmo.lessons.lessons21.patterns.singleton;

public class Application {
    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getInstance(); // 38. � ������ ���������� ����� ������ �� ���� ������, � ��� ������ ����������, ��� �� ����� ��������� �� ���� ������, ������������ � ����������� ����������.

        Singleton singleton2 = Singleton.getInstance();
    }

}