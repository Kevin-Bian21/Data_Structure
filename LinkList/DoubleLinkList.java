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

    public void addTail(Object data) {
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
            head.next.pre = null;
            head = head.next;
            size --;
        }else {
            while (i < index) {         //找到要删除的节点元素
                current = current.next;
                i++;
            }
            //更改节点的指针域，释放删除的节点
            current.pre.next = current.next;
            current.next.pre = current.pre;
            current = null;
            size--;
        }
    }


    //双向链表插入操作
    public void insert(int index, Object data){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Illegal Capacity");

        int i =0;
        Node current = head;
        Node newNode  = new Node(data);
        if (index == 0){
            newNode.pre = null;
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        }else{
            while (i < index) {
                current = current.next;
                i++;
            }
            newNode.pre = current.pre;
            current.pre.next = newNode;
            newNode.next = current;
            current.pre = newNode;
        }
        size ++;
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
