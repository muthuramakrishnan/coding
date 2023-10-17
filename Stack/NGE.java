//{ Driver Code Starts
/*package whatever //do not write package name here */
package Stack;

import java.util.*;
import java.io.*;

// } Driver Code Ends

public class NGE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = Long.parseLong(inputLine[i]);
            long[] res = nextLargerElement(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }

    // Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Pair<Long, Integer>> auxStack = new Stack<>();
        long[] resultArr = new long[n];
        Arrays.fill(resultArr, -1);
        auxStack.push(new Pair<Long, Integer>(arr[0], 0));
        for (int idx = 1; idx < n; idx++) {
            long currItem = arr[idx];
            Pair<Long, Integer> stackItem = auxStack.peek();
            if (currItem <= stackItem.getX()) {
                auxStack.push(new Pair<Long, Integer>(currItem, idx));
            } else {
                while (currItem > stackItem.getX()) {
                    auxStack.pop();
                    resultArr[stackItem.getY()] = currItem;
                    if (auxStack.isEmpty()) {
                        break;
                    }
                    stackItem = auxStack.peek();
                }
                auxStack.push(new Pair<Long, Integer>(currItem, idx));
            }

        }

        // for(Pair<Long, Integer> item : auxStack){
        // resultArr[item.getY()] = -1;
        // }

        return resultArr;
    }
}

class Pair<S, T> {
    S x;
    T y;

    Pair(S x, T y) {
        this.x = x;
        this.y = y;
    }

    public S getX() {
        return x;
    }

    public T getY() {
        return y;
    }
}