package ru.itmo.lessons.lesson6.books;

public class Author {

    // свойства, хорактеристики, поля, атребуты
    public String name;
    public String surname;
    // public это значит, что можно обратиться из любой точки программы
    // есть методы которые просто выполняют какие ни будь инструкции, они ни чего не возвращают эти методы называются public void
    public void printFullName() {
        System.out.println(name + " " + surname);
    }

    public String getFullName() {
        return  name + " " + surname;
    }
    // return возврощает результат работы метода, и прерывае работу метода.
    // return; можно использовать в методах (void) только, что бы прервать метод.
}
