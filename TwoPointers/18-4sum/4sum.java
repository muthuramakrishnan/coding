class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        List<List<Integer>> outputList = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            for (int j = i+1; j < n; j++) {
                if (j > i + 1 && arr[j - 1] == arr[j]) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long numExpected = target-((long)arr[i] + arr[j]);
                    int num3 = arr[k];
                    int num4 = arr[l];
                    if ((long)arr[k] + arr[l] == numExpected) {
                        outputList.add(List.of(arr[i], arr[j], arr[k], arr[l]));
                        while (k<n && arr[k] == num3) {
                            k++;
                        }
                        while (l>=0 && arr[l] == num4) {
                            l--;
                        }
                    } else if ((long)arr[k] + arr[l] < numExpected) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return outputList;
    }
}