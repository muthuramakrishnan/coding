package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthElementInaMatrix {
    public static int findEleLessEq(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= k) {
                low = mid + 1;
            } else {
                if (mid <= 0 || arr[mid - 1] < k) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return low;
    }

    public static int findKthElemInMatrix(int[][] arr, int k, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            int lessEqElCount = 0;
            int lessEqElCountOfMinus1 = 0;
            for (int[] row : arr) {
                lessEqElCount += findEleLessEq(row, mid);
                lessEqElCountOfMinus1 += findEleLessEq(row, mid - 1);
            }
            if (lessEqElCount >= k && lessEqElCountOfMinus1 < k) {
                return mid;
            } else {
                if (lessEqElCount < k) {
                    low = mid + 1;
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
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int[][] arr = new int[m][n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                max = Math.max(arr[i][j], max);
                min = Math.min(arr[i][j], min);
            }
        }
        int k = Integer.parseInt(br.readLine());
        System.out.println(findKthElemInMatrix(arr, k, min, max));
    }
}
