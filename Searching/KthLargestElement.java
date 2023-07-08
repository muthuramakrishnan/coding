package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthLargestElement {
    public static int findCount(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                count++;
            }
        }
        return count;
    }

    public static int findKthLargestElement(int[] arr, int k, int max, int min) {
        int low = min;
        int high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int lessOrEqElemCount = findCount(arr, mid);
            if (lessOrEqElemCount < k) {
                low = mid + 1;
            } else {
                int lessOrEqElementForMidMinus1 = findCount(arr, mid - 1);
                if (lessOrEqElementForMidMinus1 < k) {
                    return mid;
                } else {
                    high = mid - 1;
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
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        int k = Integer.parseInt(br.readLine());
        System.out.println(findKthLargestElement(arr, k, max, min));
    }
}