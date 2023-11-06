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
    public ListNode getHeadOfList2(ListNode head, int startPoint){
        int currPointer = 0;
        ListNode currNode = head;
        while(currPointer != startPoint){
            currNode = currNode.next;
            currPointer++;
        }

        ListNode prevNode = null;
        while(currNode.next!=null){
            ListNode auxNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = auxNode;
        }
        currNode.next = prevNode;
        return currNode;
    }
    public boolean isPalindrome(ListNode head) {
        int n = 1;
        ListNode currNode = head;
        while(currNode.next!=null){
            currNode = currNode.next;
            n++;
        }
        if(n == 1){
            return true;
        }
        ListNode list1Head = head;
        int mid = n/2;
        ListNode list2Head = getHeadOfList2(head, n%2==0 ? mid : mid+1);
        
        if(list2Head.next == null){
            return list1Head.val == list2Head.val;
        }
        while(list2Head!=null){
            if(list1Head.val != list2Head.val){
                return false;
            }
            list1Head = list1Head.next;
            list2Head = list2Head.next;
        }
        return true;
    }
}