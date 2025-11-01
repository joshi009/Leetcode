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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            mp.putIfAbsent(nums[i], 0);
            mp.put(nums[i], mp.get(nums[i]) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        ListNode ansHead = new ListNode();
        ListNode curr = ansHead;
        while(temp != null)
        {
            if(!mp.containsKey(temp.val))
            {
                ListNode node = new ListNode(temp.val);
                curr.next = node;
                curr = curr.next;
            }
            temp = temp.next;
        }
        return ansHead.next;
    }
}