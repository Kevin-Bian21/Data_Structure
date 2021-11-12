package Tries;

/**
 * @author BianWenKai
 * @DATE 2021/11/9 - 22:38
 **/
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertInMap("tree");
        trie.insertInMap("trie");
        trie.insertInMap("tries");
        System.out.println();

//        trie.remove("tries");
        trie.traversal();
        System.out.println("============================");
        System.out.println(trie.contain("tries"));
        System.out.println("============================");


        System.out.println(trie.findWords("hello"));

    }
}
