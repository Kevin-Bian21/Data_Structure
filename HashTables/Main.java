package HashTables;

/**
 * @author BianWenKai
 * @DATE 2021/9/3 - 15:35
 **/

/*
    哈希表（Hash Table）：也叫散列表，是根据关键码值（Key-Value）而直接进行访问的数据结构，也就是我们常用到的map。
    哈希函数：也称为是散列函数，是Hash表的映射函数，它可以把任意长度的输入变换成固定长度的输出，
    该输出就是哈希值。哈希函数能使对一个数据序列的访问过程变得更加迅速有效，通过哈希函数数据元素能够被很快的进行定位。
    若关键字为k，则其值存放在f(k)的存储位置上。
 */
/*
    解决hash 碰撞：
    1. 让数组中的每个单元格指向一个链接列表，不把值存储到数组本身，而是存储到链表中
    2. 找另一个地方来存储碰撞的值（开放寻址算法）
 */
public class Main {

    public static void main(String[] args) {
        FindCharacter findCharacter = new FindCharacter();
        //{ =2, p=2, a=2, r=1, e=3, g=1, l=1, n=1}
        char ch = findCharacter.findFirstNonRepeatingCharAdvance("a green apple");
        System.out.println(ch);
        char ch1 = findCharacter.findFirstRepeatedChar("green apple");
        System.out.println(ch1);

        String a = new String("a") ;
        String b = "b";

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

//        Map<String,String> map = new HashMap<>();

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"边");
        map.put(3,"文");
        map.put(6,"凯");
        map.put(9,null);
        map.put(9,"A");
        map.put(11,"B");
        map.put(0,"C");
        System.out.println(map.get(9));
//        map.remove(2);
        System.out.println(map.get(0));
        System.out.println(map.containKey(11));
        System.out.println(map.containValue(""));
    }
}
