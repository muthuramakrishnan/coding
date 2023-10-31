package Queue;

public class Main {
    public static void main(String[] args) {
        // Queue queue = new Queue(2);
        // System.out.println(queue.isEmpty());
        // queue.add(5);
        // queue.add(2);
        // System.out.println(queue.peek());
        // System.out.println(queue.isFull());
        // queue.remove();
        // System.out.println(queue.peek());

        // CircularQueue queue = new CircularQueue(2);
        // System.out.println(queue.isEmpty() + " " + queue.isFull());
        // queue.add(1);
        // queue.add(2);
        // System.out.printf("%b %b %d", queue.isEmpty(), queue.isFull(), queue.peek());

        StackQueue queue = new StackQueue();
        System.out.println(queue.isEmpty());
        queue.push(1);
        queue.push(2);
        System.out.printf("%b %d", queue.isEmpty(), queue.peek());
        queue.pop();
        System.out.printf("%d", queue.peek());
    }
}
