package ru.itmo.lessons.lesson6.books;

public class Shelf {
    private String color = "белый";//Цвет полки
    // Книги
    public Book[] books = new Book[10];

    // метод добовление одной книги на полку
    public  void addBook(Book bool){

// [null, null, null, null, null,......]
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = bool;
                return;
            }
        }
        System.out.println("Нет места");
    }
    // метод добовлния нескольких книг на полку
    public  void addBook(Book...books){

    }
}
