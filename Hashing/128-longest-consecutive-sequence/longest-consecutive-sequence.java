class Solution {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
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
        return ans;
    }
}