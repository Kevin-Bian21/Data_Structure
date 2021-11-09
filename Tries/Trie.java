package Tries;

/**
 * @author BianWenKai
 * @DATE 2021/11/5 - 23:58
 **/

/**
 * trie，也称为数字树或前缀树，是一种搜索树，一种用于从集合中定位特定键的树 数据结构。
 *  例如：cat,can 它的存储结构为 c 为父节点，a 为 c 的子结点，t 和 n 为 a 的子结点
 */
public class Trie {
    //26个英文字母
    public static int ENGLISH_ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private Node[] child = new Node[ENGLISH_ALPHABET_SIZE];
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private Node root = new Node(' ');
    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            //索引为相对于 a 的偏移量
            int index = ch - 'a';
            if (current.child[index] == null)
                current.child[index] = new Node(ch);
            current = current.child[index];
        }
        current.isEndOfWord = true;
    }
}
