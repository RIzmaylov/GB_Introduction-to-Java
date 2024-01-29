package Homework_02.Task_02;

/*
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход один параметр:

int[] arr - числовой массив

После каждого прохода по массиву ваш код должен делать запись в лог-файл 'log.txt' в формате год-месяц-день час:минуты {массив на данной итерации}. Для логирования использовать логгер logger класса BubbleSort.

Пример


arr = new int[]{9, 4, 8, 3, 1};
sort(arr)

// При чтении лог-файла получим:

2023-05-19 07:53 [4, 8, 3, 1, 9]
2023-05-19 07:53 [4, 3, 1, 8, 9]
2023-05-19 07:53 [3, 1, 4, 8, 9]
2023-05-19 07:53 [1, 3, 4, 8, 9]
2023-05-19 07:53 [1, 3, 4, 8, 9]
 */
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

// Решение семинариста:

class bubbleSort2 {
  private static FileWriter fileWriter;

  static void createLog() {
    try {
      fileWriter = new FileWriter("Homework_02/Task_02/log2.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void closeLog() {
    try {
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void sort (int[] mas) {
    createLog();
    bubbleSort(mas);
    closeLog();
  }

  private static int[] bubbleSort(int[] mas) {
    boolean isSorted = false;
    int buffer;

    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < mas.length - 1; ++i) {
        if (mas[i] > mas[i + 1]) {
          isSorted = false;

          buffer = mas[i];
          mas[i] = mas[i + 1];
          mas[i + 1] = buffer;
        }
      }
      log(Arrays.toString(mas));
    }

    return mas;
  }

  static void log(String note) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm");
      String timestamp = dateFormat.format(new Date());
      fileWriter.write(timestamp + " " + note + "\n");
      fileWriter.flush();
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
