package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintAllPermutationsLexicographically {

    public static void rotateBy1Unit(char[] ipString, int startIdx, int endIdx) {
        char temp = ipString[endIdx];
        for (int i = endIdx - 1; i >= startIdx; i--) {
            ipString[i + 1] = ipString[i];
        }
        ipString[startIdx] = temp;
    }

    public static void printAllPermutationsLexicographically(char[] ipString, int n, int depthIdx) {
        if (depthIdx == n) {
            for (int i = 0; i < depthIdx; i++) {
                System.out.print(ipString[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = depthIdx; i < n; i++) {
            rotateBy1Unit(ipString, depthIdx, i);
            printAllPermutationsLexicographically(ipString, n, depthIdx + 1);
            rotateBy1Unit(ipString, depthIdx, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        char[] ipString = new char[n];
        for (int i = 0; i < n; i++) {
            ipString[i] = s[i].charAt(0);
        }
        printAllPermutationsLexicographically(ipString, n, 0);
    }

}
