//leetcode 2nd 2015/2/7
//Mingxuan Wang
//rotateRight

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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null){
			return null;
		}
		
		int len = getLength(head);
		n = n % len;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode tail = dummy;
		
		for (int i = 0; i < n; i++){
			head = head.next;
		}
		
		while (head.next != null){
			head = head.next;
			tail = tail.next;
		}
		
		head.next = dummy.next;
		dummy.next = tail.next;
		tail.next = null;
		return dummy.next;
	}
	
	private int getLength(ListNode head){
		int len = 1;
		while (head.next != null){
			len ++;
			head = head.next;
		}
		return len;
	}
}