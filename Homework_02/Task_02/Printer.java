package Homework_02.Task_02;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;

class BubbleSort {
    static String logPath = "Homework_02/Task_02/log.txt";
    private static File log;
    private static FileWriter fileWriter;
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    static Date date = new Date();

    public static void sort(int[] mas) {
      try {
        fileWriter = new FileWriter(logPath);
      } catch (IOException e) {
        e.printStackTrace();
      }
      for (int i = 0; i < mas.length; ++i) {
        String tempMas = "[";
        int cnt = 0;
        for (int j = 0; j < mas.length - 1; ++j) {
          if (mas[j] > mas[j + 1]) {
            int temp = mas[j];
            mas[j] = mas[j + 1];
            mas[j + 1] = temp;
            cnt++;
            // swap(&mas[j], &mas[j + 1]);
          }
          tempMas += mas[j];
          if (j != mas.length - 2) tempMas += ", ";
        }
        try {
          fileWriter.write(formatter.format(date) + " " + tempMas + ", " + mas[mas.length - 1] + "]\n");
        } catch (IOException e) {
          e.printStackTrace();
        }
        
        if (cnt == 0) break;
      }
      try {
        fileWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
  }
}
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
    public static void main(String[] args) { 
      int[] arr = {};
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      }
      else{
        arr = Arrays.stream(args[0].split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
      }     
      
      BubbleSort ans = new BubbleSort();      
      ans.sort(arr);

      try (BufferedReader br = new BufferedReader(new FileReader("Homework_02/Task_02/log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
