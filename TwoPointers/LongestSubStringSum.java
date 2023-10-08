import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] arr = new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        Map<Integer, Integer> elementIdxMap = new HashMap<>();
        elementIdxMap.put(0, -1);
        int dist = 0;
        for (int i = 0; i < n; i++) {
            boolean hasElem = elementIdxMap.containsKey(prefixSum[i]);
            if (!hasElem) {
                elementIdxMap.put(prefixSum[i], i);
            }

            //expected sum -> k
            //is it equal to the expected sum
            int num2 = prefixSum[i] - k;
            boolean hasNum2 = elementIdxMap.containsKey(num2);
            if(hasNum2){
               int idx = elementIdxMap.get(num2);
                dist = Math.max(dist, i - idx);
            }
        }
        System.out.println(dist);
    }
}
