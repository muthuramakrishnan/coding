import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoPointersBinarySearch {
    public static boolean hasNum(int[] arr, int num) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == num) {
                return true;
            }
            if (arr[mid] > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        // arr[i] + arr[j] == sum;
        // If i fix arr[i], then what should be arr[j]? - sum - arr[i]

        int sum = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        boolean hasNum = false;
        for (int i = 0; i < n; i++) {
            int num1 = arr[i];
            int num2 = sum - num1;
            if (hasNum(arr, num2)) {
                hasNum = true;
                break;
            }
        }
        System.out.println(hasNum);
    }
}
