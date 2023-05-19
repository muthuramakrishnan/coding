import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxGapBucketing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = s.length;
        if (n == 0) {
            System.exit(0);
        }

        int[] arr = new int[n];
        int minEl = Integer.MAX_VALUE;
        int maxEl = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            minEl = Math.min(minEl, arr[i]);
            maxEl = Math.max(maxEl, arr[i]);
        }
        if (minEl == maxEl) {
            System.exit(0);
        }
        int gap = (maxEl - minEl) / (n-1);
        int minGap = (maxEl - minEl) % (n-1) == 0 ? gap : gap + 1;

        int[] minElBucket = new int[n];
        int[] maxElBucket = new int[n];
        for(int i=0; i<n; i++){
            minElBucket[i] = Integer.MAX_VALUE;
            maxElBucket[i] = Integer.MIN_VALUE;
        }
        for(int i=0; i<n; i++){
            int bucketNo = (arr[i] - minEl) / minGap;
            minElBucket[bucketNo] = Math.min(minElBucket[bucketNo], arr[i]);
            maxElBucket[bucketNo] = Math.max(maxElBucket[bucketNo], arr[i]);
        }

        int ans = Integer.MIN_VALUE;
        int diff = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(diff == Integer.MIN_VALUE && maxElBucket[i]!=Integer.MIN_VALUE){
                diff = maxElBucket[i];
            }
            else if(minElBucket[i]!=Integer.MAX_VALUE){
                diff = minElBucket[i] - diff;
                ans = Math.max(diff, ans);
                diff = maxElBucket[i];
            }
        }
        System.out.println(ans);
    }
}
