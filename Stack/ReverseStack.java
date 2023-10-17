package Stack;

import java.util.List;
import java.util.Stack;

public class ReverseStack {

    public static void pushBack(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int topElement = stack.pop();
        pushBack(stack, item);
        stack.push(topElement);
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int topElement = stack.pop();
        reverse(stack);
        pushBack(stack, topElement);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(new Integer[] { 7, 6, 3, 1, 2 }));
        reverse(stack);
        System.out.println(stack);
    }
}
