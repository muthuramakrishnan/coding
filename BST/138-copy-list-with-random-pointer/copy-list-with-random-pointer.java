/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Map<Node, Node> nodeMap = new HashMap<>();
        Node myListHead = null;
        Node prevNode = null;
        Node headCopy = head;

        while(head!=null){
            Node myNode = new Node(head.val);
            if(myListHead == null){
                myListHead = myNode;
            }
            else{
                prevNode.next = myNode;
            }
            prevNode = myNode;
            nodeMap.put(head, myNode);
            head = head.next;
        }

        Node myListHeadCopy = myListHead;
        while(headCopy!=null){
            Node nextRandom = headCopy.random;
            Node correspondingRandom = nodeMap.get(nextRandom);
            myListHeadCopy.random = correspondingRandom;
            headCopy = headCopy.next;
            myListHeadCopy = myListHeadCopy.next;
        }
        return myListHead;
    }
}