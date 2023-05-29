import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int nCopy = n;
        List<Integer> primeFactors = new ArrayList<>();
        for(int i=2; i*i<=n; i++){
            while(nCopy%i==0){
                nCopy = nCopy / i;
                primeFactors.add(i);
            }
        }
        if(nCopy!=1){
            primeFactors.add(nCopy);
        }
        System.out.println(primeFactors);
    }
}
