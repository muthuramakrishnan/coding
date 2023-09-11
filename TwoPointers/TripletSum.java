import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripletSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        // find triplet such that a + b + c = 0;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            int sum = -arr[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (arr[j] + arr[k] == sum) {
                    int numJ = arr[j];
                    int numK = arr[k];
                    System.out.printf("%d, %d, %d%n", arr[i], arr[j], arr[k]);
                    while (j < n && arr[j] == numJ) {
                        j++;
                    }
                    while (k >= 0 && arr[k] == numK) {
                        k--;
                    }
                } else if (arr[j] + arr[k] < sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
    }
}
