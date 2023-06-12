package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideAndConquer {
    public static int findLargestNum(int[] arr, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return arr[startIdx];
        }
        int mid = (startIdx + endIdx) / 2;
        int num1 = findLargestNum(arr, startIdx, mid);
        int num2 = findLargestNum(arr, mid + 1, endIdx);
        return Math.max(num1, num2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(findLargestNum(arr, 0, n - 1));
    }
}
