package Stack;

import java.util.List;
import java.util.Stack;

public class PushBottom {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(new Integer[] { 7, 6, 3, 1, 2 }));

        // Insert 5 into stack using only stack methods
        Stack<Integer> tempStack = new Stack<>();
        for (int i = stack.size() - 1; i >= 0; i--) {
            tempStack.push(stack.peek());
            stack.pop();
        }
        stack.clear();
        for (int i = tempStack.size() - 1; i >= 0; i--) {
            stack.push(tempStack.peek());
            tempStack.pop();
        }
        System.out.println(stack);
    }
}
