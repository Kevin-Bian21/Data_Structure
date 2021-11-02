package Heap;

import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/11/2 - 17:01
 **/
public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(3);
        heap.insert(7);
        heap.insert(5);
        heap.insert(9);
        System.out.println(Arrays.toString(Arrays.copyOfRange(heap.Items, 0, heap.size)));
    }
    private int[] Items;
    private int size;

    public Heap() {
        this.Items = new int[3];
        this.size = 0;
    }

    /**
     * Index(leftChild) = (2 * parent) + 1; Index(rightChild) = (2 * parent) + 2; parent = (index - 1) / 2;
     * @param value
     */
    public void insert(int value) {
        if (isFull())
            grow();
        Items[size++] = value;
        int index = size - 1;
        int parentIndex = (index - 1) / 2;
        //子结点和父结点进行比较，如果大则将父节点和子结点进行交换
        while (index > 0 && Items[index] > Items[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }







    private void grow() {
        int[] newItems = new int[size + (size >> 1)];
        System.arraycopy(Items, 0, newItems, 0, size);
        Items = newItems;
    }

    private void swap(int first, int second){
        int temp = Items[first];
        Items[first] = Items[second];
        Items[second] = temp;
    }

    private boolean isFull(){
        return size == Items.length;
    }
}























