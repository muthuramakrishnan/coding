package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeProcess {

    public static int[] retainSortMerge(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int[] res = new int[m+n];

        int i=0, j=0, c=0;
        while(i<n && j<m){
            if(arr1[i] < arr2[j]){
                res[c] = arr1[i];
                i++;
            }
            else{
                res[c] = arr2[j];
                j++;
            }
            c++;
        }

        for(;i<n;){
            res[c++] = arr1[i++];
        }
        for(;j<m;){
            res[c++] = arr2[j++];
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        s = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr1[i] = Integer.parseInt(s[i]);
        }

        s=br.readLine().split(" ");
        for(int i=0; i<m; i++){
            arr2[i] = Integer.parseInt(s[i]);
        }

        System.out.println(Arrays.toString(retainSortMerge(arr1, arr2)));

    }
}
