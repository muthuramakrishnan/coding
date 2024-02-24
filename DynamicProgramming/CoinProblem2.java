package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinProblem2 {
    private static long[] memoizedValues;

    public static long findMinCoins(int[] coins, int currAmt, int m, int total) {
        if (currAmt == total) {
            return 0;
        }
        if (currAmt > total || currAmt < 0) {
            return Long.MAX_VALUE;
        }
        if (memoizedValues[currAmt] != -1) {
            return memoizedValues[currAmt];
        }

        long minCoinsRequired = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            minCoinsRequired = Math.min(findMinCoins(coins, currAmt + coins[i], m, total), minCoinsRequired);
        }
        memoizedValues[currAmt] = minCoinsRequired == Long.MAX_VALUE ? Long.MAX_VALUE : 1 + minCoinsRequired;
        return memoizedValues[currAmt];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int m = Integer.parseInt(s[0]);
        int total = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        int[] coins = new int[m];
        for (int i = 0; i < m; i++) {
            coins[i] = Integer.parseInt(s[i]);
        }
        memoizedValues = new long[total + 5];
        Arrays.fill(memoizedValues,-1);
        long minCoinsRequired = findMinCoins(coins, 0, m, total);
        System.out.println(minCoinsRequired == Long.MAX_VALUE ? -1 : minCoinsRequired);
    }
}
