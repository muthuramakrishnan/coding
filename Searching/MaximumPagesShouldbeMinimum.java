package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumPagesShouldbeMinimum {
    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static boolean canBeAllocated(int[] pages, int maxPage, int students) {
        int i = 0;
        int count = 0;
        while (i < pages.length && students > 0) {
            if (count <= maxPage) {
                count += pages[i];
                if (pages.length == i - 1) {
                    students--;
                }
            } else {
                students--;
                count = pages[i];
            }
            i++;
        }
        return !(students > 0);
    }

    public static int getMaxPage(int[] pages, int students) {
        int n = pages.length;
        int low = getMin(pages);
        int high = getMax(pages);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (!canBeAllocated(pages, mid, students)) {
                low = mid + 1;
            } else {
                if (!canBeAllocated(pages, mid - 1, students)) {
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
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(s[i]);
        }
        int students = Integer.parseInt(br.readLine());
        System.out.println(getMaxPage(pages, students));
    }

}
