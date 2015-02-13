//leetcode 2nd 2015/1/30
//Mingxuan Wang
//reverseKGroup

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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
		ListNode test = head;
		while (test != null){
			test = test.next;
			len++;
		}
		if (len < k){
			return head;
		}
		
		ListNode dummy = null;
		ListNode tail = new ListNode(0);
		int loop = len / k;
		
		for (int i = 0; i < loop; i++){
			ListNode h = head;
			
			for (int j = 0; j < k; j++){
				head = head.next;
			}
			
			ListNode[] tmp = reverse(h, k);
			
			if (dummy == null){
				dummy = tmp[0];
				tail = tmp[1];
			}else{
				tail.next = tmp[0];
				tail = tmp[1];
				
			}
		}
		
		if (len % k == 0){
			tail.next = null;
		}else{
			tail.next = head;
		}
		return dummy;
    }
	
	private ListNode[] reverse(ListNode h, int k){
		ListNode prev = null;
		ListNode[] result = new ListNode[2];
		result[1] = h;
		for (int i = 0; i < k; i++){
			ListNode temp = h.next;
			h.next = prev;
			prev = h;
			h = temp;
		}
		result[0] = prev;
		return result;
	}
}