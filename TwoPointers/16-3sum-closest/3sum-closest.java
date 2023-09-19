class Solution {
    public int threeSumClosest(int[] arr, int sum) {
        int n = arr.length;
        Arrays.sort(arr);
        int possibleAns =  Integer.MIN_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            int j = i+1;
            int k = n - 1;
            while (j < k) {
                int currentSum = arr[i] + arr[j] + arr[k];
                if(currentSum == sum){
                    diff = 0;
                    possibleAns = sum;
                    break;
                }
                if(currentSum < sum){
                    j++;
                    int newDiff = Math.min(diff, sum - currentSum);
                    if(newDiff < diff){
                        diff = newDiff;
                        possibleAns = currentSum;
                    }
                }
                else{
                    k--;
                    int newDiff = Math.min(diff, currentSum - sum);
                    if(newDiff < diff){
                        diff = newDiff;
                        possibleAns = currentSum;
                    }
                }
            }
        }
        return possibleAns;
    }
}