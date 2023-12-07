package GraphsPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphRepresentation {
    public static void doBfs(int src, List<Integer> adjacentNodes, boolean[] visitedNodes, Queue<Integer> queue) {
        if (visitedNodes[src]) {
            return;
        }
        queue.add(src);
        visitedNodes[src] = true;
        while (!queue.isEmpty()) {
            int currItem = queue.remove();
            System.out.printf("%d, ", currItem);
            for (int node : adjacentNodes) {
                if (!visitedNodes[node]) {
                    queue.add(node);
                    visitedNodes[node] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        List<Integer>[] graph = new ArrayList[n + 1];

        // graph
        // 1 - [2,3]
        // 2 - [1,3]
        // 3 - [1,,2,4]
        // 4 - [3,5]
        // 5 - [4]

        // degree of a node -> the number of connections that it has to other nodes in
        // the network
        // degree => simply count the edges
        // an edge can contribute to 2 degrees, because, it will connect 2 nodes (so its
        // contribution is seen in 2 nodes)
        // So degree of a graph is 2 * E
        // Space complexity -> n nodes connecting to each other (o(n)2)
        // but in reality it can be calculated as ==> O (v + (2 * E)) ==> O(V + E)
        // time complexity -> looping o(V + E)

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            s = br.readLine().split(" ");
            graph[i].addAll(
                    List.of(Arrays.stream(s).map(item -> Integer.parseInt(item)).toArray(size -> new Integer[size])));
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(graph[i]);
        }

        // BFS
        boolean[] visitedNodes = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            doBfs(i, graph[i], visitedNodes, queue);
        }
    }
}
