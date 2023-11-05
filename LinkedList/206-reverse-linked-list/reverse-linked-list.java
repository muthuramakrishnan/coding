/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode _reverseRecurrsively(ListNode currNode, ListNode prevNode) {
        if (currNode == null) {
            return prevNode;
        }
        ListNode nextNode = currNode.next;
        currNode.next = prevNode;
        prevNode = currNode;
        currNode = nextNode;
        return _reverseRecurrsively(currNode, prevNode);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode returnedNode = _reverseRecurrsively(currNode, prevNode);
        head = returnedNode;
        return head;
    }

}