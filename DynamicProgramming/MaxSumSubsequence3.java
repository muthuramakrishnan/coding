package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSumSubsequence3 {

    // private static long[] memoizedValues;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        s = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        // memoizedValues = new long[n + 5];
        // Arrays.fill(memoizedValues, Long.MIN_VALUE);

        // memoizedValues[0] = Math.max(arr[0], 0);
        // memoizedValues[1] = Math.max(memoizedValues[0], arr[1]);

        int first = Math.max(arr[0], 0);
        if (n == 1) {
            System.out.println(first);
            System.exit(0);
        }
        int second = Math.max(arr[1], first);

        for (int i = 2; i < n; i++) {
            // memoizedValues[i] = Math.max(memoizedValues[i - 1], arr[i] + memoizedValues[i
            // - 2]);
            int current = Math.max(arr[i] + first, second);
            first = second;
            second = current;
        }
        // System.out.println(memoizedValues[n - 1]);
        System.out.println(second);
    }

}
