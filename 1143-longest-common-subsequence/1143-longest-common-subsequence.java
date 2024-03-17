class Solution {
    public static void deepCopy(int[] arr1, int[] arr2){
        for(int i=0; i<arr1.length; i++){
            arr1[i] = arr2[i];
        }
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] prevArr = new int[n];
        int[] currArr = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if (c1 == c2) {
                    currArr[j] = 1 + (i > 0 && j > 0 ? prevArr[j - 1] : 0);
                } else {
                    currArr[j] = Math.max(i > 0 ? prevArr[j] : 0, j > 0 ? currArr[j - 1] : 0);
                }
            }
            prevArr = new int[n];
            deepCopy(prevArr, currArr); 

        }
        return currArr[n - 1];
    }
}