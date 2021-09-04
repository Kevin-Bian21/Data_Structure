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
public class HashMap<K,V> implements Map<K,V>{

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
    private int hash(Object key){
        return Math.abs((Integer) key) % entries.length;
    }

    @Override
    public void put(K key, V value) {
        //当有相同的key值进来的时候，只需要更新key对应的value即可，不需要将其往链表后边添加
        Entry entry = getEntry(key);
        if (entry != null){
            entry.value = value;
            return;
        }
        //如果传入的key值没有在桶中，则在对应索引处的桶中创建链表，否则获取key对应的桶
        LinkedList<Entry> bucket = getOrCreateBucket(key);
        //将entry对象加入到索引为index处的数组单元保存的链表末尾。
        bucket.addLast(new Entry(key,value));
    }

    @Override
    public Object get(Object key) {
        Entry entry = getEntry(key);
        return (entry == null) ? null : entry.value;
//        if (entry != null)
//            return entry.value;
//        return null;
    }

    @Override
    public void remove(Object key) {
        Entry entry = getEntry(key);
        if (entry != null)
            getBucket(key).remove(entry);
        throw new IllegalStateException();
    }

    @Override
    public boolean containKey(Object key) {
        LinkedList<Entry> bucket = getBucket(key);
        if (bucket != null){
            for (Entry entry : bucket)
                if (entry.key.equals(key))
                    return true;
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

    /*
    优化代码
    1. 因为方法中很多地方都有获取hash桶的代码，所以将其提取出来单独设置为一个方法
    2. 将获取Entry实体的代码提取出来设置为一个方法
    3.
 */
    private LinkedList<Entry> getBucket(Object key){
        return entries[hash(key)];
    }

    private Entry getEntry(Object key){
        LinkedList<Entry> bucket = getBucket(key);
        if (bucket != null){
            for (Entry entry : bucket){
                if (entry.key.equals(key))
                    return entry;
            }
        }
        return null;
    }

    //如果hash表中的桶已经存了链表则拿到该链表对象，否则给hash表中的空桶桶创建链表
    private LinkedList<Entry> getOrCreateBucket(Object key){
        LinkedList<Entry> bucket = getBucket(key);
        return (bucket == null) ? new LinkedList<>() : bucket;
    }


}
