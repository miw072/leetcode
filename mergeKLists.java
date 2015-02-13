//leetcode 2nd 2015/1/30
//Mingxuan Wang
//mergeKLists

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
    public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0){
			return null;
		}
		//pay attention to how to use heap in java
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), myComparator);
		for(ListNode node:lists){
			if (node != null){
				heap.offer(node);
			}
		}
		
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		while (!heap.isEmpty()){
			ListNode tmp = heap.poll();
			current.next = tmp;
			current = current.next;
			if (tmp.next != null){
				heap.offer(tmp.next);
			}
		}
		return dummy.next;
	}
	
	private Comparator<ListNode> myComparator = new Comparator<ListNode>(){
		public int compare(ListNode n1, ListNode n2){
			//bug 1: must deal with n1 == null or n2 == null
			if (n1 == null){
			    return -1;
			}else if (n2 == null){
			    return 1;
			}
			return n1.val - n2.val;
		}
	};
}