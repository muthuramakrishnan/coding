package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

public class KarenAndCoffee {
    public static final int LIMIT = (int) Math.pow(10, 6) - 1;
// public static final int LIMIT = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n, k, q;
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        q = Integer.parseInt(s[2]);

        int[] booksRecommended = new int[LIMIT + 1];
        int[] itemsFoundBeyondThresh = new int[LIMIT + 1];
        while (n >= 1) {
            s = br.readLine().split(" ");
            int temp1 = Integer.parseInt(s[0]);
            int temp2 = Integer.parseInt(s[1]);
            booksRecommended[temp1]++;
            if (temp2 + 1 <= LIMIT)
                booksRecommended[temp2 + 1]--;
            n--;
        }
        for (int i = 1; i <= LIMIT; i++) {
            booksRecommended[i] += booksRecommended[i - 1];
        }
        for(int i=1; i<=LIMIT; i++){
            itemsFoundBeyondThresh[i] = itemsFoundBeyondThresh[i-1];
            if(booksRecommended[i] >= k){
                itemsFoundBeyondThresh[i]++;
            }
        }
        // System.out.println(Arrays.toString(itemsFoundBeyondThresh));
        // List<Integer> output = new ArrayList<>();
        while(q>=1){
            s = br.readLine().split(" ");
            int temp1 = Integer.parseInt(s[0]);
            int temp2 = Integer.parseInt(s[1]);

            int numOfItems = itemsFoundBeyondThresh[temp2];
            if(temp1 > 0){
                numOfItems -= itemsFoundBeyondThresh[temp1-1];
            }
            System.out.println(numOfItems);
            // output.add(numOfItems);
            q--;
        }
        // System.out.println(output);
    }
}
