package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Power {
    public static int findPower(int n, int k){
        if(k==0){
            return 1;
        }
        int mid = k/2;
        if(k%2==0){
            int partialAns = findPower(n, mid);
            return partialAns * partialAns;
        }
        else{
            int partialAns = findPower(n, mid);
            return partialAns * partialAns * n;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        System.out.println(findPower(n, k));
    }
    
}
