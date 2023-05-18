import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class ProcessingQueries {

    public static void getArrayInput(int[][] arr, int m, int n) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
    }

    public static void printArray(int[][] arr, int m, int n) {
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        int[][] arr = new int[m][n];
        getArrayInput(arr, m, n);
        int[][] prefixSumArr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSumArr[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefixSumArr[i][j] = prefixSumArr[i][j - 1] + prefixSumArr[i][j];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSumArr[i][j] = prefixSumArr[i - 1][j] + prefixSumArr[i][j];
            }
        }
        printArray(prefixSumArr, m, n);

        int q = Integer.parseInt(br.readLine());
        while (q >= 1) {
            s = br.readLine().split(" ");
            int i1 = Integer.parseInt(s[0]);
            int j1 = Integer.parseInt(s[1]);
            int i2 = Integer.parseInt(s[2]);
            int j2 = Integer.parseInt(s[3]);
            int result = prefixSumArr[i2][j2];
            if (i1 > 0) {
                result -= prefixSumArr[i1 - 1][j2];
            }
            if (j1 > 0) {
                result -= prefixSumArr[i2][j1 - 1];
            }
            if (i1 > 0 && j1 > 0) {
                result += prefixSumArr[i1 - 1][j1 - 1];
            }
            System.out.println(result);
            q--;
        }
    }
}