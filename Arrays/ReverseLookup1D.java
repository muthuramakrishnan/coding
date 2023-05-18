import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseLookup1D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += arr[i] * (i + 1) * (n - i);
        }
        System.out.println(result);
    }
}
