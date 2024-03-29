package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FibonacciNums {
    private static int[] computedValues;

    public static int generateFibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        if (computedValues[n] != -1) {
            return computedValues[n];
        }
        computedValues[n] = generateFibonacci(n - 1) + n;
        return computedValues[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        computedValues = new int[n + 1];
        Arrays.fill(computedValues, -1);
        System.out.println(generateFibonacci(n));
    }
}
