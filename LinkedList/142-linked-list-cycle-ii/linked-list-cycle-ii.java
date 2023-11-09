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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }

        boolean hasCycle = false;
        ListNode slowPtr = head;
        ListNode fastPtr = head.next.next;
        while(fastPtr !=null && fastPtr.next !=null && fastPtr.next.next !=null){
            if(slowPtr == fastPtr){
                hasCycle = true;
                break;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if(!hasCycle){
            return null;
        }

        // int slowPtrIdx = 0;
        slowPtr = head;
        ListNode tempPtr = fastPtr;
        while(true){
            fastPtr = fastPtr.next;
            while(fastPtr != tempPtr){
                if(fastPtr == slowPtr){
                    return fastPtr;
                }
                fastPtr = fastPtr.next;
            }
            if(fastPtr == slowPtr){
                return fastPtr;
            }
            slowPtr = slowPtr.next;
        }
        // return null;
    }
}