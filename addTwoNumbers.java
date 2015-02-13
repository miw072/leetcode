//leetcode 2nd 2015/1/28
//Mingxuan Wang
//addTwoNumbers

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
			return null;
		}
		
		ListNode current = new ListNode(0);
		ListNode head = current;
		int carry = 0;
		
		while (l1 != null && l2 != null){
			//bug 2: forget to add carry
			int sum = l1.val + l2.val + carry;
			ListNode newNode = new ListNode(sum % 10);
			current.next = newNode;
			carry = sum / 10;
			current = current.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while (l1 != null){
			int sum = l1.val + carry;
			ListNode newNode = new ListNode(sum % 10);
			current.next = newNode;
			carry = sum / 10;
			current = current.next;
			l1 = l1.next;
		}
		
		while (l2 != null){
			int sum = l2.val + carry;
			ListNode newNode = new ListNode(sum % 10);
			current.next = newNode;
			carry = sum / 10;
			current = current.next;
			l2 = l2.next;
		}
		
		//bug 1: forget to deal with carry at last
		if (carry != 0){
			ListNode newNode = new ListNode(carry);
			current.next = newNode;
		}
		
		return head.next;
    }
}