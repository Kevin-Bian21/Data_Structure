package Stack;

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

    }
}
