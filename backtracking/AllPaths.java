package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AllPaths {
    public static void generateAllPaths(int[][] arr, int i, int j, int m, int n,
            List<Pair<Integer, Integer>> pathTrackList) {

        if (i == m - 1 && j == n - 1) {
            for(Pair<Integer, Integer> p : pathTrackList){
                System.out.println(p.getFirst() + " "+ p.getSecond());
            }
            System.out.println();
            System.out.println();
            return;
        }
        // check next path is valid
        if (j + 1 < n && arr[i][j + 1] != 1) {
            pathTrackList.add(new Pair<Integer, Integer>(i, j + 1));
            generateAllPaths(arr, i, j + 1, m, n, pathTrackList);
            pathTrackList.remove(pathTrackList.size() - 1);
        }

        // check next path is valid
        if (i + 1 < m && arr[i + 1][j] != 1) {
            pathTrackList.add(new Pair<Integer, Integer>(i + 1, j));
            generateAllPaths(arr, i + 1, j, m, n, pathTrackList);
            pathTrackList.remove(pathTrackList.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        List<Pair<Integer, Integer>> pathTrackList = new ArrayList<>();
        pathTrackList.add(new Pair<Integer, Integer>(0, 0));
        generateAllPaths(arr, 0, 0, m, n, pathTrackList);

    }

}

class Pair<F, S> {
    private F x;
    private S y;

    public Pair(F x, S y) {
        this.x = x;
        this.y = y;
    }

    public F getFirst() {
        return this.x;
    }

    public S getSecond() {
        return this.y;
    }
}
