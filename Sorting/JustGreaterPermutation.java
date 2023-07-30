package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JustGreaterPermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int descBrokeAt = -1;
        for (int i = n - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {
                continue;
            } else {
                descBrokeAt = i - 1;
                break;
            }
        }

        int justGreaterElIdx = -1;
        for (int i = descBrokeAt + 1; i < n; i++) {
            if (arr[i] > arr[descBrokeAt]) {
                justGreaterElIdx = i;
            } else {
                break;
            }
        }

        int temp = arr[justGreaterElIdx];
        arr[justGreaterElIdx] = arr[descBrokeAt];
        arr[descBrokeAt] = temp;

        int i = descBrokeAt + 1;
        int j = n - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));

    }
}
