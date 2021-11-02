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
    }

}
