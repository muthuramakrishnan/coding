class Solution {
    public static boolean areTheyPairs(char open, char close) {
        if (open == '(' && close == ')') {
            return true;
        }
        if (open == '[' && close == ']') {
            return true;
        }
        if (open == '{' && close == '}') {
            return true;
        }
        return false;
    }
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(currentChar);
            } else {
                char stackChar = stack.peek();
                if (areTheyPairs(stackChar, currentChar)) {
                    stack.pop();
                }
                else{
                    stack.push(currentChar);
                }
            }
        }
        return stack.isEmpty();
    }
}