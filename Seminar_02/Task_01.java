package Seminar_02;

/*Задание №1
Дано четное число N (>0) и символы c1 и c2.
Написать метод, который вернет строку длины N, которая
состоит из чередующихся символов c1 и c2, начиная с c1.
 */

public class Task_01 {
    public static void main(String[] args) {
        int num = 10;
        char ch1 = 'a', ch2 = 'b';
        System.out.println(strBuilder(num, ch1, ch2));
    }

    public static String strBuilder(int length, char ch1, char ch2) {
        StringBuilder resString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                resString.append(ch1);
            } else {
                resString.append(ch2);
            }
        }
        return resString.toString();
    }
}
