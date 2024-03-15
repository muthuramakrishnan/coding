class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] LIS = new int[n];

        Arrays.fill(LIS, 1);
        int lisLen = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    LIS[i] = Math.max(LIS[j] + 1, LIS[i]);
                }
            }
            lisLen = Math.max(LIS[i], lisLen);
        }
        return lisLen;
    }
}