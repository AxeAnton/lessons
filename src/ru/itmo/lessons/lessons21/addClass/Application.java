package ru.itmo.lessons.lessons21.addClass;

public class Application {

    public static void main(String[] args) {
        User user = new User(User.Level.LOW, "qwe");// 14. ������ ���� (������� �����), �������� ��� ����� � �����, �� ������ ���� ������������ ����� ������� �����.

        // 15. ��������� ����������� ������
        User.Account account = user.new Account(20); //16. ����������� ��� ����� ����������� User.Account, ����� ����� ���������� �������� ������ �� 6� ������ user.new � ������� ����������� ������� ��� 17.
        System.out.println(account.getUser());

        User.Account account2 = new User(User.Level.HIGH, "asd")// 17. ������� ��������� �������� ������, � � ���� �������� ��������� ���������� ������.
                .new Account(200);

        System.out.println(account2.getUser()); // 18. ���������� �� ������ ������ �� �������� �����, �� �� ����� ��� �������, � accaunta2 ��� ������� � ������� �������� ������ ����(����� �� � ������� � � ������?), �� � ���� ���� ������ ����� ������ ����������� ������ account2.getUser().

        // 26. �������� ���������� ���������� ������
        Student.Exam math = new Student.Exam("math");

        Student student1 = new Student("Tom");
        student1.addExam(math); //27. ��� �� ������� � �������� ����� � ������ ��������� ������ ����� � �������� 28.

        // 31. ��������� ������
        SomeInterface object = new SomeInterface() { // 32. � ����� ������� � ������ ��������, ������ ��� ��� �������� ��������� ����������� ��� ����� ������ ������� 26,28,30.
            @Override
            public void void1() {System.out.println("void1");} // 33. ��������� ����� ������� �������������� ���������Some Interface. � ���������� ��� ����� ������ �� ��������� �� ���� � ������ ���� ������ ����� ���������� ������.
            @Override
            public void void2() {System.out.println("void2");}
            @Override
            public void void3() {System.out.println("void3");}
        };
        System.out.println(object);
        object.void2();
        object.void1();



    }
}
