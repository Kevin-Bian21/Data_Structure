package LinkList;

import java.util.Arrays;
import java.util.Stack;

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
        s1.addTail(9);
        s1.showData();
        s1.deleteNode(2);
//        s1.reverse();
        Object[] array = s1.toArray();
        System.out.println(Arrays.toString(array));
//        System.out.println(s1.getNodeFromTheEnd(3));
//        System.out.println("单链表是否为空："+s1.isEmpty());
//        System.out.println("==============头插法建立单链表s2===============");
//        SingleLinkList s2 = new SingleLinkList();
//        s2.addHead("边");
//        s2.addHead("文");
//        s2.addHead("凯");
//        s2.showData();
//        System.out.println("单链表是否为空："+s2.isEmpty());
//        System.out.println("==============清空单链表s1==================");
//        s1.clear();
//        s1.showData();
//        System.out.println("单链表是否为空："+s1.isEmpty());
//        System.out.println("==============输出单链表s2的长度==================");
//        int length = s2.length();
//        System.out.println(length);
//        System.out.println("==============根据索引来查询对应的节点元素=============");
//        Object data = s2.find(3);
//        System.out.println(data);
//        System.out.println("==============根据指定元素来查询在链表中的位置=============");
//        System.out.println(s2.dataLocal("凯"));
//        System.out.println("==============将指定元素插入到指定位置=============");
//        System.out.println(s2.insertNode(4,"is"));
//        System.out.println(s2.insertNode(5,"good"));
//        s2.showData();
//        System.out.println("==============删除指定位置的节点元素=============");
//        System.out.println(s2.deleteNode(1));
//        System.out.println(s2.deleteNode(1));
//        s2.showData();

//        CircularLinkList s = new CircularLinkList();
//        s.addTail("边");
//        s.addTail("文");
//        s.addTail("凯");
//        s.showData();
//
//        CircularLinkList s1 = new CircularLinkList();
//        s1.addTail("a");
//        s1.addTail("b");
//        s1.addTail("c");
////        s.showData();
//
//        CircularLinkList s3 = new CircularLinkList();
//        s3.mergeLinkList(s1,s);
//        s3.showData();
        DoubleLinkList dl = new DoubleLinkList();
        dl.addTail(10);
        dl.addTail(20);
        dl.addTail(30);
        dl.addTail(40);
//        dl.deleteNode(2);
        dl.insert(3,1);
        dl.showData();


        Stack<Integer> stack = new Stack<Integer>();
    }
}
