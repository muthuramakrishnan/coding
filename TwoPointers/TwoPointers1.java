import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoPointers1 {
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
        int count = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (arr[i] + arr[j] > sum) {
                j--;
            } else if (arr[i] + arr[j] < sum) {
                i++;
            } else {
                int iNum = arr[i];
                int iCount = 0;
                int jNum = arr[j];
                int jCount = 0;
                while (arr[i] == iNum) {
                    iCount++;
                    i++;
                }
                while (arr[j] == jNum) {
                    jCount++;
                    j--;
                }
                count += iNum == jNum ? iCount : iCount * jCount;
            }
        }
        System.out.println(count);
    }
}
