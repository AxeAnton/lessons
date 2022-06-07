package ru.itmo.lessons.lessons21.patterns.observer;

import java.util.ArrayList;

public class StateClass { // 3. �� ������ ����� ������� ����������.
    // 4. ������ ���� ��������� ����������/������������
    private ArrayList<EventListener> eventListeners = new ArrayList<>();
    public void addListener(EventListener eventListener) { // 4. ����� ���������� � ���������, �� ���� ���� ��������� ����� ����������� �� �����������/��������
        eventListeners.add(eventListener);
    }
    public void removeListener(EventListener eventListener) { // 5. ��� �������� �� ��������
        eventListeners.remove(eventListener);
    }
    private void lowNotify(int code) {
        eventListeners.forEach(someInterface -> someInterface.greenEvent(code));
    }
    private void mediumNotify(int code) {
        eventListeners.forEach(someInterface -> someInterface.yellowEvent(code));
    }
    private void highNotify(int code) { // 7. �� ����� ������ �� ��������� ����������� entListeners � ������� � ���� ���� ��� ��������� ������� redEvent, ���������� � ���� ������� ����ye llowEvent greenEvent
        eventListeners.forEach(someInterface -> someInterface.redEvent(code));
    }
    public void changeState(String newValue) { //6. �������� � �������� ������� ���� changeState, ��� �� ����������,
        if ("ok".equals(newValue)) lowNotify(1);
        if ("warn".equals(newValue)) mediumNotify(5);
        if ("error".equals(newValue)) highNotify(10);
    }
}
