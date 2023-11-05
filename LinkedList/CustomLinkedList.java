package LinkedList;

public class CustomLinkedList {
    private Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public int size() {
        Node currNode = head;
        int size = 1;
        while (currNode.next != null) {
            currNode = currNode.next;
            size++;
        }
        return size;
    }

    public void insert(int idx, int data) {
        Node newNode = new Node(data);
        if (head == null && idx == 0) {
            head = newNode;
            return;
        }
        if (idx == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        int currIdx = 0;
        Node currNode = head;
        while (currIdx != idx - 1) {
            currNode = currNode.next;
            currIdx++;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    public int get(int idx) {
        Node currentNode = head;
        int currIdx = 0;
        while (currIdx != idx) {
            currentNode = currentNode.next;
            currIdx++;
        }
        return currentNode.data;
    }

    public void delete(int idx) {
        Node currNode = head;
        if (idx == 0) {
            head = head.next;
            return;
        }
        int currIdx = 0;
        while (currIdx != idx - 1) {
            currNode = currNode.next;
            currIdx++;
        }
        currNode.next = currNode.next.next;
    }
}
