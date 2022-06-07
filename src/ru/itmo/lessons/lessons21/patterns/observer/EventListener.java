package ru.itmo.lessons.lessons21.patterns.observer;

// 1. ���������, ������� ��������� ���������/�����������, ������� ���� � ��� ��� ����������.
public interface EventListener {
    void greenEvent(int code); // 2. ������, ������� �� �������
    void yellowEvent(int code);
    void redEvent(int code);
}
