package Homework_05.Task_03;

/*
 * Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки кучей (Heap Sort). 
 * Программа должна работать следующим образом:

Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен, программа использует массив по умолчанию.

Сначала выводить исходный массив на экран.

Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.

Выводить отсортированный массив на экран.

Ваше решение должно содержать два основных метода: buildTree, который строит сортирующее дерево на основе массива, 
и heapSort, который выполняет собственно сортировку кучей.

Программа должна быть способной сортировать массив, даже если он состоит из отрицательных чисел и имеет дубликаты.

На входе:


'5 8 12 3 6 9'
На выходе:


Initial array:
[5, 8, 12, 3, 6, 9]
Sorted array:
[3, 5, 6, 8, 9, 12]
 */
import java.util.Arrays;

class HeapSort {
    
    public static void buildTree(int[] tree, int sortLength, int i) {
        int largest = i; 
        int left = 2 * i + 1;  
        int right = 2 * i + 2;  
        // If left child is larger than root  
        if (left < sortLength && tree[left] > tree[largest])  
            largest = left;  
        // If right child is larger than root  
        if (right < sortLength && tree[right] > tree[largest])  
            largest = right;  
        // If root is not largest  
        if (largest != i) {  
            // swap a[i] with a[largest]  
            int temp = tree[i];  
            tree[i] = tree[largest];  
            tree[largest] = temp;  
          
            buildTree(tree, sortLength, largest);  
        }     
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            buildTree(sortArray, sortLength, i);
        }
        for (int i = sortLength - 1; i >= 0; i--) {  
            /* Move current root element to end*/  
            // swap a[0] with a[i]  
            int temp = sortArray[0];  
            sortArray[0] = sortArray[i];  
            sortArray[i] = temp;  
              
            buildTree(sortArray, i, 0);  
        }
    }
}

// Не удаляйте и не меняйте метод Main! 
public class Printer {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}
