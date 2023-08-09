package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class LittleGirlMaximumSum {
    private static final int LIMIT = (int)Math.pow(10, 6);
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);

        Integer[] arr = new Integer[n+1];
        Integer[] priorityArr = new Integer[LIMIT];
        Arrays.fill(arr, 0);
        Arrays.fill(priorityArr, 0);
        s = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(s[i-1]);
        }

        while(q>=1){
            s = br.readLine().split(" ");
            int idx1 = Integer.parseInt(s[0]);
            int idx2= Integer.parseInt(s[1]);
            priorityArr[idx1]++;
            priorityArr[idx2+1]--;
            q--;
        }

        for(int i=2; i<LIMIT; i++){
            priorityArr[i] += priorityArr[i-1];
        }

        Arrays.sort(priorityArr, Comparator.reverseOrder());
        Arrays.sort(arr, Comparator.reverseOrder());

        long ans = 0;
        for(int i=0; i<LIMIT; i++){
            if(priorityArr[i] == 0){
                break;
            }
            ans += (long)priorityArr[i] * arr[i];
        }
        System.out.println(ans);
    }
}