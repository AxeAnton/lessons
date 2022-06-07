package ru.itmo.lessons.lessons21.addClass;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private  String name;
    private List<Exam> examList = new ArrayList<>(); // 24 �������� ������� ��� � ������ ���������

    public Student(String name) {
        this.name = name;
    }

    public void addExam(Exam exam){
        examList.add(exam); // 28. ����� ���������� ��� �� ������� � �������� ����� � ������ ���������.
    }

    public void printExamInfo(){
        examList.forEach(System.out::println); // 25. ��������� �� ������ � ������� ��� ��������
    }

    public static class Exam {
        // 19. ��������� ������ (static), ������ ���������� ������ ����� ������� ��� ������� �������� ������.
        // 21. ������� ����� �� ����� ���� �����������
        // 22. ������� ���������, �������� �������������
        // NB 23. ��� ������� � �� ����������� ��������� � ������� �������� �����
        private String title;

        public Exam(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Exam{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}
