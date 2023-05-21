import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivisibleBy2Or3 {
    public static int findGCD(int a, int b) {
        int divisor = Math.min(a, b);
        int dividend = Math.max(a, b);
        int remainder = dividend % divisor;
        while (remainder != 0) {
            dividend = divisor;
            divisor = remainder;
            remainder = dividend % divisor;
        }
        return divisor;
    }

    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int n = Integer.parseInt(s[2]);

        // divisible by a;
        int divisibleByA = n / a;
        int divisibleByB = n / b;
        int divisibleByAB = findLCM(a, b);

        System.out.println(divisibleByA + divisibleByB - n / divisibleByAB);
    }

}
