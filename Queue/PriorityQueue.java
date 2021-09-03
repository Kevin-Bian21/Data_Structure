package Queue;

import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/9/3 - 11:08
 **/

//优先队列
public class PriorityQueue {

    private int[] elementData;
    private int size;
    private int capacity;

    public PriorityQueue(){
        this.capacity = 8;
        this.elementData = new int[capacity];
    }

    public PriorityQueue(int capacity){
        this.elementData = new int[capacity];
        this.capacity = capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return capacity == size;
    }
    public void add(int data){
        if (isFull())
            throw new IllegalStateException();
        int i = shiftDataToInsert(data);
        elementData[i] = data;
        size++;
    }

    //移动数组元素，并将要插入的位置返回
    public int shiftDataToInsert(int data){
        int i;
        for (i = size-1; i >= 0 ; i--) {
            if (data < elementData[i])
                elementData[i+1] = elementData[i];
            else
                break;
        }
        return i + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}
