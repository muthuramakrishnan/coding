import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class RotateTheArray {
    public static void reverseArray(int[] arr, int start, int end) {
        int i = start, j = end;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = temp.length;
        int[] arr = new int[n];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        int k = Integer.parseInt(br.readLine());
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, n-1);
        System.out.println(Arrays.toString(arr));
    }
}