package Heap;

/**
 * @author BianWenKai
 * @DATE 2021/11/2 - 17:01
 **/
public class Heap {

    private int[] Items;
    private int size;

    public Heap() {
        this.Items = new int[3];
        this.size = 0;
    }

    /**
     * 下标为index的节点其父节点为 parent = (index - 1) / 2;
     * Index(leftChild) = (2 * parent) + 1; Index(rightChild) = (2 * parent) + 2;
     * @param value
     */
    public void insert(int value) {
        if (isFull())
            grow();
        Items[size++] = value;
        int index = size - 1;
        int parentIndex = (index - 1) / 2;
        bubbleUp(index, parentIndex);
    }

    public void remove(){
        if (isEmpty())
            throw new IllegalStateException("The heap is empty !");
        //为了将删除节点后的空位补上，首先需要将堆中最后一个元素移动到该位置，然后判断是否符合堆的结构，不符合则进行相应的调整
        Items[0] = Items[--size];
        int index = 0;
        bubbleDown(index);

    }

    public void remove(int index){
        if (isEmpty())
            throw new IllegalStateException("The heap is empty !");
        if (index >= size)
            throw new IllegalArgumentException();
        //为了将删除节点后的空位补上，首先需要将堆中最后一个元素移动到该位置，然后判断是否符合堆的结构，不符合则进行相应的调整
        Items[index] = Items[--size];
        bubbleDown(index);

    }

    //判断父节点是否有效（大于左右子结点）
    private boolean isValidParent(int index) {
        if (! hasLeftChild(index))
            return true;
        if (! hasRightChild(index))
            return Items[index] >= Items[leftChildIndex(index)];

        return Items[index] >= Items[leftChildIndex(index)] && Items[index] >= Items[rightChildIndex(index)];
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private void bubbleDown(int index) {
        while (index < size && !isValidParent(index)) {
            int maxChildIndex = (Items[leftChildIndex(index)] >= Items[rightChildIndex(index)]) ? leftChildIndex(index) : rightChildIndex(index);
            swap(index, maxChildIndex);
            index = maxChildIndex;
        }
    }

    private void bubbleUp(int index, int parentIndex) {
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

    private boolean isEmpty(){
        return size == 0;
    }

    public int[] getItems() {
        return Items;
    }

    public int getSize() {
        return size;
    }
}























