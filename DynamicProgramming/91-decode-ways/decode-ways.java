class Solution {
    private int[] memoizedValues;

    public int countWays(String s, int startIdx) {
        int n = s.length();
        if (startIdx >= n) {
            return 1;
        }
        int s1 = Character.getNumericValue(s.charAt(startIdx));
        int s2 = startIdx + 2 <= n ? Integer.parseInt(s.substring(startIdx, startIdx + 2)) : -1;

        if (memoizedValues[startIdx] != -1) {
            return memoizedValues[startIdx];
        }

        int way1 = 0;
        int way2 = 0;
        if(s1 < 1 || s1 > 27){
            memoizedValues[startIdx] = 0;
            return 0;
        }
        way1 = countWays(s, startIdx + 1);
        if (s2 >= 1 && s2 <= 26) {
            way2 = countWays(s, startIdx + 2);
        }
        memoizedValues[startIdx] = way1 + way2;
        return memoizedValues[startIdx];

    }

    public int numDecodings(String s) {
        
        memoizedValues = new int[s.length() + 5];
        Arrays.fill(memoizedValues, -1);
        return countWays(s, 0);
    }
}