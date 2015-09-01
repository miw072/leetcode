//递归方法来实现反转链表
ListNode reverseList(ListNode head, ListNode newHead){
	if(head == null || head.next == null){
		newHead = head;
		return head;
	}
	//递归
	ListNode pre = reverseList(head.next, newHead);
	pre.next = head;
	head.next = null;
	return head;
}

//非递归
ListNode reverseList(ListNode head){
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	if (head == null){
		return head;
	}
	ListNode curr = head.next; //从第二个节点开始遍历
	head.next = null;
	while(curr != null){
		//依次插入遍历过的节点
		ListNode next = curr.next;
		curr.next = dummy.next;
		dummy.next = curr;
		curr = next;	
	}
	return dummy.next;
}

//扩展
ListNode reverseBetween(ListNode head, int m, int n){
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode mNode = new ListNode(0);
	ListNode pre = dummy, curr = head, next;
	for (int i = 1; i <= n; i++){
		if(i == m){
			mNode = curr;
		}
		if(i < m){
			pre = pre.next;
		}
		next = curr.next;
		if (i > m && i <= n){
			mNode.next = next;
			curr.next = pre.next;
			pre.next = curr;
		}
		curr = next;
	}
	return dummy.next;
}