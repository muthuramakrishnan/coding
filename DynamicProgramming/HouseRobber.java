package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HouseRobber {
    public static int robHouse(int[] houseArr) {
        int n = houseArr.length;
        int val1 = houseArr[0];
        if (n < 2) {
            return val1;
        }
        int val2 = Math.max(val1, houseArr[1]);

        for (int i = 2; i < n; i++) {
            int val3 = Math.max(houseArr[i] + val1, val2);
            val1 = val2;
            val2 = val3;
        }
        return val2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int[] prefixRemovedArr = new int[n - 1];
        int[] suffixRemovedArr = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            prefixRemovedArr[i] = arr[i + 1];
            suffixRemovedArr[i] = arr[i];
        }
        System.out.println(Math.max(robHouse(suffixRemovedArr), robHouse(prefixRemovedArr)));
    }
}
