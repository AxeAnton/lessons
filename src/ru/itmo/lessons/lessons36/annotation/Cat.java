package ru.itmo.lessons.lessons36.annotation;

@ClassConfig(prefix = "cat")
public class Cat {
    @Required // 55. ���� � ������ ���� �������� � ���������� @Required - ��� ������ ����� ���������� ���������� �������� ����� ����, ������ ��� ����� � �������� ���������� ����� �� configFile() �. 56
    private String name;

    @Required // 45. ������ ������������� ����� ������
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
