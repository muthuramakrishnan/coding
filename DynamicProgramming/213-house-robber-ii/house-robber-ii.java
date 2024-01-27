class Solution {
    public int robHouse(int[] houseArr) {
        int n = houseArr.length;
        int val1 = houseArr[0];
        if (n < 2) {
            return val1;
        }
        int val2 = Math.max(val1, houseArr[1]);

        for (int i = 2; i < n; i++) {
            int val3 = Math.max(houseArr[i] + val1, val2);
            val1 = val2;
            val2 = val3;
        }
        return val2;
    }
    public int rob(int[] arr) {
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }
        int[] prefixRemovedArr = new int[n - 1];
        int[] suffixRemovedArr = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            prefixRemovedArr[i] = arr[i + 1];
            suffixRemovedArr[i] = arr[i];
        }
        return Math.max(robHouse(prefixRemovedArr), robHouse(suffixRemovedArr));
    }
}