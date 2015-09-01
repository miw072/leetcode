//反转一个链表中的每k个节点，如果不能被k整除，则保留最后的顺序
ListNode reverseKGroup(ListNode head, int k){
	if (head == null || k <= 1){
		return head;
	}
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	//记录分组区间的起点
	ListNode pre = dummy, cross = head;
	int count = 0;
	while(cross != null){
		count++;
		if(count%k == 0){
			//分组结束节点
			pre = reverse(pre, cross.next);
			cross = pre.next;
		}else{
			cross = cross.next;
		}
	}
	return dummy.next;
}

ListNode reverse(ListNode pre, ListNode next){
	ListNode last = pre.next;
	ListNode cur = last.next;
	while(cur != next){
		last.next = cur.next;
		cur.next = pre.next;
		pre.next = cur;
		cur = last.next;
	}
	return last;
}