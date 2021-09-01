package Queue;


/**
 * @author BianWenKai
 * @DATE 2021/9/1 - 18:44
 **/
public class Main {

    public static void main(String[] args) {
        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<Integer>();
        queue.add(3);
        queue.add(6);
        queue.add(9);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        System.out.println(queue.element());
        System.out.println(queue.remove());
        System.out.println(queue.getCapacity());
        System.out.println(queue.getSize());
        System.out.println(queue.toString());


    }



}
