package Stack.StackGenericity;

/**
 * @author BianWenKai
 * @DATE 2021/9/1 - 15:35
 **/
public interface Stack<T> {
    //判空
    boolean isEmpty();

    //压栈
    void push(T data);

    //返回栈顶元素
    T peek();

    //出栈
    T pop();
}
