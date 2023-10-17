package Stack;

import java.io.IOException;

public class StackDriver {
    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
        CustomStack customStack = new CustomStack(5);
        customStack.push(1);
        customStack.push(5);
        customStack.push(7);
        customStack.push(2);
        customStack.push(4);
        customStack.push(1);
            
        System.out.println(customStack.isFull());
    }
}
