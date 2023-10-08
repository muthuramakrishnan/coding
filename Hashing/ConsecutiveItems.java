package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ConsecutiveItems {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int minEl = Integer.MAX_VALUE;
        Set<Integer> countSet = new HashSet<>();
        for(int i=0; i<n; i++){
            countSet.add(arr[i]);
            minEl = Math.min(minEl, arr[i]);
        }

        for(int i=minEl; i<minEl+n; i++){
            if(!countSet.contains(i)){
                System.out.println(false);
                System.exit(0);
            }
        }
        System.out.println(true);
    }
}
