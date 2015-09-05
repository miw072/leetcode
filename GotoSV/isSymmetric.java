boolean isSymmetric(TreeNode root){
	if (root == null){
		return true;
	}
	
	Queue<TreeNode> left = new LinkedList<TreeNode>();
	Queue<TreeNode> right = new LinkedList<TreeNode>();
	
	left.add(root.left);
	right.add(root.right);
	
	while(!left.isEmpty() && !right.isEmpty()){
		TreeNode l = left.poll();
		TreeNode r = right.poll();
		if(l == null && r == null){
			continue;
		}
		if(l == null || r == null){
			return false;
		}
		if(l.val != r.val){
			return false;
		}
		left.add(l.left);
		left.add(l.right);
		right.add(r.right);
		left.add(r.left);
	}
	
	if(l.isEmpty() && r.isEmpty()){
		return true;
	}else{
		return false;
	}
}