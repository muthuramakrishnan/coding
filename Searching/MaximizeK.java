package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximizeK {
    public static boolean doesWindowSizeExceedsGivenX(int[] arr, int windowSize, int x) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < windowSize; i++) {
            sum += arr[i];
        }
        if (sum > x) {
            return true;
        }
        for (int i = windowSize; i < n; i++) {
            sum += arr[i];
            sum -= arr[i - windowSize];
            if (sum > x) {
                return true;
            }
        }
        return false;
    }

    public static int findMaxK(int[] arr, int x) {
        int n = arr.length;
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (doesWindowSizeExceedsGivenX(arr, mid, x)) {
                high = mid - 1;
            } else {
                if (doesWindowSizeExceedsGivenX(arr, mid + 1, x)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        int x = Integer.parseInt(br.readLine());
        System.out.println(findMaxK(arr, x));
    }
}