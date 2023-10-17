package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Map<Integer, Integer> streakMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!streakMap.containsKey(arr[i])) {
                int currElStreak = 1;
                int rightStreak = streakMap.getOrDefault(arr[i] + 1, 0);
                int leftStreak = streakMap.getOrDefault(arr[i] - 1, 0);

                // update streaks
                int value = currElStreak + rightStreak + leftStreak;
                streakMap.put(arr[i], value);
                streakMap.put(arr[i] + rightStreak, value);
                streakMap.put(arr[i] - leftStreak, value);
                ans = Math.max(ans, value);
            }
        }
        System.out.println(ans);
    }
}
