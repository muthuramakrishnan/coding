package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] arr, int startIdx1, int endIdx1, int startIdx2, int endIdx2) {
        int m = endIdx1 - startIdx1 + 1;
        int n = endIdx2 - startIdx2 + 1;

        int[] resArr = new int[m + n];
        int resIdx = 0;
        while (startIdx1 <= endIdx1 && startIdx2 <= endIdx2) {
            if (arr[startIdx1] < arr[startIdx2]) {
                resArr[resIdx] = arr[startIdx1];
                startIdx1++;
            } else {
                resArr[resIdx] = arr[startIdx2];
                startIdx2++;
            }
            resIdx++;
        }
        while (startIdx1 <= endIdx1) {
            resArr[resIdx++] = arr[startIdx1++];
        }
        while (startIdx2 <= endIdx2) {
            resArr[resIdx++] = arr[startIdx2++];
        }

        return resArr;
    }

    public static void mergeSort(int[] arr, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return;
        }
        int mid = (startIdx + endIdx) / 2;
        mergeSort(arr, 0, mid);
        mergeSort(arr, mid + 1, endIdx);
        int[] resArr = merge(arr, startIdx, mid, mid + 1, endIdx);
        int resIdx = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            arr[i] = resArr[resIdx];
            resIdx++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        mergeSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

}
