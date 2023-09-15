class Solution {
    public int[] intersection(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0;
        int j = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        List<Integer> resultList = new ArrayList<>();
        while(i<m && j<n){
            int num1 = arr1[i];
            int num2 = arr2[j];
            while(i<m && arr1[i] == num1){
              i++;
            }
            while(j<n && arr2[j] == num2){
              j++;
            }
            i--;
            j--;
            if(arr1[i] == arr2[j]){
                resultList.add(arr1[i++]);
                j++;
            }
            else if(arr1[i] < arr2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        int[] resultArr = new int[resultList.size()];
        int[] idx = {0};
        resultList.forEach((item) -> {
          resultArr[idx[0]] = item;
          idx[0]++;
        });
        return resultArr;
    }
}