package Seminar_04;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * Задание №1
Реализовать консольное приложение, которое:
1. Принимает от пользователя строку вида text~num
2. Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
3. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
 */

public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new LinkedList<>();
        boolean work = true;

        while(work) {
            System.out.println("Введите строку вида text~num");
            String line = scanner.nextLine();
            String[] arr = line.split("~");
            String text = arr[0];
            int num = Integer.parseInt(arr[1]);

            switch (text) {
                case "print":
                    System.out.println(list.remove(num));
                    break;
                case "end":
                    work = false;
                    break;
                default:
                    list.add(num, text);
                    break;
            }
        }
        scanner.close();
    }
}
