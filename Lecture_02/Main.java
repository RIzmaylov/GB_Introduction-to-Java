package Lecture_02;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

import Lesson_02.Ex005_Logger;

public class Main {
    public static void main(String[] args) throws SecurityException, IOException {
        // API - это сторонние приграммы или сервисы от разных разработчиков, которые можно использовать

        var s = System.currentTimeMillis();
        // String str = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            // str += "+";                           // такая операция со строками займет примерно 44 секунды
            sb.append("+");                     // Используя StringBuilder из API JAVA можно сократить до 14мс
        }
        System.out.println(System.currentTimeMillis() - s);
        // System.out.println(str);
        // System.out.println(sb);


        /*
        Что такое API для нас: строки 

        cancat(): объединение строк

        valueOf(): преобразует Object в строкое представление (завязан на toString())

        join(): объединяет набор строк в одну с учетом разделителя

        charAt(): получение символа по индексу

        indexOf(): первый индекс вхождения подстроки

        lastIndexOf(): послеждний индекс вхождения подстроки

        startsWith()/endsWith(): определяет, начинается/заканчивается ли строка с подстроки

        replace(): замена одной подстроки на другую

        trim(): удаляет начальные и конечные пробелы

        substring(): возвращает подстроки(см. аргументы)

        toLowerCase()/toUpperCase(): возвращает новую строку в нижнем/верхнем регистре
        
        compareTo(): сравнение двух строк

        equals(): стравниваетс троки с учетом регистра

        equalsIgnoreCase(): сравнивает строки без учета регистра
        
        regionMatches(): сравнивает подстроки в строках
         */

         // Строки и массивы

         String[] name = {"С", "е", "р", "г", "е", "й"};
         String sk = "СЕРГЕЙ КА.";
         System.out.println(sk.toLowerCase());      // сергей ка.
         System.out.println(String.join("",name));      // Сергей
         System.out.println(String.join(",", "С", "е", "р", "г", "е", "й")); // С,е,р,г,е,й

         // Вывод:
         // Если надо компоновать и создавать строки, то - StringBuilder
         // Если надо работать с уже готовой строкой, то - String

         // РАБОТА С ФАЙЛОВОЙ СИСТЕМОЙ

        // Для работы нужно:
        // File <имя> = new File(<полный путь к файлу>);

        File f1 = new File("Lecture_02/File.txt");

        // При работе с файлами могут (и будут) возникать ошибки
        // Чтобы их избежать, исопльзовать try - catch
        try {
            // Код, в котором может появиться ошибка
        } catch (Exception e) {
            // Обработка, если ошибка случилась
        } finally {
            // Код, который выполнится в любом случае
        }

        // Пример:
        try {
            String pathProject = System.getProperty(("user.dir"));
            String pathFile = pathProject.concat("/Lecture_02/file.txt");
            File f3 = new File(pathFile);
            System.out.println("try");
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }

        /*
         * Работа с файлами:
         * 
         * isHidden(): возвращает истину, если каталог или файл является скрытым
         * 
         * length(): возвращает размер файла в 
         * 
         * lastModified(): возвращает время последнего изменения файла или каталога
         * 
         * list(): возвращает массив файлов и подкаталогов, которые находятся в каталоге
         * 
         * listFiles(): возвращает массив файлов и подкаталогов. которые находятся в определенном каталоге
         * 
         * mkdir(): создать новый каталог
         * 
         * renameTo(File dest): переименовывает файл или каталог
         */

        // ЛОГИРОВАНИЕ
        // Использование:
        // Logger logger = Logger.getLogger();

        // Уровни важности:
        // INFO, DEBUG, ERROR, WARNING и др.

        // Вывод:
        // ConsoleHandler info = new ConsoleHandler();
        // log.addHandler(info);

        // Формат вывода: структурированный, абы как*
        // XMLFormatter, SimpleFormatter

        // Пример:
        Logger logger = Logger.getLogger(Ex005_Logger.class.getName());
        // ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("Lecture_02/log.xml");

        // logger.addHandler(ch);
        logger.addHandler(fh);

        // SimpleFormatter sFormat = new SimpleFormatter();
        XMLFormatter xml = new XMLFormatter();
        // ch.setFormatter(sFormat);
        fh.setFormatter(xml);

        // logger.setLevel(level.INFO);
        logger.log(Level.WARNING, "Тестовое логирование 1");
        logger.info("Тестовое логирование 2");
    }
}
