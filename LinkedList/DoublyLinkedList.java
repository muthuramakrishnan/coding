package LinkedList;

public class DoublyLinkedList {
    public class DoubleNode {
        public int val;
        public DoubleNode prev = null;
        public DoubleNode next = null;
    }

    public DoubleNode head;
    public DoubleNode tail;
    int size = 0;

    public void add(int val) {
        DoubleNode node = new DoubleNode();
        node.val = val;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void insert(int idx, int val) {
        int count = 0;
        if(idx == size){
            add(val);
        }
        DoubleNode newNode = new DoubleNode();
        newNode.val = val;
        DoubleNode currNode = head;
        while (currNode != null && count != idx) {
            count++;
            currNode = currNode.next;
        }
        if (count == idx) {
            DoubleNode prevNode = currNode.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = currNode;
            currNode.prev = newNode;
            size++;
        }
    }

    public int get(int idx){
        int count = 0;
        DoubleNode currNode = head;
        while(currNode !=null && count!=idx){
            currNode = currNode.next;
            count++;
        }
        if(count == idx){
            return currNode.val;
        }
        return -1;
    }
}
