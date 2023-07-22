package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class FindKClosestPointsComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            int num1 = Integer.parseInt(s[i].split(",")[0]);
            int num2 = Integer.parseInt(s[i].split(",")[1]);
            arr[i] = new Point(num1, num2);
        }
        Arrays.sort(arr, new CustomComparator());
        int k = Integer.parseInt(br.readLine());
        System.out.println(Arrays.toString(Arrays.copyOf(arr, k)));
    }
}

class CustomComparator implements Comparator<Point> {
    public int compare(Point a, Point b) {
        int d1 = (a.x * a.x) + (a.y * a.y);
        int d2 = (b.x * b.x) + (b.y * b.y);
        return d1 - d2;
    }
}
