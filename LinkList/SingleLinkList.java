package LinkList;

/**
 * @author BianWenKai
 * @DATE 2021/7/18 - 20:50
 **/
public class SingleLinkList {

    private Node head; //头节点
    private int size; //链表中元素个数
    private Node tail ; //声明尾节点，在尾插法建立链表的时候总是定位到最后一个节点，提高尾插法的效率

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

    private class Node{
        private Node next; //指针，指向Node类型的指针
        private Object data;

        //创建构造函数，保证我们创建的Node都是有值的，不会有无值Node实例被初始化出来
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
            tail = head;
        }else{
            //把新节点接在temp的后面
            tail.next = newNode;
            tail = tail.next;  //使尾节点总是指向链表的最后
        }
        size++;
    }

    //头插法
    public void addHead(Object data){
        Node newNode = new Node(data);
        //优化一下，使用isEmpty()方法来判断链表是否为空
        if (isEmpty()){
            head = newNode;
            tail = head;
        }else {
            newNode.next = head;
            head = newNode;
        }
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
            if (i == index){
                return temp.data;
            }
            temp = temp.next;
            i++;
        }
        return null;
    }

    //根据指定数据来获取该数据所在的位置
    public int dataLocal(Object data){
        int i = 0;
        Node temp = head;
        while (temp != null){
            if (temp.data.equals(data)){
                return i;
            }
            temp = temp.next;
            i ++;
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
    public void deleteNode(int index){
        int i = 0;
        Node current = head;
        if (isEmpty() || index > size){
            System.out.println("删除位置不合理");
        }else if (index == 0){       //删除的假如是头节点
            System.out.println("被删掉的数据为："+current.data);
            current = current.next;
            head = current;
            size--;
        }else{
            while (i < index){
                current = current.next;
                i++;
            }
            //[       1        ->        2       ->    3]
            //getPrevious(current)    current
            System.out.println("被删掉的数据为："+current.data);
            getPrevious(current).next = current.next;     //调用获取当前节点的前一个节点方法
            current.next = null;
            size--;
        }

/*
        Node temp = head;
        Node q ;
        Object e = null;
        //要删除的是头节点的话
        if (index == 0){
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
        if (temp == null || index > getSize())
            return false;
        q = temp.next;
        temp.next =temp.next.next;
        e = q.data;   //保存删除的节点数据域
        System.out.println("被删掉的数据为："+e);
        q = null;   //释放删除节点的空间
        size--;
        return true;
 */
    }



    //将链表转化为数组
    public Object[] toArray(){
        Object[] array = new Object[size];
        Node current = head;
        int i = 0;
        while (current != null){
            array[i] = current.data;
            current = current.next;
            i++;
        }
        return array;
    }

    //在链表中的很多方法中都需要获取前一个节点，所以我们将其提取出来，写一个新方法
    public Node getPrevious(Node node){
        Node current = head;
        while (current != null){
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    public void showData(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("size:"+size);
    }
}
