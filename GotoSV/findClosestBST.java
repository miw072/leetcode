//给定一个BST和一个值，找出最接近给定值的节点
TreeNode findClosestBST(TreeNode root, int val){
	if (root == null) return null;
	if (root.val == val) return root;
	TreeNode left = findClosestBST(root.left, val);
	TreeNode right = findClosestBST(root.right, val);
	int diffLeft = left == null?Integer.MAX_VALUE:Math.abs(val-left.val);
	int diffRight = right == null?Integer.MAX_VALUE:Math.abs(val-right.val);
	int diff = Math.abs(root.val - val);
	
	int min = Math.min(diff, Math.min(diffLeft, diffRight));
	
	if (min == diff){
		return root;
	}else if(min == diffLeft){
		return left;
	}else{
		return right;
	}
	 
}