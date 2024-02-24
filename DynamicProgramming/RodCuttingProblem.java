package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RodCuttingProblem {
    private static int[] memoizedValues;

    public static int maximizeProfit(int k, int[] arr) {
        if (k <= 0) {
            return 0;
        }
        if (memoizedValues[k] != -1) {
            return memoizedValues[k];
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i <= k; i++) {
            maxProfit = Math.max(arr[i] + maximizeProfit(k - i, arr), maxProfit);
        }
        memoizedValues[k] = maxProfit;
        return memoizedValues[k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = s.length;
        int[] arr = new int[n + 1];
        memoizedValues = new int[n + 5];
        Arrays.fill(memoizedValues, -1);
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
        }

        int k = Integer.parseInt(br.readLine().split(" ")[0]);

        // maximize the profit if i cut the rod into k pieces
        System.out.println(maximizeProfit(k, arr));
    }
}
