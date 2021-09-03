package HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author BianWenKai
 * @DATE 2021/9/3 - 15:31
 **/

public class FindCharacter {

    /*
    给一个字符串，找出字符串中没有重复的第一个字符
    eg："a green apple"
    第一个没有重复的字符是 g
    */
    public char findFirstNonRepeatingCharAdvance(String str){
        char[] charArray = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char ch: charArray){
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch,count+1);
        }
        for (char ch: charArray){
            if (map.get(ch) == 1)
                return ch;
        }
        return Character.MIN_VALUE;
    }

    public char findFirstNonRepeatingChar(String str){
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (char ch: str.toCharArray()){
            if (map.containsKey(ch)){
                count = map.get(ch);
                map.put(ch,count+1);
            }else {
                map.put(ch,1);
            }
        }
        System.out.println(map);
        for (char ch: str.toCharArray()){
            if (map.get(ch) == 1)
                return ch;
        }
        return ' ';
    }

    //找出第一个重复的字符
    public char findFirstRepeatedChar(String str){
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
