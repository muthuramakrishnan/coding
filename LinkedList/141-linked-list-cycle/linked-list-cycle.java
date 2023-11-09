/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head.next.next;

        while(fastPtr != null && fastPtr.next!=null && fastPtr.next.next!=null){
            if(slowPtr == fastPtr){
                return true;
            }
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return false;
    }
}