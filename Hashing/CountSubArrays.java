package Hashing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSubArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        System.out.println(Arrays.toString(prefixSum));
        int[] result = new int[n];
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            int num2 = prefixSum[i] - k;
            boolean hasNum2 = countMap.containsKey(num2);
            if (hasNum2) {
                int num2Count = countMap.get(num2);
                result[i] = num2Count;

            }

            int currentNum = prefixSum[i];
            boolean hasCurrentNum = countMap.containsKey(currentNum);
            if (hasCurrentNum) {
                int currentNumCount = countMap.get(currentNum);
                countMap.put(currentNum, ++currentNumCount);
            } else {
                countMap.put(currentNum, 1);
            }
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += result[i];
        }
        System.out.println(total);
    }
}