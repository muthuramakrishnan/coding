class Solution {
    private long[] memoizedValues;

    public long findMinCoins(int[] coins, int currAmt, int m, int total) {
        if(currAmt == total){
            return 0;
        }
        if(currAmt > total || currAmt < 0){
            return Long.MAX_VALUE;
        }
        if(memoizedValues[currAmt] != -1){
            return memoizedValues[currAmt];
        }

        long minCoinsRequired = Long.MAX_VALUE;
        for(int i=0; i<m; i++){
            minCoinsRequired = Math.min(findMinCoins(coins, currAmt + coins[i], m, total), minCoinsRequired);
        }
        memoizedValues[currAmt] = minCoinsRequired == Long.MAX_VALUE ? Long.MAX_VALUE : 1 + minCoinsRequired;
        return memoizedValues[currAmt];
    }

    public int coinChange(int[] coins, int total) {
        int m = coins.length;
        memoizedValues = new long[total + 5];
        Arrays.fill(memoizedValues, -1);
        long minCoinsRequired = findMinCoins(coins, 0, m, total);
        return minCoinsRequired == Long.MAX_VALUE ? (int) -1 : (int) minCoinsRequired;
    }
}