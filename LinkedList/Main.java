package LinkedList;

// import LinkedList.CustomLinkedList.Node;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.push(10);
        linkedList.push(20);
        linkedList.insert(0, 5);
        linkedList.insert(3, 25);

        linkedList.delete(2);
        int n = linkedList.size();
        System.out.println("Before reversal");
        for (int i = 0; i < n; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        CustomLinkedList.reverseRecurrsively(linkedList);
        System.out.println("After reversal");
        for (int i = 0; i < n; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
    }
}
