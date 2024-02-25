package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LineSegmentCutting2 {
    private static int[] memoizedValues;

    public static int cutLineSegment(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        if (memoizedValues[n] != Integer.MIN_VALUE) {
            return memoizedValues[n];
        }
        int val1 = 1 + cutLineSegment(n - x, x, y, z);
        int val2 = 1 + cutLineSegment(n - y, x, y, z);
        int val3 = 1 + cutLineSegment(n - z, x, y, z);
        memoizedValues[n] = Math.max(val1, Math.max(val2, val3));
        return memoizedValues[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);

        int x = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);
        int z = Integer.parseInt(s[3]);

        memoizedValues = new int[n + 1];
        Arrays.fill(memoizedValues, Integer.MIN_VALUE);
        int maxCuts = cutLineSegment(n, x, y, z);
        System.out.println(maxCuts < 0 ? 0 : maxCuts);
    }
}
