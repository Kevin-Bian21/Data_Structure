package Tree;

/**
 * @author BianWenKai
 * @DATE 2021/9/4 - 16:51
 **/
public class Main {
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.insert(4);
        tree.insert(9);
        tree.insert(7);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println();
        System.out.println(tree.find(7));

        System.out.println(factorial(5));

        System.out.println("=====================");
        tree.postOrderTraversal();
        System.out.println("=====================");
        System.out.println(tree.height());

        System.out.println(tree.min());
    }

    //求阶乘
    // n! = n * (n - 1)!
    public static int factorial(int n){
        if (n < 0)
            throw new IllegalArgumentException("负数没有阶乘");
        //f(3) = 3 * f(2)
        //f(2) = 2 * f(1)
        //f(1) = 1 * f(0)
        //f(0) = 1
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
