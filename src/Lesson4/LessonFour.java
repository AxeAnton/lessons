package Lesson4;


import java.util.Arrays;

public class LessonFour {
    public static void main(String[] args) {
/*        int age = 22;
        if (age >18) {
            int code = 123;
            System.out.println("Вам" + age);
            System.out.println("ДОступ разрешен Ваш код" + code);
        }
        System.out.println("ДОступ разрешен Ваш код" + code); */

        // Область видемости ограничевается скобками за областью скобок среда ее не видит.

        // примитиввные типы данны
        // ссылочные типы данных
/*
        int a = 78; // [100] a
        int b = a; // [78] a
        a = 100;
*/
/*        int [] ints1 *//*int ints2[]*//* = new int[7];
        // массив на семь элементов, имеет значение по умолчанию
        //System.out.println(ints1); // так не выводят! а выводят через класс Arrays
        System.out.println(Arrays.toString(ints1));*/

 /*       int[] ints2 = {6, -90, 56, 12, 0, -44}; // длинна массива 6
        System.out.println(Arrays.toString(ints2));
        // длтнна массива
        int len = 10;
        int[] ints3 = new int [len];

        //доступ к элементам массива
        System.out.println(inst2[3]);
        */
        // многомерный массив
//        int [][] ints5 = new int[4][4];
//        System.out.println(Arrays.deepToString(ints5));

        // перебор массива
        // цикл for будит использоваться если необходимо перелажить/заменить элементы массива
/*        int[] ints7 = {3, -6, 12, 0, 4};
//        for (int i = 0; i < ints7.lemgth; i +=1); {
//            ints7[i] *= ints7[i];
//        }
        // сумма
        int s = 0;
        for (int i = 0; i < ints7.length; i +=1) {
             s += ints7[i];
        }
        System.out.println(s);

            // for reach не позволяет изменить значение массива
            // и не предоставляет доступа к индексам
            // цикл сам определит размер и пройдет от первого до последнего
        for (int element:ints7) { // element- это ЗНАЧЕНИЕ элемента не индекс
            System.out.println(element);
            s +=element;
            }
        */

//        double s =0;
        double[] ints8 = {3.7, -6.2, 12.9, 0.4, 4.1};
        /*for (double element:ints8) {
            double x = element[0];
            if (element[0] < element) {
                x = element;
            }
            System.out.println(element[0]);

            // случайный элемент
            System.out.println(ints8[(int)(Math.random() * ints8.length)]);

            // Класс Arrays
            Arrays.sort(ints8);
            System.out.println(Arrays.toString(ints8));*/

            int element = Arrays.binarySearch(ints8, 4);
        System.out.println(element); // если в массиве значение нет то выпадает отрицательное число
//         int element = Arrays.binarySearch(ints8, 13);
//        System.out.println(element);

        //копирование массива
        double[] ints9 = {3.7, -6.2, 12.9, 0.4, 4.1};
        //double[] int10 = ints9; // Так копировать нельзя. Так можно обращаться как int9 так и к int10
        double[] clonInts9 =ints9.clone();

        double[] copyInts9 = Arrays.copyOf(ints9, 3);
        System.out.println(Arrays.toString(copyInts9));

        double[] newDouble = new double[10];
        System.arraycopy(ints9, 1, newDouble, 3, 2);
        // ints9 - откуда, 1 - начало копирования индекс , newDouble, 3 - начало вставки индекс, 2 - сколько элементов будет скопировано)
        // алгоритм быстрой сортировки
    }
}
