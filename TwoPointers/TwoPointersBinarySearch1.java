import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoPointersBinarySearch1 {
    public static int getNumCount(int[] arr, int num, int low, int high){
        int count = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] < num){
                low = mid + 1;
            }
            else{
                if(arr[mid] == num){
                    count++;
                }
                high = mid - 1;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        // arr[i] + arr[j] == sum;
        // If i fix arr[i], then what should be arr[j]? - sum - arr[i]

        int sum = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n; i++) {
            int num1 = arr[i];
            int num2 = sum - num1;
            count += getNumCount(arr, num2, i, n-1);
        }
        System.out.println(count);
    }
}
