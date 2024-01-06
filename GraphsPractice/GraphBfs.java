package GraphsPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphBfs {

    public static void doBfs(List<List<Integer>> graph, int i, Queue<Integer> queue, Set<Integer> visitedNodes) {
        if (visitedNodes.contains(i)) {
            return;
        }
        visitedNodes.add(i);
        queue.add(i);
        while (!queue.isEmpty()) {
            int element = queue.remove();
            List<Integer> adjacencyList = graph.get(element - 1);
            System.out.printf("%d, ", element);
            for (int adjacentElem : adjacencyList) {
                if (!visitedNodes.contains(adjacentElem)) {
                    visitedNodes.add(adjacentElem);
                    queue.add(adjacentElem);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("new Program");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            List<Integer> adjacencyList = List
                    .of(Arrays.stream(s).map(item -> Integer.parseInt(item)).toArray(size -> new Integer[size]));
            graph.add(adjacencyList);
        }

        // graph
        // 1 - [2,3]
        // 2 - [1,3]
        // 3 - [1,,2,4]
        // 4 - [3,5]
        // 5 - [4]

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedNodes = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            doBfs(graph, 1, queue, visitedNodes);
        }
    }
}
