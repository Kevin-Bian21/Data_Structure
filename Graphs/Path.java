package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author BianWenKai
 * @DATE 2021/11/16 - 22:20
 **/
public class Path {

    private List<String> nodeList = new ArrayList<>();

    public void add(String node) {
        nodeList.add(node);
    }

    @Override
    public String toString() {
        return Arrays.toString(nodeList.toArray()) ;
    }
}
