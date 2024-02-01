package Seminar_04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Задание №3
1) Написать метод, который принимает массив элементов, помещает их в стэк
и выводит на консоль содержимое стэка.
2) Написать метод, который принимает массив элементов, помещает их в
очередь и выводит на консоль содержимое очереди. 
 */

public class Task_03 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        printAsStack(arr);
        printAsQueue(arr);
    }

    static void printAsStack(Integer[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(arr));

        System.out.println(stack);  // таким образом выводится через ToString и получается в прямом порядке, а не в правильном обратном

        while(!stack.empty()) {
            System.out.println(stack.pop());    // теперь в правильном порядке, но числа будут удаляться
        }
    }
    
    private static void printAsQueue(Integer[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(arr));
        
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
