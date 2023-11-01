package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static List<Integer> generateChildElementList(int currentParent, Integer[] baseElements) {
        List<Integer> childElementList = new ArrayList<>(baseElements.length);
        int currentParentMultipledByTen = currentParent * 10;
        for (int baseElement : baseElements) {
            childElementList.add(currentParentMultipledByTen + baseElement);
        }
        return childElementList;
    }

    public static void printNaturalNos(Queue<Integer> queue, int totalLimit, int currentLimit, int itemsPrinted,
            Integer[] baseElements) {
        if (currentLimit - 1 >= totalLimit) {
            while (!queue.isEmpty() && itemsPrinted - 1 != totalLimit) {
                System.out.println(queue.poll());
                itemsPrinted++;
            }
            return;
        }
        int currentParent = queue.peek();
        queue.remove();
        if (currentParent == 0) {
            queue.addAll(List.of(baseElements));
        } else {
            System.out.println(currentParent);
            queue.addAll(generateChildElementList(currentParent, baseElements));
        }
        printNaturalNos(queue, totalLimit, currentLimit + baseElements.length, itemsPrinted + 1, baseElements);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);

        s = br.readLine().split(" ");
        int arrLen = s.length;
        Integer[] arr = new Integer[arrLen];
        for (int i = 0; i < arrLen; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        printNaturalNos(queue, n, 0, 0, arr);
    }
}
