package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BalancedParanthesis {
    public static void generateAllBalancedParanthesis(int currIdx, int openCount, int closeCount, int n,
            char[] outputStr) {
        if (currIdx == n*2) {
            System.out.println(Arrays.toString(outputStr));
            return;
        }
        if (openCount == closeCount) {
            outputStr[currIdx] = '(';
            generateAllBalancedParanthesis(currIdx + 1, openCount + 1, closeCount, n, outputStr);
        } else if (openCount > closeCount) {
            if (openCount == n) {
                outputStr[currIdx] = ')';
                generateAllBalancedParanthesis(currIdx + 1, openCount, closeCount + 1, n, outputStr);
            } else {
                outputStr[currIdx] = '(';
                generateAllBalancedParanthesis(currIdx + 1, openCount + 1, closeCount, n, outputStr);
                outputStr[currIdx] = ')';
                generateAllBalancedParanthesis(currIdx + 1, openCount, closeCount + 1, n, outputStr);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] outputStr = new char[n*2];
        generateAllBalancedParanthesis(0, 0, 0, n, outputStr);
    }

}
