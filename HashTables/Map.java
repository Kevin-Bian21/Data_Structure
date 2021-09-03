package HashTables;

/**
 * @author BianWenKai
 * @DATE 2021/9/3 - 15:11
 **/
public interface Map<K,V> {

    void put(K key,V value);

    V get(K key);

    void remove(K key);

    boolean containKey(K key);  //O(1)

    boolean containValue(V value);  //O(n)

}
