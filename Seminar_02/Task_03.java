package Seminar_02;

/*Задание №3
Напишите метод, который принимает на вход строку (String) и
определяет является ли строка палиндромом (возвращает
boolean значение).
 */

public class Task_03 {
    public static void main(String[] args) {
        String polindrom = "А роза упала на лапу Азора";
        System.out.println(isPolindrom(polindrom));
        System.out.println(isPolindrom2(polindrom));
    }

    static boolean isPolindrom(String str) {
        str = str.toLowerCase();
        str = str.replace(" ", "");
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPolindrom2 (String str) {
        str = str.toLowerCase();
        str = str.replace(" ", "");
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString().equals(str);
    }
}
