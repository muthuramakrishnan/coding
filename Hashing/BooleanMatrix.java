package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BooleanMatrix {
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

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> diagonal1Set = new HashSet<>();
        Set<Integer> diagonal2Set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    rowSet.add(i);
                    columnSet.add(j);
                    diagonal1Set.add(i - j);
                    diagonal2Set.add(i + j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            boolean foundRow = rowSet.contains(i);
            for (int j = 0; j < n; j++) {
                boolean foundColumn = columnSet.contains(j);
                boolean foundDialognal1 = diagonal1Set.contains(i - j);
                boolean foundDialognal2 = diagonal2Set.contains(i + j);
                if (foundRow || foundColumn || foundDialognal1 || foundDialognal2) {
                    arr[i][j] = 1;
                }
            }
        }

        for(int i=0; i<m; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }

}
