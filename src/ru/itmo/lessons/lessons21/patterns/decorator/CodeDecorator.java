package ru.itmo.lessons.lessons21.patterns.decorator;

import java.util.UUID;

public class CodeDecorator extends BaseDecorator{// 6. ��������� BaseDecorator
    public CodeDecorator(LogStrategy logger) {
        super(logger);
    }

    @Override
    public void log(String data) { // 7. �������������� �������� �� ���� ������
        String newData = data + " " + UUID.randomUUID();
        super.log(newData); // log info 0.31058440874503557 //8. ��������� � �������� � �������� ������
    }
}