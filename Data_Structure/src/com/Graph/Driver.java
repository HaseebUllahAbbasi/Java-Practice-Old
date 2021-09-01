package com.Graph;

import com.sort.Bubble.Bubble;

import java.lang.reflect.MalformedParametersException;
import java.util.Map;
import java.util.TreeMap;

public class Driver {
    public static void main(String args[])
    {

        Bubble obj  = new Bubble();
        Map<Object,String>  ok = new TreeMap<>();
        ok.put(1,"ok");

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFS(2);

        System.out.println();
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        g.BFS(2);

    }
}
