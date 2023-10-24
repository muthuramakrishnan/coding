class Solution {
    enum SMALLER_ARR_TYPE {
        NEXT_SMALLER_ARR,
        PREV_SMALLER_ARR;
    }

    public void doComputeSmallerElem(int[] arr, int[] smallerArr, Stack<Integer> smallerStack, int i) {
        int topIdx = smallerStack.peek();
        int topItem = arr[topIdx];
        if (arr[i] >= topItem) {
            smallerStack.push(i);
        } else {
            while (arr[i] < topItem) {
                smallerArr[topIdx] = i;
                smallerStack.pop();
                if (smallerStack.isEmpty()) {
                    break;
                }
                topIdx = smallerStack.peek();
                topItem = arr[topIdx];
            }
            smallerStack.push(i);
        }
    }

    public void populateSmallerArr(int[] arr, int[] smallerArr, SMALLER_ARR_TYPE arrType) {
        int n = arr.length;
        Stack<Integer> smallerStack = new Stack<>();
        switch (arrType) {
            case PREV_SMALLER_ARR: {
                smallerStack.push(n - 1);
                for (int i = n - 2; i >= 0; i--) {
                    doComputeSmallerElem(arr, smallerArr, smallerStack, i);
                }
                break;
            }
            case NEXT_SMALLER_ARR:
            default: {
                smallerStack.push(0);
                for (int i = 1; i < n; i++) {
                    doComputeSmallerElem(arr, smallerArr, smallerStack, i);
                }
            }

        }
    }


    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        // find next smaller element
        int[] nextSmallerArr = new int[n];
        Arrays.fill(nextSmallerArr, n);
        populateSmallerArr(arr, nextSmallerArr, SMALLER_ARR_TYPE.NEXT_SMALLER_ARR);

        int[] prevSmallerArr = new int[n];
        Arrays.fill(prevSmallerArr, -1);
        populateSmallerArr(arr, prevSmallerArr, SMALLER_ARR_TYPE.PREV_SMALLER_ARR);

        System.out.println(Arrays.toString(nextSmallerArr));
        System.out.println(Arrays.toString(prevSmallerArr));

        int largestArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            largestArea = Math.max(largestArea, (nextSmallerArr[i] - prevSmallerArr[i] - 1) * arr[i]);
        }
        return largestArea;
    }
}