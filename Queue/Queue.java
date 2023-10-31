package Queue;

public class Queue {
    int[] arr;
    int front;
    int back;
    int length;

    Queue(int length) {
        this.length = length;
        arr = new int[length];
        front = -1;
        back = -1;
    }

    public void add(int num) {
        arr[++back] = num;
        if (back == 0) {
            front = back;
        }
    }

    public int peek(){
        return arr[front];
    }

    public void remove() {
        front++;
    }

    public boolean isEmpty() {
        return back == -1;
    }

    public boolean isFull() {
        return back == length - 1;
    }
}
