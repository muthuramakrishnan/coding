import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoPointers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int sum = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int i = 0;
        int j = n - 1;
        boolean hasNum = false;
        while (i < j) {
            if (arr[i] + arr[j] == sum) {
                hasNum = true;
                break;
            }
            if (arr[i] + arr[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println(hasNum);

    }
}
