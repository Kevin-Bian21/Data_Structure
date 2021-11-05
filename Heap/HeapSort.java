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
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = h.remove();
        }
    }
}
