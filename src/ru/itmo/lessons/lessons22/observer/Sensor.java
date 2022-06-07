package ru.itmo.lessons.lessons22.observer;

import java.util.HashSet;
import java.util.Set;

public class Sensor { // 3. ���������
    private Set<Listener> listeners = new HashSet<>(); //4. ������ ����������.
    private int temp;

    public void addListener(Listener listener) { // 5. �������� ���������.
        listeners.add(listener);
    }

    public void removeListener(Listener listener) { // 6. ������� ���������.
        listeners.remove(listener);
    }

    private void notifyListeners(int temp){
        listeners.forEach(listener -> listener.tempChanged(temp));
        // 8. ����������� ����������, ������� ����������� listeners � �������� �� ����� ������� - tempChanged(temp).
    }   // 9. �����, ��� ������ ���������� ����������� ������������� �� ��� ����������, � �� ��������

    public void changeState(){ // 7. ����� � ��������� �����������, ������ ��������.
        if (Math.random() < 0.5) temp -= 40;
        else temp += 40;
        System.out.println(temp);
        notifyListeners(temp);
    }
}
