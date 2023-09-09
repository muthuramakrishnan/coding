package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InversionCount1 {
    public static int[] deepCopy(int[] arr){
        int[] newArr = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }
    public static void getInterArrInversionCount(int[] arr, int startIdx1, int endIdx1, int startIdx2, int endIdx2,
            Map<Integer, Integer> inversionCountMap) {
        Arrays.sort(arr, startIdx1, endIdx1 + 1);
        Arrays.sort(arr, startIdx2, endIdx2 + 1);
        while (startIdx1 <= endIdx1 && startIdx2 <= endIdx2) {
            if (arr[endIdx1] > arr[endIdx2]) {
                int currVal = 0;
                if (inversionCountMap.get(arr[endIdx1]) != null) {
                    currVal = inversionCountMap.get(arr[endIdx1]);
                }
                inversionCountMap.put(arr[endIdx1], currVal + endIdx2 - startIdx2 + 1);
                endIdx1--;
            } else {
                endIdx2--;
            }
        }
    }

    public static void getInversionCount(int[] arr, int startIdx, int endIdx, Map<Integer, Integer> inversionCountMap) {
        if (startIdx >= endIdx) {
            return;
        }
        int mid = (startIdx + endIdx) / 2;
        getInversionCount(arr, startIdx, mid, inversionCountMap);
        getInversionCount(arr, mid + 1, endIdx, inversionCountMap);
        getInterArrInversionCount(arr, startIdx, mid, mid + 1, endIdx, inversionCountMap);

    }

    public static List<Integer> countSmaller(int[] arr) {
        int[] arrCopy = deepCopy(arr);
        Map<Integer, Integer> inversionCountMap = new HashMap<>();
        getInversionCount(arr, 0, arr.length - 1, inversionCountMap);
        List<Integer> inversionCountList = new ArrayList<>();
        for (int i = 0; i < arrCopy.length; i++) {
            int value = 0;
            if (inversionCountMap.get(arrCopy[i]) != null) {
                value = inversionCountMap.get(arrCopy[i]);
            }
            inversionCountList.add(value);
        }
        return inversionCountList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(countSmaller(arr));
    }

}
