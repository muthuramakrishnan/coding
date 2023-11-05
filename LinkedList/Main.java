package LinkedList;

// import LinkedList.CustomLinkedList.Node;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.push(10);
        linkedList.push(20);
        linkedList.insert(0, 1);
        linkedList.insert(3, 1);

        linkedList.delete(2);
        for(int i=0; i<linkedList.size(); i++){
            System.out.println(linkedList.get(i));
        }
    }
}
