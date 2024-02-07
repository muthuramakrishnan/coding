class Solution {
    private long[] memoizedValues;

    public long findMinCoins(int[] coins, int m, int balance) {
        if (balance == 0) {
            return 0;
        }
        if (balance < 0) {
            return Long.MAX_VALUE;
        }
        if (memoizedValues[balance] != -1) {
            return memoizedValues[balance];
        }

        long minCoinsRequired = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            minCoinsRequired = Math.min(findMinCoins(coins, m, balance - coins[i]), minCoinsRequired);
        }
        memoizedValues[balance] = minCoinsRequired == Long.MAX_VALUE ? Long.MAX_VALUE : 1 + minCoinsRequired;
        return memoizedValues[balance];
    }

    public int coinChange(int[] coins, int total) {
        int m = coins.length;
        memoizedValues = new long[total + 5];
        Arrays.fill(memoizedValues, -1);
        long minCoinsRequired = findMinCoins(coins, m, total);
        return minCoinsRequired == Long.MAX_VALUE ? (int) -1 : (int) minCoinsRequired;
    }
}