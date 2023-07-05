package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareRoot {
    public static int findSqrt(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid == n || mid * mid < n && (mid + 1) * (mid + 1) > n) {
                return mid;
            } else if (mid * mid > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(findSqrt(n));
    }
}
