package Seminar_02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*Задание №4
Напишите метод, который составит строку, состоящую из 100
повторений слова TEST и метод, который запишет эту строку в
простой текстовый файл, обработайте исключения.
 */

public class Task_04 {
    
    static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        String filePath = "Seminar_02/test.txt";
        String logPath = "Seminar_02/log.txt";
        String s = "test";
        int n = 10;

        createLogger(logPath);

        String s1 = repeat(s, n);
        writeToFile(s1, filePath);
        System.out.println(readFile(filePath));

        closeLogger();
    }

    static void createLogger(String logPath) {
        try {
            FileHandler fh = new FileHandler(logPath, true);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fh.setFormatter(simpleFormatter);
            logger.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void closeLogger() {
        Handler[] handlers = logger.getHandlers();
        for (Handler handler : handlers) {
            handler.close();
        }
    }

    static void writeToFile(String s, String filePath) {
        // FileWriter fw = null;
        // try {
        //     fw = new FileWriter(filePath);
        //     fw.write(s);    // Подготовливает строку к записи, добавляет в буфер, НЕ ЗАПИСЫВАЕТ!
        //     fw.flush();     // После этого уже будет записаны данные в файл
        // } catch (IOException e) {
        //     e.printStackTrace();
        // } finally {
        //     try {
        //         fw.close(); // ОБЯЗАТЕЛЬНО. Закрывает поток и записывает все данные в файл из буфера (можно тогда без flash())
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }     
        // }

        // Чтобы не делать все те манипуляции с try catch, что сверху:
        try (FileWriter fw = new FileWriter(filePath, true)) { // Вcе что в скобках будет автоматически закрыто после блока try catch
            fw.write(s);    // теперь блок finally и закрытие файла не нужно!
            fw.write("\n");
            logger.info("Запись в файл была успешна!");
        } catch (IOException e) {
            logger.warning("Не удалось записать в файл!");
            e.printStackTrace();
        }
        // При создании new FileWriter(filePath, true) - true - это флаг дозаписывать или переписывать файл
        
    }

    static String readFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(filePath);
        try(Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                stringBuilder.append(sc.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    static String repeat(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
        // return s.repeat(n);      // то же самое
    }

    
}
