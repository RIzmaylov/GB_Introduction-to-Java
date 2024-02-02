package Lecture_05;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // MAP - это множество коллекций, работающих с даными по принципу <Ключ / Значение>
        // Ключевые особенности:
        // - ускоренная обработка данных
        // - порядок добавления не запоминается
        // - допускаются только уникальные ключи, значения могут повторяться
        // - помнить про null значения

        // В HashMap элементы располагаются как угодно и могут менять свое расположение

        Map<Integer, String> db = new HashMap<>();
        db.putIfAbsent(1, "Один");  // - добавляет только если такого ключа ранее не было
        db.put(2, "Два");           // - добавляет, если ключ уже был - перезаписывает значение
        db.put(null, "!null");
        System.out.println(db); // {null=!null, 1=один, 2=два}
        System.out.println(db.get(44));
        //db.remove(null);
        System.out.println(db); // {1=одинб 2=два}
        System.out.println(db.containsValue("Один"));   // true
        // System.out.println(db.containsValue(1));    // false
        // System.out.println(db.containsKey("Один")); // false
        System.out.println(db.containsKey(1));  // true
        System.out.println(db.keySet());
        System.out.println(db.values());

        // put(K,V) - добавить пару или изменить значение, если ключ имеется
        // putIfAbsent(K,V) - произвести добавление если ключ не найден
        // get(K) - получение значения по указанному ключу
        // remove(K) - удаляет пару по указанному ключу
        // containsValue(V) - проверка наличия значения
        // containsKey(K) - проверка наличия ключа
        // keySet() - возвращает множество ключей
        // values() - возвращает набор значений.

        // Перебор значений через for each
        for (var item : db.entrySet()) {
            System.out.printf("[%d: %s]\n", item.getKey(), item.getValue());
        }

        // Варианты конструкторов:
        Map<Integer, String> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>(9);
        Map<Integer, String> map3 = new HashMap<>(9, 1.0f); // - здесь 1.0f - это процент заполнения
        // хеша, при котором будет происходить его увеличение емкости, здесь при заполнении на 100%

        // TreeMap - множество коллекция, основанное на красно-черном дереве, УПОРЯДОЧЕННОЕ ПО КЛЮЧУ
        // позволяет быстрее искать, но могут возникнуть заминки при добавлении
        TreeMap<Integer, String> tMap = new TreeMap<>();
        tMap.put(1, "One");
        System.out.println(tMap);   // {1=one}
        tMap.put(6,"six");
        System.out.println(tMap);   // {1=one, 6=six}
        tMap.put(4,"four");
        System.out.println(tMap);   // {1=one, 4=four, 6=six}
        tMap.put(3,"three");
        System.out.println(tMap);   // {1=one, 3=three, 4=four, 6=six}
        tMap.put(2,"two");
        System.out.println(tMap);   // {1=one, 2=two, 3=three, 4=four, 6=six}
        System.out.println(tMap.descendingKeySet());
        System.out.println(tMap.descendingMap());

        // put(K,V) - добавление ключ значение
        // get(K) - получение значчения по ключу
        // remove(K) - удаление по ключу
        // descendingKeySet(V) - получение ключей по нисходящему порядку
        // descendingMap() - получение map в обратном порядке
        // tailMap() - получение хвоста мапы
        // headMap() - получение головы мапы
        // lastEntry() - последнее вхождение
        // firstEntry() - первое вхождение

        // "Старший брат" коллекции HashMap, который помнит все это LinkedHashMap
        // Помнит порядок добавления элементов, а значит более медлительный

        Map<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(11, "one one");
        linkedMap.put(1, "one");
        linkedMap.put(2, "two");
        System.out.println(linkedMap);  // {11=one one, 1=one, 2=two}
        Map<Integer, String> map = new HashMap<>();
        map.put(11, "one one");
        map.put(2, "two");
        map.put(1, "one");
        System.out.println(linkedMap);  // {11=one one, 1=one, 2=two}

    }
}
