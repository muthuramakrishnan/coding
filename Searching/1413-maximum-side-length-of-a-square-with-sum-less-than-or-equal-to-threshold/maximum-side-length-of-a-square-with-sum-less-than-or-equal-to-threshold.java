class Solution {
    public static boolean haveSideLengthUnderThreshold(int[][] prefixSum, int len, int threshold) {
        int m = prefixSum.length-1;
        int n = prefixSum[0].length-1;
        for (int i = len; i <= m; i++) {
            for (int j = len; j <= n; j++) {
                if (prefixSum[i][j] - prefixSum[i - len][j] - prefixSum[i][j - len]
                        + prefixSum[i - len][j - len] <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int binarySearch(int[][] prefixSum, int threshold) {
        int m = prefixSum.length-1;
        int n = prefixSum[0].length-1;
        int low = 1;
        int high = Math.min(m, n);
        while (low <= high) {
            int mid = (low + high) / 2;
            if (!haveSideLengthUnderThreshold(prefixSum, mid, threshold)) {
                high = mid - 1;
            } else {
                if (!haveSideLengthUnderThreshold(prefixSum, mid + 1, threshold)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return 0;
    }

    public int maxSideLength(int[][] arr, int threshold) {
        int m = arr.length;
        int n = arr[0].length;
       int[][] prefixSum = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr[i-1][j-1];
            }
        }
        return binarySearch(prefixSum, threshold);
    }
}