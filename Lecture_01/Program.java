/*
 * Комментарии
 */

public class Program {
    static public void main(String[] args) {
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
    }

    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }
}
