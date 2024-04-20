package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[start];
        int l = start + 1;
        int r = end;

        while (l <= r) {
            while (l<=end && arr[l] <= pivot) {
                l++;
            }
            while (r>=start+1 && arr[r] > pivot) {
                r--;
            }
            if (l <= r) {
                swap(arr, l, r);
            }
        }
        swap(arr, start, r);
        return r;
    }

    public static void quickSort(int[] arr, int start, int end) {
        int n = arr.length;
        if (start < end) {
            int mid = partition(arr, start, end);
            if (mid - 1 >= 0) {
                quickSort(arr, start, mid - 1);
            }
            if (mid + 1 <= n - 1) {
                quickSort(arr, mid + 1, end);
            }
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
        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
}
