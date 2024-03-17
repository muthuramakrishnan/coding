class Solution {
    private int[][] memoizedValues;
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        memoizedValues = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if (c1 == c2) {
                    memoizedValues[i][j] = 1 + (i > 0 && j > 0 ? memoizedValues[i - 1][j - 1] : 0);
                } else {
                    memoizedValues[i][j] = Math.max(i > 0 ? memoizedValues[i - 1][j] : 0,
                            j > 0 ? memoizedValues[i][j - 1] : 0);
                }
            }
        }
        return memoizedValues[m - 1][n - 1];
    }
}