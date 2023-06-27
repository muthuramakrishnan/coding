package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueens {
    public static boolean canPlaceQueen(boolean[][] arr, int i, int j, int n) {
        int x = i-1;
        while (x >= 0) {
            if (arr[x][j]) {
                return  false;
            }
            x--;
        }

        x = i-1;
        int y = j-1;
        while (y >= 0 & x >= 0) {
            if (arr[x][y]) {
                return false;
            }
            x--;
            y--;
        }

        x = i-1;
        y = j+1;
        while (y < n && x >= 0) {
            if (arr[x][y]) {
                return false;
            }
            x--;
            y++;
        }
        return true;

    }

    public static void placeNQueens(boolean[][] arr, int depthIdx, int n) {
        if (depthIdx == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] ? "Q " : "- ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int j = 0; j < n; j++) {
            if (canPlaceQueen(arr, depthIdx, j, n)) {
                arr[depthIdx][j] = true;
                placeNQueens(arr, depthIdx + 1, n);
                arr[depthIdx][j] = false;
            } 
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n][n];
        placeNQueens(arr, 0, n);
    }
}
