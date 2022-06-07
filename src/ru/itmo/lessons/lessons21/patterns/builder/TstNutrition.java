package ru.itmo.lessons.lessons21.patterns.builder;

public class TstNutrition { // 1. ������ Builder ������������ ��� �������� ������� � ������� ����������� �������������(�������), ������ ���� ������������ � ����� ������ ��� ���������� �������� serving, � �� ������������. �������� ������, ��� ������ ��������� ������� ������� �� ������������ ������� � � �������� �������� �������� ������ ���������, ����� ������� �������� ���������� ������ �� ������� ����� (12.1), ��� � ��������� ������� ������� �������.
    public static void main(String[] args) {
        //  // Builder: servings: 3, calories: 200, fat: 4
        NutritionFacts appleFacts =
                new NutritionFacts.Builder(3) // 2. ���������� ������ - ������������ ��������
                        .calories(200)// 3. ������������ ������� ��� ������� (�� ����� �������)
                        .fat(4)
                        .build(); // 4. �������� ��������
        System.out.println(appleFacts);
    }
}
