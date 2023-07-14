package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PlaceTheCows {
    public static boolean canCowBePlaced(int[] stalls, int d, int cows) {
        int n = stalls.length;
        int prev = stalls[0];
        cows--;
        int i = 1;
        while (cows > 0 && i < n) {
            if (stalls[i] - prev >= d) {
                cows--;
                prev = stalls[i];
            }
            i++;
        }
        return !(cows > 0);
    }

    public static int findMaxValueOfMinimumDistance(int[] stalls, int cows) {
        int n = stalls.length;
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (!canCowBePlaced(stalls, mid, cows)) {
                high = mid - 1;
            } else {
                if (!canCowBePlaced(stalls, mid + 1, cows)) {
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
        int[] stalls = new int[n];
        for (int i = 0; i < n; i++) {
            stalls[i] = Integer.parseInt(s[i]);
        }
        int cows = Integer.parseInt(br.readLine());
        Arrays.sort(stalls);
        System.out.println(findMaxValueOfMinimumDistance(stalls, cows));
    }
}