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

public class GraphBfs_ShortestDistance {

    public static void doBfs(List<List<Integer>> graph, int i, Queue<Pair<Integer, Integer>> queue,
            Set<Integer> visitedNodes) {
        int length = 0;
        Pair<Integer, Integer> pair = new Pair<>(i, 0);
        queue.add(pair);
        visitedNodes.add(i);
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> currPair = queue.remove();
            int currElem = currPair.first;
            int currLen = currPair.second;
            List<Integer> adjacencyList = graph.get(currElem - 1);
            System.out.printf("Elem: %d, Length: %d \n", currElem, currLen);
            boolean isNewLevel = false;
            for (int adjacentElem : adjacencyList) {
                if (!visitedNodes.contains(adjacentElem)) {
                    isNewLevel = true;
                    visitedNodes.add(adjacentElem);
                    queue.add(new Pair<>(adjacentElem, length + 1));
                }
            }
            if (isNewLevel) {
                length++;
            }
        }
    }

    // graph
    // 1 - [2,3]
    // 2 - [1,3]
    // 3 - [1,,2,4]
    // 4 - [3,5]
    // 5 - [4]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            List<Integer> adjacencyList = List
                    .of(Arrays.stream(s).map(item -> Integer.parseInt(item)).toArray(size -> new Integer[size]));
            graph.add(adjacencyList);
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Set<Integer> visitedNodes = new HashSet<>();
        doBfs(graph, k, queue, visitedNodes);
    }

    static class Pair<T, S> {
        T first;
        S second;

        Pair(T first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
