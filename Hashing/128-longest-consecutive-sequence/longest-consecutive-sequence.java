class Solution {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        Set<Integer> inputSet = new HashSet<>();
        Set<Integer> consideredItems = new HashSet<>();
        for(int elem : arr){
            inputSet.add(elem);
        }

        int maxConsecutiveLen = 0;
        for(int i=0; i<n; i++){
            boolean isStartingPoint = !inputSet.contains(arr[i] - 1);
            boolean isItemConsidered = consideredItems.contains(arr[i]);
            int currentConsecutiveArr = 0;
            if(isStartingPoint && !isItemConsidered){
                consideredItems.add(arr[i]);
                for(int j = arr[i]; j<arr[i]+n; j++){
                    if(!inputSet.contains(j)){
                        break;
                    }
                    currentConsecutiveArr++;
                }
            }
            maxConsecutiveLen = Math.max(currentConsecutiveArr, maxConsecutiveLen);
        }
        return maxConsecutiveLen;
    }
}