//leetcode 2nd 2015/2/10
//Mingxuan Wang
//deleteDuplicates2

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		while (head.next != null && head.next.next != null){
			if (head.next.val == head.next.next.val){
				int val = head.next.val;
				while (head.next != null && head.next.val == val){
					head.next = head.next.next;
				}
			}else{
				head = head.next;
			}
		}
		return dummy.next;
    }
}