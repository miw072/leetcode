//将一个BST转化为一个有序的双向链表
//记录头指针以便返回新的链表
//每次有新的节点加入，头指针需要和该节点建立相互指向关系
TreeNode treeToDoublyList(TreeNode root){
	TreeNode prev = null;
	TreeNode head = null;
	treeToDoublyList(root, prev, head);
	return head;
}

//实现函数
void treeToDoublyList(TreeNode p, TreeNode prev, TreeNode head){
	if(!p){
		return;
	}
	treeToDoublyList(p.left, prev, head);
	//当前节点的左节点指向前一个节点
	p.left = prev;
	if (prev){
		prev.right = p; //前一个节点的右节点指向当前节点
	}else{
		head = p; //如果prev未被初始化，那么它是链表的头
	}
	TreeNode right = p.right;
	//首尾相接，建立循环关系
	head.left = p;
	p.right = head;
	//进入下一个节点前，更新prev节点
	prev = p;
	treeToDoublyList(right, prev, head);
}