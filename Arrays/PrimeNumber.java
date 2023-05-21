import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        boolean isPrime = true;
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime);
    }
}
