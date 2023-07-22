package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindKClosestPoints {
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
        Arrays.sort(arr);
        int k = Integer.parseInt(br.readLine());
        System.out.println(Arrays.toString(Arrays.copyOf(arr, k)));
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int first() {
        return x;
    }

    public int second() {
        return y;
    }

    public int compareTo(Point p) {
        // distance from origin
        int d1 = (this.x) + (this.y * this.y);
        int d2 = (p.x * p.x) + (p.y * p.y);
        return d1 - d2;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}