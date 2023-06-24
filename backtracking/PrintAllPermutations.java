package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Permutation you need to pick all the elements
//permutation is a re-arrangement

//ABC
//BAC
//BCA
//BAC
//ACB
//CBA

public class PrintAllPermutations {
    public static void swap(char[] ipString, int idx1, int idx2) {
        char temp = ipString[idx1];
        ipString[idx1] = ipString[idx2];
        ipString[idx2] = temp;
    }

    public static void printAllPermutations(char[] ipString, int n, int depthIdx) {
        if (n == depthIdx) {
            for (int i = 0; i < n; i++) {
                System.out.print(ipString[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = depthIdx; i < n; i++) {
            swap(ipString, depthIdx, i);
            printAllPermutations(ipString, n, depthIdx + 1);
            swap(ipString, depthIdx, i);
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
        printAllPermutations(ipString, n, 0);
    }
}
