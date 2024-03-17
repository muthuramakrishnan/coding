package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

    private static int memoizedValues[][];

    public static int findCommonSubSequenceLen(String s1, String s2, int x, int y, int m, int n) {
        if (x < 0 || y < 0) {
            return 0;
        }

        char char1 = s1.charAt(x);
        char char2 = s2.charAt(y);

        if (memoizedValues[x][y] != -1) {
            return memoizedValues[x][y];
        }

        if (char1 == char2) {
            memoizedValues[x][y] = 1 + findCommonSubSequenceLen(s1, s2, x - 1, y - 1, m, n);
        } else {
            memoizedValues[x][y] = Math.max(
                    findCommonSubSequenceLen(s1, s2, x - 1, y, m, n),
                    findCommonSubSequenceLen(s1, s2, x, y - 1, m, n));
        }
        return memoizedValues[x][y];
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        memoizedValues = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memoizedValues[i][j] = -1;
            }
        }
        int x = m - 1;
        int y = n - 1;
        return findCommonSubSequenceLen(s1, s2, x, y, m, n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(longestCommonSubsequence(s1, s2));

    }
}
