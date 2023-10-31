package Queue;

public class CircularQueue {
    int[] arr;
    int front;
    int back;
    int length;
    int count;

    CircularQueue(int length) {
        this.length = length;
        arr = new int[length];
        front = -1;
        back = -1;
        count = 0;
    }

    public void add(int num) {
        arr[(++back) % length] = num;
        count++;
        if (back == 0) {
            front = back;
        }
    }

    public int peek() {
        return arr[front];
    }

    public void remove() {
        front = (front++) % length;
        count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == length;
    }
}
