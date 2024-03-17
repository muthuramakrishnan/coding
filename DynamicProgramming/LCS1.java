package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS1 {

    public static void deepCopy(int[] arr1, int[] arr2){
        for(int i=0; i<arr1.length; i++){
            arr1[i] = arr2[i];
        }
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] prevArr = new int[n];
        int[] currArr = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if (c1 == c2) {
                    currArr[j] = 1 + (i > 0 && j > 0 ? prevArr[j - 1] : 0);
                } else {
                    currArr[j] = Math.max(i > 0 ? prevArr[j] : 0, j > 0 ? currArr[j - 1] : 0);
                }
            }
            prevArr = new int[n];
            deepCopy(prevArr, currArr);
            // currArr = new int[n];

        }
        return currArr[n - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(longestCommonSubsequence(s1, s2));

    }
}
