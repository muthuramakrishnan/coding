import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FastFactorization1 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] spf = new int[n+1];
        for(int i=2; i<=n; i++){
            spf[i] = i;
        }
        for(int i=2; i*i<=n; i++){
            if(spf[i]==i){
                for(int j=i; i*j<=n; j++){
                    spf[i*j] = i;
                }
            }
        }
        List<Integer> primeFactors = new ArrayList<>();
        while(n!=1){
            primeFactors.add(spf[n]);
            n = n/spf[n];
        }
        System.out.println(primeFactors);
    }
}
