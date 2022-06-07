package ru.itmo.lessons.lessons21.patterns.builder;

public class NutritionFacts {
    // 5. ������������ ���������
    private final int servings;
    // 6. �������������� ���������
    private final int calories;
    private final int fat;

    public static class Builder { //7. ����� ������ ������� ���������� NutritionFacts- ��������� ������
        // 8. ������������ ���������
        private final int servings;
        // 9. �������������� ���������, ����������������
        // 10. ���������� �� ���������
        private int calories = 1;
        private int fat;

        // 11. �������� ������������ ������������� ����� �����������
        public Builder(int servings) {
            this.servings = servings;
        }

        // 12. ��� ���������, ��� �� ����� ��������
        public Builder calories(int caloriesVal){
            calories = caloriesVal; // ��������� �������
            return this; // 12.1 ���������� ������ �� ������� ���������� ������
        }

        public Builder fat(int fatVal){ // 13. �� �� �����, ��� � 12
            fat = fatVal; // ��������� �������
            return this; // ���������� ������ �� ������� ���������� ������
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        } // 14. ������ ����� (������� ������ �������� ������), ��� ������� ������� ��� ����� �������� ������, �� �������� ������ �� bilder,
    }

    private NutritionFacts(Builder builder){ // 15. ����� ������ �� ������ ����������� (��� ������ ����������� �������� ������) �� 14 � ������������
        servings = builder.servings; // 16. �������� �������� ��� �������� ������ (NutritionFacts) ����� ����� �������� �� ����������� ������ ������.
        calories = builder.calories;
        fat = builder.fat;
    }


    @Override
    public String toString() { // 17. ��� ������
        return "NutritionFacts{" +
                "servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                '}';
    }
}
