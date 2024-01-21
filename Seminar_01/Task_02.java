package Seminar_01;
/*
 * Задание №2
Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести
максимальное количество подряд идущих 1.
 */
public class Task_02 {
    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 1, 1, 1, 1};
        int cnt = 0;
        int max_cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                cnt++;
                if (cnt > max_cnt) {
                    max_cnt = cnt;
                }
            } else {
                cnt = 0;
            }
        }
        System.out.println("Максимальное кол-во идущих 1 равно: " + max_cnt);
    }
}
