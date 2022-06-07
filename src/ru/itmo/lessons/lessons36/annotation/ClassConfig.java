package ru.itmo.lessons.lessons36.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // ������������ ����� ������ ������
@Retention(RetentionPolicy.RUNTIME)
// 48. ��������� ����� ���� ��� ���������� � 48.1 � � ����������� (������� ������) �. 48.2
public @interface ClassConfig { // 54. ���� � ������ ���� ��������� �lassConfig, ������ ��������� ����� ������ ������ ���� ������ ����� ��������� (1. ������� ������ ������, 2� ���������� �������� ����� �� �������, 3� �.55
    // 49. ������������ ���������� ��������� - � �������� ���������� ����� ������������: ������, ���������, enum (������������), ������ �� ������.
    String prefix(); // 50. ����������� ������� �� ��� ������������� ���������
    // 51. ���� �������� ��������� �� ��������� - default "config.properties";, �� ��� ����� �� ��������� � ������� ������� (�.� � ����������(��������� ���������)) �.48.3 ��� 48.5
    String configFile() default "config.properties"; // 56. configFile() � ���� ����������� ������ ��, �� ������ �� �������� ��� �� ��� - test.name = some date /n, cat.name = Tome /n, cat.age = 1 /n, mouse.colore = white /n, mause.name = Jarry /n, ����������� ���� ���������� �� ������.�������� (��������: cat.name = Tome � cat.Age = 1), ��� � ���� ������ ������, ����,  �� �����.
    long version() default 1; // 52. ��� �� ����� ������ �������� ��������� �� ��������� �. 48.2 � 48.3

}
// 48.0-5
// 48.1 @Entity - ��� ����������
// 48.2 @Table(prefix = "���", configFile = "file.text", version = 2) - � ����������� �.�. �������� ������
// 48.3 @Table(prefix = "���", version = 2)
// 48.4 @Table(prefix = "���", configFile = "file.text")
// 48.5 @Table(prefix = "���")