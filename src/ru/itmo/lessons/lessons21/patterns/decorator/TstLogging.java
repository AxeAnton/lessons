package ru.itmo.lessons.lessons21.patterns.decorator;

public class TstLogging {
    public static void main(String[] args) {
        ClassInProgram inProgram = new ClassInProgram(new ConsoleLogging());
        inProgram.action();

        inProgram.setStrategy(new DateDecorator(new FileLogging()));
        inProgram.action();

        inProgram.setStrategy(new DateDecorator(new CodeDecorator(new ConsoleLogging())));
        inProgram.action();

        //11. ��� ��������� �� ��� 8� ������ ��������, ������ ����� ������ FileLogging - ConsoleLogging.
        LogStrategy consol = new FileLogging(); //13. �������� ���������� ������� � �������
        LogStrategy code = new CodeDecorator(consol); //12.  CodeDecorator ����������(���������� �����) ����� ����������, ����� �������� � �������� ���������� - consol.
        LogStrategy log = new DateDecorator(code);// 11.  ������������ DateDecorator (���������� ����), ����� ���������� CodeDecorator, ����� ��������.
        log.log("������"); // 10. ������� ������ ������� ���������� ��������� � ����


    }
}

