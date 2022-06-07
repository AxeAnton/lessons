package ru.itmo.lessons.lessons21.patterns.observer;

import java.util.Scanner;


public class TstListener {
    public static void main(String[] args) {

        EventListener firstListener = new EventListener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("������� firstListener �� " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("������� firstListener �� " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("������� firstListener �� " + code);
            }

        };

        EventListener secondListener = new EventListener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("������� secondListener �� " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("������� secondListener �� " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("������� secondListener �� " + code);
            }
        };

        StateClass stateClass = new StateClass();
        stateClass.addListener(firstListener);
        stateClass.addListener(secondListener);

        Scanner scanner = new Scanner(System.in);
        String s;
        while (true){
            System.out.println("������� ������");
            s = scanner.nextLine();
            if ("exit".equals(s)) break;
            stateClass.changeState(s);
        }
    }
}
