package Heap;

/**
 * @author BianWenKai
 * @DATE 2021/11/4 - 22:03
 **/

//实现父节点的值总比其子结点的值大
public class MaxHeap {
    public void maxHeap(int[] array) {
        int lastParentIndex = array.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            priorityHeap(array, i);
        }
    }
    //{3,5,7,1,6,9,2};
    private void priorityHeap(int[] array, int index) {
        int largerIndex = index;
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;
        //父节点的值小于左子节点值
        if (leftChildIndex < array.length && array[largerIndex] < array[leftChildIndex])
            largerIndex = leftChildIndex;
        //父节点的值小于右子节点的值
        if (rightChildIndex < array.length && array[largerIndex] < array[rightChildIndex])
            largerIndex = rightChildIndex;
//        int maxChildIndex = largerIndex;
//        if (rightChildIndex < array.length)
//            maxChildIndex = (array[leftChildIndex] >= array[rightChildIndex]) ? leftChildIndex : rightChildIndex;
//        if (maxChildIndex < array.length && array[largerIndex] < array[maxChildIndex])
//            largerIndex = maxChildIndex;

        //父节点的值不小于左右子结点，则直接返回，不用进行交换

        if (array[largerIndex] == array[index])
            return ;
        //如果父节点小于左子节点或右子结点的值，则将两个值进行交换
        swap(array, index, largerIndex);
        priorityHeap(array, largerIndex);
    }
    private void swap(int[] array, int index, int lagerIndex) {
        int temp = array[index];
        array[index] = array[lagerIndex];
        array[lagerIndex] = temp;
    }
}
