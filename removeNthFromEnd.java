//leetcode 2nd 2015/1/29
//Mingxuan Wang
//removeNthFromEnd

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0){
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = head;
		ListNode slow = head;
		head = dummy;
		//bug 1: must be i = 1 here
		for (int i = 1; i < n; i ++){
			fast = fast.next;
		}
		
		while (fast != null && fast.next != null){
			fast = fast.next;
			slow = slow.next;
			head = head.next;
		}
		
		head.next = slow.next;
		return dummy.next;
    }
}