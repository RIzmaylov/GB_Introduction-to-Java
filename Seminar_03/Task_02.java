package Seminar_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// Задание №3
// Создать список типа ArrayList.
// Поместить в него как строки, так и целые числа.
// Пройти по списку, найти и удалить целые числа.

public class Task_02 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(123);
        list.add(999);
        list.add("stroka");
        list.add(0.12);
        list.add(null);

        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Integer) {
                list.remove(i);
                --i;    // нужен потому что после remove все индексы смещаются вправо
            }
        }
        System.out.println(list);

        // вариант с итератором:
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() instanceof Double) {
                iterator.remove();
            }
        }
        System.out.println(list);

        // более укороченный вид предыдущего цикла:
        list.removeIf(o -> o instanceof Double);    // используется лямбда выражение
    }
}
