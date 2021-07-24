package LinkList;

/**
 * @author BianWenKai
 * @DATE 2021/7/18 - 20:50
 **/
public class SingleLinkList {

    private Node head; //头节点
    private int size; //链表中元素个数

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }



    public SingleLinkList(){
        this.head = null;
        this.size = 0;
    }

    public static class Node{
        private Node next; //指针，指向Node类型的指针
        Object data;
        public Node(Object data){
            this.next = null;
            this.data = data;
        }
    }

    //尾插法
    public void addTail(Object data){
        //实例化一个新的节点
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            size++;
            return;
        }
        Node temp = head;
        //从头节点开始往下找，找到最后一个元素
        while (temp.next != null){
            temp = temp.next;
        }
        //把新节点接在temp的后面
        temp.next = newNode;
        size++;
    }

    //头插法
    public void addHead(Object data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    //判空
    public boolean isEmpty(){
        return head == null;
    }

    //清空单链表
    public void clear(){
        Node p;
        while (head != null){
            p = head.next;
            head = null;
            head = p;
            size --;
        }
    }

    //求链表长度
    public int length(){
        int len = 0;
        //所有关于链表的操作设计头节点的，全都用中间变量来代替，防止执行后头节点发生变化，导致链表失效
        Node temp = head;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    //查找第i的节点元素
    public Object find(int index){
        int i = 0;
        Node temp = head;
        while (temp != null){
            i++;
            if (i == index){
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    //根据指定数据来获取该数据所在的位置
    public int dataLocal(Object data){
        int i = 0;
        Node temp = head;
        while (temp != null){
            i ++;
            if (temp.data.equals(data)){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    //在指定的位置上插入新的元素
    public boolean insertNode(int index,Object data){
        int i = 0;
        Node newNode = new Node(data);
        Node temp = head;
        while (temp != null){
            i++;
            if (index == 1){
                newNode.next = temp;
                head = newNode;
                size++;
                return true;
            }else if (i == index-1){  //要在第index个位置插入，就要找到第index-1的节点
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //删除指定位置的元素
    public boolean deleteNode(int index){
        int i = 1;
        Node temp = head;
        Node q ;
        Object e = null;
        //要删除的是头节点的话
        if (index == 1){
            temp = temp.next;
            System.out.println("被删掉的数据为："+head.data);
            head = temp;
            size--;
            return true;
        }
        //找到要删除节点的前一个节点
        while (temp != null && i < index-1){
            temp = temp.next;
            i++;
        }
        //删除的位置不合理
        if (temp == null || i > index-1)
            return false;
        q = temp.next;
        temp.next =temp.next.next;
        e = q.data;   //保存删除的节点数据域
        System.out.println("被删掉的数据为："+e);
        q = null;   //释放删除节点的空间
        return true;
    }

    public void showData(){
        Node flag = head;
        while (flag != null){
            System.out.println(flag.data);
            flag = flag.next;
        }
        System.out.println("size:"+size);
    }
}
