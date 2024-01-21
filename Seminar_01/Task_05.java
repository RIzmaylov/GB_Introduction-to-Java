package Seminar_01;

/*
 * Задание №5 (доп)
Во фразе "Добро пожаловать на курс по Java" переставить слова
в обратном порядке.
 */
public class Task_05 {
    public static void main(String[] args) {
        String s = "Добро пожаловать на курс по Java";
        String[] arr_s = s.split(" ");
        String res_str = "";
        for (int i = arr_s.length - 1; i >= 0; i--) {
            res_str += arr_s[i] + " ";
        }
        System.out.println(res_str.trim());     // trim - удаляет пробелы в начале и конце строки
    }
}
