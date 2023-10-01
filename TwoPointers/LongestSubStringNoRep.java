import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestSubStringNoRep {

    private static final int ASCII_LEN = 256;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int n = arr.length;
        boolean[] freqArr = new boolean[ASCII_LEN + 1];

        int i = 0;
        int j = 0;
        int count = 0;
        int currentCount = 0;
        while (i < n && j < n) {
            if (freqArr[arr[j]] == false) {
                freqArr[arr[j]] = true;
                currentCount++;
                j++;
            } else {
                count = Math.max(count, currentCount);
                freqArr[arr[i]] = false;
                currentCount--;
                i++;
            }
        }
        count = Math.max(currentCount, count);
        System.out.println(count);
    }
}