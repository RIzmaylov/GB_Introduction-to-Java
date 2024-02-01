package Seminar_04;

public class MyStack {
    private int[] arr = new int[10];
    private int size = 0;

    int size() {
        return size;
    }

    boolean empty() {
        return size == 0;
    }

    void push(int element) {
        if (size >= arr.length) {
            int[] arr2 = new int[arr.length * 2];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            arr = arr2;
        }
        arr[size++] = element;
    }

    int peek() {
        return arr[size - 1];
    }

    int pop() {
        return arr[--size];
    }

}
