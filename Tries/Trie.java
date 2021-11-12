package Tries;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author BianWenKai
 * @DATE 2021/11/5 - 23:58
 **/

/**
 * trie，也称为数字树或前缀树，是一种搜索树，一种用于从集合中定位特定键的树 数据结构。
 *  例如：cat,can 它的存储结构为 c 为父节点，a 为 c 的子结点，t 和 n 为 a 的子结点
 *   Insert O(L)   : L是Trie的高度
 *   Lookup O(L)
 *   Delete O(L)
 */
public class Trie {
    //26个英文字母
    public static int ENGLISH_ALPHABET_SIZE = 26;

    private class Node {
        private char value;
//        private Node[] child = new Node[ENGLISH_ALPHABET_SIZE];
        private Map<Character, Node> map = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        //判断是否有值为 ch 的节点
        public boolean hasChild(char ch) {
            return map.get(ch) != null;
        }

        public void addChild(char ch) {
            map.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return map.get(ch);
        }

        public Node[] getAllChild () {
            return  map.values().toArray(new Node[0]);
        }

        public void removeChild(char ch) {
            map.remove(ch);
        }

        public boolean hasChild() {
            return !isEmpty();
        }

        public boolean isEmpty() {
            return getAllChild().length == 0;
        }
    }

    private Node root = new Node(' ');

    public void insertInMap(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);

            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contain(String word) {
        if (word == null)
            throw new IllegalArgumentException("arg can't be null");
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traversal () {
        traversal(root);
    }
    private void traversal(Node root) {
        //前序遍历每个节点的子节点
        System.out.println(root.value);
        for (Node child : root.getAllChild()) {
            traversal(child);
            System.out.println("-------");
        }
    }

    public void remove (String word) {
        if (word == null)
            throw new IllegalArgumentException();
        remove(root, word, 0);
    }

    public void remove(Node root, String word, int index) {
        if (index == word.length()) {
            //为了删除，找到该词的词尾并将其 isEndOfWord 属性改为 false
            root.isEndOfWord = false;
            return;
        }
        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, index + 1);

        //当该节点没有子节点并且不为词尾时，可以将其移除
        if (!child.hasChild() && !child.isEndOfWord)
            child.removeChild(ch);
    }

    public List<String> findWords (String prefix) {
        List<String> list = new ArrayList<>();

        Node lastNode = findLastNodeOfPrefix(prefix);

        findWords(lastNode, prefix, list);
        return list;
    }

    private void findWords(Node root, String prefix, List<String> list) {
        if (root == null)
            return ;
        if (root.isEndOfWord)
            list.add(prefix);

        for (Node child : root.getAllChild())
            //递归遍历前缀之后的所有子节点
            findWords(child, prefix + child.value, list);
    }

    private Node findLastNodeOfPrefix(String prefix) {
        if (prefix == null)
            return null;
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.hasChild(ch))
                return null;
            current = current.getChild(ch);
        }
        return current;
    }















//    public void insertInArray(String word) {
//        Node current = root;
//        for (char ch : word.toCharArray()) {
//            //索引为字符 ch 相对于 a 的偏移量
//            int index = ch - 'a';
//            if (current.child[index] == null)
//                current.child[index] = new Node(ch);
//            current = current.child[index];
//        }
//        current.isEndOfWord = true;
//    }


}
