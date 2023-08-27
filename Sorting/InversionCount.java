package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InversionCount {
    public static long getInterArrInversionCount(long[] arr, int startIdx1, int endIdx1, int startIdx2, int endIdx2) {
        long count = 0;
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

    public static long getInversionCount(long[] arr, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return 0;
        }
        int mid = (startIdx + endIdx) / 2;
        return getInversionCount(arr, startIdx, mid) + getInversionCount(arr, mid + 1, endIdx)
                + getInterArrInversionCount(arr, startIdx, mid, mid + 1, endIdx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().strip());
        while (T >= 1) {
            int n = Integer.parseInt(br.readLine().strip());
            String[] s = br.readLine().split(" ");
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(s[i]);
            }
            System.out.println(getInversionCount(arr, 0, n - 1));
            T--;
        }
    }
}
