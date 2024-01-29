package Seminar_03;

import java.util.ArrayList;
import java.util.List;

/*Задание №4
Каталог товаров книжного магазина сохранен в виде двумерного
списка List<ArrayList<String>> так, что на 0й позиции каждого
внутреннего списка содержится название жанра, а на остальных
позициях - названия книг. Напишите метод для заполнения данной
структуры.

[
    ["Сказка", "Золотой ключик", "Репка"],
    ["Роман", "Мастер и Маргарита", "Война и Мир"],
    ["Фэнтези", "Гарри Поттер", "Властелин Колец"]
]
 */

public class Task_03 {
    public static void main(String[] args) {
        List<ArrayList<String>> shopBook = new ArrayList<>();
        addBook(shopBook, "Сказка", "Золотой ключик");
        addBook(shopBook, "Роман", "Мастер и Маргарита");
        addBook(shopBook, "Сказка", "Репка");
        addBook(shopBook, "Фэнтези", "Гарри Поттер");
        addBook(shopBook, "Роман", "Война и Мир");
        addBook(shopBook, "Фэнтези", "Властелин Колец");

        System.out.println(shopBook);
    }

    private static void addBook (List<ArrayList<String>> shopBook, String genre, String nameBook) {
        for (int i = 0; i < shopBook.size(); i++) {
            List<String> bookShelf = shopBook.get(i);
            if (bookShelf.get(0).equals(genre)) {
                bookShelf.add(nameBook);
                return;
            }
        }
        ArrayList<String> newBookShelf = new ArrayList<>();
        newBookShelf.add(genre);
        newBookShelf.add(nameBook);
        shopBook.add(newBookShelf);
    }
}
