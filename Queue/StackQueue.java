package Queue;

import java.util.Stack;

public class StackQueue {
    Stack<Integer> stack;
    Integer frontEl = null;

    StackQueue() {
        stack = new Stack<>();
    }

    public void push(int item) {
        if (stack.isEmpty()) {
            frontEl = item;
        }
        stack.push(item);
    }

    public int pop() {
        int ans;

        Stack<Integer> auxStack = new Stack<>();
        while (!stack.isEmpty()) {
            auxStack.push(stack.peek());
            stack.pop();
        }

        ans = auxStack.peek();
        auxStack.pop();
        if (!auxStack.isEmpty()) {
            frontEl = auxStack.peek();
        }
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.peek());
            auxStack.pop();
        }
        return ans;
    }

    public int peek() {
        return frontEl;
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
