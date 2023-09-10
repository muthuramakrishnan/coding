import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PairDifference {
    public static boolean hasNum(int[] arr, int num, int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == num) {
                return true;
            } else {
                if (arr[mid] > num) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
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
        int diff = Integer.parseInt(br.readLine().strip());
        Arrays.sort(arr);
        // arr[i] - arr[j] => diff
        // As this is a difference, if we pick 2 nums 4,5 -> we have to check 4 - 5 as
        // well as 5 - 4
        // Lets consider binary search
        // we fix one num and search for other num
        // Let's assume diff = 1, my arr[i] is 4, so arr[j] should be 3. But we have
        // sorted the arr in ascending order, there's never gonna be 3 on the right side
        // so, we should think other way
        // we should consider 3 as arr[j] -> reframe the equation -> arr[i] = arr[j] +
        // diff -> arr[i] = 3 + 1

        boolean hasNum = false;
        for (int i = 0; i < n; i++) {
            int num2 = arr[i];
            int num1 = diff + num2;
            if (hasNum(arr, num1, 0, n - 1)) {
                hasNum = true;
                break;
            }
        }
        System.out.println(hasNum);
    }
}