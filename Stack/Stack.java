package Stack;


import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/8/15 - 12:31
 **/
public class Stack {
    private Object[] elementData;  //存放栈中元素的数组
    private int elementCount;  //栈顶指针

    public Stack(int initialCapacity){
        this.elementData = new Object[initialCapacity];
        this.elementCount = 0;
    }

    public void push(Object data){
        if (elementCount == elementData.length)
            throw new StackOverflowError();
        elementData[elementCount++] = data;
    }

    //弹出栈顶项
    public Object pop(){
        if (elementCount == 0)
            throw new IllegalStateException();
        return elementData[--elementCount];
    }

    //返回栈顶项，但不删除
    public Object peek(){
        if (elementCount == 0)
            throw new IllegalStateException();
        return elementData[elementCount - 1];
    }

    public Boolean isEmpty(){
        return elementCount == 0;
    }

    @Override
    public String toString(){
        //将原数组从下标x到m，copy成一个新数组  [)
        Object[] array = Arrays.copyOfRange(elementData,0,elementCount);
        return Arrays.toString(array);
    }

}
