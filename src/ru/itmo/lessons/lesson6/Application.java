package ru.itmo.lessons.lesson6;

import ru.itmo.lessons.lesson6.books.Author;
import ru.itmo.lessons.lesson6.books.Book;
import ru.itmo.lessons.lesson6.books.Shelf;

public class Application {

    public static void main(String[] args) {

        Author author1 = new Author();
// доступ к свойствам объекта происходит через "."
        author1.name = "Tom";
        author1.surname = "Crowed";

        Author author2 = new Author();
        author2.name = "Mike";
        author2.surname = "Thompson";


// вызов метода, осуществляется через
        author1.printFullName();
        author2.printFullName();

      String fullName = author1.getFullName(); //
        System.out.println(fullName);


        Book book1 = new Book();
        book1.setTitle("Книга");
        System.out.println(book1.getTitle());
        book1.setPageCount(22);
// когда метод будет вызван
        //book1.title = "";
        //book1.title = -34;

        Shelf shelf = new Shelf();
        shelf.addBook(book1);
        shelf.addBook(book1, book1, book1);
        // вывод имени автора первой книги на полке
        System.out.println(shelf.books[0].getAuthor().name);



    }
}