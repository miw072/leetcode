//leetcode 2nd 2015/2/11
//Mingxuan Wang
//reverseBetween

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n){
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		for (int i = 1; i < m; i++){
			head = head.next;
		}
		
		ListNode premNode = head;
		ListNode mNode = head.next;
		ListNode nNode = mNode;
		ListNode postnNode = mNode.next;
		
		for (int i = m ; i < n; i++){
			if (postnNode == null){
				return null;
			}
			ListNode tmp = postnNode.next;
			postnNode.next = nNode;
			nNode = postnNode;
			postnNode = tmp;
		}
		mNode.next = postnNode;
		premNode.next = nNode;
		
		return dummy.next;
    }
}