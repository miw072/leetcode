//合并两个有序链表，返回合并后的有序链头。
ListNode mergeTwoLists(ListNode l1, ListNode l2){
	//创建dummy
	ListNode dummy = new ListNode(0);
	ListNode cur = dummy;
	while (l1 != null && l2 != null){
		if (l1.val <= l2.val){
			cur.next = l1;
			l1 = l1.next;
		}else{
			cur.next = l2;
			l2 = l2.next;
		}
		cur = cur.next;
	}
	if (l1 != null){
		cur.next = l1;
	}else if (l2 != null){
		cur.next = l2;
	}
	return dummy.next;
}