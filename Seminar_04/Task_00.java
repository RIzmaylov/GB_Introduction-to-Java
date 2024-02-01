package Seminar_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Задание №0
1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
2) Замерьте время, за которое в LinkedList добавятся 10000 элементов.
Сравните с предыдущим.
 */

public class Task_00 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        test(list1);    // 35
        test(list2);    // 172
        // в коротку добавление элемента в дшые быстрая операция, но в длинную на большом количестве массив начинает выигрывать
        // потому что каждый раз при увеличении размера массив увеличивает вместимость на два и каждый раз ему нужно делать
        // эту операцию все меньше и меньше. Однако добавление не в начало массива или удаление будет много быстрее у листа.
        // Вставка в середину массива будет быстрее у массива, т.к. листу надо пройтись по всем элементам до вставляемого индекса

        test2(list1);
        test2(list2);   // обращение по индексу у листа очень долгая ( через обычный for i, а через for each будет быстро, 
        // т.к.ттам используются итераторы, они могут запоминать последнюю позицию и не делать перебор с начала)
    }

    private static void test(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long timeFinish = System.currentTimeMillis();
        System.out.println(list.getClass().getSimpleName() + ": " + (timeFinish - timeStart));
    }

    private static void test2(List<Integer> list) {
        long timeStart = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        long timeFinish = System.currentTimeMillis();
        System.out.println(list.getClass().getSimpleName() + ": " + (timeFinish - timeStart));
    }
    
}
