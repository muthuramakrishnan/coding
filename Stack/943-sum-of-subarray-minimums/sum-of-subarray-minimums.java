class Solution {
    private static final long MOD = (long) Math.pow(10, 9) + 7;
    enum SMALLER_ARR_TYPE {
        NEXT_SMALLER_ARR,
        PREV_SMALLER_ARR;
    }

    public void getMin(int[] arr, int[] minArr, Stack<Integer> minStack, int i, boolean checkEquality) {
        int topIdx = minStack.peek();
        int topEl = arr[topIdx];
        if (checkEquality ? arr[i] > topEl : arr[i] >= topEl) {
            minStack.push(i);
        } else {
            while (checkEquality ? topEl >= arr[i] : topEl > arr[i]) {
                minArr[topIdx] = i;
                minStack.pop();
                if (minStack.isEmpty()) {
                    break;
                }
                topIdx = minStack.peek();
                topEl = arr[topIdx];
            }
            minStack.push(i);
        }
    }

    public void calculateMin(int[] arr, int[] minArr, SMALLER_ARR_TYPE type, boolean checkEquality) {
        int n = arr.length;
        Stack<Integer> minStack = new Stack<>();
        switch (type) {
            case NEXT_SMALLER_ARR:
                minStack.push(0);
                for (int i = 1; i < n; i++) {
                    getMin(arr, minArr, minStack, i, checkEquality);
                }
                break;
            case PREV_SMALLER_ARR:
            default:
                minStack.push(n - 1);
                for (int i = n - 2; i >= 0; i--) {
                    getMin(arr, minArr, minStack, i, checkEquality);
                }
        }
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] prevMin = new int[n];
        boolean checkEquality = true;
        Arrays.fill(prevMin, -1);
        calculateMin(arr, prevMin, SMALLER_ARR_TYPE.PREV_SMALLER_ARR, checkEquality);

        int[] nextMin = new int[n];
        checkEquality = false;
        Arrays.fill(nextMin, n);
        calculateMin(arr, nextMin, SMALLER_ARR_TYPE.NEXT_SMALLER_ARR, checkEquality);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = ((sum % MOD) + (((i - prevMin[i]) % MOD) * ((nextMin[i] - i) % MOD) * (arr[i] % MOD)) % MOD) % MOD;
        }
        return (int) sum;
    }
}