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

        System.out.println("Doubly Linked LIst");
        DoublyLinkedList linkedList2 = new DoublyLinkedList();
        linkedList2.add(1);
        linkedList2.add(2);
        linkedList2.add(3);
        linkedList2.add(4);

        linkedList2.insert(1, 10);
        linkedList2.insert(4, 20);
         linkedList2.insert(6, 100);
        for(int i=0; i<7; i++){
            System.out.println(linkedList2.get(i));
        }
    }
}
