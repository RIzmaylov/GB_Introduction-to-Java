/*
 * Комментарии
 */

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class Program {
    static public void main(String[] args) throws Exception {
        System.out.println("Hello World!");       // комментарии 2
        String s = null;                            // без присваивания значения не скомпилируется

        System.out.println(s);
        short age = 10;
        int salary = 123456;
        System.out.println(age);
        System.out.println(salary);

        float e = 2.7f;                             // для float ОБЯЗАТЕЛЬНО ставить f
        double d = 123.123;                         // для double можно не указывать d
        System.out.println(e);
        System.out.println(d);

        char ch = '1';
        System.out.println(ch);
        System.out.println(Character.isDigit(ch));  // true
        ch = 'a';
        System.out.println(ch);
        System.out.println(Character.isDigit(ch));  // false

        boolean flag1 = 123 <= 234;
        System.out.println(flag1);
        boolean flag2 = 123 >= 234 || flag1;
        System.out.println(flag2);
        boolean flag3 = flag1 ^ flag2;              // разделительная дизъюнкция истана только тогда, когда только один true
        System.out.println(flag3);

        String msg = "Hello world";
        System.out.println(msg);

        var i = 123;                                // типа auto, неявная типизация
        System.out.println(i);
        var j = 123.456;
        System.out.println(j);
        System.out.println(getType(i));             // Integer
        System.out.println(getType(j));             // Double

        /*
         * Классы обертки:              // Они позволяют работать с примитивами как с классами с разными удобными методами
         * int              Integer
         * short            Short
         * long             Long
         * byte             Byte
         * float            Float
         * double           Double
         * char             Character
         * boolean          Boolean
         */

         String str = "qweert";
         // str[1]; - так нельзя! String не массив, а класс
         System.out.println(str.charAt(1)); // вот так обращаться по индексу

         String sss = "qwer";   // 4, 0..3
         boolean b = sss.length() >= 5 && sss.charAt(4) == '1';   // ленивые вычсиления, второй считаться не будет
         //boolean b2 = sss.length() >= 5 & sss.charAt(4) == '1';   // считает все, и поэтому вылетит exception
         System.out.println(b);

         System.out.println();
         // МАССИВЫ
         // Одномерные
         int[] arr = new int[10];
         System.out.println(arr.length);

         arr = new int[] {1, 2, 3, 4, 5 };
         System.out.println(arr.length);

         // Многомерные
         int[] arr2[] = new int[3][5];
         for (int[] line : arr2) {
            for (int item : line) {
                System.out.printf("%d", item);
            }
            System.out.println();
         }

         // Массивы массивов
         int[][] arr3 = new int[3][5];
         for (int i3 = 0; i < arr3.length; i++) {
            for (int j3 = 0; j < arr3[i].length; j++) {
                System.out.printf("%d", arr3[i3][j3]);
            }
            System.out.println();
         }

         // Явные преобразования
         int ii = 123; double dd = ii;
         System.out.println(ii);
         System.out.println(dd);
         dd = 3.1415; ii = (int)dd;
         System.out.println(dd);
         System.out.println(ii);
         dd = 3.9415; ii = (int)dd;
         System.out.println(dd);
         System.out.println(ii);
         byte bb = Byte.parseByte("123");
         System.out.println(bb);
        //  bb = Byte.parseByte("1234");            // Здесь будет ошибка, переполнение Byte
        //  System.out.println(bb);


        System.out.println();
        // Получание данных из терминала
        // Импортировать import java.util.Scanner;
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!", name);
        System.out.println();

        System.out.printf("int a: ");
        int x = iScanner.nextInt();
        System.out.printf("double a: ");
        double y = iScanner.nextDouble();
        System.out.printf("%d +%f = %f", x , y, x + y);
        System.out.println();

        // Проверка получаемого значения:
        System.out.printf("int a: ");
        boolean flag = iScanner.hasNextInt();
        System.out.println(flag);
        int i2 = iScanner.nextInt();
        System.out.println(i2);
        iScanner.close();

        // Форматированный вывод
        int af = 1, bf = 2;
        int cf = af + bf;
        String res = af + " + " + bf + " = " + cf;
        String ress = String.format("%d + %d = %d \n", af, bf, cf);
        System.out.println(res);
        System.out.println(ress);
        System.out.println();

        // Работа с файлами
        // Импортируем:
        // import java.io.FileWriter;
        // import java.io.IOException;
        // Запись
        try (FileWriter fw = new FileWriter("Lecture_01\\file.txt", false)) {       // false/true - нужно ли дописывать. Если нет, то файл будет перезаписан
            fw.write("line 1");
            fw.append('\n');
            fw.append('2');
            fw.append('\n');
            fw.write("line 3");
            fw.flush();                 // принудительная запись
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // Чтение посимвольно
        // добавить в main - throws Exception - это вместо блока try - catch
        FileReader fr = new FileReader("Lecture_01\\file.txt");
        int c;
        while ((c = fr.read()) != -1) {
            char ch1 = (char) c;
            if (ch1 == '\n') {
                System.out.print(ch1);
            } else {
                System.out.print(ch1);
            }
        }
        fr.close();
        System.out.println();
        // Чтение построчно
        BufferedReader br = new BufferedReader(new FileReader("Lecture_01\\file.txt"));
        String str1;
        while ((str1 = br.readLine() ) != null) {
            System.out.printf("== %s ==\n", str1);
        }
        br.close();
    }

    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }
}
