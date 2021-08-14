package Array;

/**
 * @author BianWenKai
 * @DATE 2021/8/14 - 22:29
 **/
public class Main {
    public static void main(String[] args) {
        // Vector : 扩容100%，只能用在单线程中
        // ArrayList ： 扩容50%


        Array array = new Array(3);
        array.add("边");
        array.add("文");
        array.add("凯");
        array.add(2);
        array.remove(3);
        array.add(null);
        array.showData();
        System.out.println(array.indexOf(null));

    }

}
