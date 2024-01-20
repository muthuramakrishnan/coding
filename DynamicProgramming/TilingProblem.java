class Solution {
    private static final long MODULO = (long) Math.pow(10, 9) + 7;
    static Long calculateNumberOfWays(int i, int n, long[] memoizedValues){
        if(i == n){
            return 1L;
        }
        if(i > n){
            return 0L;
        }
        if(memoizedValues[i] != -1){
            return memoizedValues[i];
        }
        memoizedValues[i] =  (calculateNumberOfWays(i+1, n, memoizedValues) % MODULO + calculateNumberOfWays(i+2, n, memoizedValues) % MODULO) % MODULO;
        return memoizedValues[i];
    }
    static Long numberOfWays(int N) {
        long[] memoizedValues = new long[N+1];
        Arrays.fill(memoizedValues, -1);
        return calculateNumberOfWays(0, N, memoizedValues);
    }
};