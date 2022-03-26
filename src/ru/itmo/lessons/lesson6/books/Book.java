package ru.itmo.lessons.lesson6.books;

import java.util.Objects;

public class Book {
    // свойства
    private String title; // названия
    private int pageCount;// количество страниц
    private Author author;// автор
    public Book(){}

    public Book(Author author) {
        Objects.requireNonNull(author, "author не мб null");
        this.author = author;
        }

    public Book(String title, Author author) {
        // вызвать другой конструктор
        this(author);
        setTitle(title);

    }





    // если модификатор privet стоит перед свойством или методом, значит к свойству элемента можно обратиться только в этом класе, только { облости видемости}
    // ели privet а обратиться все равно нужно создаются методы которые позволяют установить значения свойств внутри класса и в этих методах мы будем осуществлять всю не обходимую проверку.
    public void setTitle (String titleValue){
        if (titleValue == null || titleValue.length() < 3) {
            throw new IllegalArgumentException("Значение title от 3 символов");

        }
        title = titleValue;
    }
    // методы, которые возвращают значения свойств - гкттеры
    public String getTitle(){
        return title;
    }
    public void  setPageCount(int pageCount){
        if (pageCount < 10)
            throw new IllegalArgumentException("значчение pageCount бд больше 10");
        this.pageCount = pageCount;
    }


    public int getPageCount() {

        return pageCount;
    }

    public Author getAuthor() {
        return author;
    }
}
