package ru.itmo.lessons.lesson16;

import ru.itmo.lessons.lesson16.education.Course;
import ru.itmo.lessons.lesson16.education.University;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaAndCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15)); //FIXME не очень понятная строчка
        // void accept(T t);
        // перебор коллекции - метод foreach
        Consumer<Course> soutCourse = course -> System.out.println(course);
        //FIXME метод forEach (реализация - void accept(T t) принимает на вход T и ни чего не возвращает void)
        // переберает текущую коллекцию, проверяет на null у объекта вызывает метод
        // и передает в метод элемент коллекции.
        university.getCourses().forEach(soutCourse);
        university.getCourses().forEach(course -> System.out.println(course));
        //FIXME - course -> System.out.println(course) - реализация метода функционального интерфейса, если его расписать
        //:: - два двоеточия + имяМетода, это ссылка на метод (не вызов)
        // void accept(T t);
        university.getCourses().forEach(System.out::println);

        // TODO:: увеличить стоимость каждого курса на 10%
        university.getCourses()
                .forEach(course -> course.setPrice(course.getPrice() * 1.1));

        // TODO:: вывести  в консоль название каждого курса
        university.getCourses()
                .forEach(course -> System.out.println(course.getName()));

        // TODO:: удалить из коллекции курсы, если их стоимость меньше 15000
        //FIXME Метод removeIf - имеет внутри методы Predicat и test исходя из этогонам
        // надо написать реализацию метода test - (ourse.getPrice() < 15000).
        university.getCourses().removeIf(course -> course.getPrice() < 15000);
        //FIXME далее  - class University стр.22 и вся соль в 27.

        // TODO:: написать реализацию метода getFilteredCourses,
        //  который принимает на вход Predicate<Course>
        //  и возвращает список отфильтрованных данным предикатом курсов

        // TODO::написать предикаты, которые возвращают true, если:
        //  1) курс дешевле 20000
        Predicate<Course> lessPrice = course -> course.getPrice() < 20000;
        //  2) продолжительность курса 3 месяца или меньше
        Predicate<Course> lessDuration = course -> course.getDuration() <= 3;
        //  3) название курса JJD
        Predicate<Course> jjd =
                course -> course.getName().equalsIgnoreCase("jjd");

        // TODO:: Отфильтровать
        //  Далее показано, как можно используюя выше написанные предикаты, запихать в метод
        //  который назвается фильтрование курсов, можно использовать один или много предикатов в аргументе.
        //  1) дешевле 20000
        List<Course> filtered = university.getFilteredCourses(lessPrice);
        filtered.forEach(System.out::println);
        //  2) дешевле 20000 и меньше 3х месяцев
        filtered = university.getFilteredCourses(lessPrice.and(lessDuration));
        filtered.forEach(System.out::println);
        //  3) JJD или дешевле 20000
        filtered = university.getFilteredCourses(jjd.or(lessPrice));
        filtered.forEach(System.out::println);

        System.out.println("---- Comparator ----");
        //FIXME Метод - int compare(T o1, T o2) сравникает о1 и о2 и
        // возвращает если =0, или -1 или +1 объяснение на срт.79 и ниже;
            Comparator<Course> byName =
                (course1, course2) -> course1.getName().compareTo(course2.getName());
        // Здесть делаем компаратор с помощью лямбда...

            // "Python" "Node js" "JJD" "C++"
        university.getCourses().sort(byName); // void accept(T t);
        university.getCourses().forEach(System.out::println);

        Comparator<Course> byDuration
                = (course1, course2) -> {
            if (course1.getDuration() < course2.getDuration()) return -1;
            if (course1.getDuration() > course2.getDuration()) return 1;
            return 0;
        };

        university.getCourses().sort(byName.thenComparing(byDuration));


    }
}