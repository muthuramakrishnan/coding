class Solution {
    private int[] memoizedValues;

    public int coinChange(int[] denoms, int totalMoney) {
        int denomLen = denoms.length;
        memoizedValues = new int[totalMoney + 1];
        memoizedValues[0] = 0;
        for (int i = 1; i <= totalMoney; i++) {
            memoizedValues[i] = Integer.MAX_VALUE;
            for (int j = 0; j < denomLen; j++) {
                if (i - denoms[j] < 0) {
                    continue;
                }
                memoizedValues[i] = (int) Math.min((long) memoizedValues[i], (long) 1 + memoizedValues[i - denoms[j]]);
            }
        }
        return memoizedValues[totalMoney] == Integer.MAX_VALUE ? -1 : memoizedValues[totalMoney];
    }
}