package GraphsPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepthFirstSearch {

    public static void doDfs(int idx, List<List<Integer>> graph, Set<Integer> visitedSet){
        if(visitedSet.contains(idx)){
            return;
        }
        visitedSet.add(idx);
        System.out.printf("%d, ", idx);
        List<Integer> adjacencyList = graph.get(idx);
        for(int adjacentItem : adjacencyList){
            doDfs(adjacentItem, graph, visitedSet);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            graph.add(
                    List.of(Arrays.stream(s).map((item) -> Integer.parseInt(item)).toArray(size -> new Integer[size])));
        }

        Set<Integer> visitedSet = new HashSet<>();
        for (int i = 0; i < graph.size(); i++) {
            doDfs(0, graph, visitedSet);
        }
    }
}
