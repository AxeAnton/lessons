package ru.itmo.lessons.lessons21.addClass;

public class User { // 1. ������ ����� ���� � ��� ��� = �������� ������

    private Level level; //2. ���� Level ����� ������ ����� ������ �� ����� enum Level ����������� ������ ������. ���� Level �� ������ ������� ���� � ���� �� enum Level ������� �� ������.
    protected String login;

    @Override
    public String toString() {
        return "User{" +
                "level=" + level +
                ", login='" + login + '\'' +
                '}';
    }

/*
    public Level getLevel() {
        return level;
    }

    public String getLogin() {
        return login;
    }


*/


    public User(Level level, String login) {
        this.level = level;
        this.login = login;
    }

    // 5. ���������� ����� � ���������� ����� ��� ������ ��������� ����������� ������ ������� ������.
    // NB 6. ���������� ����� ��� ��� ����� ������� ����� STATIC.
    // NB 7. ���������� �����, ��� ��� ����� ������� ��� ����� STATIC.
    // 1. 8. ������� ��������� - �������� ������������� �������.
    // NB 2. 9. ������ ������� ������ ����������� ������ ���  ������� ������� �������� ������.
    public class Account{
        private  float balance;


        public Account(float balance) {
            // 1. ������� ��������� ����� ������� �������� ������������� �������
            // 2. ������ ������� ������ ����������� ������ ��� �������� �������� �������� ������.
            // 3. 10. ���������� ����� �� ����� ��������� ����������� ������� � �������, ������ ���� ����������� �������� � ������������� final ex. privet static finel int MAX_BALANCE = 500;
            this.balance = balance + User.this.level.getCount(); // 13. �� ����������� ������ �������� ������ � ��������� ������� � ��������� �������� ������. �� ����� �� �������� �������� ���������� ������  level �� ����������� ������.
        }
    public User getUser(){
            // 11. ������ ����������� ������, ����� �������� ������ � ���������� �������� ������, ������� ��������, ��� getor �������� ������ User, ��������� ������ ���������� ������!
        return User.this; // 12. ������ �� ��������� �������� ������
    }

}



    public enum Level { // 3. ��������� ����� (static �����). ������� ��������� ������������ � ������������ ������ ���� ������������ ��������� � ��������� ��������� ������, ���� ��� ��������� ��� � � ������ ������� �� ����� ������� ��������.

        HIGH(10), MEDIUN(5), LOW(0);
        // 4. ������ � ������������ ��� ������ - �������� ������������ �������: User.Level.�������

        private int count;

        Level(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }



    }


}


