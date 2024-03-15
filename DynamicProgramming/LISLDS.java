package DynamicProgramming;

public class LISLDS {
    public int LongestBitonicSequence(int[] arr)
    {
        // Code here
        int n = arr.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        
        for(int i=0; i<n; i++){
            lis[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }
        
        for(int i=n-1; i>=0; i--){
            lds[i] = 1;
            for(int j=n-1; j>i; j--){
                if(arr[i] > arr[j]){
                    lds[i] = Math.max(lds[i], 1 + lds[j]);
                }
            }
        }
        
        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, lis[i] + lds[i] - 1);
        }
        return ans;
    }
}
