package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LexicographicSubsets {
    public static void printLexicographicSubsets(String[] ipString, int n, char[] outputStr, int inputCurrElIdx,
            int outputCurrElIdx) {
        for (int i = 0; i < outputCurrElIdx; i++) {
            System.out.print(outputStr[i] + " ");
        }
        System.out.println();
        if (inputCurrElIdx == n) {
            return;
        }
        for (int i = inputCurrElIdx; i < n; i++) {
            outputStr[outputCurrElIdx] = ipString[i].charAt(0);
            printLexicographicSubsets(ipString, n, outputStr, i + 1, outputCurrElIdx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ipString = br.readLine().split(" ");
        int n = ipString.length;
        char[] outputStr = new char[n];
        printLexicographicSubsets(ipString, n, outputStr, 0, 0);
    }
}