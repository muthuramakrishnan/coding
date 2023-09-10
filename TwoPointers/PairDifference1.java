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
        boolean hasNum = false;
        while (i <= j && i < n && j < n) {
            int currentDiff = arr[j] - arr[i];
            if (currentDiff < diff) {
                j++;
                continue;
            }
            else if (currentDiff > diff) {
                i++;
                continue;
            }
            else if (currentDiff == diff && i != j) {
                hasNum = true;
                break;
            }
            else{
                j++;
            }
        }
        System.out.println(hasNum);
    }
}
