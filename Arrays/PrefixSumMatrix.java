import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrefixSumMatrix {
    public static boolean haveSideLengthUnderThreshold(int[][] prefixSum, int len, int threshold) {
        int m = prefixSum.length-1;
        int n = prefixSum[0].length-1;
        for (int i = len; i <= m; i++) {
            for (int j = len; j <= n; j++) {
                if (prefixSum[i][j] - prefixSum[i - len][j] - prefixSum[i][j - len]
                        + prefixSum[i - len][j - len] <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int binarySearch(int[][] prefixSum, int threshold) {
        int m = prefixSum.length-1;
        int n = prefixSum[0].length-1;
        int low = 1;
        int high = Math.min(m, n);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (!haveSideLengthUnderThreshold(prefixSum, mid, threshold)) {
                high = mid - 1;
            } else {
                if (!haveSideLengthUnderThreshold(prefixSum, mid + 1, threshold)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        int[][] prefixSum = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr[i-1][j-1];
            }
        }
        int T = Integer.parseInt(br.readLine());
        int threshold = Integer.parseInt(br.readLine());
        while (T >= 1) {
            System.out.println(binarySearch(prefixSum, threshold));
            T--;
        }
    }

}
