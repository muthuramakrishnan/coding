package Queue;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class ReverseQueue {

    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int frontItem = queue.peek();
        queue.remove();
        reverseQueue(queue);
        queue.add(frontItem);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(List.of(new Integer[] { 1, 2, 3 }));
        reverseQueue(queue);
        System.out.println(queue.peek());
    }
}
