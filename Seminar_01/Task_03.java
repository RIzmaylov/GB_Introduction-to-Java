package Seminar_01;

import java.util.Arrays;

/*
 * Задание №3
Дан массив nums = [3,2,2,3] и число val = 3.
Если в массиве есть числа, равные заданному, нужно перенести
эти элементы в конец массива.
Таким образом, первые несколько (или все) элементов массива
должны быть отличны от заданного, а остальные - равны ему.
 */
public class Task_03 {
    public static void main(String[] args) {
        int arr[] = {3, 2, 2, 3, 2, 1, 5, 2};
        int val = 3;
        int res_arr[] = sorting(arr, val);
        // for (int i = 0; i < res_arr.length; i++) {
        //     System.out.printf("%d, ", res_arr[i]);
        // }
        System.out.println();
        System.out.println(Arrays.toString(res_arr));
    }

    static int[] sorting(int[] arr, int val) {
        int[] res_arr = new int[arr.length];
        Arrays.fill(res_arr, val);
        for (int i = 0, index = 0; i < res_arr.length; i++) {
            if (arr[i] != val) {
                res_arr[index++] = arr[i];
            }
        }
        return res_arr;
    }
}
