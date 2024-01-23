package Seminar_02;

/*Задание №2
Напишите метод, который сжимает строку.
Пример: вход aaaabbbcdd.
Результат: a4b3cd2
 */

public class Task_02 {
    public static void main(String[] args) {
        String str = "aaaabbbcdd";
        System.out.println(packString(str));
    }

    static String packString(String str) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                cnt++;
            } else {
                sb.append(str.charAt(i - 1));
                if (cnt > 1) {
                    sb.append(cnt);
                }
                cnt = 1;
            }
        }
        sb.append(str.charAt(str.length() - 1));
        if (cnt > 1) {
            sb.append(cnt);
        }
        return sb.toString();
    }
}
