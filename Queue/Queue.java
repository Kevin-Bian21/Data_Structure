package Queue;

/**
 * @author BianWenKai
 * @DATE 2021/9/1 - 18:29
 **/
public interface Queue<E> {
    //可以用数组、链表、栈实现队列

    boolean isEmpty();

    boolean isFull();

    void add(E data);

    //删除队头元素并返回删除的元素
    E remove();

    //获取但不删除队头元素
    E element();
}
