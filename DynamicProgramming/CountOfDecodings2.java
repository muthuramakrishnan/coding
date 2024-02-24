class Solution {
    private int[] memoizedValues;
    private boolean invalidSequence;

    Solution(){
        invalidSequence = false;
    }

    public boolean isValid(int num) {
        if (num >= 1 && num <= 26) {
            return true;
        }
        return false;
    }

    public int countDecodings(String s, int startIdx, int n) {
        if (startIdx < 0) {
            return 1;
        }

        if(memoizedValues[startIdx] != -1){
            return memoizedValues[startIdx];
        }
        
        int firstNum = Character.getNumericValue(s.charAt(startIdx));
        int secondNum = startIdx - 1 >= 0 ? Integer.parseInt(s.substring(startIdx - 1, startIdx + 1)) : -1;
        boolean isDoubleDigitSecondNum = Integer.toString(secondNum).length() == 2;

        // if (!isValid(firstNum)) {
        //     if(firstNum == 0 && startIdx == n-1){
        //         //do nothing
        //     }
        //     else{
        //         memoizedValues[startIdx] = 0;
        //         invalidSequence = true;
        //         return 0;
        //     }

        // }
        int way1 = 0;
        int way2 = 0;
        if(isValid(firstNum)){
            way1 = countDecodings(s, startIdx - 1, n);
        }
        if (isValid(secondNum) && isDoubleDigitSecondNum) {
            way2 = countDecodings(s, startIdx - 2, n);
        }

        memoizedValues[startIdx] = way1 + way2;
        return memoizedValues[startIdx];

    }

    public int numDecodings(String s) {
        int n = s.length();
        memoizedValues = new int[s.length() + 5];
        Arrays.fill(memoizedValues, -1);
        int numDecodings = countDecodings(s, n-1, n);
        return invalidSequence ? 0 : numDecodings;
    }
}