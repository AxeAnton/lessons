package ru.itmo.lessons.lessons36.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // 43. ������������ ����� ������ �������� ������
@Retention(RetentionPolicy.RUNTIME) // 46. ����� ��������� ����� �������� ������ �. 47
// 41. �������� ����� ����� �������� ������������� ������� public, �������� ��������� ���� ��� �������� ����������, ������ �� ������ (�������) @interface, ��� �������� Required (������� ��� � �������), ����� �������� ��������  {}
//42. ��� ��� ����� �������� ��� ���������� ���������, ���������� ������ ������������ ��������� @Target, �������� � ����� ��������� ��� ���� ��� �� �������, ��� ����� ������������ (��������: ElementType.FIELD, � �������� ������ �. 44).
public @interface Required { // 43 ��������� ����� ���� ������ ��� ����� ��� ��� ����� ��������/���������
}
