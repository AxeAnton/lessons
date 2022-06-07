package ru.itmo.lessons.lessons20;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ArgsAndProps {
    public static void main(String[] args) {
        // ��� ����� main ���������� ��� ������� ��������� � ������ ����� ������ �����, ���� �� ��� ������� ��������� ��� ��������� ��������� �� �� �� ������ ��������.
        // ����� �������� ��� �����, ��������� � �,� �� ��� ��� ����� ������, ��������� � ���������� ������� args.

        //����� ��������� � �����������
        // ��� - Modify Run Configuration
        // -> Program Argument: ����������� ����� ������

        for (String arg : args){ // ����� � ������ � �����
            System.out.println(arg);

        }
//�������� ����� ��������, ������ ������ (����. ��������) ��� ��� �������� ��� ������.
        Properties properties = new Properties(); // ������
        properties.setProperty("key", "��������");// �������� ������
        System.out.println(properties.getProperty("key"));// ��������� �������� �� �����.
        //��� �� �����, ��������, ���������, �������� � �.�
        properties.clear();

        //��� �� � ������ properties ����� ��������� ������ �� properties ����� � �����!  ��������:
        //������� 1 - properties.load((InputStream);
        //��� �� �������� ����� ������� ����������:
/*        ������� 2 - try (InputStream inputt = ArgsAndProps.class
            .getClassLoader()
            .getResourceAsStream("lessonse20.properties")) {
            properties.load(inputt); // � load ����� ��� �� ��������� ������ �� properties �����!
            catch (IOException) {
                throw new RuntimeException(e)
            }*/

        // ������� 3 - properties.forEach((key, value) ->  System.out.println(key + " " + value);


    }
}

//���������� � ��������� ��� properties
