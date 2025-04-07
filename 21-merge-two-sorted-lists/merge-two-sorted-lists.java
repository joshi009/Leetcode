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
        ListNode dummy = new ListNode(-1);
        ListNode dummy2 = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                dummy2.next = list1;
                list1 = list1.next;
            }else{
                dummy2.next = list2;
                list2 = list2.next;
            }
            dummy2 = dummy2.next;

        }
        if(list1 != null){
            dummy2.next = list1;
        }else{
            dummy2.next = list2;
        }
        return dummy.next;
        
    }
}