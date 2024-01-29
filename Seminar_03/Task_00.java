package Seminar_03;

import java.util.ArrayList;
import java.util.List;

public class Task_00 {
    public static void main(String[] args) {
//  Задание №0
//  Даны следующие строки, cравнить их с помощью == и
//  метода equals() класса Object
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});

        // Строки через == не сравниваются! Сравнивается равенство ССЫЛОК, а не посимвольно
        /*
         * Суть строк в том, что у них в куче отдельный pull string. И при создании строки, просматривается пул и если в нем
         * уже есть такая строка, то новая не создается. Например, строка s2 вовсе не создается, а указывает на s1, потому что
         * точно такая же, и s1 и s2 - это ссылки на одну и ту же строку, и поэтому они равны через ==.
         * Ключевое слово new создает уже строку не в пул стринг, а в общей куче, а значит будет не равен.
         * Поэтому создавать String с помощью new не стоит!
         */
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // true
        System.out.println(s1 == s4); // true
        System.out.println(s1 == s5); // false
        System.out.println(s1 == s6); // false

        System.out.println(s5.equals(s6)); // true - equals - проверяет посимвольно, поэтому везде будет true

        // Все ссылочные типы данных (которые с большой буквы) нужно сравнивать с помощью equals!!!, а не ==

        int a = 5;
        List<Integer> list = new ArrayList<>();
        String s = "hello";
        test(a, list, s);
        System.out.println(a);  // a остался 5
        System.out.println(list);   // list поменялся, потому что это ссылочный тип
        System.out.println(s);  // но s не поменяется, потому что строка неизменяемая и в методе будет просто новая ссылка
    }

    static void test(int a, List<Integer> list, String s) {
        a++;
        list.add(10);
        s = "bye";
    }
}
