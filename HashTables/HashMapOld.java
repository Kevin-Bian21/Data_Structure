package HashTables;

import java.util.LinkedList;

/**
 * @author BianWenKai
 * @DATE 2021/9/3 - 14:55
 **/

/*
    key通过hash Function来将value存储到内存中的相应位置，当我们要查找相应的value时，
    只需将key传入，哈希表会将员工编号传递给hash函数，找到value的存储位置并返回。
    Insert O(1)
    Delete O(1)
    LookUp O(1)
    但有时也会出现这些操作是O(n)的情况。
    哈希映射允许键和值为 null 的情况
 */
public class HashMapOld<K,V> implements Map<K,V>{

    private class Entry{
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[10];


    //哈希函数
    public int hash(Object key){
        return Math.abs((Integer) key) % entries.length;
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        //当有相同的key值进来的时候，只需要更新key对应的value即可，不需要将其往链表后边添加
        for (Entry entry : entries[index]){
            if (key == entry.key){
                entry.value = value;
                return ;
            }
        }
        //将entry对象加入到索引为index处的数组单元保存的链表末尾。
        entries[index].addLast(new Entry(key,value));
    }

    @Override
    public Object get(Object key) {
        int index = hash(key);
        if (entries[index] != null) {
            for (Entry entry : entries[index])
                if (entry.key == key)
                    return entry.value;
        }
        return null;
    }

    @Override
    public void remove(Object key) {
        int index = hash(key);
        if (entries[index] != null) {
            for (Entry entry : entries[index]){
                if (entry.key == key){
                    entries[index].remove(entry);
                    return;
                }
            }
        }else
            throw new IllegalStateException("Not Found");
    }

    @Override
    public boolean containKey(Object key) {
        int index = hash(key);
        if (entries[index] != null){
            for (Entry entry : entries[index]){
                if (entry.key.equals(key))
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean containValue(Object value) {
        for (LinkedList<Entry> list : entries)  {
            if (list != null) {
                for (Entry entry : list)
                    if (entry.value.equals(value))
                        return true;
            }
        }
        return false;
    }
}
