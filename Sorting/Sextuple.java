package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sextuple {
    public static int findFirstOccurence(List<Integer> rhsList, int k) {
        int n = rhsList.size();
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (rhsList.get(mid) >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int findLastOccurrence(List<Integer> rhsList, int k) {
        int n = rhsList.size();
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (rhsList.get(mid) <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static int findOccurrences(List<Integer> rhsList, int k) {
        return findLastOccurrence(rhsList, k) - findFirstOccurence(rhsList, k) + 1;
    }

    // (a * b + c) / d - e = f;
    // converted equation -> a * b + c = (e + f) * d
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        List<Integer> lhsList = new ArrayList<>();
        List<Integer> rhsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    lhsList.add(arr[i] * arr[j] + arr[k]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    rhsList.add(arr[i] * (arr[j] + arr[k]));
                }
            }
        }
        Collections.sort(rhsList);
        int resCount = 0;
        for (int lhsItem : lhsList) {
            resCount += findOccurrences(rhsList, lhsItem);
        }
        System.out.println(resCount);
    }

}
