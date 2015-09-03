//给定两个节点，求它们在一个二叉树中的LCA
TreeNode LCA3(TreeNode root, TreeNode p, TreeNode q){
	if (root == null || p == null || q == null){
		return null;
	}
	if (root == p || root == q){
		return root;
	}
	TreeNode left = LCA3(root.left, p, q);
	TreeNode right = LCA3(root.right, p, q);
	if (left != null && right != null){
		return root;
	}
	return left == null?right:left;
}