//给定一个单向链表的头指针，如果有环，则返回环的长度，否则返回0
int getCircleLength(ListNode head){
	ListNode slow = head;
	if (slow == null || slow.next == null){
		return 0;
	}
	ListNode fast = slow.next.next;
	//使用一快一慢指针
	while (fast != null && fast.next != null){
		if(slow == fast){
			return getLength(slow);
			slow = slow.next;
			fast = fast.next.next;
		}
	}
	return 0;
}

int getLength(ListNode node){
	int length = 1;
	ListNode curr = node;
	while (curr.next != node){
		length++;
		curr = curr.next;
	}
	return length;
}