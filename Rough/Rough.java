package Rough;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rough {
        public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        
        int n = s.length;
        int[] arr = new int[n];
        arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        
        System.out.println(Arrays.toString(arr));
    }
}
