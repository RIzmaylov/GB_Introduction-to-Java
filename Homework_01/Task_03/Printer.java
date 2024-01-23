package Homework_01.Task_03;

/*
 * Реализуйте простой калькулятор

В методе calculate класса Calculator реализовать калькулятор, который будет выполнять математические операции (+, -, *, /) 
над двумя целыми числами и возвращать результат вещественного типа.

В классе Printer необходимо реализовать проверку переданного оператора, при некорректном операторе программа должна вывести сообщение об ошибке 
"Некорректный оператор: 'оператор'".

Аргументы, передаваемые в метод/функцию:

'3'
'+'
'7'
На выходе:

10.0
 */
class Calculator {
    public double calculate(char op, int a, int b) {
        // Введите свое решение ниже
        double result = 0.0;
        switch (op) {
            case ('+'):
                result = a + b;
                break;
            case ('-'):
                result = a - b;
                break;
            case ('*'):
                result = a * b;
                break;
            case ('/'):
                result = a / b;
                break;
            default:
                System.out.println("Некорректный оператор: " + op);
                break;
                // throw new IllegalArgumentException("Некорректный оператор: " + op); // взято от перподавателя с семинара
        }
        return result;

    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
    public static void main(String[] args) { 
        int a = 0;
        char op = ' ';
        int b = 0;

        if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        Calculator calculator = new Calculator();
        double result = calculator.calculate(op, a, b);
        System.out.println(result);
    }
}
