package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinChange_NumberOfWays {
    private static int[][] memoizedValues;

    public static int findWays(int[] denoms, int currIdx, int currAmt, int totalAmt) {

        if (totalAmt == currAmt) {
            return 1;
        }
        if (currAmt > totalAmt) {
            return 0;
        }
        if (currIdx == denoms.length) {
            return 0;
        }

        if (memoizedValues[currIdx][currAmt] != -1) {
            return memoizedValues[currIdx][currAmt];
        }

        // either i can stay at the current index - which means i'm going to take the
        // current denomination more than once.
        // or i can move it to the next denomination
        memoizedValues[currIdx][currAmt] = findWays(denoms, currIdx + 1, currAmt, totalAmt)
                + findWays(denoms, currIdx, currAmt + denoms[currIdx], totalAmt);
        return memoizedValues[currIdx][currAmt];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int denomLen = s.length;
        int[] denoms = new int[denomLen];
        for (int i = 0; i < denomLen; i++) {
            denoms[i] = Integer.parseInt(s[i]);
        }

        int totalAmt = Integer.parseInt(br.readLine().strip());
        memoizedValues = new int[denomLen][totalAmt + 1];

        for (int denomination = 0; denomination < denomLen; denomination++) {
            for (int cachedValue = 0; cachedValue <= totalAmt; cachedValue++) {
                memoizedValues[denomination][cachedValue] = -1;
            }
        }

        int currIdx = 0;
        int currAmt = 0;
        int ways = findWays(denoms, currIdx, currAmt, totalAmt);
        System.out.println(ways);
    }
}
