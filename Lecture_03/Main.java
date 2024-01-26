package Lecture_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        // Object - обертка над типами данных, в него можно запаковывать различные типы данных и распаковывать
        Object o = 1; GetType(o);   // java.lang.Integer
        o = 1.2; GetType(o);        // java.lang.Double


        System.out.println(Sum(1, 2));
        System.out.println(Sum(1.0, 2));
        System.out.println(Sum(1, 2.0));
        System.out.println(Sum(1.0, 2.0));

        // Массивы

        // Что делать если в массив длиной 2 нужно добавить 3ий элемент:
        int[] arr = new int[] {1, 9};
        int[] barr = new int[3];
        System.arraycopy(arr, 0, barr, 0, arr.length);

        for (int i : arr) {
            System.out.printf("%d ", i); // 1 9
        }
        System.out.println();
        for (int i : barr) {
            System.out.printf("%d ", i); // 1 9 0 
        }
        System.out.println();

        // Коллекции. ArrayList

        ArrayList lsit = new ArrayList(); // - сырой List, может работать с любыми типами но с преобразованиями к Object

        // List:
        // ArrayList, LinkedList (Vector, Stack - устаревшие)
        // Пользователь этого интерфейса имеет точный контроль на тем, где в списке вставляется каждый элемент.
        // Пользоветль может обращаться к элементам по их целочисленному индексу (позиции в списке) и искать элементы в списке.

        List<Integer> list = new ArrayList<Integer>();
        // Можно объявить явно:
        // ArrayList list = new ArrayList();
        list.add(2809);

        for (Object oo : list) {
            System.out.println(oo);
        }
        // Методы создания ArrayList:
        ArrayList<Integer> List1 = new ArrayList<Integer>();
        ArrayList<Integer> List2 = new ArrayList<>();
        ArrayList<Integer> List3 = new ArrayList<>(10);
        ArrayList<Integer> List4 = new ArrayList<>(List3);

        // Функционал коллекций:
        /*
         * add(args) - добавляет элемент в список (в т.ч. на нужную позицию)
         * 
         * get(pos) - возвращает элемент из списка по указанной позиции
         * 
         * indexOf(item) - первое вхождение или -1
         * 
         * lastIndexOf(item) - последнее вхождение или -1
         * 
         * remove(pos) - удаление элемента на указанной позиции и его возвращение
         * 
         * set(int pos, T item) - помещает значение item элементу, который находится на позиции pos
         * 
         * void sort(Comparator) - сортирует набор данных по правилу
         * 
         * subList(int start, int end) - получение набора данных от позиции start до end
         * 
         * clear() - очистка списка
         * 
         * toString() - "конвертация" списка в строку
         * 
         * Arrays.asList - преобразует массив в список
         * 
         * containsAll(col) - проверяет включение всех элементов из col
         * 
         * removeAll(col) - удаляет элементы, имеющиеся в col
         * 
         * retainAll(col) - оставляет элементы, имеющиеся в col
         * 
         * toArray() - конвертация списка в массив Object'ов
         * 
         * toArray(type array) - конвертация списка в массив type
         * 
         * List.copyOf(col) - возвращает копию списка на основе имеющегося
         * 
         * List.Of(item1, item2...) - возвращает неизменяемый список
         */

         // Из массива в ArrayList:
         int day = 29;
         int month = 9;
         int year = 1990;
         Integer[] date = {day, month, year};
         List<Integer> d = Arrays.asList(date);
         System.out.println(d);

         // Есть нюансы!!!:
         StringBuilder daySB = new StringBuilder("28");
         StringBuilder monthSB = new StringBuilder("9");
         StringBuilder yearSB = new StringBuilder("1990");
         StringBuilder[] dateSB = new StringBuilder[] {daySB, monthSB, yearSB};
         List<StringBuilder> dSB = Arrays.asList(dateSB);
         System.out.println(dSB); // [29, 9, 1990]
         dateSB[1] = new StringBuilder("09");       // Меняем в исходном массиве dateSB, а меняется и в List!
         System.out.println(dSB); // [29, 09, 1990]

         // Создание неизменяемого массива, нюансы:
         Character value = null;
         List<Character> list1 = List.of('S', 'e', 'r', 'g', 'e', 'y');
         System.out.println(list1);
        //  list1.remove(1);   // java.lang,UnsupportedOperationException   // Элементы удалять просто так нельзя
        List<Character> list2 = List.copyOf(list1);

        // ИТЕРАТОРЫ

        List<Integer> listIter = List.of(1, 12, 123, 1234, 12345);
        
        for (int item : listIter) {
            System.out.println(item);
        }

        Iterator<Integer> col = list.iterator();
        System.out.println();

        while (col.hasNext()) {
            System.out.println(col.next());
            // col.next();      - так делать не нужно
            // col.remove();    - так делать не нужно
        }
    }

    private static void GetType(Object o) {
        System.out.println(o.getClass().getName());
    }

    // Вместо того, чтобы городить функцию на каждый вариант sum, используем Object:
    private static Object Sum(Object a, Object b) {
        if (a instanceof Double && b instanceof Double) {
            return (Object)((Double) a + (Double) b);   // используем явное преобразование к Double и обратно к Object
        } else if (a instanceof Integer && b instanceof Integer) {
            return (Object)((Integer) a + (Integer) b);
        } else return 0;
    }

    // Создаем метод для копирования в массив:
    static int[] AddItem(int [] array, int item) {
        int length = array.length;
        int[] temp = new int[length + 1];
        System.arraycopy(array, 0, temp, 0, length);
        temp[length] = item;
        return temp;
    } 
}
