package LinkList;

/**
 * @author BianWenKai
 * @DATE 2021/8/14 - 16:15
 **/
public class DoubleLinkList {

    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private class Node{
        private Node pre;
        private Node next;
        private Object data;

        public Node(Object data){
            this.pre = null;
            this.next = null;
            this.data = data;
        }
    }

    public void buildLinkList(Object data) {
        Node newNode = new Node(data);
        Node current = tail;
        if (isEmpty()){
            head = newNode;
            tail = head;
        }else {
            tail.next = newNode;
            tail = tail.next;
            tail.pre = current;
        }
        size ++;
    }

    //给定索引，来删除删除一个元素
    public void deleteNode(int index){
        int i = 0 ;
        Node current = head;
        if (isEmpty())
            throw new IllegalStateException("链表为空");
        else if (index < 0 || index > size-1)
            throw new IllegalArgumentException("参数异常");
        else if (index == 0){  //删除的是头节点
            head = head.next;
            size --;
        }else {
            while (i < index) {         //找到要删除的节点元素
                current = current.next;
                i++;
            }
            current.pre.next = current.next;    //将要删除节点的前一个节点的指针域指向要删除节点的下一个节点
            size--;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void showData(){
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
