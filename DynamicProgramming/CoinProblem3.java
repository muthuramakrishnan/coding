package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinProblem3 {

    private static int[] memoizedValues;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int totalMoney = Integer.parseInt(s[0]);
        int denomLen = Integer.parseInt(s[1]);

        int[] denoms = new int[denomLen];
        s = br.readLine().split(" ");

        for (int i = 0; i < denomLen; i++) {
            denoms[i] = Integer.parseInt(s[i]);
        }

        memoizedValues = new int[totalMoney + 1];
        memoizedValues[0] = 0;
        for (int i = 1; i <= totalMoney; i++) {
            memoizedValues[i] = Integer.MAX_VALUE;
            for (int j = 0; j < denomLen; j++) {
                if (i - denoms[j] < 0) {
                    continue;
                }
                memoizedValues[i] = (int) Math.min((long) memoizedValues[i], (long) 1 + memoizedValues[i - denoms[j]]);
            }
        }
        System.out.println(memoizedValues[totalMoney] == Integer.MAX_VALUE ? -1 : memoizedValues[totalMoney]);
    }
}
