import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCM {
    public static int findLcm(int a, int b){
        return (a * b) / Gcd.findGcd(a, b);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int lcm = findLcm(a, b);
        System.out.println(lcm);
    }
}
