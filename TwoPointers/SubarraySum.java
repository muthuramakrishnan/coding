import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubarraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int sum = Integer.parseInt(br.readLine().strip());
        int i = 0;
        int j = 0;
        int currentsum = arr[i];
        boolean hasResult = false;
        while (i < n && j < n) {
            if (currentsum == sum) {
                hasResult = true;
                break;
            }
            if (currentsum > sum) {
                currentsum -= arr[i];
                i++;
                if (i > j) {
                    j++;
                    if (j < n) {
                        currentsum = arr[j];
                    }
                }
            } else {
                j++;
                if (j < n) {
                    currentsum += arr[j];
                }
            }
        }
        System.out.println(hasResult);
    }
}
