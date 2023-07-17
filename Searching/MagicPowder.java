package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicPowder {
    public static boolean canPrepare(int maxItems, int[] ingridientRequired, int[] ingridientInStock,
            int magicPowderCount) {
        int n = ingridientRequired.length;
        for (int i = 0; i < n; i++) {
            int diff = ingridientInStock[i] - (maxItems * ingridientRequired[i]);
            if (diff < 0) {
                magicPowderCount += diff;
            }
            if (magicPowderCount < 0) {
                return false;
            }
        }
        return true;
    }

    public static int binarySearch(int[] ingridientRequired, int[] ingridientInStock, int magicPowderCount) {
        int low = 1;
        int high = 1;
        for (int i = 0; i < ingridientInStock.length; i++) {
            high = Math.max(high, ingridientInStock[i]);
        }
        high += magicPowderCount;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (!canPrepare(mid, ingridientRequired, ingridientInStock, magicPowderCount)) {
                high = mid - 1;
            } else {
                if (!canPrepare(mid + 1, ingridientRequired, ingridientInStock, magicPowderCount)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int magicPowderCount = Integer.parseInt(s[1]);
        int[] ingridientRequired = new int[n];
        int[] ingridientInStock = new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            ingridientRequired[i] = Integer.parseInt(s[i]);
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            ingridientInStock[i] = Integer.parseInt(s[i]);
        }
        System.out.println(binarySearch(ingridientRequired, ingridientInStock, magicPowderCount));
    }
}
