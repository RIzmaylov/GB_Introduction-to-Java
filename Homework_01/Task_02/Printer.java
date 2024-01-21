package Homework_01.Task_02;

import java.util.Arrays;

/*
 * Напишите функцию printPrimeNums, которая выведет на экран все простые числа в промежутке от 1 до 1000, каждое на новой строке.

Напишите свой код в методе printPrimeNums класса Answer.

Пример

2
3
5
7
11
...
 */
class Answer {
    public void printPrimeNums(){
        // Напишите свое решение ниже
        int first = 2, last = 1000;
        boolean isPrime[] = new boolean[last];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = first; i < last; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < last; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = first; i < isPrime.length; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
    public static void main(String[] args) { 
      
      Answer ans = new Answer();      
      ans.printPrimeNums();
    }
}