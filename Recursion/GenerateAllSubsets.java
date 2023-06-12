package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateAllSubsets {
    public static void generateAllSubsets(int[] arr, int currentElIdx, int[] outputArr, int depthCounterIdx) {
        if (depthCounterIdx == arr.length) {
            for (int i = 0; i < currentElIdx; i++) {
                System.out.print(outputArr[i]);
            }
            System.out.println();
            return;
        }
        // choose it
        outputArr[currentElIdx] = arr[depthCounterIdx];
        generateAllSubsets(arr, currentElIdx + 1, outputArr, depthCounterIdx + 1);

        // not choose it
        generateAllSubsets(arr, currentElIdx, outputArr, depthCounterIdx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] outputArr = new int[n];
        int depthCounterIdx = 0;
        int currentElIdx = 0;
        generateAllSubsets(arr, currentElIdx, outputArr, depthCounterIdx);
    }
}
