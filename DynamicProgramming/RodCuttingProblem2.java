package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RodCuttingProblem2 {

    private static int[] memoizedValues;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = s.length;
        memoizedValues = new int[n + 1];
        int[] prices = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prices[i] = Integer.parseInt(s[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                memoizedValues[i] = Math.max(prices[j] + memoizedValues[i - j], memoizedValues[i]);
            }
        }

        System.out.println(memoizedValues[n]);
    }
}
