package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FamilyOfStrings {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        //definition
        // f[0] = 0;
        // f[1] = 0 . 0 . 1
        // f[2] = 001 . 0 . 110
        // f[3] = 0010110 . 0 . 1101001
        //so find the k th char in the n th string

        // (2^i) - 1 -> no of chars
        int high = (int)(Math.pow(2, n) - 1) - 1;
        int low = 0;
        
        int currBit = 0;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(mid == k){
                break;
            }
            if(mid > k){
                high = mid - 1;
            }
            else if(mid < k){
                low = mid + 1;
                currBit = 1;
            }
        }
        System.out.println(currBit);
    }
    
}
