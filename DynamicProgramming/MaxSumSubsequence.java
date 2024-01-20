package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSumSubsequence {

    private static long[] memoizedValues;

    public static long findMaxSum(int[] arr, int i, int n) {
        if (i >= n) {
            return 0;
        }

        if (memoizedValues[i] != Long.MIN_VALUE) {
            return memoizedValues[i];
        }
        memoizedValues[i] = Math.max(findMaxSum(arr, i + 1, n), arr[i] + findMaxSum(arr, i + 2, n));
        return memoizedValues[i];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        s = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        memoizedValues = new long[n + 5];
        Arrays.fill(memoizedValues, Long.MIN_VALUE);

        System.out.println(findMaxSum(arr, 0, arr.length));
    }

}
