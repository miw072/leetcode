//leetcode 2nd 2015/1/30
//Mingxuan Wang
//swapPairs

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		while (head.next != null && head.next.next != null){
			ListNode tmp = head.next.next.next;
			head.next.next.next = head.next;
			head.next = head.next.next;
			head.next.next = tmp;
			head = head.next.next;
		}
		return dummy.next;
    }
}