package ru.itmo.lessons.lessons21.patterns.singleton;

//  ������� (����������) �������������
public class Singleton { // 34. Singleton �� ��� ��������� ����, �������� ��� -
    // ��� ����������� ������ � ��������

    private static Singleton instance; /* new Singleton()*/ // 36. ������� ����������� �������� instance, ���������� ������ �� ��������� ������� ������

    // 35. ��������� ����������� �������� ������� ��� ������ ����� �� private, ������ ������� ��� ������ �����������
    private Singleton() {}

    public static Singleton getInstance(){ // 37. ������� ����������� �����, ��� �� �� ��������� ������� ������, ����� ������� �����������
        if (instance == null) { // �������� ��� �� ������ ������
            // �������� ������� (���� �� �� ��� ������ �����)
            instance = new Singleton();
        }
        return instance;
    }
}
