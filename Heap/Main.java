package Heap;

import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/11/2 - 20:16
 **/
public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(3);
        heap.insert(7);
        heap.insert(5);
        heap.insert(9);
        heap.insert(4);
        heap.insert(11);
        heap.remove();
        heap.remove();
        heap.remove(0);
        System.out.println(Arrays.toString(Arrays.copyOfRange(heap.getItems(), 0, heap.getSize())));

        int[] array = {9,4,8,6,7,5};
        HeapSort sort = new HeapSort();
        sort.heapSort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("=========================");
        PriorityQueueWithHeap priorityQueueWithHeap = new PriorityQueueWithHeap();
        priorityQueueWithHeap.enqueue(3);
        priorityQueueWithHeap.enqueue(5);
        priorityQueueWithHeap.enqueue(2);
        priorityQueueWithHeap.enqueue(7);

        System.out.print(priorityQueueWithHeap.dequeue()+"  ");
        System.out.print(priorityQueueWithHeap.dequeue()+"  ");
        System.out.print(priorityQueueWithHeap.dequeue()+"  ");
        System.out.println(priorityQueueWithHeap.dequeue());

        System.out.println("================================");
        int[] numbers = {3,5,7,1,6,9,2};
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.maxHeap(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
