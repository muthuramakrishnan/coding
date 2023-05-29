import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

public class FastFactorization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int nCopy = n;

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, 2, n + 1, true);
        List<Integer> primeNos = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i; i * j <= n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeNos.add(i);
            }
        }

        Iterator<Integer> it = primeNos.iterator();
        List<Integer> primeFactors = new ArrayList<>();
        while (it.hasNext()) {
            int elem = (int) it.next();
            if (elem * elem > n) {
                break;
            }
            while (nCopy % elem == 0) {
                primeFactors.add(elem);
                nCopy = nCopy / elem;
            }
        }
        if (nCopy != 1) {
            primeFactors.add(nCopy);
        }
        System.out.println(primeFactors);
    }
}
