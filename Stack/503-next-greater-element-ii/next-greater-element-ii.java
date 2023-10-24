class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] ngeArr = new int[n];
        Arrays.fill(ngeArr, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            if (stack.isEmpty()) {
                stack.push(i % n);
                continue;
            }

            int topIdx = stack.peek();
            int topEl = arr[topIdx];

            if (topEl >= arr[i % n]) {
                stack.push(i % n);
            } else {
                while (topEl < arr[i % n]) {
                    ngeArr[topIdx] = arr[i % n];
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    topIdx = stack.peek();
                    topEl = arr[topIdx];
                }
                stack.push(i % n);
            }
        }
        return ngeArr;

    }
}