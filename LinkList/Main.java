package LinkList;

/**
 * @author BianWenKai
 * @DATE 2021/7/18 - 22:13
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println("==============尾插法建立单链表s1===============");
        SingleLinkList s1 = new SingleLinkList();
        s1.addTail("边");
        s1.addTail("文");
        s1.addTail("凯");
        s1.showData();
        System.out.println("单链表是否为空："+s1.isEmpty());
        System.out.println("==============头插法建立单链表s2===============");
        SingleLinkList s2 = new SingleLinkList();
        s2.addHead("边");
        s2.addHead("文");
        s2.addHead("凯");
        s2.showData();
        System.out.println("单链表是否为空："+s2.isEmpty());
        System.out.println("==============清空单链表s1==================");
        s1.clear();
        s1.showData();
        System.out.println("单链表是否为空："+s1.isEmpty());
        System.out.println("==============输出单链表s2的长度==================");
        int length = s2.length();
        System.out.println(length);
        System.out.println("==============根据索引来查询对应的节点元素=============");
        Object data = s2.find(3);
        System.out.println(data);
        System.out.println("==============根据指定元素来查询在链表中的位置=============");
        System.out.println(s2.dataLocal("凯"));
        System.out.println("==============将指定元素插入到指定位置=============");
        System.out.println(s2.insertNode(4,"is"));
        System.out.println(s2.insertNode(5,"good"));
        s2.showData();
        System.out.println("==============删除指定位置的节点=============");
        System.out.println(s2.deleteNode(1));
        System.out.println(s2.deleteNode(1));
        s2.showData();
    }
}
