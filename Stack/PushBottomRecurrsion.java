package Stack;

import java.util.List;
import java.util.Stack;

public class PushBottomRecurrsion {

    public static void pushBottom(Stack<Integer> stack, int element){
        if(stack.isEmpty()){
            stack.push(element);
            return;
        }
        int topItem = stack.pop();
        pushBottom(stack, element);
        stack.push(topItem);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(new Integer[] { 7, 6, 3, 1, 2 }));

        //push 5 recursive
        pushBottom(stack, 5);
        System.out.println(stack);
    }
}
