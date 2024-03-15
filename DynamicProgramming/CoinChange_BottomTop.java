package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChange_BottomTop {
    private static int[][] memoizedValues;

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

        for (int i = 0; i < denomLen; i++) {
            memoizedValues[i][0] = 1;
        }

        for (int denom = 0; denom < denomLen; denom++) {
            for (int currAmt = 0; currAmt <= totalAmt; currAmt++) {
                int componentA = 0;
                int componentB = 0;

                if (currAmt == 0 && denom - 1 < 0) {
                    componentA = 1;
                } else if (denom - 1 < 0) {
                    componentA = 0;
                }
                else{
                    componentA = memoizedValues[denom - 1][currAmt];
                }

                if (currAmt - denoms[denom] < 0) {
                    componentB = 0;
                }
                else{
                    componentB = memoizedValues[denom][currAmt - denoms[denom]];
                }

                memoizedValues[denom][currAmt] = componentA + componentB;

            }
        }

        System.out.println(memoizedValues[denomLen - 1][totalAmt]);
    }
}
