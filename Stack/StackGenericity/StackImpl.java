package Stack.StackGenericity;


import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/9/1 - 15:38
 **/
public class StackImpl<T> implements Stack<T> {

    private int top; //栈顶指针
    private T[] elementData;  //存放元素的数组
    private int initialCapacity; //栈的默认容量
    private int size; //栈中元素数量

    public StackImpl(){
        this.initialCapacity = 2;
        this.elementData = (T[]) new Object[initialCapacity];
        this.top = -1;
        this.size = 0;
    }

    public StackImpl(int initialCapacity){
        this.elementData = (T[]) new Object[initialCapacity];
        this.top = -1;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getLength(){
        return elementData.length;
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public void push(T data) {
        //如果栈满，则给其扩容
        if (elementData.length == size){
            T[] newArray = elementData;
            elementData =  (T[]) new Object[size * 2];
            for (int i = 0; i < size; i++) {
                elementData[i] = newArray[i];
            }
        }
        //从栈顶将数据元素压栈
        elementData[++top] = data;
        size ++;
    }

    @Override
    public T peek() {
        if (top == -1)
            throw new IllegalStateException("栈空");
        else
            return elementData[top];
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new IllegalStateException("栈空");
        else {
            size --;
            return elementData[top--];
        }
    }

    @Override
    public String toString() {
        //将原数组从下标x到m，copy成一个新数组  [)
        T[] array = Arrays.copyOfRange(elementData,0,size);
        return Arrays.toString(array);
    }
}
