package Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author BianWenKai
 * @DATE 2021/9/1 - 18:56
 **/
public class LinkedBlockingDeque<E> implements Queue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;
    private final int capacity;

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private class Node<E>{
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data){
            this.data = data;
        }
    }

    public LinkedBlockingDeque(){
        //如果未指定容量，那么容量将等于 Integer.MAX_VALUE :2^31-1 (2147483647)
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingDeque(int capacity){
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.capacity = capacity;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public void add(E data) {
        if (data == null)
            throw new NullPointerException();
        if (size >= capacity)
            throw new IllegalStateException("Deque full");
        Node<E> node = new Node<E>(data);
        Node<E> cur = last;
        if (isEmpty()){
            first = node;
            last = first;
        }
        last.next = node;
        last = last.next;
        last.prev = cur;
        size ++;
    }

    @Override
    public E remove() {
        if (isEmpty())
            throw new NoSuchElementException();
        Node<E> temp = first;
        first = first.next;
        size --;
        return temp.data;
    }

    @Override
    public E element() {
        if (isEmpty())
            throw new NoSuchElementException();
        return first.data;
    }


    public E[] toArray(){
        //将链表转化为数组
        E[] array = (E[]) new Object[size];
        Node<E> cur = first;
        int i = 0;
        while (cur != null){
            array[i] = cur.data;
            cur = cur.next;
            i++;
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
