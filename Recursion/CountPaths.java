package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountPaths {
    public static int countDistinctPaths(int i, int j, int m, int n){
        if(i==m-1 || j==n-1){
            return 1;
        }
        return countDistinctPaths(i+1, j, m, n) + countDistinctPaths(i, j+1, m, n);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int distinctPaths = countDistinctPaths(0, 0, m-1, n-1);
        System.out.println(distinctPaths);
    }
}
