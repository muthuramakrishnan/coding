package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InversionCount {
    public static int getInterArrInversionCount(int[] arr, int startIdx1, int endIdx1, int startIdx2, int endIdx2) {
        int count = 0;
        Arrays.sort(arr, startIdx1, endIdx1 + 1);
        Arrays.sort(arr, startIdx2, endIdx2 + 1);
        while (startIdx1 <= endIdx1 && startIdx2 <= endIdx2) {
            if (arr[startIdx1] > arr[startIdx2]) {
                count += endIdx1 - startIdx1 + 1;
                startIdx2++;
            } else {
                startIdx1++;
            }
        }
        return count;
    }

    public static int getInversionCount(int[] arr, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return 0;
        }
        int mid = (startIdx + endIdx) / 2;
        return getInversionCount(arr, startIdx, mid) + getInversionCount(arr, mid + 1, endIdx)
                + getInterArrInversionCount(arr, startIdx, mid, mid + 1, endIdx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        // arr[i] > arr[j]
        // i < j
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(getInversionCount(arr, 0, n - 1));
    }
}
