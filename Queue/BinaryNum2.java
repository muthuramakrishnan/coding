package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryNum2 {
    public static void generateNums(Queue<Integer> queue, int totalLimit, int currentLimit, int itemsPrinted) {
        if (currentLimit >= totalLimit) {
            while (!queue.isEmpty() && itemsPrinted != totalLimit) {
                System.out.println(queue.poll());
                itemsPrinted++;
            }
            return;
        }
        int currentNum = queue.peek();
        queue.remove();
        System.out.println(currentNum);
        queue.addAll(List.of(new Integer[] { currentNum * 10, currentNum * 10 + 1 }));
        generateNums(queue, totalLimit, currentLimit + 2, itemsPrinted + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().strip());

        // need to generate binary representation for 1 to n natural numbers
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        generateNums(queue, n, 0, 0);
    }
}
