class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            int sum = -arr[i];
            int j = i+1;
            int k = n - 1;
            while (j < k) {
                if (arr[j] + arr[k] == sum) {
                    int numJ = arr[j];
                    int numK = arr[k];
                    output.add(List.of(arr[i], arr[j], arr[k]));
                    while (j < n && arr[j] == numJ) {
                        j++;
                    }
                    while (k >= 0 && arr[k] == numK) {
                        k--;
                    }
                }
                else if (arr[j] + arr[k] < sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return output;
    }
}