package Homework_03.Task_01;

/*Внутри класса MergeSort напишите метод mergeSort, который принимает массив целых чисел, 
реализует алгоритм сортировки слиянием. Метод должен возвращать отсортированный массив.

Пример

a = {5, 1, 6, 2, 3, 4} -> [1, 2, 3, 4, 5, 6]
 */

import java.util.Arrays;

class MergeSort {
    public static int[] mergeSort(int[] a) {
        // Напишите свое решение ниже
        int length = a.length;
        if (length < 2) return a;

        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < length; i++) {
            right[i - mid] = a[i];
        }
        mergeSort(left);
        mergeSort(right);

        merge(a, left, right, mid, length - mid);
        return a;
    }

    private static void merge(int[] a, int[] left, int[] right, int leftPos, int rightPos) {
        int i = 0, j = 0, k = 0;
        while (i < leftPos && j < rightPos) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            }
            else {
                a[k++] = right[j++];
            }
        }
        while (i < leftPos) {
            a[k++] = left[i++];
        }
        while (j < rightPos) {
            a[k++] = right[j++];
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
    public static void main(String[] args) { 
        int[] a;

        if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{5, 1, 6, 2, 3, 4};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        MergeSort answer = new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}