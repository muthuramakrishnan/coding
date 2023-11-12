package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KReverse {
    public static Node[] kReverse(Node head, Node currentHead, Node prevNode, int k, int currentCount) {
        if (prevNode == null) {
            return kReverse(head, currentHead.next, currentHead, k, currentCount + 2);
        }
        Node tempNext = currentHead.next;
        currentHead.next = prevNode;
        prevNode = currentHead;
        currentHead = tempNext;
        if (currentCount >= k) {
            return new Node[] { head, prevNode };
        }
        return kReverse(head, currentHead, prevNode, k, currentCount + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        CustomLinkedList linkedList = new CustomLinkedList();
        for (int i = 0; i < n; i++) {
            linkedList.push(Integer.parseInt(s[i]));
        }

        Node head = linkedList.getHeadNode();
        Node prevTail = null;
        Node prevOrigTailNext = null;
        Node origTailNext = head;

        Node finalHead = head;
        int count = 0;
        while (count != k - 1 && finalHead != null) {
            finalHead = finalHead.next;
            count++;
        }

        for (int i = 0; i < n; i = i + k) {
            int currentCount = 0;
            prevOrigTailNext = origTailNext;
            while (currentCount != k && origTailNext != null) {
                origTailNext = origTailNext.next;
                currentCount++;
            }
            if (i + k > n) {
                prevTail.next = prevOrigTailNext;
                break;
            }
            Node[] nodeArr = kReverse(prevOrigTailNext, prevOrigTailNext, null, k, 0);
            head = nodeArr[1];
            if (i != 0) {
                prevTail.next = head;
            }
            if (i + k == n) {
                nodeArr[0].next = null;
            }
            prevTail = nodeArr[0];

        }

        while (finalHead != null) {
            System.out.print(finalHead.value + " ");
            finalHead = finalHead.next;
        }
    }
}
