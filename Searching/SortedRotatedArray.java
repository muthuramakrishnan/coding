package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortedRotatedArray {
    public static int binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int findPointOfRotation(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid + 1 < n && mid - 1 >= 0 && arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[n - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int findKey(int[] arr, int key) {
        int n = arr.length;
        boolean isRotated = false;
        int rotationPoint = 0;
        if (arr[0] > arr[n - 1]) {
            isRotated = true;
        }
        if (isRotated) {
            rotationPoint = findPointOfRotation(arr);
            int ans = binarySearch(arr, 0, rotationPoint, key);
            if (ans != -1) {
                return ans;
            } else {
                return binarySearch(arr, rotationPoint + 1, n - 1, key);
            }
        } else {
            return binarySearch(arr, 0, n - 1, key);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int key = Integer.parseInt(br.readLine());
        System.out.println(findKey(arr, key));
    }
}
