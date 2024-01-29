package Seminar_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/*
 * Задание №1
Заполнить список десятью случайными числами.
Отсортировать список методом sort() и вывести его на
экран.
 */

public class Task_01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(rand.nextInt(-5, 6));
        }
        System.out.println(list);
        list.sort(Comparator.reverseOrder());   // - по убыванию
        System.out.println(list);
        list.sort(Comparator.naturalOrder());   // - по умолчанию, по возрастанию (можно просто null)
        System.out.println(list);
        
    }
}
