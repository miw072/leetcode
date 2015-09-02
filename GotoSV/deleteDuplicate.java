//输入一个有序链表，删除重复值，确保每个只出现一次
public ListNode deleteDuplicates(ListNode head){
	if (head == null){
		return head;
	}
	ListNode prev = head; //保存非重复元素的列表
	ListNode curr = head.next;
	
	while(curr != null){
		//如果值不同，两个指针同时向后移动，prev沿着curr移动
		//如果有相同的值，只移动curr
		if(curr.val != prev.val){
			prev = prev.next;
		}
		curr = curr.next;
		prev.next = curr;
	}
	return head;
}

public ListNode deleteDuplicates2(ListNode head){
	ListNode dummy = new ListNode(0);
	ListNode tail = dummy;
	ListNode pre = head, curr = head;
	while (curr != null && curr.next != null){
		//移动当前指针到重复元素的最后一个
		while(curr.next != null && curr.val == curr.next.val){
			curr = curr.next;
		}
		if (pre == curr){
			//如果当前元素没有重复的，那么加入当前元素
			tail.next = pre;
			tail = tail.next;
		}
		pre = curr.next;
		curr = curr.next;
	}
	tail.next = curr; //加入最后一个元素
	return dummy.next;
}