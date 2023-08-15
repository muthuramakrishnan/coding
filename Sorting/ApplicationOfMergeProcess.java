package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ApplicationOfMergeProcess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        int[] res = new int[n];

        int p = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);

        }
        for (int i = 0; i < n; i++) {
            if (p == -1 && arr[i + 1] >= 0 && arr[i] < 0) {
                p = i;
            }
            arr[i] *= arr[i];
        }

        int q = p + 1;
        int resIdx = 0;
        while (p >= 0 && q < n) {
            if (arr[p] < arr[q]) {
                res[resIdx] = arr[p];
                p--;
            } else {
                res[resIdx] = arr[q];
                q++;
            }
            resIdx++;
        }

        for (; p >= 0;) {
            res[resIdx++] = arr[p--];
        }
        for (; q < n;) {
            res[resIdx++] = arr[q++];
        }
        System.out.println(Arrays.toString(res));

    }

}
