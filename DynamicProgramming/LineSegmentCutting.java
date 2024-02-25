package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LineSegmentCutting {
    private static final int CUT_TYPES = 3;
    private static int[] memoizedValues;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        memoizedValues = new int[n + 1];
        Arrays.fill(memoizedValues, 0);
        int[] possibleCuttings = new int[CUT_TYPES];

        for (int i = 0; i < 3; i++) {
            possibleCuttings[i] = Integer.parseInt(s[i + 1]);
        }

        Arrays.sort(possibleCuttings);

        for (int i = 1; i <= n; i++) {
            for (int cut : possibleCuttings) {
                int diff = i - cut;
                if (diff >= 0 && memoizedValues[diff] != Integer.MIN_VALUE) {
                    memoizedValues[i] = Math.max(memoizedValues[i], 1 + memoizedValues[diff]);
                }
            }
        }
        
        System.out.println(memoizedValues[n]);
    }
}
