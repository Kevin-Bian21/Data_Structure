package Array;

/**
 * @author BianWenKai
 * @DATE 2021/8/14 - 21:22
 **/
public class Array {

    private Object[] items;
    private int count;

    public Array(int length){
        this.items = new Object[length];
        this.count = 0;
    }

    public void add(Object data){
        //如果数组满了就创建一个容量是之前两倍的新数组，然后将之前的数组元素copy进去
        if (items.length == count) {
            Object[] newItems = new Object[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count] = data;
        count ++;
    }

    public void remove(int index){
        if (index < 0 || index >= count)
            throw new IllegalArgumentException("Illegal Capacity");
        for (int i = index; i < count; i++)
            items[i] = items[i+1];
        count --;
    }

    public int indexOf(Object data){
        if (data == null) {
            for (int i = 0; i < count; i++) {
                if (items[i] == null)
                    return i;
            }
        }else {
            for (int i = 0; i < count; i++) {
                if (items[i].equals(data))
                    return i;
            }
        }
        return -1;
    }

    public void showData(){
        for (int i = 0; i < count; i++) {
            System.out.print(items[i]+"  ");
        }
        System.out.println();
        System.out.println("count:"+count);
    }

}
