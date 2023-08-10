package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GregAndArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int nNumbers = Integer.parseInt(s[0]);
        int mOperations = Integer.parseInt(s[1]);
        int mOperationsCopy = mOperations;
        int kQueries = Integer.parseInt(s[2]);

        long[] arr = new long[nNumbers + 1];
        s = br.readLine().split(" ");
        for (int i = 1; i <= nNumbers; i++) {
            arr[i] = Long.parseLong(s[i - 1]);
        }

        Map<Integer, List<Integer>> operations = new HashMap<>();
        int counter = 1;
        while (mOperationsCopy >= 1) {
            s = br.readLine().split(" ");
            List<Integer> value = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                value.add(Integer.parseInt(s[i]));
            }
            operations.put(counter, value);
            mOperationsCopy--;
            counter++;
        }

        int[] multiplier = new int[mOperations + 1];
        while (kQueries >= 1) {
            s = br.readLine().split(" ");
            int startIdx = Integer.parseInt(s[0]);
            int endIdx = Integer.parseInt(s[1]);
            multiplier[startIdx]++;
            if (endIdx < mOperations) {
                multiplier[endIdx + 1]--;
            }
            kQueries--;
        }

        for (int i = 2; i <= mOperations; i++) {
            multiplier[i] += multiplier[i - 1];
        }

        long[] prefixSum = new long[nNumbers + 1];
        for (int i = 1; i <= mOperations; i++) {
            List<Integer> idxValueList = operations.get(i);
            int startIdx = idxValueList.get(0);
            int endIdx = idxValueList.get(1);
            int value = idxValueList.get(2);
            prefixSum[startIdx] += (long)multiplier[i] * value;
            if (endIdx < nNumbers) {
                prefixSum[endIdx + 1] -= (long)multiplier[i] * value;
            }
        }

        for (int i = 2; i <= nNumbers; i++) {
            prefixSum[i] += prefixSum[i - 1];
            arr[i] += prefixSum[i];
        }

        arr[1] += prefixSum[1];
        for (int i = 1; i <= nNumbers; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
