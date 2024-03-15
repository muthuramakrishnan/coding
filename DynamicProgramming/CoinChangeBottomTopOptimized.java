package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChangeBottomTopOptimized {
    private static int[] memoizedValues;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int denomLen = s.length;
        int[] denoms = new int[denomLen];
        for (int i = 0; i < denomLen; i++) {
            denoms[i] = Integer.parseInt(s[i]);
        }

        int totalAmt = Integer.parseInt(br.readLine().strip());
        memoizedValues = new int[totalAmt + 1];

        memoizedValues[0] = 1;

        for (int denom = 0; denom < denomLen; denom++) {
            for (int currAmt = 1; currAmt <= totalAmt; currAmt++) {
                if (currAmt - denoms[denom] >= 0) {
                    memoizedValues[currAmt] += memoizedValues[currAmt - denoms[denom]];
                }

            }
        }

        System.out.println(memoizedValues[totalAmt]);
    }
}
