class Solution {
    public int findPairs(int[] arr, int k) {
        if(k<0){
            k = -k;
        }
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0;
        int j = i+1;
        int count = 0;
        while(i<n && j<n){
            int currentDiff = arr[j] - arr[i];
            if(currentDiff < k){
                j++;
                continue;
            }
            else if(currentDiff > k){
                i++;
                continue;
            }
            else if(currentDiff == k && i!=j){
                count++;
                int num1Val = arr[i];
                int num2Val = arr[j];
                while(i<n && arr[i]==num1Val){
                    i++;
                }
                while(j<n && arr[j]==num2Val){
                    j++;
                }
            }
            else{
                j++;
            }
        }
        return count;
    }
}