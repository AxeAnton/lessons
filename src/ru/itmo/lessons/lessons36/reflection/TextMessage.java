package ru.itmo.lessons.lessons36.reflection;

public class TextMessage extends Message{ // 2. ����� ����������� �� ������ Message ��� �������� � ������ � ��� ����� ���� ��������

    private String text;
    public final String code = "��������� ���������"; // 3. ����� ����� �������� final code �� ��������� "��������� ���������"

    // 5. ��� �� � TextMessage ���� �����������, ������� ��������� �� ���� ����������� � � Message �. 6 ���� �����������, ������� ��������� �� ���� �����������.
    public TextMessage(String sender) {
        super(sender);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // 4. ��� �� �������� code ����� ��������� ����� printInfo, ������� ������� ����� �� ����.
    private void printInfo(){
        System.out.println("��������� ���� TextMessage. �������� � ��������: sender(" + getSender() + "), " +
                "text(" + text + "), " +
                "code(" + code + ") ");
    }


    @Override
    public String toString() {
        return "TextMessage{" +
                "text='" + text + '\'' +
                "} " + super.toString();
    }
}
