package Lecture_04;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // LinkedList - двусвязный список

        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(2);
        ll.add(3);

        // Queue - очередь FIFO

        Queue<Integer> queue = new LinkedList<>(); // - очередь построена на LinkedList'е

        queue.add(1);
        queue.add(2);
        queue.add(3);

        int item = queue.remove(); // удалиться первый элемент, т.к. FIFO
        System.out.println(item); // - 1

        // PriorityQueue - Очередь, где наивысший приоритет имеет наименьший элемент

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(123);
        pq.add(3);
        pq.add(13);
        pq.add(1);  // - в отсортированном порядке
        System.out.println(pq);
        System.out.println(pq.poll());  // - извелечение элемента с наивысшим приоритетом - 1
        System.out.println(pq.poll());  // - 3
        System.out.println(pq.poll());  // - 13

        // Deque - double ended queue - линейная коллекция, которая поддерживает вставку и удаление элементов на обоих концах
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);      // - вставляет элемент, может вылетить исключение, если переполнение capacity
        deque.removeLast();
        deque.offerFirst(1);    // - вставляет элемент, только если не нарушается capacity, не вызывает исключения
        deque.pollFirst();
        deque.addFirst(1);
        deque.getFirst();         // - возвращает первый элемент, если его нет, то исключение
        deque.peekFirst();        // - возвращает первый элемент, если его нет, то возвращает null без исключения
        deque.addLast(2);
        deque.removeLast();
        deque.offerLast(2);
        deque.pollLast();
        deque.getLast();
        deque.peekLast();

        // Stack - LIFO

        // Решение выражения, записанного в постфиксной форме:
        // (1+2*3*4)*(10/5) - 20
        // 1 2 3 * 4 * + 10 5 / * 20 -
        
        //var exp = "20 30 - 10 *".split(" "); // (20-30)*10
        var exp = "1 2 3 * +".split(" ");   // (1 + 2 * 3) -> (1 2 3 * +) - постфиксная форма
        int res = 0;
        System.out.println(exp);

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length; i++) {
            if (isDigit(exp[i])) {
                st.push(Integer.parseInt(exp[i]));
            } else {
                switch (exp[i]) {
                    case "+":
                        res = st.pop() + st.pop();
                        st.push(res);
                        break;
                    case "-":
                        res = st.pop() - st.pop();
                        st.push(res);
                        break;
                    case "*":
                        res = st.pop() * st.pop();
                        st.push(res);
                        break;
                    case "/":
                        res = st.pop() / st.pop();
                        st.push(res);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.printf("%d\n", st.pop());
    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
