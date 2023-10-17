package Stack;

public class CustomStack {
    private int[] arr;
    private int top = -1;

    CustomStack(int size) {
        arr = new int[size];
    }

    public void push(int item) {
        if(isFull()){
            System.out.println("Array is full, you cannot insert anymore");
            return;
        }
        arr[++top] = item;
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Array is empty, you cannot pop anymore");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        return arr[top];
    }

    public boolean isFull() {
        if (top == arr.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }
}
