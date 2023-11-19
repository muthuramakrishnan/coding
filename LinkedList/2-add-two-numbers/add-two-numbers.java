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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode myHead = new ListNode(0);
        ListNode temp = myHead;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            ListNode currNode;
            int sum = 0;
            if(l1!=null){
                sum = l1.val;
            }
            if(l2!=null){
                sum += l2.val;
            }
            sum += carry;
            int rem = sum % 10;
            carry = sum / 10;
            currNode = new ListNode(rem);
            temp.next = currNode;
            temp = currNode;
            if(l1 != null)
            {
                l1 = l1.next;
            }
            if(l2 != null)
            {
                l2 = l2.next;
            }
        }
        return myHead.next;
    }
}