package Seminar_04;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/*
 * Задание №2
 Реализовать консольное приложение, которое:
1. Принимает от пользователя и “запоминает” строки.
2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
3. Если введено revert, удаляет предыдущую введенную строку из памяти
 */

public class Task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new LinkedList<>();
        boolean flag = true;

        while(flag) {
            String text = scanner.nextLine();
            switch(text) {
                case "print":
                    // Долгий вариант, т.к. через индексы, нужно через итераторы
                    // for (int i = list.size() - 1; i >= 0 ; i--) {
                    //     System.out.println(list.get(i));
                    // }
                    ListIterator<String> li = list.listIterator(list.size());
                    while(li.hasPrevious()) {
                        System.out.println(li.previous());
                    }
                    break;
                case "revert":
                    list.removeLast();
                    break;
                case "end":
                    flag = false;
                    break;
                default:
                    list.add(text);
                    break;
            }
            scanner.close();
        }
    }
}
