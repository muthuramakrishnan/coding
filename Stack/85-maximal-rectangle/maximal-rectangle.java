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


    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1'){
                    arr[i][j] = 1;
                }
                else{
                    arr[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (arr[i][j] != 0 && i > 0) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j];
                }
            }
        }
        int largestArea = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] nextSmallerArr = new int[n];
            Arrays.fill(nextSmallerArr, n);
            populateSmallerArr(arr[i], nextSmallerArr, SMALLER_ARR_TYPE.NEXT_SMALLER_ARR);

            int[] prevSmallerArr = new int[n];
            Arrays.fill(prevSmallerArr, -1);
            populateSmallerArr(arr[i], prevSmallerArr, SMALLER_ARR_TYPE.PREV_SMALLER_ARR);

            for (int j = 0; j < n; j++) {
                largestArea = Math.max(largestArea, (nextSmallerArr[j] - prevSmallerArr[j] - 1) * arr[i][j]);
            }
        }
        return largestArea;
    }
}