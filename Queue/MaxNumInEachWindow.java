package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MaxNumInEachWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] arr = new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Deque<Integer> queue = new ArrayDeque<>(k);
        queue.add(0);
        for (int i = 1; i < k; i++) {
            int lastElIdx = queue.peekLast();
            int lastEl = arr[lastElIdx];
            while (lastEl <= arr[i]) {
                queue.removeLast();
                if (queue.isEmpty()) {
                    break;
                }
                lastElIdx = queue.peekLast();
                lastEl = arr[lastElIdx];
            }
            queue.add(i);
        }

        for (int i = k; i < n; i++) {
            int firstIdx = queue.peekFirst();
            int firstEl = arr[firstIdx];
            System.out.printf("%d ", firstEl);

            boolean shouldKickOutFirstEl = i - k == firstIdx;
            if (shouldKickOutFirstEl) {
                queue.removeFirst();
            }
            if (!queue.isEmpty()) {
                int lastElIdx = queue.peekLast();
                int lastEl = arr[lastElIdx];
                while (lastEl <= arr[i]) {
                    queue.removeLast();
                    if (queue.isEmpty()) {
                        break;
                    }
                    lastElIdx = queue.peekLast();
                    lastEl = arr[lastElIdx];
                }
                queue.add(i);
            } else {
                queue.add(i);
            }
        }

        if(!queue.isEmpty()){
            System.out.printf("%d ", arr[queue.pollFirst()]);
        }
    }
}
