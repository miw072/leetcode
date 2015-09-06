public void connectTree(TreeLinkNode root){
	TreeLinkNode currLevel = root;
	while(currLevel != null){
		TreeLinkNode across = currLevel;
		while(across != null){
			if (across.left != null){
				across.left.next = across.right;
			}
			if (across.right != null && across.next != null){
				across.right.next = across.next.left;
			}
			across = across.next;
		}
		currLevel = connectTree.left;
	}
}