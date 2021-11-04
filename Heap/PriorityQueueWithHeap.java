package Heap;

/**
 * @author BianWenKai
 * @DATE 2021/11/4 - 21:34
 **/
public class PriorityQueueWithHeap {
    private Heap heap;

    public PriorityQueueWithHeap() {
        heap = new Heap();
    }

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        return heap.remove();
    }

    private boolean isEmpty() {
        return heap.getSize() == 0;
    }
}
