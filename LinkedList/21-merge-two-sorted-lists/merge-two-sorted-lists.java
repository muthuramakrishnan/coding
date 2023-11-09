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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode myList = null;
        ListNode myListHead = null;
        if(list1.val < list2.val){
            myList = list1;
            myListHead = list1;
            list1 = list1.next;
        }
        else{
            myList = list2;
            myListHead = list2;
            list2 = list2.next;
        }
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                myList.next = list1;
                list1 = list1.next;
            }
            else{
                myList.next = list2;
                list2 = list2.next;
            }
            myList = myList.next;
        }
        while(list1!=null){
            myList.next = list1;
            list1 = list1.next;
            myList = myList.next;
        }
        while(list2!=null){
            myList.next = list2;
            list2 = list2.next;
            myList = myList.next;
        }
        return myListHead;
    }
}