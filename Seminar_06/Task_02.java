package Seminar_06;

import java.util.HashSet;
import java.util.Set;

/*
 * Задание №2
1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для
приложения, которое является
а) информационной системой ветеринарной клиники
б) архивом выставки котов
в) информационной системой Театра кошек Ю. Д. Куклачёва
Можно записать в текстовом виде, не обязательно реализовывать в java.

Задание №3
1. Реализуйте 1 из вариантов класса Cat из предыдущего задания, можно
использовать не все придуманные поля и методы. Создайте несколько
экземпляров этого класса, выведите их в консоль.
2. Добейтесь того, чтобы при выводе в консоль объекта типа Cat, выводилась
его кличка, цвет и возраст (или другие параметры на ваше усмотрение).

Задание №4
1. Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>.
Поместите в него некоторое количество объектов.
2. Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество.
Убедитесь, что все они сохранились во множество.
3. Создайте метод public boolean equals(Object o)
Пропишите в нём логику сравнения котов по параметрам, хранимым в полях. То есть, метод
должен возвращать true, только если значения во всех полях сравниваемых объектов равны.
4. Создайте метод public int hashCode()
который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно использовать
Objects.hash(...))
5. Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились.
 */

public class Task_02 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "Барсик";
        cat1.poroda = "Сфинкс";
        cat1.age = 10;
        cat1.owner = "Иван Васильевич";
        
        Cat cat2 = new Cat();
        cat2.name = "Мурка";
        cat2.poroda = "Вислоухая";
        cat2.age = 8;
        cat2.owner = "Дарья Ивановна";
        
        Cat cat3 = new Cat();
        cat3.name = "Жорик";
        cat3.poroda = "Дворняга";
        cat3.age = 9;
        cat3.owner = "Татьяна Викторовна";
        
        Cat cat4 = new Cat();
        cat4.name = "Марья";
        cat4.poroda = "Персидская";
        cat4.age = 3;
        cat4.owner = "Кирилл Петрович";

        Cat cat5 = new Cat();
        cat5.name = "Марья";
        cat5.poroda = "Персидская";
        cat5.age = 3;
        cat5.owner = "Кирилл Петрович";

        System.out.println(cat4.equals(cat5));

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println(cat4);
        System.out.println(cat5);

        Set<Cat> cats = new HashSet<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);

        System.out.println(cats);
        System.out.println();
        // или:
        printSet(cats);
        System.out.println();
        // или:
        cats.forEach(cat -> System.out.println(cat));
        System.out.println();
        System.out.println(filterAsAge(cats, 9));
    }

    static Set<Cat> filterAsAge(Set<Cat> cats, int age) {
        Set<Cat> res = new HashSet<>();
        for (Cat cat : cats) {
            if (cat.age == age) {
                res.add(cat);
            }
        }
        return res;
    }

    static void printSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }
}
