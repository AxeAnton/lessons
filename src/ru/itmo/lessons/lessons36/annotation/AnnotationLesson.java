package ru.itmo.lessons.lessons36.annotation;
// 53. ������ ���� ��� �� ����� ������� ���������, ��� �� ����� � ��� ����� ���-�� �������� (���������.....)

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;


public class  AnnotationLesson {
    public static void main(String[] args) {
        Class<Cat> catClass = Cat.class;

        // 57. � ������� ������, � ������� ������ �������� ������������ ��� �������� ������ � ��������� ������� ����� �������� ������ ���������, ��� ����� �� ���������� � ������ �� �����, � ������ �� �������� ������ ��� ��������� ������ � �������� ����� - getAnnotations ������� ������ ������ �� ����� �����������.
        Annotation[] annotations = catClass.getAnnotations();
        System.out.println("������ �� ��������� ������: " + Arrays.toString(annotations));

        // 58. ��������� �� ������� ���������� ���������
        //59. ����������, ���������� � ������ - catClass, �������� ����� - isAnnotationPresent (�������� true ���� ��������� ���� � false ���� ���), � �������� ������ �������� (������� ��������� - ClassConfig.class)
        if (catClass.isAnnotationPresent(ClassConfig.class)){
            System.out.println("ClassConfig");
            //60. ���� ��������� ������������, �� ����� �������� ������ �� ��� (��� �� ����� �������� ��������� ���������)
            ClassConfig classConfig = catClass.getDeclaredAnnotation(ClassConfig.class);
            // 61 ��������� ����������. ����������: ���������� � ��������� �� ������ - classConfig � �������� ������� ��������: prefix, version � file. ������� ������ �� configFile() � ��� � ������� ����.
            System.out.println("prefix: " + classConfig.prefix());
            System.out.println("version: " + classConfig.version());
            System.out.println("file: " + classConfig.configFile());
        }

        // 62. ���� � ��� ��������� ��� ������, ���� ���� ��� ��� ��, �� �� ����� �������� ������, �������� ��� ����� ��� ��� �������.
        // 63. ������� ��� ������ � ���� � ���� ������ � ������� ������ getDeclaredFields() � �������� ����������
        Field[] fields = catClass.getDeclaredFields();

        for (Field field: fields){
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            System.out.println("������ �� ��������� ����: " + Arrays.toString(fieldAnnotations));

            //64. �������� ������� ������������ ���������
            if (field.isAnnotationPresent(Required.class)){
            } else {
                System.out.println(field.getName() + " - ���� ��� ��������� Required");
            }
        }
// test
        // TODO: �������: ����������� �����, ����������� �� ���� ������ �� ����� � ������������ ��������� �������
        //  ������ ��� null
        //  ���� ����� ����������� ���������� ConfigClass, ������� ������ ������� ������ (������������ ���������),
        //  ���� ��������� ���, ������� null.
        //  ���� ���� �������� ���������� @Required,
        //  ���������� ���������� �������� ������� ���� (����� ��� �� config.properties �����),
        //  �������� ���� ������������� ����� ������ (name - setName / age - setAge).
        //  � ���������� ������� ������� ����� toString(), ��������� ���������.
        //  ������� ��������� ������.
    }
}
