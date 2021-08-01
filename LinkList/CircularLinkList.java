package LinkList;

/**
 * @author BianWenKai
 * @DATE 2021/7/26 - 16:18
 **/
public class CircularLinkList {

    private int size ;
    private Node head;
    private Node tail;
    Node p;

    public CircularLinkList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public class Node{
        public Node next;
        public Object data;

        public  Node(Object data){
            this.next = null;
            this.data = data;
        }
    }

    //创建循环链表
    public void addTail(Object data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            size++;
            tail = head;
            p = tail;
            p.next = head;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
        p = tail;
        size++;
        p.next = head;  //尾节点的next域指向头节点
    }

    //将给定的两个不为空的循环链表进行合并
    public void mergeLinkList(CircularLinkList c1,CircularLinkList c2){
        if (c1.head != null && c2.head != null){
            head = c1.head;
            c1.tail.next = c2.head;
            c2.tail.next = c1.head;
        }
    }

    public void showData(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
