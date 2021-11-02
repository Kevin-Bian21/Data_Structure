package Heap;

/**
 * @author BianWenKai
 * @DATE 2021/11/2 - 21:57
 **/
public class HeapSort {
    public void heapSort(int[] array) {
        Heap h = new Heap();
        for (int i : array)
            h.insert(i);
        for (int i = 0; i < array.length; i++) {
            array[i] = h.remove();
        }
    }
}
