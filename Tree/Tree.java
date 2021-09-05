package Tree;

/**
 * @author BianWenKai
 * @DATE 2021/9/4 - 15:49
 **/
public class Tree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value){
        Node node = new Node(value);
        if (root == null){
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value){
                if (current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }else {
                if (current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        Node current = root;
        while (current != null) {
           if (value < current.value)
               current = current.leftChild;
           else if (value > current.value)
               current = current.rightChild;
           else
               return true;
        }
        return false;
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    //先序遍历二叉树
    private void preOrderTraversal(Node root){
        if (root == null)
            return;
        System.out.println(root.value);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    //中序遍历
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root){
        if (root == null)
            return;
        inOrderTraversal(root.leftChild);
        System.out.println(root.value);
        inOrderTraversal(root.rightChild);
    }

    //后序遍历
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node root){
        if (root == null)
            return;
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.value);
    }

    //二叉树的高度
    public int height(){
        return height(root);
    }
    //通过递归，先得到叶节点的高度，然后传给叶节点的双亲节点，一直到根节点。
    private int height(Node root){
        if (root == null)
            return -1;
        if (root.leftChild == null && root.rightChild == null)
            return 0;
        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
    }

    //二叉树中最小的值
    public int min(){
        return min(root);
    }

    private int min(Node root){
        if (root == null)
            throw new IllegalStateException();
        if (root.leftChild == null && root.rightChild == null)
            return root.value;
        int left = min(root.leftChild);
        int right = min(root.rightChild);
        return Math.min(Math.min(left,right),root.value);
    }
}
