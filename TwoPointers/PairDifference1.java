import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PairDifference1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int diff = Integer.parseInt(br.readLine().strip());
        if (diff < 0) {
            diff = -diff;
        }
        Arrays.sort(arr);

        int i = 0;
        int j = i + 1;
        int count = 0;
        boolean hasNum = false;
        while (i <= j && i < n && j < n) {
            int currentDiff = arr[j] - arr[i];
            if (currentDiff < diff) {
                j++;
                continue;
            } else if (currentDiff > diff) {
                i++;
                continue;
            } else if (currentDiff == diff && i != j) {
                int num1 = arr[i];
                int num1Count = 0;
                int num2 = arr[j];
                int num2Count = 0;
                while (i < n && arr[i] == num1) {
                    num1Count++;
                    i++;
                }
                while (j < n && arr[j] == num2) {
                    num2Count++;
                    j++;
                }
                if (num1 == num2) {
                    count += (num1Count * (num1Count - 1)) / 2;
                } else {
                    count += num1Count * num2Count;
                }
                hasNum = true;
            } else {
                j++;
            }
        }
        System.out.println(hasNum ? count : 0);
    }
}
