package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StairCaseProblem {
    private static long[] memoizedValues;

    public static long countJumps(int i) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }

        if (memoizedValues[i] != -1) {
            return memoizedValues[i];
        }
        memoizedValues[i] = countJumps(i - 1) + countJumps(i - 2);
        return memoizedValues[i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        memoizedValues = new long[n + 1];
        Arrays.fill(memoizedValues, -1);
        // either i can take 1 unit jump or 2 units jump
        System.out.println(countJumps(n));
    }
}
