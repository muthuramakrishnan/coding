import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class QuadrupletSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (j > i + 1 && arr[j - 1] == arr[j]) {
                    continue;
                }
                // use 2 pointers
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int numExpected = -(arr[i] + arr[j]);
                    int num3 = arr[k];
                    int num4 = arr[l];
                    if (arr[k] + arr[l] == numExpected) {
                        System.out.printf("%d, %d, %d %d%n", arr[i], arr[j], arr[k], arr[l]);
                        while (arr[k] == num3) {
                            k++;
                        }
                        while (arr[l] == num4) {
                            l--;
                        }
                    } else if (arr[k] + arr[l] < numExpected) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
    }
}