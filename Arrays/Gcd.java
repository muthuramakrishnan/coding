import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gcd {
    public static int findGcd(int a, int b) {
        int dividend = Math.max(a, b);
        int divisor = Math.min(a, b);
        int remainder = dividend % divisor;
        while (remainder != 0) {
            dividend = divisor;
            divisor = remainder;
            remainder = dividend % divisor;
        }
        return divisor;
    }

    public static void main(String[] args) throws IOException {
        int a, b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        int gcd = findGcd(a, b);
        System.out.println(gcd);
    }
}
