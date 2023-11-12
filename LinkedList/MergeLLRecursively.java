package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeLLRecursively {

    public static Node merge(Node myNodeHead, Node tempNodeHead, Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return myNodeHead;
        }
        if (tempNodeHead == null) {
            tempNodeHead = myNodeHead;
        }
        if (head1 == null) {
            tempNodeHead.next = head2;
            head2 = head2.next;
        } else if (head2 == null) {
            tempNodeHead.next = head1;
            head1 = head1.next;
        } else if (head1.value < head2.value) {
            tempNodeHead.next = head1;
            head1 = head1.next;
        } else {
            tempNodeHead.next = head2;
            head2 = head2.next;
        }
        tempNodeHead = tempNodeHead.next;
        return merge(myNodeHead, tempNodeHead, head1, head2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        CustomLinkedList linkedList1 = new CustomLinkedList();
        CustomLinkedList linkedList2 = new CustomLinkedList();

        int n = s.length;
        for (int i = 0; i < n; i++) {
            linkedList1.push(Integer.parseInt(s[i]));
        }

        s = br.readLine().split(" ");
        int m = s.length;
        for (int i = 0; i < m; i++) {
            linkedList2.push(Integer.parseInt(s[i]));
        }

        Node head1 = linkedList1.getHeadNode();
        Node head2 = linkedList2.getHeadNode();

        Node myNodeHead;
        if (head1 == null || head2 == null) {
            System.exit(0);
        }
        if (head1 == null) {
            myNodeHead = head2;
        } else if (head2 == null) {
            myNodeHead = head2;
        } else if (head1.value < head2.value) {
            myNodeHead = head1;
            head1 = head1.next;
        } else {
            myNodeHead = head2;
            head2 = head2.next;
        }
        myNodeHead = merge(myNodeHead, null, head1, head2);

        while(myNodeHead!=null){
            System.out.println(myNodeHead.value);
            myNodeHead = myNodeHead.next;
        }

    }
}
