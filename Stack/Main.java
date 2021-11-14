package Stack;

import Stack.StackGenericity.StackImpl;

/**
 * @author BianWenKai
 * @DATE 2021/8/15 - 15:17
 **/
public class Main {
    public static void main(String[] args){
        Stack stack = new Stack(4);
        stack.push("边");
        stack.push("文");
        stack.push("凯");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.pop();

        System.out.println(stack.isEmpty());

        StackImpl<Integer> stack1 = new StackImpl<Integer>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        System.out.println(stack1.getSize());
        System.out.println(stack1.getLength());
        System.out.println(stack1.peek());
        System.out.println(stack1.pop());
        System.out.println(stack1.peek());
        System.out.println(stack1.getSize());
        System.out.println(stack1.toString());

        StackImpl<Integer> stack2 = new StackImpl<Integer>(-1);
        System.out.println(stack2.isEmpty());
        System.out.println(stack2.toString());
    }
}
