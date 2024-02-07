package Seminar_06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*Задание №1
1. Напишите метод, который заполнит массив из 1000 элементов случайными
цифрами от 0 до 24.
2. Создайте метод, в который передайте заполненный выше массив и с
помощью Set вычислите процент уникальных значений в данном массиве и
верните его в виде числа с плавающей запятой.
Для вычисления процента используйте формулу:
процент уникальных чисел = количество уникальных чисел * 100 / общее
количество чисел в массиве.
 */

public class Task_01 {
    public static void main(String[] args) {
        Integer[] arr = fillArray(1000, 0, 24);
        System.out.println(Arrays.toString(arr));
        System.out.println(percent(arr));
    }

    static Integer[] fillArray(int count, int start, int fin) {
        Integer[] arr = new Integer[count];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(start, fin + 1);
        }
        return arr;
    }

    static double percent(Integer[] arr) {
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        return set.size() * 100.0 / arr.length;
    }
}
