class Solution {

    public int getInterArrInversionCount(int[] arr, int startIdx1, int endIdx1, int startIdx2, int endIdx2) {
        int count = 0;
        Arrays.sort(arr, startIdx1, endIdx1 + 1);
        Arrays.sort(arr, startIdx2, endIdx2 + 1);
        while (startIdx1 <= endIdx1 && startIdx2 <= endIdx2) {
            if (arr[startIdx1] > (long) 2 * arr[startIdx2]) {
                count += endIdx1 - startIdx1 + 1;
                startIdx2++;
            } else {
                startIdx1++;
            }
        }
        return count;
    }

    public int getInversionCount(int[] arr, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return 0;
        }
        int mid = (startIdx + endIdx) / 2;
        return getInversionCount(arr, startIdx, mid) + getInversionCount(arr, mid + 1, endIdx)
                + getInterArrInversionCount(arr, startIdx, mid, mid + 1, endIdx);
    }

    public int reversePairs(int[] arr) {
        int n = arr.length;
        return getInversionCount(arr, 0, n - 1);
    }
}