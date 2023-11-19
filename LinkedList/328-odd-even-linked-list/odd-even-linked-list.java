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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;

        ListNode node1Head = head;
        ListNode node2Head = head.next;
        
        while((node1.next != null && node1.next.next != null) || (node2.next != null && node2.next.next != null)){
            if(node1.next == null || node1.next.next == null){
                continue;
            }
            node1.next = node1.next.next;
            node1 = node1.next;
            
            if(node2.next == null || node2.next.next == null){
                continue;
            }
            node2.next = node2.next.next;
            node2 = node2.next;
        }

        node1.next = node2Head;
        node2.next = null;
        return node1Head;

    }
}