package Tree;

import java.util.Arrays;

/**
 * @author BianWenKai
 * @DATE 2021/9/4 - 16:51
 **/
public class Main {
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        tree.insert(0);
        tree.preOrderTraversal();

        Tree tree2 = new Tree();
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        System.out.println();
        System.out.println(tree2.find(7));

        System.out.println(factorial(5));

        System.out.println("=====================");
        tree.postOrderTraversal();
        System.out.println("========树的高度=============");
        System.out.println(tree.height());

        System.out.println(tree.min());

        System.out.println(tree.equals(tree2));
        System.out.println("=====================");
        System.out.println(tree.isBinarySearchTree());
        tree.swapNode();
        System.out.println(tree.isBinarySearchTree());

        System.out.println(Arrays.toString(tree2.getNodesAtDistance(3).toArray()));
        System.out.println("=========层次遍历二叉树===========");
        tree2.traverseLevelOrder();

        System.out.println("=====================");
//        System.out.println(tree.sort());
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