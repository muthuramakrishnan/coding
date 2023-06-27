package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllPaths1 {
    public static int getAllPaths(int[][] arr, int i1, int j1, int i2, int j2, int m, int n, boolean[][] visited) {
        if (i1 == i2 && j1 == j2) {
            return 1;
        }
        int paths = 0;
        if (i1 + 1 < m && arr[i1 + 1][j1] != -1 && !visited[i1 + 1][j1]) {
            visited[i1 + 1][j1] = true;
            paths += getAllPaths(arr, i1 + 1, j1, i2, j2, m, n, visited);
            visited[i1 + 1][j1] = false;
        }
        if (j1 + 1 < n && arr[i1][j1 + 1] != -1 && !visited[i1][j1 + 1]) {
            visited[i1][j1 + 1] = true;
            paths += getAllPaths(arr, i1, j1 + 1, i2, j2, m, n, visited);
            visited[i1][j1 + 1] = false;
        }
        if (i1 - 1 >= 0 && arr[i1 - 1][j1] != -1 && !visited[i1 - 1][j1]) {
            visited[i1 - 1][j1] = true;
            paths += getAllPaths(arr, i1 - 1, j1, i2, j2, m, n, visited);
            visited[i1 - 1][j1] = false;
        }
        if (j1 - 1 >= 0 && arr[i1][j1 - 1] != -1 && !visited[i1][j1 - 1]) {
            visited[i1][j1 - 1] = true;
            paths += getAllPaths(arr, i1, j1 - 1, i2, j2, m, n, visited);
            visited[i1][j1 - 1] = false;
        }
        return paths;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        s = br.readLine().split(" ");
        int i1 = Integer.parseInt(s[0]);
        int j1 = Integer.parseInt(s[1]);
        int i2 = Integer.parseInt(s[2]);
        int j2 = Integer.parseInt(s[3]);
        boolean[][] isVisited = new boolean[m][n];
        System.out.println(getAllPaths(arr, i1, j1, i2, j2, m, n, isVisited));
    }
}