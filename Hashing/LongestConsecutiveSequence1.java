package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

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
        System.out.println(maxConsecutiveLen);
    }
}
