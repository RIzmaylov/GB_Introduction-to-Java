package Lecture_06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // HashSet
        /*
         * isEmpty() - проверка на пустоту
         * add(V) - добавление элемента в коллекцию
         * remove(V) - удаление элемента из коллекции
         * contains(V) - проверка на включение элемента в коллекции
         * clear() - удаление всех элементов из коллекции
         * size() - возвращает количество элементов в коллекции
         * 
         * addAll(Coll) - объединение множеств
         * retainAll(Coll) - пересечение множеств
         * removeAll(Coll) - разность множеств
         */

         Set<Integer> set = new HashSet<>();
         set.add(1); set.add(12); set.add(123); set.add(1234); set.add(1234);
         System.out.println(set.contains(12));  // true
         set.add(null);
         System.out.println(set.size());    // 5
         System.out.println(set);   // [null, 1, 1234, 123, 12]
         set.remove(12);
         for (var item : set) System.out.println(item); // null 1 1234 123
         set.clear();
         System.out.println(set);   // []

         var a = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
         var b = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17));
         var u = new HashSet<Integer>(a); u.addAll(b);
         var r = new HashSet<Integer>(a); r.retainAll(b);
         var s = new HashSet<Integer>(a); s.removeAll(b);
         System.out.println(a); // [1, 2, 3, 4, 5, 6, 7]
         System.out.println(b); // [17, 2, 3, 5, 7, 11, 13]
         System.out.println(u); // [1, 17, 2, 3, 4, 5, 6, 7, 11, 13]
         System.out.println(r); // [2, 3, 5, 7]
         System.out.println(s); // [1, 4, 6]
         boolean res = a.addAll(b);
         System.out.println(res);


         // TreeSet
         /*
          * В основе HashMap
          * Упорядочен по возрастанию
          * null'ов быть не может
          */

          // LinkedHashSet
          /*
           * В основе HashMap
           * Помнит порядок
           */

        //-----------------------------------------------------------------------------
        System.out.println("Работа с Worker:");
        Worker w1 = new Worker();
        w1.firstName = "Имя_01";
        w1.lastName = "Фамилия_01";
        w1.salary = 100;
        w1.id = 1000;

        Worker w4 = new Worker();
        w4.firstName = "Имя_01";
        w4.lastName = "Фамилия_01";
        w4.salary = 100;
        w4.id = 1000;

        System.out.println(w1 == w4);       //false
        System.out.println(w1.equals(w4));  //false без переопределения equals

        Worker w2 = new Worker();
        w2.firstName = "Имя_02";
        w2.lastName = "Фамилия_02";
        w2.salary = 200;
        w2.id = 2000;
        Worker w3 = new Worker();

        w3.firstName = "Имя_03";
        w3.lastName = "Фамилия_03";
        w3.salary = 300;
        w3.id = 3000;

        var workers = new HashSet<Worker>(Arrays.asList(w1, w2, w3));
        System.out.println(workers.contains(w4));   //false без переопределения equals, с ним определяет w1 как w4

        System.out.println(w1.toString());
        System.out.println(w2.toString());
        System.out.println(w3.toString());
        System.out.println(w4.toString());
    }
}
