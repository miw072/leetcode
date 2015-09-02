//给定一个链表和一个值k，把链表一分为二，以x为分界点。
public ListNode partitionLinkedList(ListNode head, int x){
	ListNode dummy = new ListNode(0); //第一个链表头
	ListNode pivot = new ListNode(x); //第二个链表头
	ListNode first = dummy, second = pivot, curr = head;
	while(curr != null){
		ListNode next = curr.next;
		if (curr.val < x){
			//放置小于x的节点
			first.next = curr;
			first = curr;
		}else{
			//放置大于等于x的节点
			second.next = curr;
			second = curr;
			second.next = null;
		}
		curr = next;
	}
	first.next = pivot.next;
	return dummy.next;
}