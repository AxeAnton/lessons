package ru.itmo.lessons.lessons21.patterns.decorator;

public abstract class BaseDecorator implements LogStrategy { //4.������������ ���������
    private LogStrategy logger; //5. �������� ������ ���� - ���������

    public BaseDecorator(LogStrategy logger) {
        this.logger = logger; // 3. ���������� � ����������� ��������� �� ���������� (LogStrategy).
    }

    @Override
    public void log(String data) { //15. ��� ����� log ����� ������ � ��������  logger, ������� ����������� � �����������. � ��� ��� (��� ������) ����������� loger FileLogging (��. 11 �����) �������������� ����� log ����� ���������� � FileLogging.
        logger.log(data);
    }
}


// 1. ��� ���������� ����������� �� �������� ����������!
// 2. ������� ��������� � ����� � �������� ������������ ������ ���������������� ���� � ��� �