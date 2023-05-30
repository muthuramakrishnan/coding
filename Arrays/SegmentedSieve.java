import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SegmentedSieve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long l = Long.parseLong(s[0]);
        long r = Long.parseLong(s[1]);

        int n = (int) Math.ceil(Math.sqrt(r));
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, 2, n + 1, true);
        List<Integer> primeNos = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeNos.add(i);
                for (int j = i; i * j <= n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        isPrime = new boolean[(int) (r - l + 1)];
        Arrays.fill(isPrime, true);
        for (int primeNo : primeNos) {
            long firstMultiple = l % primeNo == 0 ? l / primeNo : l / primeNo + 1;
            for (long j = firstMultiple; (long) primeNo * j <= r; j++) {
                isPrime[(int) ((primeNo * j) - l)] = false;
            }
        }

        primeNos = new ArrayList<>();
        for (long i = l; i <= r; i++) {
            if (isPrime[(int) (i - l)]) {
                primeNos.add((int) i);
            }
        }
        System.out.println(primeNos);
    }
}
